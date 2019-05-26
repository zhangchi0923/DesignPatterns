package cn.zhangchi.iterator.v2;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(3);
        list.add(2);
        System.out.println(list);
    }
}
class LinkedList{
    private class Node{
        Object o;
        Node next;

        public Node(Object o) {
            this.o = o;
        }
    }

    Node head;
    Node tail;
    private int size = 0;
    public void add(Object o){
        Node n = new Node(o);
        n.next = null;

        if(head == null){
            head = n;
            tail = n;
        }else{
            tail.next = n;
        }
        size++;
    }

    @Override
    public String toString() {
        return "LinkedList{" +
                "head=" + head +
                ", tail=" + tail +
                ", size=" + size +
                '}';
    }
}