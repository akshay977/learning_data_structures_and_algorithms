package Queues;

import java.util.ArrayDeque;
import java.util.Deque;

public class JavaDeque {
    public static void main(String[] args) {
        Deque<Integer> dq1 = new ArrayDeque<>();

        dq1.addFirst(1);
        dq1.addLast(2);
        dq1.addFirst(3);

        System.out.println("Deque: ");
        for (int element: dq1) {
            System.out.print(element + " ");
        }
        System.out.println();

        int frontElement = dq1.removeFirst();
        int backElement = dq1.removeLast();

        System.out.println("Removed from front: " + frontElement);
        System.out.println("Removed from last: " + backElement);

        System.out.println("Updated Deque: ");
        for (int element: dq1) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
