package searching;

import java.util.Scanner;

public class linear_search {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();

        int[] list = new int[n];

        int i = 0;
        while (i < n) {
           int el = sc.nextInt();;
           list[i] = el;
           i++;
        }

        boolean found = false;
        int j = 0;
        while (j < n) {
            if (list[j] == target) {
                found = true;
                break;
            }
            j++;
        }

        if (found) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
