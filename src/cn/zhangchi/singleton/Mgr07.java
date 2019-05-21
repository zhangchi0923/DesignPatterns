package cn.zhangchi.singleton;

/**
 * Java创始人给出的枚举单例
 * 不仅解决线程问题，还可以防止反序列化
 * 完美中的完美
 */
public enum Mgr07 {
    /*
    除了枚举类，其他类都有构造方法，都可能由于反射的newInstance()方法而被反序列化
    而枚举类没有构造方法，因此可以防止反序列化
     */

    INSTANCE;

    public void m(){}

    public static void main(String[] args) {
        for(int i=0;i<100;i++){
            new Thread(()->
                    System.out.println(Mgr07.INSTANCE.hashCode())
            ).start();
        }
    }
}
