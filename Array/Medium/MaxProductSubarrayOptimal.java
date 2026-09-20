/*
 * Approach: Track max AND min in a single pass (Optimal)
 * Time Complexity:  O(n)  — single pass
 * Space Complexity: O(1)  — 4 variables
 * Sheet: Arrays Row 13 — Maximum Product Subarray (Amazon)
 *
 * Logic:
 *   Unlike max-sum, multiplying by a NEGATIVE flips max and min.
 *   So we track BOTH:
 *     - maxProd = largest product ending at current position
 *     - minProd = smallest product ending at current position (could be very negative)
 *
 *   At each step, compute three candidates:
 *     c1 = maxProd * nums[i]
 *     c2 = minProd * nums[i]
 *     c3 = nums[i]  (start fresh from here)
 *   Then:
 *     newMax = max(c1, c2, c3)
 *     newMin = min(c1, c2, c3)
 *
 *   Update global answer with newMax each step.
 *
 * Example trace: [2, 3, -2, 4]
 *   i=0: max=2,  min=2,  ans=2
 *   i=1: max=6,  min=3,  ans=6
 *   i=2: max=-2 (from min*num), min=-12, ans=6
 *   i=3: max=4 (from min*num),  min=-48, ans=6
 */
public class MaxProductSubarrayOptimal {

    // Time: O(n) | Space: O(1)
    public static int maxProduct(int[] nums) {
        int maxProd = nums[0];      // largest product ending at i
        int minProd = nums[0];      // smallest product ending at i
        int answer = nums[0];       // global best

        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];

            // Candidates when extending from i-1
            int c1 = maxProd * num;
            int c2 = minProd * num;

            // maxProd: best of (extend max, extend min, start fresh)
            maxProd = Math.max(num, Math.max(c1, c2));
            // minProd: worst of (extend max, extend min, start fresh)
            minProd = Math.min(num, Math.min(c1, c2));

            // Update global answer
            answer = Math.max(answer, maxProd);
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, -2, 4};
        System.out.println(maxProduct(nums1)); // 6

        int[] nums2 = {-2, 0, -1};
        System.out.println(maxProduct(nums2)); // 0

        int[] nums3 = {-2, 3, -4};
        System.out.println(maxProduct(nums3)); // 24
    }
}