package learning_linked_lists;

public class InsertNode {
    static class Node {
        int value;
        Node next;

        Node(int val) {
            value = val;
            next = null;
        }
    }

    static class LinkedList {
        Node head;

        LinkedList() {
            head = null;
        }

        public int getHeadValue() {
            if (head == null) {
                return -1;
            } else {
                return head.value;
            }
        }

        public void insertFront(int value) {
            System.out.println("Inserting " + value);

            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertFront(2);
        System.out.println("The value at head is: " + list.getHeadValue());
        list.insertFront(3);
        System.out.println("The value at head is: " + list.getHeadValue());
    }
}
