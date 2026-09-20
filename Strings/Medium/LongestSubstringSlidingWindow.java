import java.util.HashSet;
import java.util.Set;

/*
 * Approach: Sliding Window with HashSet (Expected / Optimal)
 * Time Complexity:  O(n)  — each character added and removed at most once
 * Space Complexity: O(k)  — k = size of character set (≤ 26 for lowercase)
 * Sheet: Strings Row 8 — Longest Substring Without Repeating Characters
 *        (Morgan Stanley + Amazon)
 *
 * Logic:
 *   - Maintain a window [left, right] with a HashSet of characters inside.
 *   - Expand right one char at a time:
 *       - If the new char is NOT in the set, add it. Update max.
 *       - If it IS in the set, shrink left until the duplicate is removed.
 *   - Each character is added once and removed once → O(n) total.
 *
 * Key Insight:
 *   The window always holds a substring WITHOUT duplicate characters.
 *   When a duplicate is encountered, we can't keep the old left position —
 *   we must shrink from the left until the duplicate is gone.
 */
public class LongestSubstringSlidingWindow {

    // Time: O(n) | Space: O(k)
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> window = new HashSet<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // Shrink window until the duplicate 'c' is removed
            while (window.contains(c)) {
                window.remove(s.charAt(left));
                left++;
            }

            window.add(c);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // 3
        System.out.println(lengthOfLongestSubstring(""));         // 0
        System.out.println(lengthOfLongestSubstring(" "));        // 1
    }
}