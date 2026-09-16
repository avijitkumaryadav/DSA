import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Approach: Brute Force (Generate ALL permutations, sort, find next)
 * Time Complexity:  O(n! * n)  — generate n! permutations, each of size n
 * Space Complexity: O(n! * n)  — store all permutations
 *
 * Logic:
 *   1. Generate all permutations of nums
 *   2. Sort them lexicographically
 *   3. Find the current permutation in the sorted list
 *   4. Return the one right after it (or the first if it's the last)
 *
 * NOTE: Only works for n <= ~8. LeetCode will TLE for n > 8.
 *       Use this only to understand the definition of "next permutation".
 */
public class NextPermutationBrute {

    // Time: O(n! * n) | Space: O(n! * n)
    static void permute(int[] nums, int index, List<int[]> allPerms) {
        if (index == nums.length) {
            allPerms.add(nums.clone());
            return;
        }
        for (int i = index; i < nums.length; i++) {
            swap(nums, index, i);
            permute(nums, index + 1, allPerms);
            swap(nums, index, i);   // backtrack
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Time: O(n! * n) | Space: O(n! * n)
    public static void nextPermutation(int[] nums) {
        List<int[]> allPerms = new ArrayList<>();
        permute(nums.clone(), 0, allPerms);

        // Sort all permutations lexicographically
        Collections.sort(allPerms, (a, b) -> {
            for (int i = 0; i < a.length; i++) {
                if (a[i] != b[i]) return a[i] - b[i];
            }
            return 0;
        });

        // Find the current permutation in the list
        int currentIndex = -1;
        for (int i = 0; i < allPerms.size(); i++) {
            if (Arrays.equals(allPerms.get(i), nums)) {
                currentIndex = i;
                break;
            }
        }

        // Get the next one (or first if we're at the last)
        int[] next = allPerms.get((currentIndex + 1) % allPerms.size());
        System.arraycopy(next, 0, nums, 0, nums.length);
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        nextPermutation(nums1);
        System.out.println(Arrays.toString(nums1)); // [1, 3, 2]

        int[] nums2 = {3, 2, 1};
        nextPermutation(nums2);
        System.out.println(Arrays.toString(nums2)); // [1, 2, 3]

        int[] nums3 = {1, 1, 5};
        nextPermutation(nums3);
        System.out.println(Arrays.toString(nums3)); // [1, 5, 1]
    }
}