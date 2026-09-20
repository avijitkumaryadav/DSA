import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Approach: Sort + Two Pointers (Optimal)
 * Time Complexity:  O(n^2)  — sort O(n log n) + outer loop O(n) × inner two-pointer O(n)
 * Space Complexity: O(1)    — excluding the output list
 * Sheet: Arrays Row 16 — 3Sum (Adobe + Amazon + Microsoft + Morgan Stanley)
 *
 * Logic:
 *   - Sort the array first.
 *   - For each index i (the "fixed" first element):
 *       - Skip duplicates at i (to avoid duplicate triplets).
 *       - Use two pointers l = i+1, r = n-1 to find pairs summing to -nums[i].
 *       - For each found triplet, add it and skip duplicates at l and r.
 *
 * Key Insight:
 *   After sorting, we can use the two-pointer trick to find pairs in O(n),
 *   reducing the overall complexity from O(n^3) to O(n^2).
 */
public class ThreeSumOptimal {

    // Time: O(n^2) | Space: O(1) excluding output
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);                              // O(n log n)
        int n = nums.length;

        for (int i = 0; i < n - 2; i++) {
            // Skip duplicate values for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Optimization: if smallest is > 0, no triplet can sum to 0
            if (nums[i] > 0) break;

            int l = i + 1, r = n - 1;
            int target = -nums[i];

            while (l < r) {
                int sum = nums[l] + nums[r];

                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    // Skip duplicates for the second element
                    while (l < r && nums[l] == nums[l + 1]) l++;
                    // Skip duplicates for the third element
                    while (l < r && nums[r] == nums[r - 1]) r--;

                    l++;
                    r--;
                } else if (sum < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        // [[-1, -1, 2], [-1, 0, 1]]

        System.out.println(threeSum(new int[]{0, 1, 1}));    // []
        System.out.println(threeSum(new int[]{0, 0, 0}));    // [[0, 0, 0]]
    }
}