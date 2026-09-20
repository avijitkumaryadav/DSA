import java.util.ArrayList;
import java.util.Arrays;

/*
 * Approach: Sort + Single Pass (Expected / Optimal)
 * Time Complexity:  O(n log n)  — sort dominates
 * Space Complexity: O(n)        — result list
 * Sheet: Arrays Row 20 — Merge Overlapping Intervals (Google)
 *
 * Logic:
 *   1. Sort intervals by start time.
 *   2. Add the first interval to the result.
 *   3. For each remaining interval:
 *        - If it overlaps with the LAST merged interval (curr.start <= last.end),
 *          extend the end: last.end = max(last.end, curr.end).
 *        - Else, start a new interval (add curr to result).
 *
 * Key insight:
 *   After sorting, overlapping intervals are consecutive.
 *   So we only need to compare each interval with the LAST one in the result.
 */
public class MergeIntervalsOptimal {

    // Time: O(n log n) | Space: O(n)
    public static ArrayList<ArrayList<Integer>> mergeOverlap(int[][] arr) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (arr.length == 0) return res;

        // Step 1: Sort by start time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // Step 2: Add first interval to result
        ArrayList<Integer> first = new ArrayList<>();
        first.add(arr[0][0]);
        first.add(arr[0][1]);
        res.add(first);

        // Step 3: Merge each remaining interval with the last one in result
        for (int i = 1; i < arr.length; i++) {
            ArrayList<Integer> last = res.get(res.size() - 1);
            int[] curr = arr[i];

            if (curr[0] <= last.get(1)) {
                // Overlap → extend the end
                last.set(1, Math.max(last.get(1), curr[1]));
            } else {
                // No overlap → new interval
                ArrayList<Integer> interval = new ArrayList<>();
                interval.add(curr[0]);
                interval.add(curr[1]);
                res.add(interval);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        int[][] arr1 = {{1, 3}, {2, 4}, {6, 8}, {9, 10}};
        printResult(mergeOverlap(arr1));   // [1 4] [6 8] [9 10]

        int[][] arr2 = {{7, 8}, {1, 5}, {2, 4}, {4, 6}};
        printResult(mergeOverlap(arr2));   // [1 6] [7 8]
    }

    static void printResult(ArrayList<ArrayList<Integer>> res) {
        for (ArrayList<Integer> interval : res) {
            System.out.println(interval.get(0) + " " + interval.get(1));
        }
        System.out.println("---");
    }
}