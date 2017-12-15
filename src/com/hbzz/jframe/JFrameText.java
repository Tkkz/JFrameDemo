package com.hbzz.jframe;

import javax.swing.*;
import java.awt.*;

/**
 * Created by sssss on 2017/12/7.
 */
public class JFrameText {

    public static void main(String[] args) {
        int sceneWidth=800;
        int sceneHeight=800;

        int N=10;
        Circle[] circles=new Circle[N];
        int R=50;
        //实例化
        for (int i=0;i<N;i++){
            int x=(int)(Math.random()*(sceneWidth-2*R))+R;
            int y= (int) (Math.random() * (sceneHeight - 2 * R)) + R;
            int vx = (int) (Math.random() * 11)-5;
            int vy = (int) (Math.random() * 11)-5;
            circles[i]=new Circle(x,y,R,vx,vy);

        }
        EventQueue.invokeLater(()->{
            AlgoFrame algoFrame=new AlgoFrame("welcome to here",sceneWidth,sceneHeight);
           // AlgoFrame algoFrame=new AlgoFrame("he");

            new Thread(()->{
                while (true) {
                    //绘制数据
                    algoFrame.render(circles);
                    AlgVisHelper.pause(20);
                    //更新数据
                    for (Circle circle : circles) {
                        circle.move(0,0,sceneWidth,sceneHeight);
                    }
                }
            }).start();

        });

    }

    



}
