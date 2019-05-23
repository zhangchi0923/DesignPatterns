package cn.zhangchi.iterator.v1;

public class Main {
    public static void main(String[] args) {

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
}