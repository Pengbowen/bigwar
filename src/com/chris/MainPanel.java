package com.chris;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MainPanel extends JPanel {

    Sky sky = new Sky();
    Hero hero = new Hero();

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
    }
}
