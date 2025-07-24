package searching;

public class SearchAndRotatedMinimum {
    public static void main(String[] args) {
        int[] arr = {41, 55, 75, 28};
        int min = findMin(arr);
        System.out.println("Min: " + min);
    }

    public static int findMin(int[] arr) {
        int low = 0;
        int n = arr.length;
        int high = n-1;

        if (arr[0] < arr[n-1]) return arr[0];

        while (low <= high) {
            int mid = low + (high-low)/2;

            if (low == high) {
                return arr[low];
            } else if (arr[mid] > arr[high]) {
                low = mid+1;
            } else {
                high = mid;
            }
        }

        return arr[low];
    }
}
