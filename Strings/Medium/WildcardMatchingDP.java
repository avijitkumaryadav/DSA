/*
 * Approach: Dynamic Programming (2D DP table)
 * Time Complexity:  O(n × m)  — fill n×m table
 * Space Complexity: O(n × m)  — 2D boolean table
 * Sheet: Strings Row 16 — Wildcard String Matching
 *        (Microsoft + Amazon + Ola + Zoho + Walmart + Google
 *         + InMobi + United Health Group)
 *
 * Logic:
 *   dp[i][j] = true if pat[0..j-1] matches txt[0..i-1]
 *
 *   Base cases:
 *     dp[0][0] = true           (empty pattern matches empty text)
 *     dp[0][j] = dp[0][j-1] if pat[j-1] == '*'   (empty text, all '*' → match)
 *     dp[i][0] = false          (non-empty text, empty pattern → no match)
 *
 *   Recurrence:
 *     If pat[j-1] == '?' or pat[j-1] == txt[i-1]:
 *       dp[i][j] = dp[i-1][j-1]   (match 1 char, move both pointers)
 *     If pat[j-1] == '*':
 *       dp[i][j] = dp[i][j-1]     (match empty: skip '*')
 *               || dp[i-1][j]     (match 1+ chars: consume txt[i-1])
 *     Else:
 *       dp[i][j] = false          (chars don't match)
 *
 * Key Insight:
 *   The '*' can consume 0 or more characters. dp[i][j-1] = consume 0 (skip '*'),
 *   dp[i-1][j] = consume at least 1 (keep '*', advance text).
 */
public class WildcardMatchingDP {

    // Time: O(n × m) | Space: O(n × m)
    public static boolean wildCard(String txt, String pat) {
        int n = txt.length();
        int m = pat.length();

        boolean[][] dp = new boolean[n + 1][m + 1];

        // Base: empty pattern matches empty text
        dp[0][0] = true;

        // Base: empty text, only '*' pattern can match
        for (int j = 1; j <= m; j++) {
            if (pat.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 1];
            }
        }

        // Fill DP table
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                char pc = pat.charAt(j - 1);
                char tc = txt.charAt(i - 1);

                if (pc == '?' || pc == tc) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        System.out.println(wildCard("abcde", "a?c*"));    // true
        System.out.println(wildCard("baaabab", "a*ab"));  // false
        System.out.println(wildCard("abc", "*"));         // true
        System.out.println(wildCard("abc", "a*c"));       // true
        System.out.println(wildCard("abc", "a?c"));       // true
        System.out.println(wildCard("abc", "a?d"));       // false
        System.out.println(wildCard("", "*"));            // true
    }
}