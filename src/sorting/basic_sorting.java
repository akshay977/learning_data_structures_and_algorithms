package sorting;

import java.util.Arrays;
import java.util.Scanner;

// Sorting 3 integers
public class basic_sorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[3];
        int count = 0;

        while (count < 3) {
            int el = sc.nextInt();
            arr[count] = el;
            count++;
        }

        for (int i = 0; i < 2; i++) {
            for (int j = i; j < 3; j++) {
                if (arr[j] < arr[i]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
