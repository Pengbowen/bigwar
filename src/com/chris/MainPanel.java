package com.chris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.*;
import java.util.List;

public class MainPanel extends JPanel {

    private EnemyFactory factory = new EnemyFactory();

    public static int score = 0;

    public  Status status = Status.START;

    Sky sky = new Sky();
    Hero hero = new Hero();
    Map<String,Bullet> bulletMap = new HashMap<>();
    List<Enemy> enemyList = Collections.synchronizedList(new ArrayList<>());
    //计数器
    long count = 0;
    //子弹发射间隔
    int bulletPeriod = 20;
    //敌机产生间隔
    int enemyPeriod = 80;


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
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (status == Status.RUNNING){
                    status = Status.PAUSE;
                }else{
                    status = Status.RUNNING;
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }
            @Override
            public void mouseEntered(MouseEvent e) {
                if (status == Status.PAUSE){
                    status = Status.RUNNING;
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {
                if(status == Status.RUNNING){
                    status = Status.PAUSE;
                }

            }
        });
    }


    @Override
    public void paint(Graphics g) {

        switch (status){
            case START:
                g.drawImage(new ImageIcon("src/imgs/start.png").getImage(),20,0,null);
                break;
            case RUNNING:
                run(g);
                break;
            case PAUSE:
                g.drawImage(new ImageIcon("src/imgs/pause.png").getImage(),35,50,null);
                break;
        }

    }

    void run(Graphics g){
        sky.paintObject(g);
        hero.paintObject(g);
        //当计数器满足条件，创建一个新的子弹
        if(count % bulletPeriod == 0 ){
            Bullet bullet = new Bullet(UUID.randomUUID().toString(),hero.getX()+45,hero.getY()-8);
            bulletMap.put(bullet.getId(),bullet);
        }
        Iterator<Map.Entry<String, Bullet>> iterator = bulletMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Bullet> next = iterator.next();
            Bullet bullet = next.getValue();
            if (bullet.getY() < -10){
                iterator.remove();
            }else{
                bullet.paintObject(g);
            }
        }
        if (count % enemyPeriod == 0){

            Enemy enemy = factory.newEnemy();
            enemyList.add(enemy);
        }
        Iterator<Enemy> enemyIterator = enemyList.iterator();
        while (enemyIterator.hasNext()){
            Enemy next = enemyIterator.next();

            Iterator<Map.Entry<String, Bullet>> bulletIterator = bulletMap.entrySet().iterator();
            while (bulletIterator.hasNext()){
                Bullet bullet = bulletIterator.next().getValue();
                int bx  = bullet.getX();
                int by = bullet.getY();
                int ex = next.getX();
                int ey = next.getY();
                //碰撞
                if (bx>=ex && bx <= ex+next.getWidth() && by >= ey && by<= ey+next.getHeight()){
                    next.hit();
                    bulletIterator.remove();
                }
            }
            if (next.status >= 25){
                enemyIterator.remove();
            }
            next.paintObject(g);
        }
        count++;
        g.drawString("SCORE:"+score,20,20);
    }
}
