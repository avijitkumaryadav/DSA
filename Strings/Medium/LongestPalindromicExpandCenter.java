/*
 * Approach: Expand Around Center (Expected / Optimal for interviews)
 * Time Complexity:  O(n^2)  — n centers, each expansion O(n)
 * Space Complexity: O(1)    — no extra space
 * Sheet: Strings Row 11 — Longest Palindromic Substring
 *        (Microsoft + Google + Samsung + Visa)
 *
 * Logic:
 *   Every palindrome has a center:
 *     - Odd-length:  single character center (e.g., "aba" → center at 'b')
 *     - Even-length: center between two characters (e.g., "abba" → center between 'b','b')
 *
 *   For each of the 2n-1 possible centers (n odd + n-1 even):
 *     - Expand outward while characters match.
 *     - Track the longest palindrome found.
 *
 * Why it works:
 *   Any palindrome is uniquely determined by its center + expansion radius.
 *   By checking all centers and expanding, we cover every possible palindrome.
 *
 * Optimization: Maintain start and maxLen indices instead of rebuilding strings.
 */
public class LongestPalindromicExpandCenter {

    private static int start = 0;
    private static int maxLen = 1;

    // Time: O(n^2) | Space: O(1)
    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 2) return s;

        start = 0;
        maxLen = 1;

        for (int i = 0; i < s.length(); i++) {
            expandAroundCenter(s, i, i);       // odd-length (center at i)
            expandAroundCenter(s, i, i + 1);   // even-length (center between i, i+1)
        }

        return s.substring(start, start + maxLen);
    }

    private static void expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            int len = right - left + 1;
            if (len > maxLen) {
                maxLen = len;
                start = left;
            }
            left--;
            right++;
        }
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad")); // bab or aba
        System.out.println(longestPalindrome("cbbd"));  // bb
        System.out.println(longestPalindrome("a"));     // a
        System.out.println(longestPalindrome("ac"));    // a or c
        System.out.println(longestPalindrome("racecar")); // racecar
    }
}