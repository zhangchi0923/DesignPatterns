package cn.zhangchi.flyweight;
/**
 * FlyWeight享元模式
 */

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

class Bullet{
    public UUID id = UUID.randomUUID();
    boolean isAlive = true;

    @Override
    public String toString() {
        return "Bullet{" +
                "id=" + id +
                '}';
    }
}
public class BulletPool {
    private List<Bullet> bullets = new ArrayList<>();

    {
        for(int i=0;i<5;i++){
            bullets.add(new Bullet());
        }
    }

    public Bullet getBullet(){
        for(int i=0;i<bullets.size();i++){
            Bullet b = bullets.get(i);
            if(!b.isAlive) return b;
        }
        return new Bullet();
    }

    public static void main(String[] args) {
        BulletPool bp = new BulletPool();

        for(int i=0;i<10;i++){
            Bullet b = bp.getBullet();
            System.out.println(b);
        }
        System.out.println("==============================================");
        for(int i=0;i<bp.bullets.size();i++){
            System.out.println(bp.bullets.get(i));
        }
    }
}
