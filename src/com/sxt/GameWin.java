package com.sxt;

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cgpstart
 * @create 2021-08-18 13:41
 */

public class GameWin extends JFrame {//创建窗口，监听鼠标事件

    //0:未开始  1：运行中   2：商店   3： 失败  4、成功
    static int state;

    //创建集合存储金块、石块
    List<Object> objectList= new ArrayList<>();

    //创建背景类的对象
    Bg bg = new Bg();
    //创建红线的对象
    Line line = new Line(this);

    //添加金块
    {
        //是否可以放置
        boolean isPlace = true;

        for(int i = 0;i < 11;i ++){
            double random = Math.random();
            Gold gold ;//存放当前的金块
            if(random<0.3){
                gold = new GoldMini();
            }
            else if(random<0.7){
               gold = new Gold();
            }
            else{
                gold = new GoldPlus();
            }

            for(Object obj : objectList){
                if(gold.getRec().intersects(obj.getRec())){//判断是否重叠
                    //不可放置，需要重新生成
                    isPlace = false;
                }
            }
            if (isPlace){
                objectList.add(gold);
            }else{
                isPlace = true;
                i--;
            }
        }

    //创建三个石块

        for(int i = 0;i < 5;i ++){

            Rock rock = new Rock() ;//存放当前的石块

            for(Object obj : objectList){
                if(rock.getRec().intersects(obj.getRec())){//判断是否重叠
                    //不可放置，需要重新生成
                    isPlace = false;
                }
            }
            if (isPlace){
                objectList.add(rock);
            }else{
                isPlace = true;
                i--;
            }
        }
    }


    //利用双缓存技术解决人物闪动
    //创建幕布
    Image offScreanImage;

    //窗口设置
    //launch()初始化窗口信息
    void launch(){

        //设置窗口可见
        this.setVisible(true);
        //设置窗口大小
        this.setSize(768,1000);
        //设置窗口位置居中
        this.setLocationRelativeTo(null);
        //设置窗口标题
        this.setTitle("阿皮黄金矿工");
        //关闭窗口
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //设置鼠标事件，改变红绳状态
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                switch(state){
                    case 0:
                        if(e.getButton() == 3){
                            state = 1;
                        }
                            break;
                    case 1:
                        //左右摇摆
                        if(e.getButton() == 1 && line.state == 0){
                            line.state = 1;
                        }
                        //抓取返回
                        if(e.getButton() == 3 && line.state == 3){
                            Bg.waterFlag = true;
                            Bg.waterNum --;
                            break;
                        }
                    case 2:
                    case 3:
                    case 4:
                        default:

                }

            }
        });

        while(true){
            repaint();
            nextlevel();
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    //下一关
    public void nextlevel(){
        if(Bg.count >= bg.goal){
            Bg.level += 1;
            GameWin gameWin = new GameWin();
            dispose();
            gameWin.launch();
        }

    }

    //绘制窗口
    @Override
    public void paint(Graphics g) {
        //创建画布
        offScreanImage = this.createImage(768,1000);
        Graphics gImage = offScreanImage.getGraphics();

        //在画布上画背景
        bg.paintSelf(gImage);
        //绘制物块
        for(Object obj :objectList){
            obj.paintSelf(gImage);

        }
        line.paintSelf(gImage);

        //将画布绘制到窗口中
        g.drawImage(offScreanImage,0,0,null);
    }

    public static void main(String[] args) {
        com.sxt.GameWin gameWin = new com.sxt.GameWin();
        gameWin.launch();

    }

}