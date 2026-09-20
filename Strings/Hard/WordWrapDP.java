/*
 * Approach: Dynamic Programming (Optimal)
 * Time Complexity:  O(n^2)  — n starting positions, each tries O(n) line breaks
 * Space Complexity: O(n)    — single dp array
 * Sheet: Strings Row 22 — Word Wrap (Microsoft + Flipkart)
 *
 * Logic:
 *   Let dp[i] = minimum cost to wrap words arr[i..n-1] into lines.
 *
 *   Base case: dp[n] = 0 (no more words → no cost).
 *
 *   For each i from n-1 down to 0:
 *     - Try putting words i, i+1, ..., j on the SAME line.
 *     - Keep adding words until the line exceeds width k.
 *     - For each valid j, cost = (k - lineLength)^2 + dp[j+1].
 *     - If j is the last word (j == n-1), the last line has cost 0.
 *     - dp[i] = min over all valid j.
 *
 * Answer: dp[0].
 *
 * Key Insight:
 *   We process from RIGHT to LEFT because dp[i] depends on dp[j+1] where j >= i.
 *   This gives us a bottom-up DP table that fills naturally.
 */
public class WordWrapDP {

    // Time: O(n^2) | Space: O(n)
    public static int solveWordWrap(int[] arr, int k) {
        int n = arr.length;
        int[] dp = new int[n + 1];
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {
            int lineLength = 0;
            dp[i] = Integer.MAX_VALUE;

            for (int j = i; j < n; j++) {
                lineLength += arr[j] + (j == i ? 0 : 1);

                if (lineLength > k) break;

                int extraSpaces = k - lineLength;
                int cost = extraSpaces * extraSpaces;

                if (j == n - 1) cost = 0;   // last line has 0 cost

                dp[i] = Math.min(dp[i], cost + dp[j + 1]);
            }
        }

        return dp[0];
    }

    public static void main(String[] args) {
        System.out.println(solveWordWrap(new int[]{3, 2, 2, 5}, 6));   // 10
        System.out.println(solveWordWrap(new int[]{3, 2, 2}, 4));      // 5
        System.out.println(solveWordWrap(new int[]{1, 1, 1}, 3));      // 0 (all in one line)
        System.out.println(solveWordWrap(new int[]{5, 5, 5}, 6));      // 1 (last line 0 cost, first line 1 cost)
    }
}