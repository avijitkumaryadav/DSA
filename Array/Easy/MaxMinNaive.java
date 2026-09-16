import java.util.ArrayList;
import java.util.Collections;

public class MaxMinNaive {    // Time: O(n log n) | Space: O(n)
    public static ArrayList<Integer> findMinMax(int[] arr) {
        ArrayList<Integer> sortedArr = new ArrayList<>(); // O(n) space
        for (int num : arr) { // O(n) time
            sortedArr.add(num);
        }

        // Sort ArrayList
        Collections.sort(sortedArr); // O(n log n) 

        ArrayList<Integer> result = new ArrayList<>(); // O(1) space
        result.add(sortedArr.get(0));
        result.add(sortedArr.get(sortedArr.size() - 1));

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 9};
        ArrayList<Integer> result = findMinMax(arr);
        System.out.println(result.get(0) + " " + result.get(1));
    }
}