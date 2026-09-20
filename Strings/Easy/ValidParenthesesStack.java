import java.util.ArrayDeque;
import java.util.Deque;

/*
 * Approach: Stack (Expected / Optimal)
 * Time Complexity:  O(n)  — single pass
 * Space Complexity: O(n)  — stack holds up to n/2 characters
 * Sheet: Strings Row 3 — Valid Parentheses (Google)
 *
 * Logic:
 *   - Traverse the string.
 *   - If it's an OPEN bracket, push the MATCHING close bracket onto the stack.
 *   - If it's a CLOSE bracket:
 *       - If stack is empty → invalid (no matching open).
 *       - Pop the stack; if popped != current → invalid (mismatched type).
 *   - At the end: valid iff the stack is empty.
 *
 * Key trick: We push the CLOSING bracket, not the opening one.
 * That way, when we see a closing bracket, we can compare it directly
 * against the top of the stack.
 */
public class ValidParenthesesStack {

    // Time: O(n) | Space: O(n)
    public static boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            // Push the matching closing bracket
            if (c == '(') stack.push(')');
            else if (c == '[') stack.push(']');
            else if (c == '{') stack.push('}');
            else {
                // Closing bracket: check the stack
                if (stack.isEmpty() || stack.pop() != c) {
                    return false;
                }
            }
        }

        return stack.isEmpty();   // All opens must be closed
    }

    public static void main(String[] args) {
        System.out.println(isValid("()"));        // true
        System.out.println(isValid("()[]{}"));    // true
        System.out.println(isValid("(]"));        // false
        System.out.println(isValid("([])"));      // true
        System.out.println(isValid("([)]"));      // false
        System.out.println(isValid("("));         // false
        System.out.println(isValid(")"));         // false
    }
}