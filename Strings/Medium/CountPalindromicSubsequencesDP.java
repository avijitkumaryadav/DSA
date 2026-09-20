/*
 * Approach: Dynamic Programming
 * Time Complexity:  O(n^2)  — fill n×n DP table
 * Space Complexity: O(n^2)  — 2D DP table
 * Sheet: Strings Row 14 — Count Palindromic Subsequences (Myntra)
 *
 * Logic:
 *   Let dp[i][j] = number of palindromic subsequences in s[i..j].
 *
 *   Base case: dp[i][i] = 1 (every single char is a palindrome).
 *
 *   For a substring s[i..j]:
 *     - If s[i] == s[j]:
 *         dp[i][j] = dp[i+1][j] + dp[i][j-1] + 1
 *         Explanation:
 *           - dp[i+1][j] = palindromes not using s[i] (or using it as interior)
 *           - dp[i][j-1] = palindromes not using s[j]
 *           - +1 = the new palindrome formed by s[i] + s[j] alone
 *           - (The overlap dp[i+1][j-1] is NOT subtracted because we're adding
 *              new palindromes, not merging sets.)
 *
 *     - If s[i] != s[j]:
 *         dp[i][j] = dp[i+1][j] + dp[i][j-1] - dp[i+1][j-1]
 *         Explanation:
 *           - Add palindromes ending at i, ending at j
 *           - Subtract overlap (dp[i+1][j-1]) counted twice
 *
 * Result: dp[0][n-1].
 */
public class CountPalindromicSubsequencesDP {

    // Time: O(n^2) | Space: O(n^2)
    public static int countPS(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int[][] dp = new int[n][n];

        // Base case: single chars
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Fill by increasing length
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {
        System.out.println(countPS("abcd")); // 4
        System.out.println(countPS("aab"));  // 4
        System.out.println(countPS("b"));    // 1
        System.out.println(countPS("aaa"));  // 7 (a, a, a, aa, aa, aaa)
        System.out.println(countPS("aba"));  // 5 (a, b, a, aa, aba)
    }
}