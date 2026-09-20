/*
 * Approach: Iterative Replacement (Simple but slow)
 * Time Complexity:  O(n^2)  — each pass reduces length by 2, up to n/2 passes
 * Space Complexity: O(n)    — new string created each pass
 * Sheet: Strings Row 3 — Valid Parentheses (Google)
 *
 * Logic:
 *   - Repeatedly replace "()", "[]", "{}" with empty string.
 *   - If the string becomes empty → valid.
 *   - If a full pass produces no change but the string is non-empty → invalid.
 *
 * NOTE: Simple to understand but O(n²). Use only to grasp the concept.
 */
public class ValidParenthesesReplace {

    // Time: O(n^2) | Space: O(n)
    public static boolean isValid(String s) {
        while (s.contains("()") || s.contains("[]") || s.contains("{}")) {
            s = s.replace("()", "")
                 .replace("[]", "")
                 .replace("{}", "");
        }
        return s.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));        // true
        System.out.println(isValid("()[]{}"));    // true
        System.out.println(isValid("(]"));        // false
        System.out.println(isValid("([])"));      // true
        System.out.println(isValid("([)]"));      // false
    }
}