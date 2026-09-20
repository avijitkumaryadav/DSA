import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Approach: Character Count String as Key (Optimal)
 * Time Complexity:  O(n × L)  — n strings, each scanned once (no sorting)
 * Space Complexity: O(n × L)  — HashMap with count-encoded keys
 * Sheet: Strings Row 10 — Group Anagrams
 *        (Samsung + Adobe + Amazon)
 *
 * Logic:
 *   - Instead of sorting each string (O(L log L)), count character frequencies
 *     and build a unique key like "#2#1#0...#0" (counts for a..z).
 *   - Two anagrams have the same frequency array → same key.
 *   - This is O(n × L) instead of O(n × L log L) — faster for long strings.
 *
 * Key format example:
 *   "eat" → counts = {a:1, e:1, t:1} → key = "1#0#0#0#1#0#...#1#...#0"
 *   "tea" → counts = {a:1, e:1, t:1} → same key ✓
 */
public class GroupAnagramsCountKey {

    // Time: O(n × L) | Space: O(n × L)
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            // Build count array for a-z
            int[] count = new int[26];
            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            // Build unique key from count array
            StringBuilder keyBuilder = new StringBuilder();
            for (int c : count) {
                keyBuilder.append(c).append('#');
            }
            String key = keyBuilder.toString();

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