import java.util.Arrays;

public class LearningArrays {
    public static void main(String[] args) {
        /*
            Types of array operations:
                1. Search (unsorted or sorted array)
                2. Insert
                3. Delete
                4. Get ith element
                5. Update ith element
                6. Insert at the end and delete from the end
                    can be done in O(1) time
        */
        int arr[] = {5, 3, 8, 9, 10, 1, 99};
        // int ans = search(arr, 7, 1);
        // System.out.println("search index: " + ans);

        // int arr2[] = {5, 3, 8, 9, 10, 1, 99, 0, 0};
        // int ans2 = insert(arr2, 7, 10, 9, 2);
        // System.out.println(Arrays.toString(arr2));

        /*
            Time complexity of insert in dynamically sized arrays:
                1. O(1) for n inserts in n-sized array
                2. Average time complexity from (n+1)th index is Theta(n)

            When the dynamically sized array is full, it creates a new array
            double the size of original array and inserts the element.
        */
        // int ans3 = deleteElement(arr, 7, 8);
        // System.out.println("delete ans: " + ans3 + " " + Arrays.toString(arr));

        int ans4 = findLargestElement(arr);
        System.out.println("findLargestElement: " + ans4);

        int ans5 = findSecondLargest(arr, 7);
        System.out.println("findSecondLargestElement: " + ans5);

        boolean ans6 = checkArrayIsSorted(arr);
        System.out.println("checkArrayIsSorted: " + ans6);

        int arr3[] = {1, 2, 3, 4, 5};
        reverseArray(arr3);
        System.out.println("reverseArray: " + Arrays.toString(arr3));

        int arr4[] = {1, 1, 2, 2, 3, 3, 4, 5};
        int ans7 = removeDuplicatesFromSortedArray(arr4, arr4.length);
        System.out.println("removeDuplicatesFromSortedArray (Naive): " + ans7);

        int arr5[] = {1, 1, 2, 2, 3, 3, 4, 5};
        int ans8 = removeDupsFromSortedArray(arr5, arr5.length);
        System.out.println("removeDupsFromSortedArray (Efficient): " + ans8);

        int arr6[] = {0, 2, 0, 3, 4};
        moveZerosToEndNaiveMethod(arr6);
        System.out.println("moveZerosToEndNaiveMethod: " + Arrays.toString(arr6));

        int arr7[] = {0, 1, 0, 9, 10};
        moveZerosToEndEfficientMethod(arr7);
        System.out.println("moveZerosToEndEfficientMethod: " + Arrays.toString(arr7));
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

    // Average time complexity is Theta(n)
    public static int deleteElement(int[] arr, int n, int x) {
        int i;
        for (i = 0; i < n; i++) {
            if (arr[i] == x) {
                break;
            }
        }

        if (i == n) {
            return n;
        }

        for (int j = i; j < n-1; j++) {
            arr[j] = arr[j+1];
        }

        return n-1;
    }

    // Efficient Approach
    public static int findLargestElement(int[] arr) {
        int res = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[res]) {
                res = i;
            }
        }

        return res;
    }

    // Efficient Approach
    public static int findSecondLargest(int[] arr, int n) {
        int res = -1, largest = 0;

        /*
            Test cases:
                1. arr[i] > arr[largest]
                2. arr[i] == arr[largest]
                3. arr[i] < arr[largest]
                    a. res = -1 || arr[i] > arr[res]
                    b. arr[i] < arr[res]
        */
        for (int i = 1; i < n; i++) {
            if (arr[i] > arr[largest]) {
                res = largest;
                largest = i;
            } else if (arr[i] < arr[largest]) {
                if (res == -1 || arr[i] > arr[res]) {
                    res = i;
                }
            }
        }

        return res;
    }

    public static boolean checkArrayIsSorted(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i-1]) {
                return false;
            }
        }

        return true;
    }

    // Average Time complexity: Theta(n)
    // Aux. space: Theta(1)
    public static void reverseArray(int[] arr) {
        int low = 0, high = arr.length - 1;

        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;

            low++;
            high--;
        }
    }

    // Remove duplicates from sorted array (Naive Method)
    /*
        Time Complexity: O(n)
        Space Complexity: O(n)
    */
    public static int removeDuplicatesFromSortedArray(int[] arr, int n) {
        int[] temp = new int[n];
        temp[0] = arr[0];
        int res = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] != temp[res-1]) {
                temp[res] = arr[i];
                res++;
            }
        }

        return res;
    }

    // Remove duplicates from sorted array (Efficient method)
    /*
        Time complexity: O(n)
        Space complexity: O(1)
    */
    public static int removeDupsFromSortedArray(int[] arr, int n) {
        int res = 1;

        for (int i = 1; i < n; i++) {
            if (arr[i] != arr[res - 1]) {
                arr[res] = arr[i];
                res++;
            }
            arr[i] = 0;
        }

        return res;
    }

    /*
        Naive Method: move zeros to end
        Time complexity: O(n^2)
    */
    public static void moveZerosToEndNaiveMethod(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                for (int j = i+1; j < n; j++) {
                    if (arr[j] != 0) {
                        arr[i] = arr[j];
                        arr[j] = 0;
                        break;
                    }
                }
            }
        }
    }

    /*
        Efficient Method: Move zeros to end
        Time complexity: O(n)
    */
    public static void moveZerosToEndEfficientMethod(int[] arr) {
        int count = 0;
        // 1, 2, 0, 0, 4
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                int temp = arr[i];
                arr[i] = arr[count];
                arr[count] = temp;
                count++;
            }
        }
    }

    /*
        Time complexity: O(n)
        Space complexity: Theta(1)
    */
    public static void leftRotateByOne(int[] arr) {
        int temp = arr[0];
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            arr[i-1] = arr[i];
        }

        arr[n - 1] = temp;
    }
}