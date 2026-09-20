import java.util.HashMap;
import java.util.Map;

/*
 * Approach: Prefix Sum modulo K with HashMap (Expected / Optimal)
 * Time Complexity:  O(n)             — single pass
 * Space Complexity: O(min(n, k))     — at most k distinct remainders
 * Sheet: Arrays Row 24 — Subarray Sum Divisible by K
 *        (Snapdeal + Microsoft)
 *
 * Logic:
 *   Key insight: If prefix[i] % k == prefix[j] % k, then
 *                the subarray arr[i+1..j] has sum divisible by k.
 *   (Because the difference of the two prefix sums is the subarray sum,
 *    and if both have the same remainder mod k, their difference is 0 mod k.)
 *
 * Algorithm:
 *   1. Traverse the array, maintaining a running prefix sum modulo k.
 *   2. For each i, if (prefix mod k) == 0, then the subarray arr[0..i]
 *      is divisible by k → update res = i + 1.
 *   3. Else, if we've seen this remainder before at index j, then the
 *      subarray arr[j+1..i] has sum divisible by k → update res = i - j.
 *   4. Otherwise, store (remainder, i) as the first occurrence.
 *
 * Negative handling:
 *   Java's % can return negative values. Use ((sum + arr[i]) % k + k) % k
 *   to normalize the remainder to [0, k-1].
 */
public class LongestSubarrayDivKPrefixSum {

    // Time: O(n) | Space: O(min(n, k))
    public static int longestSubarrayDivK(int[] arr, int k) {
        int n = arr.length, res = 0;
        Map<Integer, Integer> prefIdx = new HashMap<>();   // remainder → first index
        int sum = 0;

        for (int i = 0; i < n; i++) {
            // Update running prefix sum, normalized to [0, k-1]
            sum = ((sum + arr[i]) % k + k) % k;

            if (sum == 0) {
                // Subarray arr[0..i] is divisible by k
                res = i + 1;
            } else if (prefIdx.containsKey(sum)) {
                // We've seen this remainder before → subarray arr[j+1..i]
                res = Math.max(res, i - prefIdx.get(sum));
            } else {
                // First time seeing this remainder → store index
                prefIdx.put(sum, i);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        System.out.println(longestSubarrayDivK(new int[]{2, 7, 6, 1, 4, 5}, 3));             // 4
        System.out.println(longestSubarrayDivK(new int[]{-2, 2, -5, 12, -11, -1, 7}, 3));    // 5
        System.out.println(longestSubarrayDivK(new int[]{1, 2, -2}, 5));                    // 2
    }
}