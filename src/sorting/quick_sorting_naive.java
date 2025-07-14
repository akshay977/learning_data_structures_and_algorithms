package sorting;

public class quick_sorting_naive {
    public static void main(String[] args) {
        int[] arr = {5, 13, 6, 9, 12, 11, 8};
        int n = arr.length;

        quickSort(arr, 0, n - 1);

        for (int ele : arr)
            System.out.print(ele + " ");
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int n = high - low + 1;
        int[] temp = new int[n];
        int idx = 0;

        // First: Elements less than pivot
        for (int i = low; i <= high; i++) {
            if (arr[i] < pivot) {
                temp[idx++] = arr[i];
            }
        }

        // Count of elements less than pivot gives us final pivot index
        int pivotIndex = idx;
        temp[idx++] = pivot;

        // Then: Elements greater than pivot
        for (int i = low; i <= high; i++) {
            if (arr[i] > pivot) {
                temp[idx++] = arr[i];
            }
        }

        // Copy temp back to original array
        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }

        // return pivot index w.r.t original array
        return low + pivotIndex;
    }
}
