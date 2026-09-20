/*
 * Approach: Mapping Strings (key + press count)
 * Time Complexity:  O(n × p)  — n = length of string, p = max presses (4)
 * Space Complexity: O(1)      — two fixed-size mapping strings
 * Sheet: Strings Row 6 — Convert Sentence to Numeric Keypad Sequence (Adobe)
 *
 * Logic:
 *   - 'keys' string: for each letter A-Z, the keypad digit to press.
 *   - 'presses' string: for each letter A-Z, how many times to press.
 *   - For each character:
 *       - Space → append '0'.
 *       - Letter → look up its digit and count, append digit 'count' times.
 *
 * Mapping:
 *   A→'2'×1, B→'2'×2, C→'2'×3, D→'3'×1, E→'3'×2, F→'3'×3,
 *   G→'4'×1, H→'4'×2, I→'4'×3, J→'5'×1, K→'5'×2, L→'5'×3,
 *   M→'6'×1, N→'6'×2, O→'6'×3, P→'7'×1, Q→'7'×2, R→'7'×3, S→'7'×4,
 *   T→'8'×1, U→'8'×2, V→'8'×3, W→'9'×1, X→'9'×2, Y→'9'×3, Z→'9'×4
 */
public class KeypadSequenceMapping {

    // Time: O(n × p) | Space: O(1)
    public static String printSequence(String s) {
        String keys    = "22233344455566677778889999";
        String presses = "12312312312312312341231234";

        StringBuilder res = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                res.append('0');
            } else {
                int idx = ch - 'A';                          // 0-25
                char key = keys.charAt(idx);
                int count = presses.charAt(idx) - '0';       // convert char '1'-'4' → int

                for (int i = 0; i < count; i++) {
                    res.append(key);
                }
            }
        }

        return res.toString();
    }

    public static void main(String[] args) {
        System.out.println(printSequence("GFG"));     // 43334
        System.out.println(printSequence("HEY U"));   // 4433999088
        System.out.println(printSequence("ABC"));     // 222222
        System.out.println(printSequence("A B C"));   // 20220222
    }
}