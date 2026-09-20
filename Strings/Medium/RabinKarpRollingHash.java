import java.util.ArrayList;

/*
 * Approach: Rabin-Karp with Rolling Hash (Expected / Optimal)
 * Time Complexity:  O(n + m) average, O(n × m) worst (many hash collisions)
 * Space Complexity: O(1)  — only numeric variables
 * Sheet: Strings Row 18 — Rabin-Karp Algorithm (Microsoft)
 *
 * Logic:
 *   1. Compute hash of pattern: p
 *   2. Compute hash of first window of text: t
 *   3. Slide window:
 *        - If p == t, do char-by-char comparison to confirm.
 *        - Update hash by removing leftmost char, adding new char:
 *            t = (d * (t - txt[i] * h) + txt[i+m]) % q
 *          where h = d^(m-1) % q
 *
 * Rolling hash formula:
 *   hash(s[i..i+m-1]) = s[i] * d^(m-1) + s[i+1] * d^(m-2) + ... + s[i+m-1] * d^0
 *
 *   When sliding to s[i+1..i+m]:
 *     hash_new = d * (hash_old - s[i] * d^(m-1)) + s[i+m]
 *
 * Parameters:
 *   d = 256 (ASCII alphabet size)
 *   q = 101 (prime modulus — small but fast; use 10^9+7 for production)
 */
public class RabinKarpRollingHash {

    // Time: O(n + m) average | Space: O(1)
    public static ArrayList<Integer> search(String pat, String txt) {
        int d = 256;     // ASCII alphabet size
        int q = 101;     // prime modulus

        int m = pat.length();
        int n = txt.length();
        ArrayList<Integer> result = new ArrayList<>();

        if (m == 0 || n < m) return result;

        // Precompute h = d^(m-1) % q
        int h = 1;
        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        // Initial hashes for pattern and first window of text
        int p = 0;   // pattern hash
        int t = 0;   // text window hash
        for (int i = 0; i < m; i++) {
            p = (d * p + pat.charAt(i)) % q;
            t = (d * t + txt.charAt(i)) % q;
        }

        // Slide pattern over text
        for (int i = 0; i <= n - m; i++) {
            // If hash matches, verify char by char (avoid false positives)
            if (p == t) {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (txt.charAt(i + j) != pat.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) result.add(i);
            }

            // Compute rolling hash for next window
            if (i < n - m) {
                t = (d * (t - txt.charAt(i) * h) + txt.charAt(i + m)) % q;
                if (t < 0) t += q;   // handle negative modulo
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(search("geeks", "geeksforgeeks"));    // [0, 8]
        System.out.println(search("aaba", "aabaacaadaabaaba"));  // [0, 9, 12]
        System.out.println(search("aa", "aaaa"));                // [0, 1, 2]
        System.out.println(search("xyz", "abcdef"));             // []
    }
}