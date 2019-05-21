package cn.zhangchi.Strategy;

public class Dog {
    int food, speed;

    public Dog(int food, int speed) {
        this.food = food;
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                ", speed=" + speed +
                '}';
    }
}
