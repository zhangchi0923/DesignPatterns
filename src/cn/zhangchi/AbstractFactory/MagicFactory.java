package cn.zhangchi.AbstractFactory;

public class MagicFactory extends AbstractFactory {
    @Override
    Food createFood() {
        return new Mushroom();
    }

    @Override
    Weapon createWeapon() {
        return new MagicStick();
    }

    @Override
    Vehicle createVehicle() {
        return new Broom();
    }
}
