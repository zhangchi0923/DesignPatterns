package cn.zhangchi.Observer.v4;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义Observer接口
 */
interface Observer{
    void actionWakeUp();
}
class Child{
    private boolean cry = false;
    private List<Observer> observers = new ArrayList<>();

    {
        observers.add(new Dad());
        observers.add(new Mom());
        observers.add(new Dog());
        observers.add(()-> {System.out.println("ppp");});
    }
    public boolean isCry() {
        return cry;
    }

    public void wakeUp(){
        cry = true;
        for(Observer observer:observers){
            observer.actionWakeUp();
        }

    }
}
class Dad implements Observer{
    public void feed(){ System.out.println("Dad is feeding..."); }

    @Override
    public void actionWakeUp() {
        feed();
    }
}
class Mom implements Observer{
    public void hug(){ System.out.println("Mom is hugging..."); }

    @Override
    public void actionWakeUp() {
        hug();
    }
}
class Dog implements Observer{
    public void bark(){System.out.println("Dog is barking...");}

    @Override
    public void actionWakeUp() {
        bark();
    }
}

public class Main {
    public static void main(String[] args) {
        Child c = new Child();
        c.wakeUp();
    }
}
