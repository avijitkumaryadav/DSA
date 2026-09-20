/*
 * Approach: Prefix and Suffix Products (Optimal — no division)
 * Time Complexity:  O(n)  — two passes
 * Space Complexity: O(1)  — output array not counted as extra space
 * Sheet: Arrays Row 12 — Product of Array Except Self (Microsoft + Facebook)
 *
 * Logic:
 *   answer[i] = (product of all nums[0..i-1]) × (product of all nums[i+1..n-1])
 *             = prefix[i] × suffix[i]
 *
 * Pass 1 (left to right):
 *   answer[i] = product of all elements to the LEFT of i.
 *
 * Pass 2 (right to left):
 *   Maintain a running "rightProduct" (product of all to the right).
 *   answer[i] *= rightProduct;
 *   Then update rightProduct *= nums[i] for the next iteration.
 *
 * This gives O(n) time with O(1) extra space (excluding the output array).
 * Satisfies the Follow-up: "Can you solve in O(1) extra space?"
 */
public class ProductExceptSelfOptimal {

    // Time: O(n) | Space: O(1)
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        // Pass 1: answer[i] = product of everything to the LEFT of i
        answer[0] = 1;                                  // nothing to the left of index 0
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Pass 2: multiply by product of everything to the RIGHT
        int rightProduct = 1;                           // nothing to the right of last element
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= rightProduct;
            rightProduct *= nums[i];                    // update for next iteration
        }

        return answer;
    }

    public static void main(String[] args) {
        System.out.println(java.util.Arrays.toString(
            productExceptSelf(new int[]{1, 2, 3, 4})));       // [24, 12, 8, 6]

        System.out.println(java.util.Arrays.toString(
            productExceptSelf(new int[]{-1, 1, 0, -3, 3})));  // [0, 0, 9, 0, 0]
    }
}