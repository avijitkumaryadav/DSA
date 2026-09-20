import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/*
 * Approach: Custom Comparator based on Concatenation
 * Time Complexity:  O(n log n × L)  — sort with string comparison of length L
 * Space Complexity: O(n)            — string array + result builder
 * Sheet: Arrays Row 22 — Arrange Numbers to Form the Biggest Number (Barclays)
 *
 * Logic:
 *   We cannot sort numerically. We cannot sort lexicographically. We must
 *   sort by "which order gives a larger concatenation".
 *
 *   For two numbers X and Y:
 *     - XY = X concatenated with Y
 *     - YX = Y concatenated with X
 *   If XY > YX → X should come BEFORE Y.
 *   Else       → Y should come BEFORE X.
 *
 *   Example: X="2", Y="20"
 *     XY = "220"
 *     YX = "202"
 *     "220" > "202" → "2" before "20" → final: "3220" ✓
 *
 * Key Insight:
 *   The comparison must be based on concatenation, not numeric value.
 *
 * Edge case:
 *   If the sorted array's first element is "0", ALL elements are 0
 *   (because "0" would sort last among non-zero strings). Return "0".
 */
public class LargestConcatenatedNumber {

    // Time: O(n log n × L) | Space: O(n)
    public static String findLargest(int[] arr) {
        // Convert to string array
        String[] nums = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            nums[i] = String.valueOf(arr[i]);
        }

        // Sort with custom comparator
        // (a + b).compareTo(b + a) — if (a+b) > (b+a), a comes first
        Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));

        // Edge case: if the largest element is "0", all are 0
        if (nums[0].equals("0")) return "0";

        // Concatenate
        StringBuilder sb = new StringBuilder();
        for (String num : nums) {
            sb.append(num);
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(findLargest(new int[]{3, 30, 34, 5, 9}));         // 9534330
        System.out.println(findLargest(new int[]{54, 546, 548, 60}));       // 6054854654
        System.out.println(findLargest(new int[]{2, 3, 10}));               // 3210
        System.out.println(findLargest(new int[]{0, 0, 0}));                // 0
        System.out.println(findLargest(new int[]{10, 2}));                  // 210
    }
}