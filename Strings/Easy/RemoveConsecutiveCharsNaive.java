/*
 * Approach: Naive Iterative Reduction
 * Time Complexity:  O(n^2)  — each pass may only remove 2 chars in the worst case
 * Space Complexity: O(n)    — new string each iteration
 * Sheet: Strings Row 4 — Remove Consecutive Characters (Samsung + Adobe)
 *
 * Logic:
 *   - In each pass, build a new string by skipping a character if it equals
 *     the previous one.
 *   - If the new string equals the old → done.
 *   - Otherwise, repeat.
 *
 * NOTE: Slow for large inputs. Use only to understand the problem.
 */
public class RemoveConsecutiveCharsNaive {

    // Time: O(n^2) | Space: O(n)
    public static String removeConsecutive(String s) {
        while (true) {
            StringBuilder sb = new StringBuilder();
            char prev = '\0';

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c != prev) {
                    sb.append(c);
                    prev = c;
                }
            }

            String next = sb.toString();
            if (next.equals(s)) return next;
            s = next;
        }
    }

    public static void main(String[] args) {
        System.out.println(removeConsecutive("aabb"));    // ab
        System.out.println(removeConsecutive("aabaa"));   // aba
        System.out.println(removeConsecutive("aaaa"));    // a
    }
}