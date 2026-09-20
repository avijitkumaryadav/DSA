/*
 * Approach: Expand Around Center (Expected / Optimal)
 * Time Complexity:  O(n^2)  — 2n-1 centers, each expansion O(n)
 * Space Complexity: O(1)    — only counter and index variables
 * Sheet: Strings Row 12 — Palindromic Substrings (Microsoft)
 *
 * Logic:
 *   Same as "Longest Palindromic Substring" — but instead of tracking
 *   the longest, we COUNT every palindrome found during expansion.
 *
 *   Every palindrome has a center:
 *     - Odd-length:  center at character i      → expand(i, i)
 *     - Even-length: center between i and i+1   → expand(i, i+1)
 *
 *   For each center, expand outward while chars match, incrementing count
 *   for each valid palindrome found.
 *
 * Key Insight:
 *   Each successful expansion step = one new palindromic substring.
 */
public class PalindromicSubstringsExpandCenter {

    // Time: O(n^2) | Space: O(1)
    public static int countSubstrings(String s) {
        if (s == null || s.isEmpty()) return 0;

        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            count += expand(s, i, i);       // odd-length palindromes
            count += expand(s, i, i + 1);   // even-length palindromes
        }

        return count;
    }

    private static int expand(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc"));    // 3
        System.out.println(countSubstrings("aaa"));    // 6
        System.out.println(countSubstrings("a"));      // 1
        System.out.println(countSubstrings("abba"));   // 6  (a, b, b, a, bb, abba)
    }
}