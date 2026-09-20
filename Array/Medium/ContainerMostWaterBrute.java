/*
 * Approach: Brute Force (Try every pair of lines)
 * Time Complexity:  O(n^2)  — nested loops over all pairs (i, j) with i < j
 * Space Complexity: O(1)    — only tracking variables
 * Sheet: Arrays Row 17 — Container With Most Water (Flipkart + Dunzo)
 *
 * Logic:
 *   For every pair (i, j) with i < j:
 *     area = min(height[i], height[j]) × (j - i)
 *   Track the maximum area.
 *
 * NOTE: TLE on LeetCode for n = 10^5.
 */
public class ContainerMostWaterBrute {

    // Time: O(n^2) | Space: O(1)
    public static int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int h = Math.min(height[i], height[j]);
                int w = j - i;
                int area = h * w;
                maxArea = Math.max(maxArea, area);
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
        System.out.println(maxArea(new int[]{1, 1}));                       // 1
    }
}