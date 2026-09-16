/*
 * Approach: Brute Force (Nested Loops)
 * Time Complexity:  O(n^2)  — compare every pair
 * Space Complexity: O(1)    — no extra space
 *
 * Logic:
 *   - For each i, compare nums[i] with nums[j] for j > i
 *   - If any match found, return true
 *   - If no match after all comparisons, return false
 *
 * NOTE: Will TLE for n = 10^5. Use only to understand the problem.
 */
public class ContainsDuplicateBruteForce {

    // Time: O(n^2) | Space: O(1)
    public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {          // O(n)
            for (int j = i + 1; j < nums.length; j++) {  // O(n)
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        int[] nums2 = {1, 2, 3, 4};
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};

        System.out.println(containsDuplicate(nums1)); // true
        System.out.println(containsDuplicate(nums2)); // false
        System.out.println(containsDuplicate(nums3)); // true
    }
}