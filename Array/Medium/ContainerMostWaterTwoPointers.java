/*
 * Approach: Two Pointers (Expected / Optimal)
 * Time Complexity:  O(n)  — single pass
 * Space Complexity: O(1)  — only 4 variables
 * Sheet: Arrays Row 17 — Container With Most Water (Flipkart + Dunzo)
 *        The sheet's Remarks column says "use 2 pointer approach".
 *
 * Logic:
 *   - Start with two pointers: left = 0, right = n - 1.
 *   - At each step, compute area = min(h[left], h[right]) × (right - left).
 *   - Update maxArea.
 *   - Move the pointer with the SMALLER height inward.
 *     (Because the smaller height limits the area; moving the taller one
 *      can never increase area — width shrinks while height stays capped.)
 *
 * Why this works (proof sketch):
 *   Suppose h[left] < h[right]. For any pair (left, j) with left < j < right:
 *     - Width (j - left) < (right - left).
 *     - Height is min(h[left], h[j]) ≤ h[left].
 *     - So area ≤ h[left] × (right - left) = current area.
 *   So we can never do better keeping `left` fixed. Move `left` inward.
 */
public class ContainerMostWaterTwoPointers {

    // Time: O(n) | Space: O(1)
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int w = right - left;
            int area = h * w;

            maxArea = Math.max(maxArea, area);

            // Move the pointer with the smaller height inward
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})); // 49
        System.out.println(maxArea(new int[]{1, 1}));                       // 1
    }
}