/*
 * Approach: Bit Manipulation (Space-Optimized)
 * Time Complexity:  O(n)     — same loop count
 * Space Complexity: O(n/32)  — 32× less memory than boolean array
 * Sheet: Arrays Row 23 — Space Optimization Using Bit Manipulations (Amazon)
 *
 * Logic:
 *   Each Java int has 32 bits. Instead of one boolean per index, we use
 *   ONE BIT per index. This gives a 32× memory reduction.
 *
 *   For index x (0-based, i.e. i - a), we map it to:
 *     - array[x >> 5]      → which int in the array (x / 32)
 *     - 1 << (x & 31)      → which bit in that int (x % 32)
 *
 *   setbit:    array[x >> 5] |=  (1 << (x & 31));
 *   checkbit:  (array[x >> 5] &   (1 << (x & 31))) != 0
 *
 * Why `>> 5`?
 *   x / 32 == x >> 5   (right shift by 5 = divide by 2^5 = 32)
 *
 * Why `& 31`?
 *   x % 32 == x & 31   (bitwise AND with 31 = modulo 32)
 */
public class MarkMultiplesBitwise {

    // Time: O(1) | Space: O(1)
    static boolean checkbit(int[] array, int index) {
        int val = array[index >> 5] & (1 << (index & 31));
        return val != 0;
    }

    // Time: O(1) | Space: O(1)
    static void setbit(int[] array, int index) {
        array[index >> 5] |= (1 << (index & 31));
    }

    // Time: O(n) | Space: O(n/32)
    public static void markAndPrint(int a, int b) {
        int range = Math.abs(b - a) + 1;
        int size = (range + 31) / 32;   // ceil(range / 32)
        int[] array = new int[size];

        // Mark multiples using bit manipulation
        for (int i = a; i <= b; i++) {
            if (i % 2 == 0 || i % 5 == 0) {
                setbit(array, i - a);
            }
        }

        System.out.println("Multiples of 2 and 5 between " + a + " and " + b + ":");
        for (int i = a; i <= b; i++) {
            if (checkbit(array, i - a)) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        markAndPrint(2, 10);
        markAndPrint(60, 95);
    }
}