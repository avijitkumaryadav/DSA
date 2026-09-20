/*
 * Approach: Division with Zero Handling
 * Time Complexity:  O(n)  — two passes
 * Space Complexity: O(1)  — output array not counted
 * Sheet: Arrays Row 12 — Product of Array Except Self (Microsoft + Facebook)
 *
 * Logic:
 *   - Compute total product of all non-zero elements (prod).
 *   - Count zeroes.
 *   - If zeroCount >= 2 → all answers are 0.
 *   - If zeroCount == 1:
 *       - The index with zero → prod (product of all others)
 *       - All other indices → 0 (because their product includes the zero)
 *   - If zeroCount == 0 → answer[i] = totalProduct / nums[i]
 *
 * NOTE: Problem says "without using the division operation". This solution
 * uses division — only mentioned as a stepping stone. Use it locally to
 * understand the problem, but the optimal solution is prefix/suffix.
 */
public class ProductExceptSelfDivision {

    // Time: O(n) | Space: O(1)
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        int totalProduct = 1;
        int zeroCount = 0;

        for (int num : nums) {
            if (num == 0) {
                zeroCount++;
            } else {
                totalProduct *= num;
            }
        }

        for (int i = 0; i < n; i++) {
            if (zeroCount >= 2) {
                answer[i] = 0;
            } else if (zeroCount == 1) {
                answer[i] = (nums[i] == 0) ? totalProduct : 0;
            } else {
                answer[i] = totalProduct / nums[i];
            }
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