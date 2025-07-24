package sorting;

import java.util.Arrays;

/*
    Insertion sorting the current element is inserted
    into the right position after displacing the elements
    from that position to the right moving from right to left.

    Time complexity: O(n2)
    Space complexity: O(1)
*/
public class insertion_sorting {
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }

        System.out.println(Arrays.toString(arr));
    }
}
