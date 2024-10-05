import java.util.Arrays;

public class LearningArrays {
    public static void main(String[] args) {
        /*
            Types of array operations:
                1. Search (unsorted or sorted array)
                2. Insert
                3. Delete
        */
        int arr[] = {5, 3, 8, 9, 10, 1, 99};
        int ans = search(arr, 7, 1);
        System.out.println("search index: " + ans);

        int arr2[] = {5, 3, 8, 9, 10, 1, 99, 0, 0};
        int ans2 = insert(arr2, 7, 10, 9, 2);
        System.out.println(Arrays.toString(arr2));

        /*
            Time complexity of insert in dynamically sized arrays:
                1. O(1) for n inserts in n-sized array
                2. Average time complexity from (n+1)th index is Theta(n)

            When the dynamically sized array is full, it creates a new array
            double the size of original array and inserts the element.
        */
    }

    /*
        Time complexity:
        O(n) for unsorted array and O(log n) for sorted array
        using binary search algorithm
     */
    public static int search(int[] arr, int n, int target) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }

    /*
        Time complexity:
        1. O(n)
        2. Insert at the end: O(1)
        3. Insert at the beginning: Theta(n) (Average time complexity)
    */
    public static int insert(int[] arr, int n, int x, int cap, int pos) {
        if (n == cap) {
            return n;
        }

        int idx = pos - 1;

        for (int i = n-1; i >= idx; i--) {
            arr[i+1] = arr[i];
        }
        arr[idx] = x;

        return n+1;
    }
}