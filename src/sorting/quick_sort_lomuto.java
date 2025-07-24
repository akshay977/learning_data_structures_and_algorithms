package sorting;

public class quick_sort_lomuto {
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        int n = arr.length;

        quickSort(arr, 0, n-1);

        for (int val : arr) {
            System.out.print(val + " ");
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);

            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex+1, high);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];

        int idx = low - 1;

        for (int j = low; j <= high; j++) {
            if (arr[j] < pivot) {
                idx++;
                swap(arr, idx, j);
            }
        }

        swap(arr, idx+1, high);
        return idx+1;
    }
}
