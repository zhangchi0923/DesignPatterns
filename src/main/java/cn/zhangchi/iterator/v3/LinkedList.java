package cn.zhangchi.iterator.v3;

class LinkedList implements Collection_{
    private class Node{
        Object o;
        Node next;

        public Node(Object o) {
            this.o = o;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "o=" + o +
                    '}';
        }
    }

    Node head;
    Node tail;
    private int size = 0;

    @Override
    public int size() {
        return size;
    }

    public void add(Object o){
        Node n = new Node(o);
        n.next = null;

        if(head == null){
            head = n;
            tail = n;
        }else{
            tail.next = n;
            tail = n;
        }
        size++;
    }

    @Override
    public Iterator_ iterator() {
        return new LinkedListIterator();
    }
    private class LinkedListIterator implements Iterator_{
        Node currentNode = head;
        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public Object next() {
            Object o = currentNode;
            currentNode = currentNode.next;
            return o;
        }
    }

//    @Override
//    public String toString() {
//        return "LinkedList{" +
//                "head=" + head +
//                ", tail=" + tail +
//                ", size=" + size +
//                '}';
//    }
}