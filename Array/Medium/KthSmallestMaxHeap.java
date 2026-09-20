import java.util.Collections;
import java.util.PriorityQueue;

/*
 * Approach: Max-Heap of size k
 * Time Complexity:  O(n log k)  — n inserts, each O(log k)
 * Space Complexity: O(k)        — heap holds at most k elements
 * Sheet: Arrays Row 19 — Kth Smallest Element
 *
 * Logic:
 *   - Maintain a MAX-heap of the k SMALLEST elements seen so far.
 *   - For each number:
 *       - If heap size < k, push it.
 *       - Else if num < heap.peek() (largest in heap), pop and push num.
 *   - At the end, heap.peek() is the kth smallest element.
 *
 * Why this works:
 *   The heap always holds the k SMALLEST elements seen so far.
 *   The largest among those k is the kth smallest overall.
 *
 * Why a MAX-heap (not MIN)?
 *   We need to evict the LARGEST of the bottom-k when a smaller number arrives.
 *   A max-heap gives O(1) access to that largest element.
 */
public class KthSmallestMaxHeap {

    // Time: O(n log k) | Space: O(k)
    public static int kthSmallest(int[] arr, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : arr) {                        // O(n)
            maxHeap.offer(num);                      // O(log k)
            if (maxHeap.size() > k) {
                maxHeap.poll();                      // remove largest — O(log k)
            }
        }

        return maxHeap.peek();                       // kth smallest is the largest in heap
    }

    public static void main(String[] args) {
        System.out.println(kthSmallest(new int[]{10, 5, 4, 3, 48, 6, 2, 33, 53, 10}, 4)); // 5
        System.out.println(kthSmallest(new int[]{7, 10, 4, 3, 20, 15}, 3));                // 7
    }
}