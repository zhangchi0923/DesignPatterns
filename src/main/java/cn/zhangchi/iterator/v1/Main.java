package cn.zhangchi.iterator.v1;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        ArrayList arr = new ArrayList();
        arr.add(1);
        arr.add(3);
        arr.add(2);
        System.out.println(arr);
    }
}


class ArrayList{
    Object[] objects = new Object[10];

    private int index = 0;
    public void add(Object o){
        if(index == objects.length){
            Object[] newobjects = new Object[2*objects.length];
            System.arraycopy(objects,0,newobjects,0,objects.length);
            objects = newobjects;
        }
        objects[index] = o;
        index++;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "objects=" + Arrays.toString(objects) +
                '}';
    }
}