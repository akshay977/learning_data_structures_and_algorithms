package circular_linked_lists;

public class DeleteNode {
    public static class Node {
        int value;
        Node next;

        Node(int val) {
            this.value = val;
            this.next = null;
        }
    }

    public static class CircularLinkedList {
        Node head;
        Node tail;

        CircularLinkedList() {
            this.head = null;
            this.tail = null;
        }

        public void insertNodeAtEnd(int value) {
            Node newNode = new Node(value);

            if (head == null) {
                this.head = newNode;
                this.tail = newNode;
            } else {
                this.tail.next = newNode;
                this.tail = newNode;
                this.tail.next = this.head;
            }
        }

        public void print() {
            Node temp = head;

            while (temp != null) {
                System.out.printf("%d ", temp.value);
                if (temp == this.tail) break;
                temp = temp.next;
            }
            System.out.println("\n");
        }

        public void deleteNode(int value) {
            if (head == tail && head.value == value) {
                this.head = null;
                this.tail = null;
            }

            if (head.value == value) {
                head = head.next;
                tail = head;
                return;
            }

            Node current = head;

            while (current != null && current != tail) {
                if (current.next.value == value) {
                    current.next = current.next.next;
                    break;
                }
                current = current.next;
            }
        }
    }

    public static void main(String[] args) {
        CircularLinkedList clist = new CircularLinkedList();
        clist.insertNodeAtEnd(1);
        clist.insertNodeAtEnd(2);
        clist.insertNodeAtEnd(3);
        clist.insertNodeAtEnd(4);
        clist.insertNodeAtEnd(5);
        clist.print();


    }
}
