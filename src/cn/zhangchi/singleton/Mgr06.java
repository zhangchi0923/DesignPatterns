package cn.zhangchi.singleton;

/**
 * 懒汉式
 * 静态内部类保证线程安全
 * JVM保证单例
 * 外部类加载时内部类不会被加载
 */
public class Mgr06 {
    private Mgr06(){}

    private static class Mgr06Holder{
        private static final Mgr06 INSTANCE = new Mgr06();
    }

    public static Mgr06 getInstance(){
        return Mgr06Holder.INSTANCE;
    }

    public void m(){
        System.out.println("m");
    }

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            new Thread(()->
                    System.out.println(Mgr06.getInstance().hashCode())
            ).start();
        }
    }
}
