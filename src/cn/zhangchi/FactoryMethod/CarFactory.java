package cn.zhangchi.FactoryMethod;

public class CarFactory {

    public Movable createCar(){
        System.out.println("A new car is created.");
        return new Car();
    }
}
