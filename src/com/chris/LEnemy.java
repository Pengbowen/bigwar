package com.chris;

import javax.swing.*;
import java.awt.*;

public class LEnemy extends Enemy {

    private static final int DEAD_STATUS = 5;


    private static ImageIcon imageIcon = new ImageIcon("src/imgs/enemy.png");
    private static ImageIcon imageIcon1 = new ImageIcon("src/imgs/enemy1.png");
    private static ImageIcon imageIcon2 = new ImageIcon("src/imgs/enemy2.png");
    private static ImageIcon imageIcon3 = new ImageIcon("src/imgs/enemy3.png");
    private static ImageIcon imageIcon4 = new ImageIcon("src/imgs/enemy4.png");

    private static  ImageIcon[] imageIcons = new ImageIcon[]{imageIcon,imageIcon1,imageIcon2,imageIcon3,imageIcon4};

    public LEnemy(int x,int y) {
        this.x = x;
        this.y = y;
        this.blood = 6;
        this.width = 69;
        this.height = 99;
    }

    @Override
    public void paintObject(Graphics g) {
        if (blood == 0){
            g.drawImage(LEnemy.imageIcons[status/6].getImage(),x,y++,null);
            status++;
        }else {
            g.drawImage(LEnemy.imageIcons[status].getImage(),x,y++,null);
        }
    }

    @Override
    public String toString() {
        return "LEnemy{" +
                "x=" + x +
                ", y=" + y +
                ", blood=" + blood +
                ", status=" + status +
                '}';
    }
}
