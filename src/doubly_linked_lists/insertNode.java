package doubly_linked_lists;

public class insertNode {
    public static class Node {
        int value;
        Node next;
        Node prev;

        Node(int val) {
            value = val;
            next = null;
            prev = null;
        }
    }

    public static class DoublyLinkedList {
        Node head;

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

        public void printValues() {
            Node current = head;
            while (current != null) {
                System.out.print(current.value + " ");
                current = current.next;
            }
            System.out.println();
        }
    }
}
