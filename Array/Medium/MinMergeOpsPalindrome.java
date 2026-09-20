/*
 * Approach: Two Pointers (Optimal)
 * Time Complexity:  O(n)  — single pass from both ends
 * Space Complexity: O(1)  — only index variables + counter
 * Sheet: Arrays Row 21 — Find Minimum Number of Merge Operations to Make
 *        an Array Palindrome (Amazon)
 *
 * Logic:
 *   Maintain two pointers: i = 0 (left), j = n-1 (right).
 *   At each step, compare arr[i] and arr[j]:
 *
 *     - If arr[i] == arr[j]   → they match. Move both pointers inward.
 *     - If arr[i] >  arr[j]   → left is bigger.
 *                               Merge arr[j-1] and arr[j]:
 *                                 arr[j-1] += arr[j]; j--; ans++
 *     - If arr[i] <  arr[j]   → right is bigger.
 *                               Merge arr[i] and arr[i+1]:
 *                                 arr[i+1] += arr[i]; i++; ans++
 *
 *   Loop until i >= j.
 *
 * Key Insight:
 *   Think of this like checking if a string is a palindrome, but with a
 *   twist: when the two ends don't match, we merge the SMALLER side into
 *   its neighbor (the only way to eventually make the ends equal without
 *   extra passes).
 *
 * NOTE: This mutates the input array. If you must preserve it, clone first.
 */
public class MinMergeOpsPalindrome {

    // Time: O(n) | Space: O(1)
    public static int findMinOps(int[] arr) {
        int n = arr.length;
        int i = 0, j = n - 1;
        int ans = 0;

        while (i < j) {
            if (arr[i] == arr[j]) {
                // Match → shrink from both ends
                i++;
                j--;
            } else if (arr[i] > arr[j]) {
                // Right side too small → merge right pair
                j--;
                arr[j] += arr[j + 1];
                ans++;
            } else {
                // Left side too small → merge left pair
                i++;
                arr[i] += arr[i - 1];
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(findMinOps(new int[]{15, 4, 15}));         // 0 (already palindrome)
        System.out.println(findMinOps(new int[]{1, 4, 5, 1}));        // 1
        System.out.println(findMinOps(new int[]{11, 14, 15, 99}));    // 3
        System.out.println(findMinOps(new int[]{1, 4, 5, 9, 1}));     // 1
    }
}