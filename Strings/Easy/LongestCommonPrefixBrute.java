/*
 * Approach: Brute Force (Compare char-by-char across all strings)
 * Time Complexity:  O(n × m)  — n = number of strings, m = length of shortest
 * Space Complexity: O(1)      — only index variables
 * Sheet: Strings Row 5 — Longest Common Prefix
 *        (Adobe + Grofers + Dunzo)
 *
 * Logic:
 *   - Take the first string as reference.
 *   - For each character position i in the first string:
 *       - Check if every other string has the same character at position i.
 *       - If any string doesn't match (or is shorter) → return prefix so far.
 *   - Return the full first string if all chars match.
 */
public class LongestCommonPrefixBrute {

    // Time: O(n × m) | Space: O(1)
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        String first = strs[0];

        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);

            for (int j = 1; j < strs.length; j++) {
                // Check if strs[j] is too short OR has a different char
                if (i >= strs[j].length() || strs[j].charAt(i) != c) {
                    return first.substring(0, i);
                }
            }
        }

        return first;
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"})); // fl
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));    // (empty)
        System.out.println(longestCommonPrefix(new String[]{"a"}));                        // a
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));                  // a
    }
}