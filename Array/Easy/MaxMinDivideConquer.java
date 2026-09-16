import java.util.ArrayList;
import java.util.Arrays;

public class MaxMinDivideConquer {    // Time: O(n) | Space: O(log n) — recursion stack
    public static ArrayList<Integer> getMinMax(ArrayList<Integer> arr, int low, int high) {
        ArrayList<Integer> result = new ArrayList<>(Arrays.asList(0, 0));

        // Base case: one element — 0 comparisons
        if (low == high) {
            result.set(0, arr.get(low));
            result.set(1, arr.get(low));
            return result;
        }

        // Base case: two elements — 1 comparison
        if (high == low + 1) {
            if (arr.get(low) < arr.get(high)) {
                result.set(0, arr.get(low));
                result.set(1, arr.get(high));
            } else {
                result.set(0, arr.get(high));
                result.set(1, arr.get(low));
            }
            return result;
        }

        // Recursive case: divide array into two halves — 2 comparisons to combine
        int mid = (low + high) / 2;                                       // O(1)
        ArrayList<Integer> left = getMinMax(arr, low, mid);               // T(n/2)
        ArrayList<Integer> right = getMinMax(arr, mid + 1, high);         // T(n/2)

        // Combine results
        int min = Math.min(left.get(0), right.get(0));       // 1 comparison
        int max = Math.max(left.get(1), right.get(1));       // 1 comparison
        result.set(0, min);
        result.set(1, max);

        return result;
    }

    // Time: O(n) | Space: O(log n)
    public static ArrayList<Integer> findMinMax(ArrayList<Integer> arr) {
        return getMinMax(arr, 0, arr.size() - 1);
    }

    // Time: O(n) | Space: O(log n)
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>(Arrays.asList(3, 5, 4, 1, 9));
        ArrayList<Integer> result = findMinMax(arr);
        System.out.println(result.get(0) + " " + result.get(1));
    }
}