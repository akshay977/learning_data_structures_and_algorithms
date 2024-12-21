package singly_linked_lists;

public class InsertNodeKthPosition {
    public static class Node {
        int value;
        Node next;

        Node(int val) {
            value = val;
        }
    }

    public static class LinkedList {
        Node head;

        LinkedList() {
            head = null;
        }

        public void insertNodeKthPosition(int value, int k) {
            Node newNode = new Node(value);
            Node current = head;

            if (current == null) {
                head = newNode;
                return;
            }

            for (int i = 1; i < k; i++) {
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
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
        list.insertNodeKthPosition(1, 1);
        list.insertNodeKthPosition(2, 1);
        list.insertNodeKthPosition(3, 1);
        list.insertNodeKthPosition(3, 2);

        list.print();
    }
}
