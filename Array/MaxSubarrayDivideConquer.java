/*
 * Approach: Divide & Conquer (Follow-up asked by LeetCode)
 * Time Complexity:  O(n log n)  — T(n) = 2T(n/2) + O(n)
 * Space Complexity: O(log n)    — recursion stack depth
 *
 * Logic:
 *   - Split array into left half and right half
 *   - Max subarray lies in ONE of three places:
 *       1. Entirely in the LEFT half
 *       2. Entirely in the RIGHT half
 *       3. CROSSING the midpoint
 *   - Recursively find max in left and right
 *   - Compute max crossing sum (expand from mid to both sides)
 *   - Return the max of the three
 */
public class MaxSubarrayDivideConquer {

    // Time: O(n) — this function is called at each merge step
    private static int maxCrossingSum(int[] nums, int left, int mid, int right) {
        // Expand from mid to the LEFT
        int sum = 0;
        int leftSum = Integer.MIN_VALUE;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = Math.max(leftSum, sum);
        }

        // Expand from mid+1 to the RIGHT
        sum = 0;
        int rightSum = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = Math.max(rightSum, sum);
        }

        return leftSum + rightSum;
    }

    // Time: O(n log n) | Space: O(log n)
    private static int maxSubArrayHelper(int[] nums, int left, int right) {
        // Base case: single element
        if (left == right) return nums[left];

        int mid = left + (right - left) / 2;

        int leftMax  = maxSubArrayHelper(nums, left, mid);       // T(n/2)
        int rightMax = maxSubArrayHelper(nums, mid + 1, right);  // T(n/2)
        int crossMax = maxCrossingSum(nums, left, mid, right);   // O(n)

        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    // Time: O(n log n) | Space: O(log n)
    public static int maxSubArray(int[] nums) {
        return maxSubArrayHelper(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] nums2 = {1};
        int[] nums3 = {5, 4, -1, 7, 8};

        System.out.println(maxSubArray(nums1)); // 6
        System.out.println(maxSubArray(nums2)); // 1
        System.out.println(maxSubArray(nums3)); // 23
    }
}