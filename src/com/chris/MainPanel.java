package com.chris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.*;
import java.util.List;

public class MainPanel extends JPanel {

    Sky sky = new Sky();
    Hero hero = new Hero();
    Map<String,Bullet> bulletMap = new HashMap<>();
    List<SEnemy> sEnemyList = Collections.synchronizedList(new ArrayList<SEnemy>());
    //子弹计数器
    long count = 0;
    int period = 20;
    //敌机

    public MainPanel() {
        this.setBounds(0,0,450,852);
        //设置鼠标移动监听
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
            }
            @Override
            public void mouseMoved(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                hero.move(x,y);
            }
        });
    }


    @Override
    public void paint(Graphics g) {
        sky.paintObject(g);
        hero.paintObject(g);
        //当计数器满足条件，创建一个新的子弹
        if(count++ % period == 0 ){
            Bullet bullet = new Bullet(UUID.randomUUID().toString(),hero.getX()+45,hero.getY()-8);
            bulletMap.put(bullet.getId(),bullet);
        }
        Iterator<Map.Entry<String, Bullet>> iterator = bulletMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Bullet> next = iterator.next();
            Bullet bullet = next.getValue();
            if (bullet.getY() < -10){
                iterator.remove();
                System.out.println("容器大小："+bulletMap.size());
            }else{
                bullet.paintObject(g);
            }
        }
    }
}
