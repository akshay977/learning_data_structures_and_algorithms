package singly_linked_lists;

public class InsertNodeAtEnd {
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

        public LinkedList() {
            this.head = null;
        }

        public void insertNodeAtEnd(int val) {
            Node newNode = new Node(val);

            if (this.head == null) {
                this.head = newNode;
            } else {
                Node current = this.head;

                while (current.next != null) {
                    current = current.next;
                }

                current.next = newNode;
            }
        }

        public void print() {
            Node temp = this.head;

            while (temp != null) {
                System.out.printf("%d ", temp.value);
                temp = temp.next;
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insertNodeAtEnd(2);
        list.insertNodeAtEnd(3);

        list.print();
    }
}
