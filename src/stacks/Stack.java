package stacks;

public class Stack {
    static final int MAX_SIZE=101;
    static int[] a = new int[MAX_SIZE];
    static int top = -1;

    static void push(int ele) {
        System.out.println("Top: " + top);
        if (top < MAX_SIZE - 1) {
            top++;
            a[top] = ele;
            System.out.println("Pushed: " + ele);
        } else {
            System.out.println("Stack is full. Cannot push: " + ele);
        }
    }

    static int pop() {
        if (top >= 0) {
            int ele = a[top];
            top--;
            System.out.println("Popped: " + ele);
            return ele;
        } else {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        }
    }

    static int peek() {
        if (top >= 0) {
            int ele = a[top];
            System.out.println("Peeked: " + ele);
            return ele;
        } else {
            System.out.println("Stack is empty. Cannot peek.");
            return -1;
        }
    }

    static boolean isEmpty() {
        return top == -1;
    }

    static boolean isFull() {
        return top == MAX_SIZE - 1;
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        for (int i = 1; i <= 102; i++) {
            stack.push(i);
        }
        System.out.println("Stack is empty? : " + stack.isEmpty());
        System.out.println("Stack is full? : " + stack.isFull());
    }
}
