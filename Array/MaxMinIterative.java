import java.util.ArrayList;

public class MaxMinIterative {    // Time: O(n) | Space: O(1)
    public static ArrayList<Integer> findMinMax(int[] arr) {
        int mini = Integer.MAX_VALUE;   // O(1) space
        int maxi = Integer.MIN_VALUE;   // O(1) space


        // Find minimum and maximum
        for (int num : arr) { // O(n) time
            if (num < mini) mini = num; // 1 comparison
            if (num > maxi) maxi = num; // 1 comparison
        }

        ArrayList<Integer> result = new ArrayList<>(); // O(1) space
        result.add(mini);
        result.add(maxi);
        return result;
    }

    // Time: O(n) | Space: O(1)
    public static void main(String[] args) {
        int[] arr = {3, 5, 4, 1, 9};
        ArrayList<Integer> result = findMinMax(arr);
        System.out.println(result.get(0) + " " + result.get(1));
    }
}