package com.sxt;

import java.awt.*;

/**
 * @author cgpstart
 * @create 2021-08-18 17:18
 */
public class Object {
    //坐标
    int x;
    int y;
    //宽高
    int width;
    int heigth;
    //图片
    Image img;

    //标记是否可以移动
    boolean flag;

    //质量
    int m;

    //积分
    int count;

    //类型:   1:金块； 2：石块
    int type;

    //绘制图片
    void paintSelf(Graphics g){
        g.drawImage(img,x,y,null);

    }
    //getXxx来获取物块的宽度

    public int getWidth() {
        return width;
    }
    //获取矩形
    public Rectangle getRec(){
        return new Rectangle(x,y,width,heigth);
    }
}
