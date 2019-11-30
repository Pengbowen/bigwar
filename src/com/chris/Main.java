package com.chris;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    public static void main(String[] args) {
            MainFrame mainFrame = new MainFrame();
            mainFrame.setTitle("飞机大战");
            mainFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

            MainPanel mainPanel = new MainPanel();


            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    mainPanel.repaint();
                }
            },100,1);
            mainFrame.add(mainPanel);
            mainFrame.setVisible(true);

    }
}
