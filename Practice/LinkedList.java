package Practice;

import java.util.ArrayList;

public class LinkedList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    private Node head;
    private Node tail;


    public void addNode(int item) {
        if (head == null) {
            head = new Node(item);
            tail = head;
        } else {
            Node temp = new Node(item);
            head.next = temp;
            tail = temp;
        }
    }



}
