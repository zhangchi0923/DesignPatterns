package cn.zhangchi.spring.v2;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class TimeProxy {
    @Before("execution (void cn.zhangchi.spring.v2.Tank.move())")
    public void before(){
        System.out.println("method starts.."+System.currentTimeMillis());
    }

    @After("execution (void cn.zhangchi.spring.v2.Tank.move())")
    public void after(){
        System.out.println("method ends.."+System.currentTimeMillis());
    }
}
