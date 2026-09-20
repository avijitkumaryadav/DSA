/*
 * Approach: Single Pass with StringBuilder (Optimal)
 * Time Complexity:  O(n)  — single pass
 * Space Complexity: O(n)  — result string
 * Sheet: Strings Row 4 — Remove Consecutive Characters (Samsung + Adobe)
 *
 * Logic:
 *   - Traverse the string once.
 *   - Track the previous appended character.
 *   - If the current char differs from prev, append it to the result.
 *   - If it's the same as prev, skip it.
 *
 * Key Insight:
 *   Consecutive duplicates collapse instantly. We only need to remember
 *   the LAST character we appended. No need for nested loops.
 */
public class RemoveConsecutiveCharsOptimal {

    // Time: O(n) | Space: O(n)
    public static String removeConsecutive(String s) {
        if (s.isEmpty()) return s;

        StringBuilder result = new StringBuilder();
        char prev = s.charAt(0);
        result.append(prev);

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != prev) {
                result.append(c);
                prev = c;
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(removeConsecutive("aabb"));    // ab
        System.out.println(removeConsecutive("aabaa"));   // aba
        System.out.println(removeConsecutive("aaaa"));    // a
        System.out.println(removeConsecutive("a"));       // a
        System.out.println(removeConsecutive("abc"));     // abc (no dups)
        System.out.println(removeConsecutive("aaabbbccc")); // abc
    }
}