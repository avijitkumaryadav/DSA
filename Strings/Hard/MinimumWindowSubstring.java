/*
 * Approach: Sliding Window with Frequency Maps (Optimal)
 * Time Complexity:  O(m + n)  — m = s.length(), n = t.length()
 * Space Complexity: O(1)      — 128-element array (constant)
 * Sheet: Strings Row 20 — Minimum Window Substring
 *        (Amazon + Google + MakeMyTrip + Microsoft + Media.net + Atlassian + Flipkart)
 *
 * NOTE: This is the SAME problem as Strings Row 15. Kept here for completeness
 *       because the sheet lists it under a different name. The LeetCode version
 *       supports both uppercase and lowercase letters, so we use int[128] (ASCII)
 *       instead of int[26].
 */
public class MinimumWindowSubstring {

    // Time: O(m + n) | Space: O(1)
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        int[] need = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }

        int required = 0;
        for (int i = 0; i < 128; i++) {
            if (need[i] > 0) required++;
        }

        int[] window = new int[128];
        int formed = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int minLeft = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            window[c]++;

            if (need[c] > 0 && window[c] == need[c]) {
                formed++;
            }

            while (formed == required) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    minLeft = left;
                }

                char leftChar = s.charAt(left);
                window[leftChar]--;

                if (need[leftChar] > 0 && window[leftChar] < need[leftChar]) {
                    formed--;
                }

                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minLeft, minLeft + minLen);
    }

    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC")); // BANC
        System.out.println(minWindow("a", "a"));               // a
        System.out.println(minWindow("a", "aa"));              // (empty)
        System.out.println(minWindow("AaBbCc", "ABC"));        // aBbC (or similar)
    }
}