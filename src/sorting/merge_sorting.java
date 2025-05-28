package sorting;

import java.util.Arrays;

/*
    Time complexity: O(nlogn)
    Space complexity: O(n)
*/
public class merge_sorting {
    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right) {
        // Write your code here
        if (left < right) {
            int middle = (left + right)/2;
            mergeSort(arr, left, middle);
            mergeSort(arr, middle+1, right);
            merge(arr, left, middle, right);
        }
    }

    public static void merge(int[] arr, int left, int middle, int right) {
        int[] merged_arr = new int[right - left + 1];
        int i = left;
        int j = middle+1;
        int k = 0;

        while (i <= middle && j <= right) {
            if (arr[i] > arr[j]) {
                merged_arr[k] = arr[j];
                j++;
            } else {
                merged_arr[k] = arr[i];
                i++;
            }
            k++;
        }

        while (i <= middle) {
            merged_arr[k] = arr[i];
            i++;
            k++;
        }

        while (j <= right) {
            merged_arr[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < merged_arr.length; l++) {
            arr[left+l] = merged_arr[l];
        }
    }
}
