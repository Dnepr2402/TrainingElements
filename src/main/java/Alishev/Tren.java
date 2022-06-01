package Alishev;

import java.util.LinkedList;
import java.util.List;

public class Tren {
    public static void main(String[] args) {
        MyLinkedList linkedList = new MyLinkedList();
        linkedList.add(5);
        linkedList.add(4);
        linkedList.add(10);
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
        System.out.println(linkedList.get(2));
        linkedList.remove(0);
        System.out.println(linkedList.get(0));
        System.out.println(linkedList.get(1));
    }
}
