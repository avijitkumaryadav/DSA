/*
 * Approach: Sliding Window with Frequency Maps (Expected / Optimal)
 * Time Complexity:  O(n)  — each char added once, removed once
 * Space Complexity: O(1)  — 26-element arrays (constant)
 * Sheet: Strings Row 15 — Smallest Window Containing All Characters of Another String
 *        (Flipkart + Amazon + Microsoft + MakeMyTrip + Google
 *         + Streamoid Technologies + Media.net + Atlassian + NPCI)
 *
 * Logic:
 *   1. Count required frequency of each char in p (array 'need').
 *   2. Sliding window over s:
 *      - Expand right, add s[right] to 'window' array.
 *      - When s[right] satisfies the required count for some char, increment 'formed'.
 *      - When formed == required (all chars satisfied), try shrinking from left:
 *          - Update best window if smaller.
 *          - Remove s[left], decrement its count.
 *          - If removing causes count to drop below required, decrement 'formed'.
 *          - Increment left.
 *   3. Return best substring, or "" if none found.
 *
 * Key Insight:
 *   Track TWO counts: how many distinct chars are needed, and how many are satisfied.
 *   This avoids re-scanning the frequency array on every step.
 */
public class SmallestWindowAllChars {

    // Time: O(n) | Space: O(1)
    public static String minWindow(String s, String p) {
        if (s == null || p == null || s.length() < p.length()) return "";

        int[] need = new int[26];
        for (char c : p.toCharArray()) {
            need[c - 'a']++;
        }

        int[] window = new int[26];
        int required = 0;
        for (int i = 0; i < 26; i++) {
            if (need[i] > 0) required++;
        }

        int formed = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            int idx = c - 'a';
            window[idx]++;

            if (need[idx] > 0 && window[idx] == need[idx]) {
                formed++;
            }

            while (formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                int leftIdx = leftChar - 'a';
                window[leftIdx]--;

                if (need[leftIdx] > 0 && window[leftIdx] < need[leftIdx]) {
                    formed--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("timetopractice", "toc"));  // toprac
        System.out.println(minWindow("zoomlazapzo", "oza"));     // apzo
        System.out.println(minWindow("zoom", "zooe"));           // (empty)
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));   // BANC
    }
}