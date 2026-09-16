/*
 * Approach: Expected 1 (Two Pointers)
 * Time Complexity:  O(n)  — single pass, n/2 swaps
 * Space Complexity: O(1)  — only 2 pointer variables + 1 temp
 *
 * Logic:
 *   - left starts at 0, right starts at n-1
 *   - Swap arr[left] and arr[right]
 *   - Move left++ and right-- until left >= right
 */
public class ReverseArrayTwoPointers {

    // Time: O(n) | Space: O(1)
    static void reverseArray(int[] arr) {
        int left = 0, right = arr.length - 1;   // 2 pointers — O(1) space

        // Loop runs n/2 times — O(n) time
        while (left < right) {
            // Swap arr[left] and arr[right] — O(1)
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
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