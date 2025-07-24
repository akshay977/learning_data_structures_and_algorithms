package sorting;

import java.util.Arrays;

public class radix_sorting {
    public static void main(String[] args) {
        int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
//        int arr[] = {80, 10, 50, 20, 0};
        int n = arr.length;

        radixsort(arr, n);
        System.out.println(Arrays.toString(arr));
    }

    static void radixsort(int[] arr, int n) {
        int maxEl = getMaxElement(arr, n);

        for (int exp = 1; maxEl / exp > 0; exp *= 10) {
            counting_sort(arr, n, exp);
        }
    }

    static int getMaxElement(int[] arr, int n) {
        int max = arr[0];

        for (int i = 1; i < n; i++) {
            max = Math.max(max, arr[i]);
        }

        return max;
    }

    static void counting_sort(int[] arr, int n, int exp) {
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            int last_digit = (arr[i]/exp)%10;
            count[last_digit]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i-1];
        }

        for (int i = n-1; i >= 0; i--) {
            output[count[(arr[i]/exp)%10]-1] = arr[i];
            count[(arr[i]/exp)%10]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = output[i];
        }
    }
}
