/*
 * Approach: Simple Boolean Array (Approach 1 / 2 in the article)
 * Time Complexity:  O(n)  — n = |b - a| + 1
 * Space Complexity: O(n)  — one boolean per index
 * Sheet: Arrays Row 23 — Space Optimization Using Bit Manipulations (Amazon)
 *
 * Logic:
 *   - Allocate a boolean array of size (b - a + 1).
 *   - Translate index i → array[i - a].
 *   - Mark array[i - a] = true if i is a multiple of 2 or 5.
 *   - Then print all indices where the array is true.
 *
 * Baseline version — compare to the bit-manipulation version to see
 * the space savings.
 */
public class MarkMultiplesSimple {

    // Time: O(n) | Space: O(n)
    public static void markAndPrint(int a, int b) {
        int size = Math.abs(b - a) + 1;
        boolean[] present = new boolean[size];

        for (int i = a; i <= b; i++) {
            if (i % 2 == 0 || i % 5 == 0) {
                present[i - a] = true;
            }
        }

        System.out.println("Multiples of 2 and 5 between " + a + " and " + b + ":");
        for (int i = a; i <= b; i++) {
            if (present[i - a]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        markAndPrint(2, 10);
        // 2 4 5 6 8 10

        markAndPrint(60, 95);
        // 60 62 64 65 66 68 70 72 74 75 76 78 80 82 84 85 86 88 90 92 94 95
    }
}