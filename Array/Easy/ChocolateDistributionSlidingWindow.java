import java.util.Arrays;

/*
 * Approach: Sliding Window (Expected / Optimal)
 * Time Complexity:  O(n log n)  — sorting dominates
 * Space Complexity: O(1)        — in-place (ignoring sort's stack)
 *
 * Logic:
 *   - Sort the array first.
 *   - After sorting, the best m packets MUST be consecutive.
 *   - Use a sliding window of size m:
 *       for i in 0..n-m: diff = arr[i + m - 1] - arr[i]
 *   - Track the minimum diff across all windows.
 *
 * Why sorting works:
 *   Distributing m packets to minimize max-min is equivalent to
 *   finding a contiguous block of m sorted elements with the
 *   smallest spread. Non-contiguous picks can never beat this.
 */
public class ChocolateDistributionSlidingWindow {

    // Time: O(n log n) | Space: O(1)
    static int findMinDiff(int[] arr, int m) {
        int n = arr.length;

        // Edge cases
        if (m == 0 || n == 0 || n < m) return -1;

        // Sort the packets — O(n log n)
        Arrays.sort(arr);

        int minDiff = Integer.MAX_VALUE;

        // Slide a window of size m across the sorted array — O(n)
        for (int i = 0; i + m - 1 < n; i++) {
            int diff = arr[i + m - 1] - arr[i];   // max - min in this window
            if (diff < minDiff) {
                minDiff = diff;
            }
        }

        return minDiff;
    }

    public static void main(String[] args) {
        int[] arr1 = {7, 3, 2, 4, 9, 12, 56};
        int m1 = 3;
        System.out.println(findMinDiff(arr1, m1)); // 2

        int m2 = 5;
        System.out.println(findMinDiff(arr1, m2)); // 7
    }
}