import java.util.Arrays;

/*
 * Approach: Sort then index
 * Time Complexity:  O(n log n)  — Arrays.sort() dominates
 * Space Complexity: O(1)        — in-place (ignoring sort's internal stack)
 * Sheet: Arrays Row 19 — Kth Smallest Element
 *        (ABCO + Accolite + Amazon + Cisco + Hike + Microsoft + Snapdeal + VMWare + Google + Adobe)
 *
 * Logic:
 *   - Sort the array in ascending order.
 *   - The kth smallest element is at index (k - 1) in sorted order.
 */
public class KthSmallestSorting {

    // Time: O(n log n) | Space: O(1)
    public static int kthSmallest(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[k - 1];   // kth smallest is at index k-1
    }

    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[]{10, 5, 4, 3, 48, 6, 2, 33, 53, 10}, 4)); // 5
        System.out.println(kthSmallest(new int[]{7, 10, 4, 3, 20, 15}, 3));                // 7
    }
}