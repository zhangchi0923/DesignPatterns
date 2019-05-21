package cn.zhangchi.FactoryMethod;

public class Main {
    public static void main(String[] args) {
        Movable c = new CarFactory().createCar();

        c.go();
    }
}
