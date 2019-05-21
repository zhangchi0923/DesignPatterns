package cn.zhangchi.FactoryMethod;

/**
 * 简单工厂的可扩展性并不好
 */
public class SimpleVehicleFactory {
    //before processing, add logs, access..
    public Car createCar(){
        return new Car();
    }

    public Broom createBroom(){
        return new Broom();
    }
}
