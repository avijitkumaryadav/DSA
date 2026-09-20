/*
 * Approach: Fixed-Size Array of 26 (lowercase only)
 * Time Complexity:  O(n)  — single pass over both strings
 * Space Complexity: O(1)  — array of size 26 (constant)
 * Sheet: Strings Row 2 — Valid Anagram
 *        (Nagarro + Media.net + Directi + Google + Adobe + Flipkart)
 *
 * Logic:
 *   - Since the constraints guarantee lowercase English letters, we can use
 *     a fixed array of 26 counters instead of a HashMap.
 *   - Increment count for each char in s, decrement for each char in t.
 *   - If all counts are 0 at the end → return true.
 *
 * This is the FASTEST and most space-efficient solution for the given
 * constraints (lowercase English only). For Unicode, use the HashMap approach.
 */
public class ValidAnagramArray {

    // Time: O(n) | Space: O(1)
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] count = new int[26];   // 26 lowercase letters

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for (int c : count) {
            if (c != 0) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram")); // true
        System.out.println(isAnagram("rat", "car"));         // false
        System.out.println(isAnagram("a", "a"));             // true
    }
}