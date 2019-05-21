package cn.zhangchi.singleton;

/**
 * 饿汉式
 * 解决了线程安全问题但效率降低
 */
public class Mgr03 {
    private static Mgr03 INSTANCE;

    private Mgr03(){}

    public synchronized Mgr03 getINSTANCE(){
        if(INSTANCE == null){
            INSTANCE = new Mgr03();
        }
        return INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }
}
