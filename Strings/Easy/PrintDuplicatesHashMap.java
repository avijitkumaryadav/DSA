import java.util.LinkedHashMap;
import java.util.Map;

/*
 * Approach: HashMap (LinkedHashMap for order)
 * Time Complexity:  O(n)  — single pass + one pass over map
 * Space Complexity: O(k)  — k = number of distinct characters (≤ 26 for lowercase)
 * Sheet: Strings Row 7 — Print all Duplicates in the Input String
 *        (Ola + Amdocs)
 *
 * Logic:
 *   - Count frequency of each character in a LinkedHashMap.
 *   - LinkedHashMap preserves insertion order → first-occurrence order.
 *   - Traverse the map and print characters with count > 1.
 *
 * This is the OPTIMAL solution:
 *   - O(n) time (better than sorting's O(n log n)).
 *   - Order matches first occurrence (like the problem examples).
 *
 * IMPORTANT: Use LinkedHashMap, not HashMap!
 *   - HashMap doesn't preserve insertion order, so output order is random.
 *   - LinkedHashMap preserves order, so the output matches the problem
 *     examples (['e', 4], ['g', 2], ...).
 */
public class PrintDuplicatesHashMap {

    // Time: O(n) | Space: O(k)
    public static void printDuplicates(String s) {
        Map<Character, Integer> freq = new LinkedHashMap<>();

        // Count frequencies — preserves first-occurrence order
        for (char c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }

        // Print characters with count > 1
        for (Map.Entry<Character, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.print("['" + entry.getKey() + "', " + entry.getValue() + "], ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printDuplicates("geeksforgeeks");
        // ['e', 4], ['g', 2], ['k', 2], ['s', 2],

        printDuplicates("programming");
        // ['r', 2], ['g', 2], ['m', 2],

        printDuplicates("mississippi");
        // ['i', 4], ['s', 4], ['p', 2],

        printDuplicates("abc");
        // (no output)
    }
}