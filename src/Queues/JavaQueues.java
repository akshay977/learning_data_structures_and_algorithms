package Queues;

import java.util.LinkedList;
import java.util.Queue;

public class JavaQueues {
    public static void main(String[] args) {
        Queue<Integer> myQueue = new LinkedList<>();

        myQueue.offer(1);
        myQueue.offer(2);
        myQueue.offer(3);

        System.out.println("Front element: " + myQueue.peek());

        System.out.println("Queue elements: ");
        while (!myQueue.isEmpty()) {
            System.out.println(myQueue.poll() + " ");
        }
        System.out.println();

        if (myQueue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Queue is not empty");
        }
    }
}
