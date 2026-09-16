import java.util.Arrays;

/*
 * Approach: Naive (Using a Temporary Array)
 * Time Complexity:  O(n)  — two loops, each O(n)
 * Space Complexity: O(n)  — extra 'temp' array of size n
 *
 * Logic:
 *   1. Create temp[] of same size as arr[]
 *   2. Copy arr[n-1-i] → temp[i] (reverse order)
 *   3. Copy temp[i] back → arr[i]
 */
public class ReverseArrayNaive {

    // Time: O(n) | Space: O(n)
    static void reverseArray(int[] arr) {
        int n = arr.length;

        // Temporary array to store reversed elements — O(n) space
        int[] temp = new int[n];

        // Copy from original to temp in reverse order — O(n) time
        for (int i = 0; i < n; i++)
            temp[i] = arr[n - i - 1];

        // Copy back to original array — O(n) time
        for (int i = 0; i < n; i++)
            arr[i] = temp[i];
    }

    // Time: O(n) | Space: O(n)
    public static void main(String[] args) {
        int[] arr = { 1, 4, 3, 2, 6, 5 };
        reverseArray(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}