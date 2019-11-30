package com.chris;

import javax.swing.*;
import java.awt.*;

public class Bullet implements Fly {
    private String id;

    private int x;

    private int y;

    private ImageIcon imageIcon = new ImageIcon("src/imgs/bullet.png");

    public Bullet(String id,int x,int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public void move(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public void paintObject(Graphics g) {
        g.drawImage(imageIcon.getImage(),x,y,null);
        y-=5;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
