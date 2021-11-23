package com.sxt;

import java.awt.*;

/**
 * @author cgpstart
 * @create 2021-08-18 15:23
 */
//创建背景类
public class Bg {
    //关卡数：
    static int level = 1;
    //目标得分：
    int goal = level * 15;

    //总分
    static int count = 0;
    //药水数量
    static int waterNum = 3;
    //药水状态 :默认false，True表示正在使用
    static Boolean waterFlag = false;

    //载入背景
    Image bg = Toolkit.getDefaultToolkit().getImage("imgs/bg.jpg");
    Image bg1 = Toolkit.getDefaultToolkit().getImage("imgs/bg1.jpg");
    Image peo = Toolkit.getDefaultToolkit().getImage("imgs/peo.png");
    Image water = Toolkit.getDefaultToolkit().getImage("imgs/water.png");

    //绘制图片
    void paintSelf(Graphics g){ //传入画笔
        g.drawImage(bg1,0,0,null);
        g.drawImage(bg,0,200,null);
        g.drawImage(peo,310,50,null);
        //药水组件
        g.drawImage(water,450,150,null);
        drawWord(g,30,Color.BLACK,"*" +  waterNum ,510,170);
//打印积分字符串
        drawWord(g,30,Color.BLACK,"积分：" + count ,30,150);
        //关卡数：
        drawWord(g,20,Color.BLACK,"第" + level + "关" ,30,60);
        //目标积分：
        drawWord(g,30,Color.BLACK,"目标积分：" + goal ,30,110);



    }

    //打印字符串
    public static void drawWord(Graphics g,int size,Color color,String str,int x,int y){
        //打印字符串
        g.setColor(Color.BLACK);
        g.setFont(new Font("仿宋",Font.BOLD,size));
        g.drawString(str ,x,y);
    }
}
