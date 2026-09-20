import java.util.ArrayList;
import java.util.Arrays;

/*
 * Approach: Naive (Check All Possible Overlaps)
 * Time Complexity:  O(n^2)  — sort O(n log n) + nested O(n^2)
 * Space Complexity: O(n)    — result list
 * Sheet: Arrays Row 20 — Merge Overlapping Intervals (Google)
 *
 * Logic:
 *   - Sort intervals by start time.
 *   - For each interval i, scan all remaining intervals j > i.
 *   - If arr[j][0] <= end, extend the end.
 *   - Skip if already merged.
 *
 * NOTE: O(n^2) — works but not optimal. Use the "expected" approach
 *       for larger inputs.
 */
public class MergeIntervalsNaive {

    // Time: O(n^2) | Space: O(n)
    public static ArrayList<ArrayList<Integer>> mergeOverlap(int[][] arr) {
        int n = arr.length;
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int start = arr[i][0];
            int end = arr[i][1];

            // Skip if already covered by last merged interval
            if (!res.isEmpty() && res.get(res.size() - 1).get(1) >= end) {
                continue;
            }

            // Extend end by scanning all remaining intervals
            for (int j = i + 1; j < n; j++) {
                if (arr[j][0] <= end) {
                    end = Math.max(end, arr[j][1]);
                }
            }

            ArrayList<Integer> interval = new ArrayList<>();
            interval.add(start);
            interval.add(end);
            res.add(interval);
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