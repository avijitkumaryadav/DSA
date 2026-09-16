/*
 * Approach: Modified Binary Search (Expected / Optimal)
 * Time Complexity:  O(log n)  — halving search space each iteration
 * Space Complexity: O(1)      — only left/right/mid variables
 *
 * Logic:
 *   - Standard binary search, but the array is rotated.
 *   - At each step, ONE of the two halves (left or right) is sorted.
 *   - Determine which half is sorted:
 *       If nums[left] <= nums[mid] → LEFT half is sorted.
 *       Else                       → RIGHT half is sorted.
 *   - Check if target lies within the sorted half:
 *       If yes → search that half.
 *       If no  → search the other half.
 *
 * Key Insight:
 *   Even after rotation, at least one half of any subarray [left..right]
 *   is guaranteed to be sorted. We use that to decide which side to go.
 */
public class SearchRotatedBinary {

    // Time: O(log n) | Space: O(1)
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {                          // O(log n)
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            // Check if LEFT half [left..mid] is sorted
            if (nums[left] <= nums[mid]) {
                // Target lies within the sorted LEFT half
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Otherwise, RIGHT half [mid..right] is sorted
            else {
                // Target lies within the sorted RIGHT half
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
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