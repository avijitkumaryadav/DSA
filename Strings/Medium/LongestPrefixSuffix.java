/*
 * Approach: KMP Algorithm — LPS Array (Expected / Optimal)
 * Time Complexity:  O(n)  — single pass
 * Space Complexity: O(n)  — lps array
 * Sheet: Strings Row 17 — Longest Prefix Suffix
 *        (Flipkart + Swiggy + Accolite + Amazon + Microsoft + MakeMyTrip + NPCI)
 *
 * Logic:
 *   Build the LPS (Longest Prefix Suffix) array, same as KMP's preprocessing step.
 *   lps[i] = length of the longest PROPER prefix of s[0..i] that is also a suffix.
 *
 *   Maintain:
 *     - 'len' = length of the longest prefix-suffix found so far
 *     - 'i'   = current position we're filling
 *
 *   At each i:
 *     - If s[i] == s[len]: increment len, set lps[i] = len, i++
 *     - Else if len != 0: fall back to lps[len-1]
 *     - Else: lps[i] = 0, i++
 *
 * Key Insight:
 *   The 'fall back' step (len = lps[len-1]) uses the PREVIOUS longest prefix-suffix
 *   to avoid re-checking characters we already know match. This is what makes KMP O(n).
 */
public class LongestPrefixSuffix {

    // Time: O(n) | Space: O(n)
    public static int getLPSLength(String s) {
        int n = s.length();
        if (n <= 1) return 0;

        int[] lps = new int[n];
        int len = 0;
        int i = 1;

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(getLPSLength("abab"));      // 2
        System.out.println(getLPSLength("aabcdaabc")); // 4
        System.out.println(getLPSLength("aaaa"));      // 3
        System.out.println(getLPSLength("abc"));       // 0 (no prefix=suffix)
        System.out.println(getLPSLength("a"));         // 0 (single char)
        System.out.println(getLPSLength("ababab"));    // 4
    }
}