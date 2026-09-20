/*
 * Approach: Brute Force
 * Time Complexity:  O(n^2)  — for each bar, scan left and right
 * Space Complexity: O(1)    — no extra space
 * Sheet: Arrays Row 11 — Trapping Rain Water (Samsung)
 *
 * Logic:
 *   For each bar i:
 *     - Find max height to the LEFT (leftMax)
 *     - Find max height to the RIGHT (rightMax)
 *     - Water above bar i = min(leftMax, rightMax) - height[i]
 *     - (if negative, 0 — the bar is above the water level)
 *
 * NOTE: TLE on LeetCode for n = 2 × 10^4.
 */
public class TrapRainWaterBrute {

    // Time: O(n^2) | Space: O(1)
    public static int trap(int[] height) {
        int n = height.length;
        int water = 0;

        for (int i = 1; i < n - 1; i++) {                // O(n)
            int leftMax = 0, rightMax = 0;

            for (int j = 0; j <= i; j++) {                // O(n)
                leftMax = Math.max(leftMax, height[j]);
            }
            for (int j = i; j < n; j++) {                 // O(n)
                rightMax = Math.max(rightMax, height[j]);
            }

            water += Math.min(leftMax, rightMax) - height[i];
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