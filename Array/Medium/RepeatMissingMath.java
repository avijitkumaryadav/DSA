/*
 * Approach: Mathematical Equations (Sum + Sum of Squares)
 * Time Complexity:  O(n)  — two passes or one combined pass
 * Space Complexity: O(1)  — only tracking variables
 * Sheet: Arrays Row 9 — Repeat and Missing Number Array (Amazon)
 *
 * Logic:
 *   Let actual array have numbers: 1, 2, ..., n with
 *     - A repeated once (extra copy)
 *     - B missing
 *
 *   Let S_actual = sum of array = n(n+1)/2 - B + A
 *   Let S_expected = n(n+1)/2
 *   => S_actual - S_expected = A - B      ... (Equation 1)
 *
 *   Let Q_actual = sum of squares of array
 *   Let Q_expected = n(n+1)(2n+1)/6
 *   => Q_actual - Q_expected = A^2 - B^2 = (A - B)(A + B)   ... (Equation 2)
 *
 *   From Eq 1 and Eq 2:
 *     A + B = (Q_actual - Q_expected) / (A - B)
 *     A = ((A+B) + (A-B)) / 2
 *     B = ((A+B) - (A-B)) / 2
 *
 * CRITICAL: Use long for sums. For n = 10^5:
 *   Sum of 1..n ≈ 5 × 10^9 — exceeds int range (2.1 × 10^9)
 */
import java.util.ArrayList;

public class RepeatMissingMath {

    // Time: O(n) | Space: O(1)
    public static ArrayList<Integer> repeatedNumber(final ArrayList<Integer> A) {
        int n = A.size();

        // Use long to avoid overflow
        long sumActual = 0;
        long sumSquaresActual = 0;

        for (int num : A) {
            sumActual += num;
            sumSquaresActual += (long) num * num;
        }

        // Expected sum and sum of squares for 1..n
        long sumExpected = (long) n * (n + 1) / 2;
        long sumSquaresExpected = (long) n * (n + 1) * (2L * n + 1) / 6;

        // Differences
        long diffSum = sumActual - sumExpected;                   // A - B
        long diffSquares = sumSquaresActual - sumSquaresExpected; // A^2 - B^2

        // A + B = (A^2 - B^2) / (A - B)
        long sumAB = diffSquares / diffSum;                       // A + B

        // Solve for A and B
        long A_val = (sumAB + diffSum) / 2;
        long B_val = (sumAB - diffSum) / 2;

        ArrayList<Integer> result = new ArrayList<>();
        result.add((int) A_val);   // Repeated number A
        result.add((int) B_val);   // Missing number B

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