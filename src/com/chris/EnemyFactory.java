package com.chris;

public class EnemyFactory {


    /**
     * 生成战机工厂
     * @return
     */
    public static Enemy newEnemy(){
        //随机生成战机，大战机和小战机的比例为 1：5
        // 0-9
        int random = (int) (Math.random()*10);
        int randomX;
        if (random % 4 == 0){
            randomX = (int)(Math.random()*(480-69));
            return new LEnemy(randomX,-99);
        }else{
            randomX = (int)(Math.random()*(480-49));
            return new SEnemy(randomX,-36);
        }
    }
}
