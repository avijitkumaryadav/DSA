import java.util.ArrayList;

/*
 * Approach: Boyer Moore — Bad Character Heuristic
 * Time Complexity:
 *   - Worst case: O(n × m)  — when text and pattern have repeated characters
 *   - Best case:  O(n / m)  — when characters are all different
 *   - Average:    O(n / m) to O(n)
 * Space Complexity: O(1)  — 256-element array (constant)
 * Sheet: Strings Row 21 — Boyer Moore Algorithm (Amdocs)
 *
 * Logic:
 *   1. Preprocess: build a 'badchar' array of size 256, where
 *        badchar[c] = index of the LAST occurrence of character c in the pattern
 *        (or -1 if c doesn't appear in the pattern).
 *
 *   2. Slide the pattern over the text, matching from the RIGHT side.
 *
 *   3. On mismatch at pattern position j (text position s+j):
 *        - Let bc = badchar[txt[s+j]] (last occurrence of the mismatched char in pattern).
 *        - Shift s by max(1, j - bc).
 *        - If bc == -1 (char not in pattern), j - bc = j + 1, so we shift past the mismatch.
 *        - If bc >= 0, we align the mismatched char to its last occurrence.
 *
 *   4. On full match (j < 0), record the shift index s.
 *        - Shift further to align the NEXT character in text with its last occurrence.
 *
 * Key Insight:
 *   Boyer Moore is faster than KMP in practice because it can shift the pattern
 *   by more than one position, often skipping large chunks of the text.
 */
public class BoyerMooreBadChar {

    private static final int NO_OF_CHARS = 256;

    // Time: O(n × m) worst | Space: O(1)
    public static ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> result = new ArrayList<>();
        int m = pat.length();
        int n = txt.length();
        if (m == 0 || n < m) return result;

        int[] badchar = new int[NO_OF_CHARS];
        for (int i = 0; i < NO_OF_CHARS; i++) badchar[i] = -1;
        for (int i = 0; i < m; i++) badchar[(int) pat.charAt(i)] = i;

        int s = 0;
        while (s <= n - m) {
            int j = m - 1;

            while (j >= 0 && pat.charAt(j) == txt.charAt(s + j)) j--;

            if (j < 0) {
                result.add(s);
                s += (s + m < n) ? m - badchar[txt.charAt(s + m)] : 1;
            } else {
                s += Math.max(1, j - badchar[txt.charAt(s + j)]);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(search("AABA", "AABAACAADAABAABA")); // [0, 9, 12]
        System.out.println(search("TEST", "THIS IS A TEST TEXT")); // [10]
        System.out.println(search("ABC", "ABAAABCD")); // [4]
        System.out.println(search("ABC", "XYZ")); // []
    }
}