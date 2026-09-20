import java.util.PriorityQueue;

/*
 * Approach: Min-Heap of size k
 * Time Complexity:  O(n log k)  — n inserts, each O(log k)
 * Space Complexity: O(k)        — heap holds at most k elements
 * Sheet: Arrays Row 10 — Kth Largest Element (Amazon)
 *
 * Logic:
 *   - Maintain a MIN-heap of the k largest elements seen so far.
 *   - For each number:
 *       - If heap size < k, push it.
 *       - Else if num > heap.peek() (smallest in heap), pop and push num.
 *   - At the end, heap.peek() is the kth largest element.
 *
 * Why this works:
 *   The heap always holds the k LARGEST elements seen so far.
 *   The smallest among those k is the kth largest overall.
 *
 * Why a MIN-heap (not MAX)?
 *   We need to evict the SMALLEST of the top-k when a bigger number arrives.
 *   A min-heap gives O(1) access to that smallest element.
 */
public class KthLargestMinHeap {

    // Time: O(n log k) | Space: O(k)
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {                        // O(n)
            minHeap.offer(num);                       // O(log k)
            if (minHeap.size() > k) {
                minHeap.poll();                       // remove smallest — O(log k)
            }
        }

        return minHeap.peek();                        // kth largest is the smallest in heap
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        System.out.println(findKthLargest(nums1, 2)); // 5

        int[] nums2 = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        System.out.println(findKthLargest(nums2, 4)); // 4
    }
}