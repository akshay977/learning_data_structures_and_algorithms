package sorting;

public class counting_sort {
    public static void main(String[] args) {
        int[] inputArray = {4, 3, 8, 1, 5, 5, 3, 9};
        int[] outputArray = countSort(inputArray);

        for (int i = 0; i < inputArray.length; i++) {
            System.out.print(outputArray[i] + " ");
        }
    }

    static int[] countSort(int[] arr) {
        int n = arr.length;
        int maxEl = 0;

        // Find the max element in the input array
        for(int i = 0; i < n; i++) {
            maxEl = Math.max(arr[i], maxEl);
        }

        int[] countArr = new int[maxEl+1];

        // Store the counts in the count array
        for (int i = 0; i < n; i++) {
            countArr[arr[i]]++;
        }

        // Calculate the prefix sum in the count array which is a position map (1-based indexing)
        for (int i = 1; i <= maxEl; i++) {
            countArr[i] += countArr[i-1];
        }

        int[] outputArr = new int[n];

        // Traverse the original array from the end, get position from prefix sum array
        // and store the value in output array accordingly
        for (int i = n-1; i >= 0; i--) {
            outputArr[countArr[arr[i]]-1] = arr[i];
            countArr[arr[i]]--;
        }

        return outputArr;
    }
}
