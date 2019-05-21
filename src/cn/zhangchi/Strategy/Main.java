package cn.zhangchi.Strategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int[] arr = {13,9,2,56,28,1,7,45,3,91};
        Cat[] arr = {new Cat(3,3),new Cat(1,1),new Cat(5,5)};
        Dog[] d = {new Dog(6,6),new Dog(2,7),new Dog(4,4)};
        Sorter<Dog> sorter = new Sorter<>();
        sorter.sort(d,(o1,o2)->{
            if(o1.food>o2.food) return 1;
            else if(o1.food<o2.food) return -1;
            else return 0;
        });
        System.out.println(Arrays.toString(d));

    }
}
