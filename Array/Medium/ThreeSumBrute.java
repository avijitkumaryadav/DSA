import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Approach: Brute Force (Three Nested Loops)
 * Time Complexity:  O(n^3)  — triple loop
 * Space Complexity: O(n)    — for the result set
 * Sheet: Arrays Row 16 — 3Sum (Adobe + Amazon + Microsoft + Morgan Stanley)
 *
 * NOTE: TLE on LeetCode for n = 3000.
 */
public class ThreeSumBrute {

    // Time: O(n^3) | Space: O(n)
    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
                        triplet.sort(Integer::compareTo);   // sort to deduplicate
                        resultSet.add(triplet);
                    }
                }
            }
        }

        return new ArrayList<>(resultSet);
    }

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        // [[-1, -1, 2], [-1, 0, 1]]

        System.out.println(threeSum(new int[]{0, 1, 1}));    // []
        System.out.println(threeSum(new int[]{0, 0, 0}));    // [[0, 0, 0]]
    }
}