package cn.zhangchi.singleton;

/**
 * 懒汉式
 * 试图解决线程不安全的问题，双重检测
 * 完美方法、但是没必要
 */
public class Mgr05 {
    private static volatile Mgr05 INSTANCE; //JIT机制，比较复杂，暂时不想太多

    private Mgr05(){}

    public static Mgr05 getINSTANCE(){
        // 有必要的第一次检测，因为检测后可能就不用上锁了
        if(INSTANCE == null){
            synchronized (Mgr05.class){
                //双重检测
                if(INSTANCE == null){
                    try{
                        Thread.sleep(1);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }
                    INSTANCE = new Mgr05();
                }
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            new Thread(()->
                    System.out.println(Mgr05.getINSTANCE().hashCode())
            ).start();
        }
    }
}
