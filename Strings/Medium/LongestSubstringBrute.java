import java.util.HashSet;
import java.util.Set;

/*
 * Approach: Brute Force
 * Time Complexity:  O(n^3)  — O(n^2) substrings, each checked in O(n)
 * Space Complexity: O(n)    — HashSet per substring
 * Sheet: Strings Row 8 — Longest Substring Without Repeating Characters
 *        (Morgan Stanley + Amazon)
 *
 * NOTE: TLE on LeetCode for n = 10^5. Use only to understand the problem.
 */
public class LongestSubstringBrute {

    // Time: O(n^3) | Space: O(n)
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (allUnique(s, i, j)) {
                    maxLen = Math.max(maxLen, j - i + 1);
                }
            }
        }

        return maxLen;
    }

    private static boolean allUnique(String s, int start, int end) {
        Set<Character> seen = new HashSet<>();
        for (int k = start; k <= end; k++) {
            if (!seen.add(s.charAt(k))) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // 3
        System.out.println(lengthOfLongestSubstring(""));         // 0
    }
}