/*
 * Approach: Expected 2 (Single Pointer)
 * Time Complexity:  O(n)  — loop runs n/2 times
 * Space Complexity: O(1)  — only 1 temp variable
 *
 * Logic:
 *   - Loop i from 0 to n/2 - 1
 *   - Swap arr[i] with arr[n - i - 1]
 */
public class ReverseArraySinglePointer {

    // Time: O(n) | Space: O(1)
    static void reverseArray(int[] arr) {
        int n = arr.length;

        // Iterate first half — O(n/2) ≈ O(n) time
        for (int i = 0; i < n / 2; i++) {
            // Swap arr[i] with arr[n - i - 1] — O(1)
            int temp = arr[i];
            arr[i] = arr[n - i - 1];
            arr[n - i - 1] = temp;
        }
    }

    // Time: O(n) | Space: O(1)
    public static void main(String[] args) {
        int[] arr = { 1, 4, 3, 2, 6, 5 };
        reverseArray(arr);
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
    }
}