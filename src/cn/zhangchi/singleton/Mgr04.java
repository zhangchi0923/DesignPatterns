package cn.zhangchi.singleton;

/**
 * 懒汉式
 * 试图解决线程不安全的问题，但是这是一种典型的错误方法
 */
public class Mgr04 {
    private static Mgr04 INSTANCE;

    private Mgr04(){}

    public static Mgr04 getINSTANCE(){
        if(INSTANCE == null){
            synchronized (Mgr04.class){
                try{
                    Thread.sleep(1);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
                INSTANCE = new Mgr04();
            }
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            new Thread(()->
                    System.out.println(Mgr04.getINSTANCE().hashCode())
            ).start();
        }
    }
}
