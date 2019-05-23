package cn.zhangchi.iterator.v2;

public class Main {
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
}