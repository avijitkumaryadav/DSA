import java.util.HashSet;
import java.util.Set;

/*
 * Approach: Hashing
 * Time Complexity:  O(n)  — single pass
 * Space Complexity: O(n)  — HashSet of size up to n
 * Sheet: Arrays Row 15 — Find Pair with Sum in Sorted & Rotated Array
 *        (Microsoft + Google + Apple)
 *
 * Logic:
 *   - Iterate through the array.
 *   - For each element arr[i], compute complement = target - arr[i].
 *   - If complement is already in the set → pair found.
 *   - Otherwise, add arr[i] to the set.
 *
 * NOTE: Works for ANY array (doesn't need to be sorted or rotated).
 *       The sorted-rotated property is unnecessary for this approach.
 */
public class PairSumRotatedHashing {

    // Time: O(n) | Space: O(n)
    public static boolean pairInSortedRotated(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return true;
            }
            seen.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(pairInSortedRotated(new int[]{11, 15, 6, 8, 9, 10}, 16));      // true
        System.out.println(pairInSortedRotated(new int[]{11, 11, 15, 26, 38, 9, 10}, 35)); // true
        System.out.println(pairInSortedRotated(new int[]{9, 10, 10, 11, 15, 26, 38}, 45)); // false
    }
}