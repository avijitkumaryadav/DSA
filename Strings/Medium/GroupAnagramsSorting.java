import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Approach: Sort each string to form a key
 * Time Complexity:  O(n × L log L)  — n strings, each sorted in O(L log L)
 * Space Complexity: O(n × L)        — HashMap holds all strings
 * Sheet: Strings Row 10 — Group Anagrams
 *        (Samsung + Adobe + Amazon)
 *
 * Logic:
 *   - Two strings are anagrams iff they have the same sorted form.
 *   - Use the sorted version of each string as a HashMap key.
 *   - Append the original string to the list at that key.
 *   - Return the map's values.
 *
 * Example:
 *   "eat" → sorted → "aet"
 *   "tea" → sorted → "aet"
 *   "ate" → sorted → "aet"     ← all three go into the same group
 */
public class GroupAnagramsSorting {

    // Time: O(n × L log L) | Space: O(n × L)
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // Sort characters to form the key
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);

            // Add to the group
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String[] strs1 = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs1));
        // [[eat, tea, ate], [tan, nat], [bat]]

        String[] strs2 = {""};
        System.out.println(groupAnagrams(strs2));
        // [[]]

        String[] strs3 = {"a"};
        System.out.println(groupAnagrams(strs3));
        // [[a]]
    }
}