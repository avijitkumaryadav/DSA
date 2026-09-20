import java.util.ArrayList;
import java.util.List;

/*
 * Approach: Recursion — Include / Exclude each element
 * Time Complexity:  O(2^n)  — binary choice per element
 * Space Complexity: O(r)    — recursion depth
 * Sheet: Arrays Row 25 — Print all Combinations of r Elements (Amazon)
 *
 * Logic:
 *   For each element at index `ind`:
 *     - Include it, then recurse with ind+1.
 *     - Exclude it, then recurse with ind+1.
 *   When the combination size reaches r, add it to result.
 *
 * Note: This generates the same result as the "fix one element" approach
 * but takes longer (O(2^n) vs O(C(n,r)×r)).
 */
public class CombinationsIncludeExclude {

    // Time: O(2^n) | Space: O(r)
    static void combinationUtil(int ind, int r, List<Integer> data,
                                List<List<Integer>> result, int[] arr) {
        if (data.size() == r) {
            result.add(new ArrayList<>(data));
            return;
        }
        if (ind >= arr.length) return;

        // Include arr[ind]
        data.add(arr[ind]);
        combinationUtil(ind + 1, r, data, result, arr);

        // Exclude arr[ind] (backtrack first)
        data.remove(data.size() - 1);
        combinationUtil(ind + 1, r, data, result, arr);
    }

    static List<List<Integer>> findCombination(int[] arr, int r) {
        List<List<Integer>> result = new ArrayList<>();
        combinationUtil(0, r, new ArrayList<>(), result, arr);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        List<List<Integer>> res = findCombination(arr, 2);
        for (List<Integer> comb : res) {
            for (int num : comb) System.out.print(num + " ");
            System.out.println();
        }
        // 1 2
        // 1 3
        // 1 4
        // 2 3
        // 2 4
        // 3 4
    }
}