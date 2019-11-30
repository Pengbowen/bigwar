package com.chris;

import javax.swing.*;
import java.awt.*;

public class Sky implements Fly {

    private ImageIcon imageIcon = new ImageIcon("src/imgs/background.png");
    private int y= 0;
    private Graphics g;

    @Override
    public void paintObject(Graphics g) {
        this.g = g;
        g.drawImage(imageIcon.getImage(),0,y,null);
        g.drawImage(imageIcon.getImage(),0,imageIcon.getIconHeight()+y,null);
        y-=2;
        if ((y + imageIcon.getIconHeight()) == 0){
            y = 0;
        }
    }
}
