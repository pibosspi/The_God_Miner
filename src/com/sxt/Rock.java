package com.sxt;

import java.awt.*;

/**
 * @author cgpstart
 * @create 2021-08-18 22:44
 */
public class Rock extends Object {
    Rock(){
        this.x = (int)(Math.random()*700);  // 0<x<700
        this.y = (int)(Math.random()*550+300); //300<y<850
        this.width = 71;
        this.heigth = 71;
        this.flag = false;
        this.m = 50;
        this.count = 1;
        this.type = 2;
        this.img = Toolkit.getDefaultToolkit().getImage("imgs/rock1.png");
    }

}
