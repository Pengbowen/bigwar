package com.chris;

import javax.swing.*;
import java.awt.*;

public class SEnemy extends Enemy {

    private static final int DEAD_STATUS = 5;


    private static ImageIcon imageIcon = new ImageIcon("src/imgs/senemy.png");
    private static ImageIcon imageIcon1 = new ImageIcon("src/imgs/senemy1.png");
    private static ImageIcon imageIcon2 = new ImageIcon("src/imgs/senemy2.png");
    private static ImageIcon imageIcon3 = new ImageIcon("src/imgs/senemy3.png");
    private static ImageIcon imageIcon4 = new ImageIcon("src/imgs/senemy4.png");

    private static  ImageIcon[] imageIcons = new ImageIcon[]{imageIcon,imageIcon1,imageIcon2,imageIcon3,imageIcon4};

    public SEnemy(int x,int y) {
        this.x = x;
        this.y = y;
        this.blood = 2;
        this.width = 49;
        this.height = 36;
        this.score = 5;
    }

    @Override
    public void paintObject(Graphics g) {

        if (blood == 0){
            g.drawImage(SEnemy.imageIcons[++status/6].getImage(),x,y++,null);
        }else {
            g.drawImage(SEnemy.imageIcons[status].getImage(),x,y++,null);
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
