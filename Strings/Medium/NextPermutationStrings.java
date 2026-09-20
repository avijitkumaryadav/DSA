import java.util.Arrays;

/*
 * Approach: In-place single pass (same as Array Row 7)
 * Time: O(n) | Space: O(1)
 * Sheet: Strings Row 13 — Next Permutation (GFG)
 *        (Infosys + Flipkart + Amazon + Microsoft + FactSet + Hike
 *         + MakeMyTrip + Google + Qualcomm + Salesforce)
 *
 * Note: This is the SAME problem as Array Row 7. Kept here for completeness
 *       because the sheet lists it under Strings too.
 */
public class NextPermutationStrings {

    // Time: O(n) | Space: O(1)
    public static void nextPermutation(int[] arr) {
        int n = arr.length;

        // Step 1: Find pivot
        int i = n - 2;
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        // Step 2 & 3: Swap pivot with successor
        if (i >= 0) {
            int j = n - 1;
            while (arr[j] <= arr[i]) {
                j--;
            }
            swap(arr, i, j);
        }

        // Step 4: Reverse suffix
        reverse(arr, i + 1, n - 1);
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void reverse(int[] arr, int left, int right) {
        while (left < right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {2, 4, 1, 7, 5, 0};
        nextPermutation(arr1);
        System.out.println(Arrays.toString(arr1));   // [2, 4, 5, 0, 1, 7]

        int[] arr2 = {3, 2, 1};
        nextPermutation(arr2);
        System.out.println(Arrays.toString(arr2));   // [1, 2, 3]

        int[] arr3 = {3, 4, 2, 5, 1};
        nextPermutation(arr3);
        System.out.println(Arrays.toString(arr3));   // [3, 4, 5, 1, 2]
    }
}