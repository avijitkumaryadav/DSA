import java.util.Random;

/*
 * Approach: QuickSelect (Randomized)
 * Time Complexity:  O(n) average, O(n^2) worst  — like QuickSort but only one side
 * Space Complexity: O(1)  — iterative or tail-recursive
 * Sheet: Arrays Row 10 — Kth Largest Element (Amazon)
 *
 * Logic:
 *   - We want the kth largest. Equivalent to (n-k)th smallest (0-indexed).
 *   - Use QuickSort's partition to place a pivot in its correct position.
 *   - If pivot's index == target index, return pivot.
 *   - If pivot's index < target, search RIGHT half.
 *   - If pivot's index > target, search LEFT half.
 *
 * Why average O(n)?
 *   Each partition halves the search space, so:
 *   n + n/2 + n/4 + ... = 2n = O(n).
 *
 * Why randomized pivot?
 *   A sorted input with a fixed pivot (always last) degrades to O(n^2).
 *   Random pivot keeps the average case O(n) regardless of input order.
 */
public class KthLargestQuickSelect {

    private static final Random rand = new Random();

    // Time: O(n) average | Space: O(1)
    public static int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int targetIndex = n - k;   // kth largest = (n-k)th smallest, 0-indexed

        int left = 0, right = n - 1;
        while (left <= right) {
            int pivotIndex = randomizedPartition(nums, left, right);

            if (pivotIndex == targetIndex) {
                return nums[pivotIndex];
            } else if (pivotIndex < targetIndex) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
        return -1;   // unreachable if input is valid
    }

    // Partition the array around a random pivot (Lomuto partition scheme)
    private static int randomizedPartition(int[] nums, int left, int right) {
        // Pick a random index and swap with the right end
        int randIdx = left + rand.nextInt(right - left + 1);
        swap(nums, randIdx, right);

        int pivot = nums[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums1, 2)); // 5

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(nums2, 4)); // 4
    }
}