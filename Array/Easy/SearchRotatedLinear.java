/*
 * Approach: Linear Search (NOT optimal — for understanding only)
 * Time Complexity:  O(n)  — single pass
 * Space Complexity: O(1)  — no extra space
 *
 * NOTE: LeetCode requires O(log n). This will be REJECTED if submitted.
 *       Use only to verify correctness against the binary search version.
 */
public class SearchRotatedLinear {

    // Time: O(n) | Space: O(1)
    public static int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums1, 0));  // 4
        System.out.println(search(nums1, 3));  // -1

        int[] nums2 = {1};
        System.out.println(search(nums2, 0));  // -1
    }
}