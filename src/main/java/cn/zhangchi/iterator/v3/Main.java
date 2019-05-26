package cn.zhangchi.iterator.v3;

public class Main {
    public static void main(String[] args) {
        ArrayList arr = new ArrayList();
        arr.add(1);
        arr.add(3);
        arr.add(2);
        Iterator_ it1 = arr.iterator();
        System.out.println("arr: ");
        while(it1.hasNext()){
            System.out.print(it1.next()+" ");
        }
        System.out.println();
        System.out.println("=============");

        LinkedList list = new LinkedList();
        list.add(1);
        list.add(3);
        list.add(2);
        Iterator_ it2 = list.iterator();
        System.out.println("list: ");
        while(it2.hasNext()){
            System.out.print(it2.next()+" ");
        }
    }
}
