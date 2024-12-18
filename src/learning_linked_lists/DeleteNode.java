package learning_linked_lists;

public class DeleteNode {
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

        public void insertFront(int value) {
            System.out.println("Inserting value: " + value);

            Node newNode = new Node(value);
            newNode.next = head;
            head = newNode;
        }

        public void deleteNode(int value) {
            if (head.value == value) {
                head = head.next;
                return;
            }

            Node current = head.next;
            Node prev = head;
            while (current.value != value) {
                prev = current;
                current = current.next;
            }
            prev.next = current.next;
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
        list.insertFront(1);
        list.insertFront(2);
        list.insertFront(3);
        list.insertFront(4);
        list.insertFront(5);

        list.deleteNode(1);
        list.deleteNode(3);
        list.print();
    }
}
