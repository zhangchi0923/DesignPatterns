package cn.zhangchi.proxy.v7;

/**
 * 如果想让LogProxy可以重用，还可以代理其他类型
 * 分离代理行为和代理对象
 * 使用jdk的动态代理
 */

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
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
        Tank tank = new Tank();

        // 通过二进制字节码分析类的属性和方法
        Movable m = (Movable) Proxy.newProxyInstance(Tank.class.getClassLoader(),
                new Class[]{Movable.class},
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("Method: "+method.getName()+" starts...");
                        Object o = method.invoke(tank,args);
                        System.out.println("Method: "+method.getName()+" ends!");
                        return o;
                    }
                });

        m.move();
    }
}

