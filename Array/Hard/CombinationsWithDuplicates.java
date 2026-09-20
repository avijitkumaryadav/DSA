import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * Approach: Handle Duplicates (sort + skip)
 * Time Complexity:  O(2^n)  — binary choice per unique branch
 * Space Complexity: O(n)    — recursion depth + sorting
 * Sheet: Arrays Row 25 — Print all Combinations of r Elements (Amazon)
 *
 * Logic:
 *   - Sort the array first so duplicates are adjacent.
 *   - During recursion, skip arr[i] if arr[i] == arr[i-1] at the SAME depth.
 *   - This ensures each unique combination is produced exactly once.
 */
public class CombinationsWithDuplicates {

    // Time: O(2^n) | Space: O(n)
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

        // Exclude arr[ind] — skip all duplicates of arr[ind]
        data.remove(data.size() - 1);
        while (ind + 1 < arr.length && arr[ind] == arr[ind + 1]) {
            ind++;
        }
        combinationUtil(ind + 1, r, data, result, arr);
    }

    static List<List<Integer>> findCombination(int[] arr, int r) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);                    // sort to bring duplicates together
        combinationUtil(0, r, new ArrayList<>(), result, arr);
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2, 3, 4};
        List<List<Integer>> res = findCombination(arr, 2);
        for (List<Integer> comb : res) {
            for (int num : comb) System.out.print(num + " ");
            System.out.println();
        }
        // 1 1
        // 1 2
        // 1 3
        // 1 4
        // 2 3
        // 2 4
        // 3 4
    }
}