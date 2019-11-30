package com.chris;

import javax.swing.*;
import java.awt.*;

public class SEnemy implements Fly {

    private int x;

    private int y;

    private int status = 0;

    private static final int DEAD_STATUS = 5;


    private static ImageIcon imageIcon = new ImageIcon("src/imgs/senemy.png");
    private static ImageIcon imageIcon1 = new ImageIcon("src/imgs/senemy1.png");
    private static ImageIcon imageIcon2 = new ImageIcon("src/imgs/senemy2.png");
    private static ImageIcon imageIcon3 = new ImageIcon("src/imgs/senemy3.png");
    private static ImageIcon imageIcon4 = new ImageIcon("src/imgs/senemy4.png");

    private static  ImageIcon[] imageIcons = new ImageIcon[]{imageIcon,imageIcon1,imageIcon2,imageIcon3,imageIcon4};


    @Override
    public void paintObject(Graphics g) {
        if (status != DEAD_STATUS){
            g.drawImage(SEnemy.imageIcons[status].getImage(),x,y,null);
        }
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
