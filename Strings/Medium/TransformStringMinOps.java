import java.util.HashMap;
import java.util.Map;

/*
 * Approach: HashMap Frequency Check + Two Pointers
 * Time Complexity:  O(n)  — O(n) for frequency check, O(n) for two-pointer pass
 * Space Complexity: O(k)  — k = number of distinct characters (≤ 26 for lowercase, ≤ 256 for ASCII)
 * Sheet: Strings Row 19 — Transform One String to Another using Minimum Operations
 *        (Directi)
 *
 * Logic:
 *   Operation allowed: pick any character from s1 and insert it at the FRONT of s1.
 *   Goal: transform s1 → s2 in minimum operations.
 *
 *   Step 1: Verify anagram-ability.
 *     - Both strings must have the SAME character frequencies.
 *     - If not → return -1.
 *
 *   Step 2: Match from the BACK.
 *     - Since we can only move chars to the front, we match from the right.
 *     - Two pointers i (on s1) and j (on s2), both starting at n-1.
 *     - If s1[i] == s2[j]: both pointers move left (this char is in the right place).
 *     - If s1[i] != s2[j]: s1[i] must be moved to the front → increment result, move i left only.
 *     - Continue until i < 0.
 *
 *   Why match from the back?
 *     The characters we DON'T touch are the ones that can stay in place.
 *     Matching from the back finds the longest suffix of s2 already present in s1,
 *     so the remaining (unmatched) characters must be moved → those are the ops count.
 */
public class TransformStringMinOps {

    // Time: O(n) | Space: O(k)
    public static int transform(String s1, String s2) {
        if (s1.length() != s2.length()) return -1;

        int n = s1.length();

        // Step 1: Frequency check
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : s1.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        for (char c : s2.toCharArray()) {
            if (!freq.containsKey(c)) return -1;
            freq.put(c, freq.get(c) - 1);
        }
        for (int v : freq.values()) {
            if (v != 0) return -1;
        }

        // Step 2: Two-pointer match from the back
        int i = n - 1, j = n - 1;
        int ops = 0;

        while (i >= 0 && j >= 0) {
            if (s1.charAt(i) == s2.charAt(j)) {
                // Match → both pointers move
                i--;
                j--;
            } else {
                // s1[i] must be moved to the front
                ops++;
                i--;
            }
        }

        return ops;
    }

    public static void main(String[] args) {
        System.out.println(transform("abd", "bad"));                    // 1
        System.out.println(transform("GeeksForGeeks", "ForGeeksGeeks")); // 3
        System.out.println(transform("abc", "abc"));                    // 0
        System.out.println(transform("abc", "def"));                    // -1 (different chars)
        System.out.println(transform("abc", "abcd"));                   // -1 (different lengths)
    }
}