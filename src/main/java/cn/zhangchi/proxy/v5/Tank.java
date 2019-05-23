package cn.zhangchi.proxy.v5;

/**
 * 问题4：只可以代理TankTime？可不可以也代理其他Movable？
 * 将Movable聚合进来，这样不同的代理之间也可以相互代理
 */

import java.util.Random;

interface Movable{
    void move();
}

public class Tank implements Movable {
    @Override
    public void move() {
        System.out.println("Tank moving...");
        try{
            Thread.sleep(new Random().nextInt(10000));
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new TankTimeProxy(new Tank()).move();
        new TankLogProxy(new Tank()).move();
    }
}

class TankTimeProxy implements Movable {
    // 聚合而不没有继承
    Movable m;

    public TankTimeProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        long start = System.currentTimeMillis();
        m.move();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
}

class TankLogProxy implements Movable {
    // TankTimeProxy也可以代理TankLogProxy
    Movable m;

    public TankLogProxy(Movable m) {
        this.m = m;
    }

    @Override
    public void move() {
        System.out.println("Start moving...");
        m.move();
        System.out.println("Stop moving...");
    }
}
