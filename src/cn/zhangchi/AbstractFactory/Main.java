package cn.zhangchi.AbstractFactory;

public class Main {
    public static void main(String[] args) {
        AbstractFactory f1 = new ModernFactory();
        AbstractFactory f2 = new MagicFactory();

        Vehicle c = f1.createVehicle();
        c.go();

        Vehicle br = f2.createVehicle();
        br.go();
    }
}
