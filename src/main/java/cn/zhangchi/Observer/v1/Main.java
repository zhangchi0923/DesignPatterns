package cn.zhangchi.Observer.v1;

/**
 * while循环傻等
 */

class Child{
    private boolean cry = false;

    public boolean isCry() {
        return cry;
    }

    public void wakeUp(){
        System.out.println("Crying...");
        cry = true;
    }

}
public class Main {

    public static void main(String[] args) {
        Child c = new Child();
        while(!c.isCry()){
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            System.out.println("Observing...");
        }
    }
}
