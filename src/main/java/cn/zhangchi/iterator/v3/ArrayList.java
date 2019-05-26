package cn.zhangchi.iterator.v3;

import java.util.Arrays;


class ArrayList implements Collection_{
    Object[] objects = new Object[10];

    private int index = 0;

    @Override
    public int size() {
        return index;
    }

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
    public Iterator_ iterator() {
        return new ArrayListIterator();
    }
    private class ArrayListIterator implements Iterator_{
        int currentIndex = 0;
        @Override
        public boolean hasNext() {
            return currentIndex < index;
        }

        @Override
        public Object next() {
            Object o = objects[currentIndex];
            currentIndex++;
            return o;
        }
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "objects=" + Arrays.toString(objects) +
                '}';
    }
}