package cn.zhangchi.spring.v1;

public class TimeProxy {
    public void before(){
        System.out.println("method starts.."+System.currentTimeMillis());
    }

    public void after(){
        System.out.println("method ends.."+System.currentTimeMillis());
    }
}
