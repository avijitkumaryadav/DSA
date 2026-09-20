/*
 * Approach: Vertical Scan (Column-by-column)
 * Time Complexity:  O(n × m)  — up to n × m char comparisons
 * Space Complexity: O(1)      — only index variables
 * Sheet: Strings Row 5 — Longest Common Prefix
 *        (Adobe + Grofers + Dunzo)
 *
 * Logic:
 *   - Take the first string as reference.
 *   - For each column i (character position):
 *       - Check if ALL strings have the same char at position i.
 *   - Build the prefix incrementally.
 *
 * Very similar to the brute-force version but written differently.
 * Include it to show you understand multiple angles.
 */
public class LongestCommonPrefixVertical {

    // Time: O(n × m) | Space: O(1)
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c) {
                    return strs[0].substring(0, i);
                }
            }
        }

        return strs[0];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"})); // fl
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));    // (empty)
        System.out.println(longestCommonPrefix(new String[]{"a"}));                        // a
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));                  // a
    }
}