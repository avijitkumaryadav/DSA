/*
 * Approach: Recursive Binary Search
 * Time Complexity:  O(log n)  — same halving logic
 * Space Complexity: O(log n)  — recursion stack depth
 *
 * Same logic as iterative, but split into a helper method.
 * Good for demonstrating recursion understanding.
 */
public class SearchRotatedRecursive {

    // Time: O(log n) | Space: O(log n) — recursion stack
    private static int searchHelper(int[] nums, int left, int right, int target) {
        if (left > right) return -1;

        int mid = left + (right - left) / 2;

        if (nums[mid] == target) return mid;

        // LEFT half is sorted
        if (nums[left] <= nums[mid]) {
            if (nums[left] <= target && target < nums[mid]) {
                return searchHelper(nums, left, mid - 1, target);
            } else {
                return searchHelper(nums, mid + 1, right, target);
            }
        }
        // RIGHT half is sorted
        else {
            if (nums[mid] < target && target <= nums[right]) {
                return searchHelper(nums, mid + 1, right, target);
            } else {
                return searchHelper(nums, left, mid - 1, target);
            }
        }
    }

    // Time: O(log n) | Space: O(log n)
    public static int search(int[] nums, int target) {
        return searchHelper(nums, 0, nums.length - 1, target);
    }

    public static void main(String[] args) {
        int[] nums1 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(nums1, 0));  // 4
        System.out.println(search(nums1, 3));  // -1

        int[] nums2 = {1};
        System.out.println(search(nums2, 0));  // -1
    }
}