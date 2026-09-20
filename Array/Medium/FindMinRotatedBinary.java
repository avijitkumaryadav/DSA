/*
 * Approach: Modified Binary Search (Expected / Optimal)
 * Time Complexity:  O(log n)  — halving search space each iteration
 * Space Complexity: O(1)      — only left/right/mid variables
 * Sheet: Arrays Row 14 — Find Minimum in Rotated Sorted Array (Amazon)
 *
 * Logic:
 *   - The minimum element is at the "rotation point" — where the sorted
 *     array wraps around.
 *   - At any mid, compare nums[mid] with nums[right]:
 *       If nums[mid] > nums[right]:
 *           The minimum is in the RIGHT half (because the right side is
 *           "broken" — the drop must be there).
 *           → left = mid + 1
 *       Else:
 *           nums[mid] <= nums[right]: the right half is sorted.
 *           The minimum is at mid OR in the LEFT half.
 *           → right = mid
 *
 * Key Insight:
 *   The minimum is the only element that is smaller than its left neighbor.
 *   Binary search narrows down to it in O(log n) time.
 *
 * Note: Unique elements are guaranteed by the constraints, so we don't
 * need to handle duplicate edge cases (unlike LC 154).
 */
public class FindMinRotatedBinary {

    // Time: O(log n) | Space: O(1)
    public static int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum is in the RIGHT half
                left = mid + 1;
            } else {
                // Minimum is at mid OR in the LEFT half
                right = mid;
            }
        }

        return nums[left];   // left == right when loop exits
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