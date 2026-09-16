import java.util.Arrays;

/*
 * Approach: Optimal (In-place, single pass)
 * Time Complexity:  O(n)  — at most 3 linear scans
 * Space Complexity: O(1)  — only index variables
 *
 * Logic (4 steps):
 *   1. Find the "pivot" — the largest index i such that nums[i] < nums[i+1].
 *      If no such i exists, the array is the LAST permutation.
 *      Reverse the whole array and return.
 *   2. Find the "successor" — the largest index j > i such that nums[j] > nums[i].
 *   3. Swap nums[i] and nums[j].
 *   4. Reverse nums[i+1 .. n-1].
 *
 * Example: nums = [1, 2, 3]
 *   Step 1: pivot at i=1 (nums[1]=2 < nums[2]=3)
 *   Step 2: successor at j=2 (nums[2]=3 > nums[1]=2)
 *   Step 3: swap → [1, 3, 2]
 *   Step 4: reverse suffix [2] → [1, 3, 2] ✓
 *
 * Example: nums = [3, 2, 1]
 *   Step 1: no pivot found → reverse all → [1, 2, 3] ✓
 */
public class NextPermutationOptimal {

    // Time: O(n) | Space: O(1)
    public static void nextPermutation(int[] nums) {
        int n = nums.length;

        // ----- Step 1: Find pivot -----
        int i = n - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        // If pivot found, proceed to swap + reverse
        if (i >= 0) {
            // ----- Step 2: Find successor -----
            int j = n - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }

            // ----- Step 3: Swap -----
            swap(nums, i, j);
        }

        // ----- Step 4: Reverse suffix nums[i+1..n-1] -----
        reverse(nums, i + 1, n - 1);
    }

    // Helper: reverse subarray from start to end (inclusive)
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            swap(nums, start, end);
            start++;
            end--;
        }
    }

    // Helper: swap two indices
    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        nextPermutation(nums1);
        System.out.println(Arrays.toString(nums1)); // [1, 3, 2]

        int[] nums2 = {3, 2, 1};
        nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2)); // [1, 2, 3]

        int[] nums3 = {1, 1, 5};
        nextPermutation(nums3);
        System.out.println(Arrays.toString(nums3)); // [1, 5, 1]
    }
}