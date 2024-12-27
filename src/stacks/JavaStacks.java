package stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class JavaStacks {
    public static void main(String[] args) {
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);

        int topElement = stack.peek();
        System.out.println("Top element: " + topElement);

        stack.pop();
        topElement = stack.peek();
        System.out.println("Top element after pop: " + topElement);
    }
}
