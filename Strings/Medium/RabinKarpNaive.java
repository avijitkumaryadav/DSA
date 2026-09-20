import java.util.ArrayList;

/*
 * Approach: Naive String Matching
 * Time Complexity:  O(n × m)  — n substrings, each compared in O(m)
 * Space Complexity: O(1)      — only index variables
 * Sheet: Strings Row 18 — Rabin-Karp Algorithm (Microsoft)
 *
 * NOTE: Baseline for comparison. Rabin-Karp avoids the O(m) character
 *       comparison for MOST substrings via hashing.
 */
public class RabinKarpNaive {

    // Time: O(n × m) | Space: O(1)
    public static ArrayList<Integer> search(String pat, String txt) {
        ArrayList<Integer> result = new ArrayList<>();
        int n = txt.length();
        int m = pat.length();

        for (int i = 0; i <= n - m; i++) {
            int j;
            for (j = 0; j < m; j++) {
                if (txt.charAt(i + j) != pat.charAt(j)) break;
            }
            if (j == m) result.add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(search("geeks", "geeksforgeeks"));          // [0, 8]
        System.out.println(search("aaba", "aabaacaadaabaaba"));        // [0, 9, 12]
    }
}