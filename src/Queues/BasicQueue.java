package Queues;

public class BasicQueue {
    private static final int maxSize = 4;
    private int[] a = new int[maxSize];
    private int front = 0;
    private int rear = -1;
    private int currentSize;

    public boolean isEmpty() {
        return currentSize == 0;
    }

    public boolean isFull() {
        return currentSize == maxSize;
    }

    public int size() {
        return currentSize;
    }

    public void enqueue(int item) {
        if (isFull()) {
            System.out.println("Queue is full. Cannot enqueue.");
            return;
        }
        rear = (rear + 1)%maxSize;
        a[rear] = item;
        currentSize++;
    }

    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty. Cannot dequeue.");
            return -1;
        }
        int removedItem = a[front];
        front = (front + 1)%maxSize;
        currentSize--;
        return  removedItem;
    }

    public static void main(String[] args) {
        BasicQueue q1 = new BasicQueue();
        q1.enqueue(1);
        q1.enqueue(2);
        q1.enqueue(3);
        q1.enqueue(4);
        System.out.println(q1.size());
    }
}
