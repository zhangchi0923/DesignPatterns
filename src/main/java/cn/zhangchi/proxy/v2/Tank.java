package cn.zhangchi.proxy.v2;
/**
 * 解决：记录move的Tank.java时间
 * 办法：在move方法中记录时间
 * 问题2：如果没法改源码怎么办？
 */

import java.util.Random;

interface Movable{
    void move();
}

public class Tank implements Movable {
    @Override
    public void move() {
        long start = System.currentTimeMillis();

        System.out.println("Tank moving...");
        try{
            Thread.sleep(new Random().nextInt(10000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        long end = System.currentTimeMillis();
        System.out.println(end-start+"ms");
    }

    public static void main(String[] args) {
        new Tank().move();
    }
}
