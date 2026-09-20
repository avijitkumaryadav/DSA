/*
 * Approach: Two Pointers (Expected / Optimal)
 * Time Complexity:  O(n)  — pivot finding O(n) + two-pointer O(n)
 * Space Complexity: O(1)  — only index variables
 * Sheet: Arrays Row 15 — Find Pair with Sum in Sorted & Rotated Array
 *        (Microsoft + Google + Apple)
 *
 * Logic:
 *   Step 1: Find the pivot — index i where arr[i] > arr[i+1].
 *           The smallest element is at (i+1) % n.
 *           The largest element is at i.
 *
 *   Step 2: Use two pointers:
 *           l = (i+1) % n  (smallest element's index)
 *           r = i          (largest element's index)
 *
 *   Step 3: While l != r:
 *           - If arr[l] + arr[r] == target → return true.
 *           - If sum < target → move l forward (need bigger sum):
 *               l = (l + 1) % n
 *           - If sum > target → move r backward (need smaller sum):
 *               r = (r - 1 + n) % n
 *
 *   The modulo arithmetic handles the circular nature of the array.
 *
 * Optimization note: The pivot can be found in O(log n) with binary search,
 * but the overall complexity is still O(n) because of the two-pointer pass.
 * Keeping the linear pivot search is fine for interviews.
 */
public class PairSumRotatedTwoPointers {

    // Time: O(n) | Space: O(1)
    public static boolean pairInSortedRotated(int[] arr, int target) {
        int n = arr.length;
        if (n < 2) return false;

        // Step 1: Find pivot — index where the array drops
        int pivot = -1;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                pivot = i;
                break;
            }
        }

        // l = smallest element index, r = largest element index
        int l = (pivot + 1) % n;
        int r = pivot == -1 ? n - 1 : pivot;

        // Step 2: Two-pointer sweep with circular indexing
        while (l != r) {
            int sum = arr[l] + arr[r];

            if (sum == target) {
                return true;
            } else if (sum < target) {
                l = (l + 1) % n;      // need a bigger sum → move l forward
            } else {
                r = (r - 1 + n) % n;  // need a smaller sum → move r backward
            }
        }

        return false;
    }

    public static void main(String[] args) {
        System.out.println(pairInSortedRotated(new int[]{11, 15, 6, 8, 9, 10}, 16));      // true
        System.out.println(pairInSortedRotated(new int[]{11, 11, 15, 26, 38, 9, 10}, 35)); // true
        System.out.println(pairInSortedRotated(new int[]{9, 10, 10, 11, 15, 26, 38}, 45)); // false
    }
}