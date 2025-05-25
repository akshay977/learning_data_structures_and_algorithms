package sorting;

import java.util.Arrays;

/*
    Selection sorting is basically selecting the most minimum/maximum
    element and swaping it with the current element hence creating
    a sorted portion and unsorted portion.

    Time Complexity: O(n2) in the best, average, and worst cases.
    Space Complexity: O(1)
*/
public class selection_sorting {
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        int n = arr.length;

        for (int i = 0; i < n-1; i++) {
            int minIndex = i;
            for (int j = i+1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }

        System.out.println(Arrays.toString(arr));
    }
}
