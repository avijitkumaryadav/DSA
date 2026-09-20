/*
 * Approach: Brute Force (Try all subarrays)
 * Time Complexity:  O(n^2)  — nested loops
 * Space Complexity: O(1)    — tracking variables only
 * Sheet: Arrays Row 13 — Maximum Product Subarray (Amazon)
 *
 * NOTE: TLE on LeetCode for n = 2 × 10^4.
 */
public class MaxProductSubarrayBrute {

    // Time: O(n^2) | Space: O(1)
    public static int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            int currentProduct = 1;
            for (int j = i; j < nums.length; j++) {
                currentProduct *= nums[j];
                maxProduct = Math.max(maxProduct, currentProduct);
            }
        }

        return maxProduct;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, -2, 4};
        System.out.println(maxProduct(nums1)); // 6

        int[] nums2 = {-2, 0, -1};
        System.out.println(maxProduct(nums2)); // 0

        int[] nums3 = {-2, 3, -4};
        System.out.println(maxProduct(nums3)); // 24
    }
}