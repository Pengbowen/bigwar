package com.chris;

import javax.swing.*;
import java.awt.*;

/**
 * 英雄战机
 */
public class Hero implements Fly {

    private int x = 180;

    private int y = 500;

    private ImageIcon hero = new ImageIcon("src/imgs/hero.png");


    public Hero() {
    }

    public void move(int x,int y){
        this.x = x - 49;
        this.y = y - 62 ;
    }

    @Override
    public void paintObject(Graphics g) {
        g.drawImage(hero.getImage(),x, y,null);
    }
}
