package cn.zhangchi.Observer.v2;

/**
 * 加入观察者Dad
 */
class Child{
    private boolean cry = false;
    private Dad d = new Dad();
    public boolean isCry() {
        return cry;
    }

    public void wakeUp(){
        cry = true;
        d.feed();
    }
}

class Dad{

    public void feed(){
        System.out.println("Dad is feeding...");
    }
}
public class Main {
    public static void main(String[] args) {
        Child c = new Child();
        c.wakeUp();
    }
}
