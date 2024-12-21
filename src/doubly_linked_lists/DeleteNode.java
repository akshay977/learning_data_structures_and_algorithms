package doubly_linked_lists;

public class DeleteNode {
    public static class Node {
        Node next;
        Node prev;
        int value;

        Node(int val) {
            value = val;
        }
    }

    public static class DoublyLinkedList {
        Node head;
        Node tail;

        DoublyLinkedList() {
            head = null;
            tail = null;
        }

        public void insertAtIndex(int index, int value) {
            Node newNode = new Node(value);

            if (index == 0) {
                newNode.next = head;
                if (head != null) {
                    head.prev = newNode;
                }
                head = newNode;
            } else {
                Node iter = head;
                int i = 0;
                while (i < index - 1) {
                    iter = iter.next;
                    i++;
                }

                Node A = iter;
                Node B = iter.next;

                A.next = newNode;
                if (B != null) {
                    B.prev = newNode;
                }

                newNode.next = B;
                newNode.prev = A;
            }
        }

        public void deleteNode(int value) {
            Node temp = head;
            while (temp.value != value) {
                temp = temp.next;
            }

            Node A = temp.prev;
            Node B = temp.next;

            if (A != null) {
                A.next = B;
            }
            if (B != null) {
                B.prev = A;
            }
            if (temp == head) {
                head = temp.next;
            }
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
        DoublyLinkedList dlist = new DoublyLinkedList();
        dlist.insertAtIndex(0, 5);
        dlist.insertAtIndex(0, 4);
        dlist.insertAtIndex(0, 3);
        dlist.insertAtIndex(0, 2);
        dlist.insertAtIndex(0, 1);

        dlist.deleteNode(1);
        dlist.print();
    }
}
