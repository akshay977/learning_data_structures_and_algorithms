package stacks;

public class ConvertDecimalToBinary {
    static final int MAX_SIZE = 101;
    static int[] a = new int[MAX_SIZE];
    static int top = -1;

    static void push(int ele) {
        if (top < MAX_SIZE - 1) {
            a[++top] = ele;
        } else {
            System.out.println("Stack is full. Cannot push: " + ele);
        }
    }

    static int pop() {
        if (top >= 0) {
            int ele = a[top];
            top--;
            return ele;
        } else {
            System.out.println("Stack is empty. Cannot pop.");
            return -1;
        }
    }

    static boolean isEmpty() {
        return top == -1;
    }

    static boolean isFull() {
        return top == MAX_SIZE - 1;
    }

    static void decimalToBinary(int decimal) {
        while (decimal > 0) {
            int remainder = decimal%2;
            decimal /= 2;
            push(remainder);
        }

        if (isEmpty()) {
            System.out.println("0");
            return;
        }

        while (!isEmpty()) {
            System.out.println(pop());
        }
        System.out.println();
    }

    public static void main(String[] args) {
        decimalToBinary(10);
        decimalToBinary(15);
        decimalToBinary(18);
    }
}
