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
//        int arr[] = {5, 3, 8, 9, 10, 1, 99};
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

//        int ans4 = findLargestElement(arr);
//        System.out.println("findLargestElement: " + ans4);
//
//        int ans5 = findSecondLargest(arr, 7);
//        System.out.println("findSecondLargestElement: " + ans5);
//
//        boolean ans6 = checkArrayIsSorted(arr);
//        System.out.println("checkArrayIsSorted: " + ans6);
//
//        int arr3[] = {1, 2, 3, 4, 5};
//        reverseArray(arr3);
//        System.out.println("reverseArray: " + Arrays.toString(arr3));
//
//        int arr4[] = {1, 1, 2, 2, 3, 3, 4, 5};
//        int ans7 = removeDuplicatesFromSortedArray(arr4, arr4.length);
//        System.out.println("removeDuplicatesFromSortedArray (Naive): " + ans7);
//
//        int arr5[] = {1, 1, 2, 2, 3, 3, 4, 5};
//        int ans8 = removeDupsFromSortedArray(arr5, arr5.length);
//        System.out.println("removeDupsFromSortedArray (Efficient): " + ans8);
//
//        int arr6[] = {0, 2, 0, 3, 4};
//        moveZerosToEndNaiveMethod(arr6);
//        System.out.println("moveZerosToEndNaiveMethod: " + Arrays.toString(arr6));
//
//        int arr7[] = {0, 1, 0, 9, 10};
//        moveZerosToEndEfficientMethod(arr7);
//        System.out.println("moveZerosToEndEfficientMethod: " + Arrays.toString(arr7));
//
//        int arr8[] = {1, 2, 3, 4, 5, 6};
//        leftRotateByDTimesNaiveMethod(arr8, 2);
//        System.out.println("leftRotateByDTimesNaiveMethod: " + Arrays.toString(arr8));
//
//        int arr9[] = {1, 2, 3, 4, 5, 6};
//        leftRotateByDTimesBetterMethod(arr9, 2);
//        System.out.println("leftRotateByDTimesBetterMethod: " + Arrays.toString(arr9));
//
//        int arr10[] = {1, 2, 3, 4, 5, 6};
//        leftRotateByDTimesEfficientMethod(arr10, 2);
//        System.out.println("leftRotateByDTimesEfficientMethod: " + Arrays.toString(arr10));

//        int arr11[] = {7, 10, 14, 3, 6, 5, 2};
//        printLeadersInArrayNaiveMethod(arr11);
//        printLeadersInArrayEfficientMethod(arr11);

