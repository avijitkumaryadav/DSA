import java.util.HashMap;
import java.util.Map;

/*
 * Approach: HashMap Frequency Count
 * Time Complexity:  O(n)     — single pass over both strings
 * Space Complexity: O(k)     — k = number of distinct characters
 * Sheet: Strings Row 2 — Valid Anagram
 *        (Nagarro + Media.net + Directi + Google + Adobe + Flipkart)
 *
 * Logic:
 *   - If lengths differ, return false.
 *   - Count frequency of each character in s using a HashMap.
 *   - Decrement frequencies while iterating through t.
 *   - If any count goes below 0 or a character is missing → return false.
 *   - All counts reach 0 → return true.
 *
 * This is the solution for the Follow-up question (Unicode characters):
 *   A HashMap works for any character set, while a fixed array only works
 *   for lowercase English letters.
 */
public class ValidAnagramHashMap {

    // Time: O(n) | Space: O(k)
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> freq = new HashMap<>();

        // Count each character in s
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Decrement counts using t
        for (char c : t.toCharArray()) {
            if (!freq.containsKey(c)) return false;
            freq.put(c, freq.get(c) - 1);
            if (freq.get(c) < 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram")); // true
        System.out.println(isAnagram("rat", "car"));         // false
        System.out.println(isAnagram("a", "a"));             // true
    }
}