package com.hbzz.jframe;

/**
 * Created by sssss on 2017/12/15.
 */
public class Circle {
    //坐标
    public int x,y;
    //半径
    private int r;
    //速度
    public int vx,vy;

    //构造函数
    public Circle(int x, int y, int r, int vx, int vy) {
        this.x = x;
        this.y = y;
        this.r = r;
        this.vx = vx;
        this.vy = vy;
    }
    public int getR(){return r;}

    public void move(int minx, int miny, int maxx, int maxy){
        x +=vx;
        y +=vy;
        checkCollsion(minx, miny,maxx,maxy);
    }

    /**
     * 检测碰撞
     * @param minx x方向最小值
     * @param miny y方向最小值
     * @param maxx x方向最大值
     * @param maxy x方向最大值
     */
    private void checkCollsion(int minx,int miny,int maxx,int maxy){
        //速度反转
        if (x-r<minx){x=r;vx=-vx;}
        if(x+r>+maxx){x=maxx-r;vx=-vx;}
        if(y-r<miny){y=r;vy=-vy;}
        if(y+r>=maxy){y=maxy-r;vy=-vy;}
    }

}
