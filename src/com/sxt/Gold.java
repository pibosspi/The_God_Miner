package com.sxt;

import sun.awt.image.ToolkitImage;

import java.awt.*;

/**
 * @author cgpstart
 * @create 2021-08-18 17:22
 */
public class Gold extends  Object {
    boolean flag = false;
    //false表示不可以移动，true表示可以移动

    Gold(){
        this.x = (int)(Math.random()*700);  // 0<x<700
        this.y = (int)(Math.random()*550+300); //300<y<850
        this.width = 52;
        this.heigth = 52;
        this.flag = false;
        this.m = 30;
        this.count = 4;
        this.type = 1;
        this.img = Toolkit.getDefaultToolkit().getImage("imgs/gold1.gif");
    }
}
class GoldMini extends Gold{
    GoldMini(){
//        this.x = (int)(Math.random()*700);  // 0<x<700
//        this.y = (int)(Math.random()*550+300); //300<y<850
        this.width = 36;
        this.heigth = 36;
//        this.flag = false;
        this.m = 15;
        this.count = 2;
        this.img = Toolkit.getDefaultToolkit().getImage("imgs/gold0.gif");
    }

}
class GoldPlus extends Gold{
    GoldPlus(){
        this.x = (int)(Math.random()*650);  // 0<x<700
//        this.y = (int)(Math.random()*550+300); //300<y<850
        this.width = 105;
        this.heigth = 105;
//        this.flag = false;
        this.m = 60;
        this.count = 8;
        this.img = Toolkit.getDefaultToolkit().getImage("imgs/gold2.gif");
        System.out.println();
    }

}
