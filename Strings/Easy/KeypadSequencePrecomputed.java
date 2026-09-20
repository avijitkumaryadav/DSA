/*
 * Approach: Precomputed Keypad Sequences (Optimal)
 * Time Complexity:  O(n × p)  — n × p = total characters in output
 * Space Complexity: O(1)      — fixed array of 26 strings
 * Sheet: Strings Row 6 — Convert Sentence to Numeric Keypad Sequence (Adobe)
 *
 * Logic:
 *   - Precompute for each letter A-Z the full sequence to append.
 *     E.g., 'A' → "2", 'B' → "22", 'C' → "222", 'Z' → "9999".
 *   - For each char, look up its sequence and append it directly.
 *   - Space → append '0'.
 *
 * This is the cleanest and fastest approach:
 *   - No nested loop for presses.
 *   - Just one append per character.
 *
 * Index mapping:
 *   ch - 'A' gives 0-25 for 'A'-'Z'
 */
public class KeypadSequencePrecomputed {

    // Time: O(n × p) | Space: O(1)
    public static String printSequence(String s) {
        String[] keypad = {
            "2",    "22",  "222",   // A B C → 2
            "3",    "33",  "333",   // D E F → 3
            "4",    "44",  "444",   // G H I → 4
            "5",    "55",  "555",   // J K L → 5
            "6",    "66",  "666",   // M N O → 6
            "7",    "77",  "777", "7777",   // P Q R S → 7
            "8",    "88",  "888",   // T U V → 8
            "9",    "99",  "999", "9999"    // W X Y Z → 9
        };

        StringBuilder res = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (ch == ' ') {
                res.append('0');
            } else {
                res.append(keypad[ch - 'A']);
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