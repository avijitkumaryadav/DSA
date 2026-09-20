import java.util.Arrays;

/*
 * Approach: Sort + Compare First and Last
 * Time Complexity:  O(n log n × m)  — sort with string comparisons
 * Space Complexity: O(1)            — ignoring sort's internal space
 * Sheet: Strings Row 5 — Longest Common Prefix
 *        (Adobe + Grofers + Dunzo)
 *
 * Logic:
 *   - Sort the array of strings lexicographically.
 *   - After sorting, the FIRST and LAST strings share the longest common prefix
 *     of ALL strings (because sorted order groups similar strings together).
 *   - Compare the first and last strings character by character.
 *
 * Why this works:
 *   Lexicographic sorting puts strings with similar prefixes adjacent.
 *   The first string has the "smallest" prefix, the last has the "largest".
 *   Any prefix common to both must be common to ALL strings in between.
 *
 * This is the CLEVEREST solution — very easy to code once you see it.
 */
public class LongestCommonPrefixSorting {

    // Time: O(n log n × m) | Space: O(1)
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];

        int i = 0;
        while (i < first.length() && i < last.length() && first.charAt(i) == last.charAt(i)) {
            i++;
        }

        return first.substring(0, i);
    }

    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"})); // fl
        System.out.println(longestCommonPrefix(new String[]{"dog", "racecar", "car"}));    // (empty)
        System.out.println(longestCommonPrefix(new String[]{"a"}));                        // a
        System.out.println(longestCommonPrefix(new String[]{"ab", "a"}));                  // a
    }
}