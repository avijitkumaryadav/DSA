import java.util.ArrayList;
import java.util.List;

/*
 * Approach: Recursion — Fix one element per position
 * Time Complexity:  O(C(n, r) × r)  — C(n,r) combinations, each takes O(r) to build
 * Space Complexity: O(r)            — recursion depth + temp list
 * Sheet: Arrays Row 25 — Print all Combinations of r Elements (Amazon)
 *
 * Logic:
 *   - Fix arr[i] at position 0, recurse to pick the remaining r-1 from i+1..n-1.
 *   - When the combination size reaches r, add it to result.
 *   - Backtrack (remove last element) to try the next choice.
 *
 * This is the standard "combinations" pattern — clean and efficient.
 */
public class CombinationsFixElements {

    // Time: O(C(n,r) × r) | Space: O(r)
    static void combinationUtil(int start, int r, List<Integer> data,
                                List<List<Integer>> result, int[] arr) {
        // Base case: r elements chosen
        if (data.size() == r) {
            result.add(new ArrayList<>(data));
            return;
        }

        int n = arr.length;
        // Try every possible element at the current position
        for (int i = start; i < n; i++) {
            data.add(arr[i]);                             // include arr[i]
            combinationUtil(i + 1, r, data, result, arr); // recurse
            data.remove(data.size() - 1);                 // backtrack
        }
    }

    // Time: O(C(n,r) × r) | Space: O(r)
    static List<List<Integer>> findCombination(int[] arr, int r) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> data = new ArrayList<>();
        combinationUtil(0, r, data, result, arr);
        return result;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        List<List<Integer>> res1 = findCombination(arr1, 2);
        for (List<Integer> comb : res1) {
            for (int num : comb) System.out.print(num + " ");
            System.out.println();
        }
        // 1 2
        // 1 3
        // 1 4
        // 2 3
        // 2 4
        // 3 4

        System.out.println("---");

        int[] arr2 = {1, 2, 3, 4};
        List<List<Integer>> res2 = findCombination(arr2, 3);
        for (List<Integer> comb : res2) {
            for (int num : comb) System.out.print(num + " ");
            System.out.println();
        }
        // 1 2 3
        // 1 2 4
        // 1 3 4
        // 2 3 4
    }
}