/*
 * Approach: Brute Force (Try all subarrays)
 * Time Complexity:  O(n^2)  — nested loops over all subarrays
 * Space Complexity: O(1)    — only tracking variables
 * Sheet: Arrays Row 24 — Subarray Sum Divisible by K
 *        (Snapdeal + Microsoft)
 *
 * Logic:
 *   - For each starting index i, extend j to the end.
 *   - Maintain sum mod k (avoids overflow).
 *   - If (sum % k) == 0, update result with (j - i + 1).
 *
 * NOTE: TLE for large inputs. Use the prefix-sum HashMap approach.
 */
public class LongestSubarrayDivKNaive {

    // Time: O(n^2) | Space: O(1)
    public static int longestSubarrayDivK(int[] arr, int k) {
        int res = 0;

        for (int i = 0; i < arr.length; i++) {
            int sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum = (sum + arr[j]) % k;

                if (sum == 0) {
                    res = Math.max(res, j - i + 1);
                }
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