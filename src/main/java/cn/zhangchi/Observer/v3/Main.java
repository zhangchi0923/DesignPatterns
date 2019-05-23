package cn.zhangchi.Observer.v3;

/**
 * 添加很多观察者
 */
class Child{
    private boolean cry = false;
    private Dad dad = new Dad();
    private Mom mom = new Mom();
    private Dog dog = new Dog();


    public boolean isCry() {
        return cry;
    }

    public void wakeUp(){
        cry = true;
        dad.feed();
        mom.hug();
        dog.bark();
    }
}

class Dad{
    public void feed(){ System.out.println("Dad is feeding..."); }
}
class Mom{
    public void hug(){ System.out.println("Mom is hugging..."); }
}
class Dog{
    public void bark(){System.out.println("Dog is barking...");}
}
public class Main {
    public static void main(String[] args) {
        Child c = new Child();
        c.wakeUp();
    }

}
