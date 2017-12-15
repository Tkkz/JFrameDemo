package com.hbzz.jframe;

import java.awt.*;
import java.awt.geom.Ellipse2D;

/**
 * 算法辅助工具类
 */
public class AlgVisHelper {
    private AlgVisHelper(){}
    //设置画笔的粗细
    public static void setStrokeWidth(Graphics2D g2d,int w){
        int strokeWidth=w;
        /**
         * CAP_BUTT 端点位置
         * JOIN_ROUND 转弯的位置
         */
        g2d.setStroke(new BasicStroke(strokeWidth,BasicStroke.CAP_BUTT,BasicStroke.JOIN_ROUND));
    }

    /**
     * 设置画笔粗细
     * @param g2d
     * @param color
     */
    public static void setColor(Graphics2D g2d,Color color){
        g2d.setColor(color);
    }

    /**
     * 绘制空心圆
     * @param g2d
     * @param x 坐标
     * @param y
     * @param r 半价
     */
    public static void strokeCircle(Graphics2D g2d,int x,int y,int r){
            Ellipse2D circle=new Ellipse2D.Double(x-r,y-r,2*r,2*r);
            g2d.draw(circle);
    }
    //S实心圆
    public static void fillCircle(Graphics2D g2d, int x, int y, int r) {
        Ellipse2D circle = new Ellipse2D.Double(x - r, y - r, 2 * r, 2 * r);
        g2d.fill(circle);
    }

    public static void pause(int t){
        try{
            Thread.sleep(t);
        }catch (InterruptedException e){
            System.out.println("Error is Sleeping");
        }
    }
}
