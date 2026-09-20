import java.util.Arrays;

/*
 * Approach: Sort and Compare
 * Time Complexity:  O(n log n)  — sorting dominates
 * Space Complexity: O(n)        — char arrays
 * Sheet: Strings Row 2 — Valid Anagram
 *        (Nagarro + Media.net + Directi + Google + Adobe + Flipkart)
 *
 * Logic:
 *   - If lengths differ, return false.
 *   - Convert both strings to char arrays.
 *   - Sort both arrays.
 *   - Compare element by element.
 */
public class ValidAnagramSorting {

    // Time: O(n log n) | Space: O(n)
    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        Arrays.sort(sArr);
        Arrays.sort(tArr);

        return Arrays.equals(sArr, tArr);
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram")); // true
        System.out.println(isAnagram("rat", "car"));         // false
        System.out.println(isAnagram("a", "a"));             // true
    }
}