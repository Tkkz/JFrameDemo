package com.hbzz.jframe;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * Created by sssss on 2017/12/7.
 */
public class AlgoFrame extends JFrame{

    //私有的px
    private int canvasWidth;
    private int canvasHeight;

    /**
     * 构造方法 传默认值
     *
     * @param title
     */
    public AlgoFrame(String title) {
        this(title, 1024, 768);
    }

    //get
    public int getCanvasWidth() {
        return canvasWidth;
    }

    public int getCanvasHeight() {
        return canvasHeight;
    }

    public AlgoFrame(String title,int canvasWidth,int canvasHeight){
        super(title);
        this.canvasWidth=canvasWidth;
        this.canvasHeight=canvasHeight;

        //自定义的内容画板
        AlgoCanvas canvas=new AlgoCanvas();
        //设置画布大小
        canvas.setPreferredSize(new Dimension(canvasWidth,canvasHeight));
        //传入画板
        setContentPane(canvas);
        pack();//自动调整窗口大小

        //不能再次设置窗口大小，默认书true
        setResizable(false);
        //关闭X建
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //显示窗口
        setVisible(true);

    }

    private Circle[] circles;
    public void render(Circle[] circles){
       //传入的数组付给algframe
        this.circles=circles;
        //gframe提供的函数，对控件重新刷新 也就是清空再重新调用
        repaint();
    }

    //使用内部类 实现()画板
    private class AlgoCanvas extends JPanel{
        public  AlgoCanvas(){
            //双缓存
            super(true);
        }

        /**
         * 绘制组建
         *
         * @param g 绘制函数都定义在了g上
         */
        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            //获得绘图的上下文
            Graphics2D g2d=(Graphics2D) g;

            //开启抗锯齿
            RenderingHints hints=new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.addRenderingHints(hints);

          /*
            *具体绘制
            */
            //设置笔画大小
            AlgVisHelper.setStrokeWidth(g2d,1);
            AlgVisHelper.setColor(g2d,Color.red);
            for(Circle circle:circles){
                AlgVisHelper.fillCircle(g2d, circle.x, circle.y, circle.getR());
            }
        }

            /**
             * 构造画布大小
             *
             * @return
             */
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(canvasWidth, canvasHeight);
            }
        }
}
