package sorting;

import java.util.Arrays;

public class bubble_sorting {
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};

        int n = arr.length;
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        // Time complexity: O(n^2)
        // Space complexity: O(1)
        System.out.println(Arrays.toString(arr));
    }
}
