package stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class NextGreaterElementAlgo {
    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 10, 8};
        int n = arr.length;

        Deque<Integer> stack = new ArrayDeque<>();
        int nge[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() < arr[i]) {
                stack.pop();
            }

            nge[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(nge[i] + " ");
        }
    }
}
