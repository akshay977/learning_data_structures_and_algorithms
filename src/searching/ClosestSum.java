package searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ClosestSum {
    public static void main(String[] args) {
        int[] arr = {1, 14, 14, 6, 12, 10, 2, 11, 0, 1, 17};
        int target = 17;

        List<Integer> res = sumClosest(arr, target);
        if (res.size() > 0) {
            System.out.println(res.get(0) + " " + res.get(1));
        }
    }

    public static List<Integer> sumClosest(int[] arr, int target) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);
        List<Integer> res = new ArrayList<>();
        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < n-1; i++) {
            int complement = Math.abs(target - arr[i]);
            int closest = binarySearch(arr, i+1, n-1, complement);

            int currDiff = Math.abs(target - arr[i] - closest);
            if (currDiff < minDiff) {
                minDiff = currDiff;
                res = Arrays.asList(arr[i], closest);
            }
        }

        return res;
    }

    public static int binarySearch(int[] arr, int low, int high, int complement) {
        int res = arr[low];

        while (low <= high) {
            int mid = low + (high-low)/2;

            if (arr[mid] == complement) {
                return arr[mid];
            }  else if (Math.abs(arr[mid] - complement) == Math.abs(complement - res)) {
                res = Math.max(arr[mid], res);
                low = mid+1;
            } else if (Math.abs(arr[mid] - complement) < Math.abs(complement - res)) {
                res = arr[mid];
                low = mid+1;
            } else if (arr[mid] < complement) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }

        return res;
    }
}
