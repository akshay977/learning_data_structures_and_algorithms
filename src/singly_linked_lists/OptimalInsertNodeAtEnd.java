package singly_linked_lists;

public class OptimalInsertNodeAtEnd {
    public static class Node {
        int value;
        Node next;

        Node(int val) {
            value = val;
            next = null;
        }
    }

    public static class LinkedList {
        Node head;
        Node tail;

        LinkedList() {
            head = null;
            tail = null;
        }

        public void insertAtEnd(int value) {
            Node newNode = new Node(value);

            if (head == null) {
                head = newNode;
                tail = newNode;
            }

            tail.next = newNode;
            tail = newNode;
        }

        public void print() {
            Node temp = head;

            while (temp != null) {
                System.out.printf("%d ", temp.value);
                temp = temp.next;
            }
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insertAtEnd(1);
        list.insertAtEnd(2);
        list.insertAtEnd(3);

        list.print();
    }
}
