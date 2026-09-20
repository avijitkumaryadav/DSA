import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
 * Approach: Mo's Algorithm (Square Root Decomposition)
 * Time Complexity:  O((n + m) × √n)  — sort O(m log m) + process O((n+m)×√n)
 * Space Complexity: O(n + m)        — array + queries
 * Sheet: Arrays Row 26 — Mo's Algorithm (Microsoft)
 *
 * Logic:
 *   1. Divide the array into blocks of size √n.
 *   2. Sort queries:
 *        - Primary: block of L (L / √n)
 *        - Secondary: R value (ascending)
 *   3. Process queries one by one, moving currL and currR incrementally:
 *        - Add elements when expanding the window.
 *        - Remove elements when shrinking the window.
 *   4. This amortizes to O((n+m) × √n) total movement.
 *
 * Note: Only works for OFFLINE queries (all queries known upfront).
 *
 * The example below computes the sum of each query range [L, R].
 */
public class MosAlgorithm {

    static class Query {
        int L, R, idx;
        Query(int L, int R, int idx) {
            this.L = L;
            this.R = R;
            this.idx = idx;    // original index for output ordering
        }
    }

    // Time: O((n + m) × √n) | Space: O(n + m)
    public static int[] queryResults(int[] arr, List<Query> queries) {
        int n = arr.length;
        int m = queries.size();
        int block = (int) Math.sqrt(n);

        // Sort queries: by block of L, then by R
        Collections.sort(queries, new Comparator<Query>() {
            @Override
            public int compare(Query x, Query y) {
                int blockX = x.L / block;
                int blockY = y.L / block;
                if (blockX != blockY) return Integer.compare(blockX, blockY);
                return Integer.compare(x.R, y.R);
            }
        });

        int[] answers = new int[m];
        int currL = 0, currR = -1;    // current window is empty
        int currSum = 0;

        for (Query q : queries) {
            int L = q.L, R = q.R;

            // Expand left
            while (currL > L) {
                currL--;
                currSum += arr[currL];
            }
            // Expand right
            while (currR < R) {
                currR++;
                currSum += arr[currR];
            }
            // Shrink left
            while (currL < L) {
                currSum -= arr[currL];
                currL++;
            }
            // Shrink right
            while (currR > R) {
                currSum -= arr[currR];
                currR--;
            }

            answers[q.idx] = currSum;
        }

        return answers;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 1, 3, 4, 5, 2, 8};

        // Create queries with their original index
        List<Query> queries = new ArrayList<>();
        queries.add(new Query(0, 4, 0));
        queries.add(new Query(1, 3, 1));
        queries.add(new Query(2, 4, 2));

        int[] answers = queryResults(arr, queries);

        // Print in original query order
        System.out.println("Query [0, 4] sum = " + answers[0]);   // 8
        System.out.println("Query [1, 3] sum = " + answers[1]);   // 4
        System.out.println("Query [2, 4] sum = " + answers[2]);   // 6
    }
}