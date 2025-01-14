package stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class LargestRectangularAreaInHistogram {
    public static void main(String[] args) {
        long[] hist = {60, 20, 50, 40, 10, 50, 60};
        System.out.println(getMaxArea(hist));
        System.out.println(getMaxAreaEfficient(hist));
    }

    /*
        --- Brute force approach ---
        Time complexity: O(n^2)
        Space complexity: O(1)
    */
    static int getMaxArea(long[] hist) {
        int maxArea = 0;
        int n = hist.length;

        for (int i = 0; i < n; i++) {
            int curr_height = (int)hist[i];

            for (int j = i - 1; j >= 0 && hist[j] >= hist[i]; j--) {
                curr_height += (int)hist[i];
            }

            for (int j = i + 1; j < n && hist[j] >= hist[i]; j++) {
                curr_height += (int)hist[i];
            }

            maxArea = Math.max(maxArea, curr_height);
        }

        return maxArea;
    }

    static long getMaxAreaEfficient(long[] hist) {
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);

        for (int i = 0; i < hist.length; i++) {
            int curr = (int) hist[i];
            while (stack.peek() != -1 && curr <= hist[stack.peek()]) {
                int y = stack.pop();
                maxArea = (int) Math.max(maxArea, hist[y] * (y - 1 - stack.peek()));
            }
            stack.push(i);
        }

        while (stack.peek() != -1) {
            int y = stack.pop();
            maxArea = (int) Math.max(maxArea, hist[y] * (hist.length - 1 - stack.peek()));
        }

        return maxArea;
    }
}
