package sorting;

import java.util.Scanner;

public class merge_sorted_arrays {
        public static void main (String[] args) throws java.lang.Exception
        {
            Scanner sc = new Scanner(System.in);

            int n = sc.nextInt();
            int i = 0;
            int[] arr_n = new int[n];

            while (i < n) {
                arr_n[i] = sc.nextInt();
                i++;
            }

            int m = sc.nextInt();
            int j = 0;
            int[] arr_m = new int[m];

            while (j < m) {
                arr_m[j] = sc.nextInt();
                j++;
            }

            int k = 0;
            int[] merged_arr = new int[m+n];
            int a = 0;
            int b = 0;

            while (a < n && b < m) {
                if (arr_n[a] < arr_m[b]) {
                    merged_arr[k] = arr_n[a];
                    a++;
                } else {
                    merged_arr[k] = arr_m[b];
                    b++;
                }
                k++;
            }

            while (a < n) {
                merged_arr[k] = arr_n[a];
                k++;
                a++;
            }

            while (b < m) {
                merged_arr[k] = arr_m[b];
                k++;
                b++;
            }

            for(int l = 0; l < m+n; l++){
                System.out.print(merged_arr[l] + " ");
            }
            System.out.println();
        }
}
