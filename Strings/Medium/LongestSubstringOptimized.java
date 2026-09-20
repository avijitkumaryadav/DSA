import java.util.HashMap;
import java.util.Map;

/*
 * Approach: Sliding Window with HashMap (Optimized)
 * Time Complexity:  O(n)  — single pass, no inner while loop
 * Space Complexity: O(k)  — HashMap of up to k distinct characters
 * Sheet: Strings Row 8 — Longest Substring Without Repeating Characters
 *        (Morgan Stanley + Amazon)
 *
 * Logic:
 *   - Store the LAST SEEN index of each character in a HashMap.
 *   - When a duplicate is found at index right:
 *       Instead of shrinking one char at a time, JUMP left directly:
 *         left = max(left, lastSeen[c] + 1)
 *   - This is the "jump" optimization of the sliding window.
 *
 * Why faster than the HashSet version?
 *   - No inner while loop — one pass total.
 *   - Left pointer jumps directly to the correct position.
 *
 * Slightly trickier to write, but the same O(n) time with less constant work.
 */
public class LongestSubstringOptimized {

    // Time: O(n) | Space: O(k)
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> lastSeen = new HashMap<>();
        int left = 0, maxLen = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if (lastSeen.containsKey(c)) {
                // Jump left past the previous occurrence of c
                left = Math.max(left, lastSeen.get(c) + 1);
            }

            lastSeen.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb")); // 3
        System.out.println(lengthOfLongestSubstring("bbbbb"));    // 1
        System.out.println(lengthOfLongestSubstring("pwwkew"));   // 3
        System.out.println(lengthOfLongestSubstring(""));         // 0
    }
}