import java.util.Random;

/*
 * Approach: QuickSelect (Randomized)
 * Time Complexity:  O(n) average, O(n^2) worst
 * Space Complexity: O(1)
 * Sheet: Arrays Row 19 — Kth Smallest Element
 *
 * Logic:
 *   - We want the kth smallest. Its target index is (k - 1), 0-indexed.
 *   - Use QuickSort's partition to place a pivot in its correct position.
 *   - If pivot's index == target index, return pivot.
 *   - If pivot's index < target, search RIGHT half.
 *   - If pivot's index > target, search LEFT half.
 *
 * Why randomized pivot?
 *   A sorted input with a fixed pivot (always last) degrades to O(n^2).
 *   Random pivot keeps the average case O(n) regardless of input order.
 */
public class KthSmallestQuickSelect {

    private static final Random rand = new Random();

    // Time: O(n) average | Space: O(1)
    public static int kthSmallest(int[] arr, int k) {
        int targetIndex = k - 1;   // kth smallest → (k-1)th index in sorted order
        int left = 0, right = arr.length - 1;

        while (left <= right) {
            int pivotIndex = randomizedPartition(arr, left, right);

            if (pivotIndex == targetIndex) {
                return arr[pivotIndex];
            } else if (pivotIndex < targetIndex) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }
        return -1;   // unreachable
    }

    private static int randomizedPartition(int[] arr, int left, int right) {
        int randIdx = left + rand.nextInt(right - left + 1);
        swap(arr, randIdx, right);

        int pivot = arr[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[]{10, 5, 4, 3, 48, 6, 2, 33, 53, 10}, 4)); // 5
        System.out.println(kthSmallest(new int[]{7, 10, 4, 3, 20, 15}, 3));                // 7
    }
}