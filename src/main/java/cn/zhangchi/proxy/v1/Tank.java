package cn.zhangchi.proxy.v1;

/**
 * 问题1：想记录move运行的时间怎么办？
 */

import java.util.Random;

interface Movable{
    void move();
}

public class Tank implements Movable{
    @Override
    public void move() {
        System.out.println("Tank moving...");
        try{
            Thread.sleep(new Random().nextInt(10000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
