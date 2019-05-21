package cn.zhangchi.Strategy;

import java.util.Comparator;

public class DogSpeedComparator implements Comparator<Dog> {
    @Override
    public int compare(Dog o1, Dog o2) {
        if(o1.speed>o2.speed) return 1;
        else if(o1.speed<o2.speed) return -1;
        else return 0;
    }
}
