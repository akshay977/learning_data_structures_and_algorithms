package stacks;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

class NextSmallerElement {
	public static void main (String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] arr = {1, 3, 5, 1, 3};
        int[] arr = {2, 6, 8, 4};
        int n = arr.length;
//        for (int i = 0; i < n; i++) {
//            arr[i] = sc.nextInt();
//        }

        Deque<Integer> stack = new ArrayDeque();
        int nse[] = new int[n];

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() >= arr[i]) {
                stack.pop();
            }

            nse[i] = stack.isEmpty() ? -1 : stack.peek();

            stack.push(arr[i]);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(nse[i] + " ");
        }
	}
}
