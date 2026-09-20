/*
 * Approach: Two Pointers (Optimal)
 * Time Complexity:  O(n)  — single pass
 * Space Complexity: O(1)  — only 4 variables
 * Sheet: Arrays Row 11 — Trapping Rain Water (Samsung)
 *
 * Logic:
 *   - Start with left=0, right=n-1, leftMax=0, rightMax=0.
 *   - At each step, process the side with the SMALLER current height.
 *   - Update the corresponding max (leftMax or rightMax).
 *   - Water at that bar = max - height[i]  (guaranteed non-negative).
 *   - Move that pointer inward.
 *
 * Why this works:
 *   The side with the smaller height is the limiting factor.
 *   Water on that side is fully determined by the SAME side's max — 
 *   the other side's max is guaranteed to be >= it.
 */
public class TrapRainWaterTwoPointers {

    // Time: O(n) | Space: O(1)
    public static int trap(int[] height) {
        int n = height.length;
        if (n <= 2) return 0;

        int left = 0, right = n - 1;
        int leftMax = 0, rightMax = 0;
        int water = 0;

        while (left < right) {                            // O(n)
            if (height[left] < height[right]) {
                // Left side is limiting
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                // Right side is limiting
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }

        return water;
    }

    public static void main(String[] args) {
        int[] h1 = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(h1)); // 6

        int[] h2 = {4,2,0,3,2,5};
        System.out.println(trap(h2)); // 9
    }
}