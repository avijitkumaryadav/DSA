/*
 * Approach: Linear Scan (Not optimal — O(log n) is required)
 * Time Complexity:  O(n)  — single pass
 * Space Complexity: O(1)  — no extra space
 * Sheet: Arrays Row 14 — Find Minimum in Rotated Sorted Array (Amazon)
 *
 * NOTE: LeetCode requires O(log n). This will be REJECTED if submitted.
 *       Use only to verify correctness against the binary search version.
 */
public class FindMinRotatedLinear {

    // Time: O(n) | Space: O(1)
    public static int findMin(int[] nums) {
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println(findMin(nums1)); // 1

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(nums2)); // 0

        int[] nums3 = {11, 13, 15, 17};
        System.out.println(findMin(nums3)); // 11
    }
}