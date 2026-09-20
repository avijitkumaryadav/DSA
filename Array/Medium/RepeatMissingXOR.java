/*
 * Approach: XOR (Optimal — no overflow risk)
 * Time Complexity:  O(n)
 * Space Complexity: O(1)
 * Sheet: Arrays Row 9 — Repeat and Missing Number Array (Amazon)
 *
 * Logic:
 *   XOR of all array elements XOR XOR of 1..n = A XOR B
 *   (because pairs cancel out, leaving only A and B)
 *
 *   Then find the rightmost set bit in (A XOR B).
 *   This bit is different between A and B.
 *
 *   Split all numbers (array + 1..n) into two groups based on that bit.
 *   Each group XORs down to either A or B.
 *
 *   Finally, check which one appears twice in the original array
 *   to distinguish A (repeated) from B (missing).
 *
 * Advantages:
 *   - No overflow (integers only)
 *   - No division (safer)
 *   - Faster in practice (bit operations)
 */
import java.util.ArrayList;

public class RepeatMissingXOR {

    // Time: O(n) | Space: O(1)
    public static ArrayList<Integer> repeatedNumber(final ArrayList<Integer> A) {
        int n = A.size();

        // Step 1: XOR of all array elements
        int xorAll = 0;
        for (int num : A) {
            xorAll ^= num;
        }

        // Step 2: XOR with 1..n
        for (int i = 1; i <= n; i++) {
            xorAll ^= i;
        }
        // Now xorAll = A ^ B (repeated ^ missing)

        // Step 3: Find rightmost set bit in (A ^ B)
        int rightmostSetBit = xorAll & -xorAll;

        // Step 4: Divide numbers into two groups based on that bit
        int group1 = 0;  // will be either A or B
        int group2 = 0;  // the other one

        for (int num : A) {
            if ((num & rightmostSetBit) != 0) {
                group1 ^= num;
            } else {
                group2 ^= num;
            }
        }
        for (int i = 1; i <= n; i++) {
            if ((i & rightmostSetBit) != 0) {
                group1 ^= i;
            } else {
                group2 ^= i;
            }
        }

        // Step 5: Determine which is A (repeated) and which is B (missing)
        int repeated = group1;
        int missing = group2;

        // Check which one appears twice in the original array
        int countGroup1 = 0;
        for (int num : A) {
            if (num == group1) countGroup1++;
        }

        if (countGroup1 == 2) {
            repeated = group1;
            missing = group2;
        } else {
            repeated = group2;
            missing = group1;
        }

        ArrayList<Integer> result = new ArrayList<>();
        result.add(repeated);
        result.add(missing);
        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(3); arr1.add(1); arr1.add(2); arr1.add(5); arr1.add(3);
        System.out.println(repeatedNumber(arr1)); // [3, 4]

        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(1); arr2.add(2); arr2.add(3); arr2.add(4); arr2.add(4);
        System.out.println(repeatedNumber(arr2)); // [4, 5]
    }
}