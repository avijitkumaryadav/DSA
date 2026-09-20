/*
 * Approach: Brute Force
 * Time Complexity:  O(n^3)  — O(n^2) substrings, each checked in O(n)
 * Space Complexity: O(1)    — only index variables
 * Sheet: Strings Row 11 — Longest Palindromic Substring
 *        (Microsoft + Google + Samsung + Visa)
 *
 * NOTE: Works for n ≤ 1000 on LeetCode, but O(n^3) is very slow.
 *       Use only to understand the problem. The Expand-Around-Center
 *       approach is the interview standard.
 */
public class LongestPalindromicBrute {

    // Time: O(n^3) | Space: O(1)
    public static String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;

        int maxLen = 1;
        int start = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j) && (j - i + 1) > maxLen) {
                    maxLen = j - i + 1;
                    start = i;
                }
            }
        }

        return s.substring(start, start + maxLen);
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(longestPalindrome("babad")); // bab or aba
        System.out.println(longestPalindrome("cbbd"));  // bb
        System.out.println(longestPalindrome("a"));     // a
        System.out.println(longestPalindrome("ac"));    // a or c
    }
}