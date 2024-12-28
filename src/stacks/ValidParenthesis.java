package stacks;

public class ValidParenthesis {
    static final int MAX_SIZE = 101;
    static char[] a = new char[MAX_SIZE];
    static int top = -1;

    static void push(char ele) {
        if (top < MAX_SIZE - 1) {
            a[++top] = ele;
        } else {
            System.out.println("Stack is full. Cannot push: " + ele);
        }
    }

    static char pop() {
        if (top >= 0) {
            char ele = a[top];
            top--;
            return ele;
        } else {
            System.out.println("Stack is empty");
            return '-';
        }
    }

    static boolean isEmpty() {
        return top == -1;
    }

    static boolean isFull() {
        return top == MAX_SIZE - 1;
    }

    static boolean isBalanced(String expression) {
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);

            if (ch == '(') {
                push('(');
            } else {
                if (isEmpty()) {
                    return false;
                }
                pop();
            }
        }

        return isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isBalanced("((()))"));
        System.out.println(isBalanced("()()()"));
        System.out.println(isBalanced("(((())"));
    }
}
