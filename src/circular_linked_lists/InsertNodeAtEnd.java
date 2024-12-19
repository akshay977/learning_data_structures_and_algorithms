package circular_linked_lists;

public class InsertNodeAtEnd {
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
    }

    public static void main(String[] args) {
        CircularLinkedList clist = new CircularLinkedList();
        clist.insertNodeAtEnd(1);
        clist.insertNodeAtEnd(2);
        clist.print();
    }
}
