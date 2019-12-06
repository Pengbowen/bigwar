package com.chris;

public abstract class Enemy implements Fly{
    protected int x;

    protected int y;

    protected int blood;

    protected int status = 0;

    protected  int width;

    protected  int height;

    protected  int score;


    public void hit(){
        if (blood == 0){
            MainPanel.score +=this.getScore();
            return;
        }
        this.blood--;
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

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
