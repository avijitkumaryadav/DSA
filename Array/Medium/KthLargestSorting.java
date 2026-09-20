import java.util.Arrays;

/*
 * Approach: Sort then index
 * Time Complexity:  O(n log n)  — Arrays.sort() dominates
 * Space Complexity: O(1)        — in-place (ignoring sort's internal stack)
 * Sheet: Arrays Row 10 — Kth Largest Element (Amazon)
 *
 * Logic:
 *   - Sort the array in ascending order.
 *   - The kth largest element is at index (n - k) in sorted order.
 *
 * NOTE: LeetCode's follow-up says "solve without sorting", but this is
 * the simplest correct answer. Mention it first, then optimize.
 */
public class KthLargestSorting {

    // Time: O(n log n) | Space: O(1)
    public static int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);                        // ascending sort
        return nums[nums.length - k];             // kth largest from end
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums1, 2)); // 5

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(nums2, 4)); // 4
    }
}