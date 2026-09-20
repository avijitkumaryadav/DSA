/*
 * Approach: Sliding Window with Frequency Count (Expected / Optimal)
 * Time Complexity:  O(n)  — single pass through string
 * Space Complexity: O(1)  — 26-element array (constant)
 * Sheet: Strings Row 9 — Longest Repeating Character Replacement
 *        (Amazon + Google)
 *
 * Logic:
 *   The key insight: A window s[left..right] can be made into all-same-char
 *   if and only if:
 *       (window length) - (frequency of most common char in window) <= k
 *
 *   Because we replace every char EXCEPT the most common one with the most common.
 *
 *   Sliding window:
 *     - Expand right one char at a time, increment freq[c].
 *     - Track maxFreq (max count of any single char in the current window).
 *     - If (window length - maxFreq) > k → shrink from left.
 *     - Update maxLen with window size.
 *
 * Note on maxFreq:
 *   In this version, maxFreq is NOT decremented when left moves. This is safe
 *   because we only care about the maximum window size, and maxFreq is
 *   monotonically non-decreasing across the whole traversal.
 */
public class LongestRepeatingReplacementSlidingWindow {

    // Time: O(n) | Space: O(1)
    public static int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int left = 0;
        int maxFreq = 0;   // max frequency of a single char in the current window
        int maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);

            int windowLen = right - left + 1;

            // If more than k replacements needed, shrink the window
            if (windowLen - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(characterReplacement("ABAB", 2));    // 4
        System.out.println(characterReplacement("AABABBA", 1)); // 4
        System.out.println(characterReplacement("AAAA", 0));    // 4
        System.out.println(characterReplacement("ABCDE", 1));   // 2
    }
}