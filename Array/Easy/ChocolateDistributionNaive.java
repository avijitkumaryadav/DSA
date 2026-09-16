import java.util.Arrays;

/*
 * Approach: Naive (Generate all subsets of size m)
 * Time Complexity:  O(2^n)  — generating all subsets
 * Space Complexity: O(m)    — recursion depth for each subset
 *
 * Logic:
 *   - Generate every combination of m packets
 *   - For each combination, find max and min
 *   - Track the smallest difference across all combinations
 *
 * NOTE: Exponentially slow. Only useful for understanding the problem.
 */
public class ChocolateDistributionNaive {

    static int minDiff = Integer.MAX_VALUE;

    // Time: O(2^n) | Space: O(m)
    static void generateSubsets(int[] arr, int m, int index, int[] chosen, int count) {
        // If we've chosen m packets, compute difference
        if (count == m) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < m; i++) {
                max = Math.max(max, chosen[i]);
                min = Math.min(min, chosen[i]);
            }
            minDiff = Math.min(minDiff, max - min);
            return;
        }

        // If we've run out of elements
        if (index == arr.length) return;

        // Choice 1: include arr[index]
        chosen[count] = arr[index];
        generateSubsets(arr, m, index + 1, chosen, count + 1);

        // Choice 2: exclude arr[index]
        generateSubsets(arr, m, index + 1, chosen, count);
    }

    // Time: O(2^n) | Space: O(m)
    static int findMinDiff(int[] arr, int m) {
        int n = arr.length;
        if (m == 0 || n == 0 || n < m) return -1;

        minDiff = Integer.MAX_VALUE;
        generateSubsets(arr, m, 0, new int[m], 0);
        return minDiff;
    }

    public static void main(String[] args) {
        int[] arr = {7, 3, 2, 4, 9, 12, 56};
        int m = 3;
        System.out.println(findMinDiff(arr, m)); // 2
    }
}