//        int ans9 = maxDiffNaiveMethod(arr11);
//        System.out.println("maxDiffNaiveMethod: " + ans9);
////        maxDiffEfficientMethod(arr11);
//
//        int ans10 = maxDiffEfficientMethod(arr11);
//        System.out.println("maxDiffEfficientMethod: " + ans10);
//
//        int arr12[] = {10, 10, 20, 30, 40, 40};
//        findFrequenciesInSortedArray(arr12);
//
//        int arr13[] = {3, 0, 1, 2, 5};
//        int ans11 = getWaterNaiveMethod(arr13);
//        System.out.println("getWaterNaiveMethod: " + ans11);
//
//        int arr14[] = {3, 0, 1, 2, 5};
//        int ans12 = getWaterEfficientMethod(arr13);
//        System.out.println("getWaterEfficientMethod: " + ans12);

        int arr15[] = {0, 1, 1, 1, 0, 1, 0, 1, 1};
        int ans15 = getMaxConsecutiveOnesNaiveMethod(arr15);
        System.out.println("getMaxConsecutiveOnesNaiveMethod: " + ans15);

        int ans16 = getMaxConsecutiveOnesEfficientMethod(arr15);
        System.out.println("getMaxConsecutiveOnesEfficientMethod: " + ans16);
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

    /*
        Time complexity: O(n*d)
        Space complexity: Theta(1)
    */
    public static void leftRotateByDTimesNaiveMethod(int[] arr, int d) {
        for (int i = 0; i < d; i++) {
            leftRotateByOne(arr);
        }
    }

    /*
        Time complexity: Theta(n)
        Space complexity: Theta(d)
    */
    public static void leftRotateByDTimesBetterMethod(int[] arr, int d) {
        int[] temp = new int[d];
        int n = arr.length;

        for (int i = 0; i < d; i++) {
            temp[i] = arr[i];
        }

        for (int i = d; i < n; i++) {
            arr[i-d] = arr[i];
        }

        for (int i = 0; i < d; i++) {
            arr[n - d + i] = temp[i];
        }
    }

    /*
        Time complexity: O(n)
        Space complexity: O(1)
    */
    public static void leftRotateByDTimesEfficientMethod(int[] arr, int d) {
        int n = arr.length;

        reverseArray(arr, 0, d - 1);
        reverseArray(arr, d, n - 1);
        reverseArray(arr, 0, n - 1);
    }

    public static void reverseArray(int[] arr, int low, int high) {
        while (low < high) {
            int temp = arr[low];
            arr[low] = arr[high];
            arr[high] = temp;

            low++;
            high--;
        }
    }

    public static void printLeadersInArrayNaiveMethod(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            boolean flag = true;

            for (int j = i+1; j < n; j++) {
                if (arr[j] > arr[i]) {
                    flag = false;
                    break;
                }
            }

            if (flag == true) {
                System.out.println(arr[i]);
            }
        }
    }

    public static void printLeadersInArrayEfficientMethod(int[] arr) {
        int n = arr.length;
        int curr_ldr = arr[n - 1];
        System.out.println(curr_ldr);

        for (int i = n - 2; i >= 0; i--) {
            if (arr[i] > curr_ldr) {
                curr_ldr = arr[i];
                System.out.println(curr_ldr);
            }
        }
    }

    /*
        Max difference of arr[j] - arr[i] such that j > i
        Time complexity: O (n^2)
        Space complexity: O(1)
    */
    public static int maxDiffNaiveMethod(int[] arr) {
        int n = arr.length;
        int res = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                res = Math.max(res, arr[j] - arr[i]);
            }
        }

        return res;
    }

    /*
        Max difference of arr[j] - arr[i] such that j > i
        Time complexity: O (n)
        Space complexity: O(1)
    */
    public static int maxDiffEfficientMethod(int[] arr) {
        int res = arr[1] - arr[0];
        int minValue = arr[0];
        int n = arr.length;

        for (int j = 1; j < n; j++) {
            res = Math.max(res, arr[j] - minValue);
            minValue = Math.min(minValue, arr[j]);
        }

        return res;
    }

    /*
        Time complexity: O(n^2)
        Space complexity: O(1)
    */
    public static void findFrequenciesInSortedArray(int[] arr) {
        int n = arr.length;
        int i = 1;
        int freq = 1;

        while (i < n) {
            while (i < n && arr[i] == arr[i-1]) {
                freq++;
                i++;
            }
            System.out.println(arr[i - 1] + ": " + freq);
            freq = 1;
            i++;
        }
    }

    /*
        Stock buy and sell: (Naive method)
        Find maximum profit by buying and selling stock
    */
    public static int maxProfit(int[] price, int start, int end) {
        if (start >= end) {
            return 0;
        }

        int profit = 0;

        for (int i = 0; i < end; i++) {
            for (int j = i+1; j < end; j++) {
                if (price[j] > price[i]) {
                    int curr_profit = price[j] - price[i] + maxProfit(price, start, i - 1) + maxProfit(price, j+1, end);
                    profit = Math.max(curr_profit, profit);
                }
            }
        }

        return profit;
    }

    /*
        Stock buy and sell: (Efficient method)
        Find maximum profit by buying and selling stock
    */
    public static int maxProfit2(int[] price, int start, int end) {
        int profit = 0;

        for (int i = 1; i < end; i++) {
            if (price[i] > price[i-1]) {
                profit += price[i] - price[i-1];
            }
        }

        return profit;
    }

    /*
        Trapping Rain water (Naive method)
        Time complexity: Theta(n^2)
    */
    public static int getWaterNaiveMethod(int arr[]) {
        int res = 0;
        int n = arr.length;

        for (int i = 1; i < n-1; i++) {
            int lmax = arr[i];
            for (int j = 0; j < i; j++) {
                lmax = Math.max(lmax, arr[j]);
            }

            int rmax = arr[i];
            for (int j = i + 1; j < n; j++) {
                rmax = Math.max(rmax, arr[j]);
            }

            res += Math.min(lmax, rmax) - arr[i];
        }

        return res;
    }

    /*
        Trapping rain water (Efficient method)
        Time complexity: Theta(n)
    */
    public static int getWaterEfficientMethod(int arr[]) {
        int res = 0;
        int n = arr.length;
        int lmax[] = new int[n];
        int rmax[] = new int[n];

        lmax[0] = arr[0];
        for (int i = 1; i < n; i++) {
            lmax[i] = Math.max(lmax[i-1], arr[i]);
        }

        rmax[n-1] = arr[n-1];
        for (int i = n-2; i > 0; i--) {
            rmax[i] = Math.max(rmax[i + 1], arr[i]);
        }

        for (int i = 1; i < n-1; i++) {
            res += Math.min(lmax[i], rmax[i]) - arr[i];
        }

        return res;
    }

    /*
        Get maximum consecutive ones (Naive method)
        Time complexity: O(n^2)
        Space complexity: O(1)
    */
    public static int getMaxConsecutiveOnesNaiveMethod(int arr[]) {
        int res = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int curr = 0;

            for (int j = i; j < n; j++) {
                if (arr[j] == 1) curr++;
                else break;
            }
            res = Math.max(curr, res);
        }

        return res;
    }

    /*
        Get maximum consecutive ones (Efficient method)
        Time complexity: O(n)
        Space complexity: O(1)
    */
    public static int getMaxConsecutiveOnesEfficientMethod(int arr[]) {
        int res = 0, curr = 0;
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            if (arr[i] == 0) {
                curr = 0;
            } else {
                curr++;
                res = Math.max(res, curr);
            }
        }

        return res;
    }
}