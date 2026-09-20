/*
 * Approach: Prefix and Suffix Max Arrays
 * Time Complexity:  O(n)  — three passes
 * Space Complexity: O(n)  — two auxiliary arrays
 * Sheet: Arrays Row 11 — Trapping Rain Water (Samsung)
 *
 * Logic:
 *   Precompute for each index i:
 *     leftMax[i]  = max height from 0..i
 *     rightMax[i] = max height from i..n-1
 *   Then for each i, water += min(leftMax[i], rightMax[i]) - height[i].
 *
 * NOTE: The sheet's Remarks column says "use auxiliary arrays" — this
 * is the approach the sheet is hinting at.
 */
public class TrapRainWaterPrefixArrays {

    // Time: O(n) | Space: O(n)
    public static int trap(int[] height) {
        int n = height.length;
        if (n <= 2) return 0;

        int[] leftMax = new int[n];      // leftMax[i] = max height in [0..i]
        int[] rightMax = new int[n];     // rightMax[i] = max height in [i..n-1]

        leftMax[0] = height[0];
        for (int i = 1; i < n; i++) {                        // O(n)
            leftMax[i] = Math.max(leftMax[i - 1], height[i]);
        }

        rightMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {                   // O(n)
            rightMax[i] = Math.max(rightMax[i + 1], height[i]);
        }

        int water = 0;
        for (int i = 1; i < n - 1; i++) {                    // O(n)
            water += Math.min(leftMax[i], rightMax[i]) - height[i];
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