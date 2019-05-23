package cn.zhangchi.proxy.v3;

/**
 * 问题2：不能改源码怎么办？
 * 解决：继承？
 * 问题3：耦合度太高，但可以用。
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
}

class Tank2 extends Tank{
    @Override
    public void move() {
        long start = System.currentTimeMillis();
        super.move();
        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }


}
