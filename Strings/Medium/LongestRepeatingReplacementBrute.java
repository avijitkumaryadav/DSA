/*
 * Approach: Brute Force (check every substring)
 * Time Complexity:  O(n^3)  — O(n^2) substrings, O(n) to count frequencies
 * Space Complexity: O(1)    — 26-element frequency array
 * Sheet: Strings Row 9 — Longest Repeating Character Replacement
 *        (Amazon + Google)
 *
 * Logic:
 *   For each substring s[i..j]:
 *     - Count frequency of each character in the substring.
 *     - Let maxFreq = frequency of the most common char.
 *     - Length of substring = j - i + 1.
 *     - Characters to replace = length - maxFreq.
 *     - If (length - maxFreq) <= k, this substring is valid → update max length.
 *
 * NOTE: TLE on LeetCode for n = 10^5.
 */
public class LongestRepeatingReplacementBrute {

    // Time: O(n^3) | Space: O(1)
    public static int characterReplacement(String s, int k) {
        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            for (int j = i; j < n; j++) {
                freq[s.charAt(j) - 'A']++;

                int maxFreq = 0;
                for (int f : freq) maxFreq = Math.max(maxFreq, f);

                int len = j - i + 1;
                if (len - maxFreq <= k) {
                    maxLen = Math.max(maxLen, len);
                }
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));    // 4
        System.out.println(characterReplacement("AABABBA", 1)); // 4
        System.out.println(characterReplacement("AAAA", 0));    // 4
    }
}