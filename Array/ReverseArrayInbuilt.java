import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * Approach: Using Inbuilt Methods
 * Time Complexity:  O(n)  — Collections.reverse() runs in linear time
 * Space Complexity: O(1)  — swaps in-place, no extra array
 *
 * Note: Only works on List<Integer>, NOT on primitive int[].
 */
public class ReverseArrayInbuilt {

    // Time: O(n) | Space: O(1)
    static void reverseArray(List<Integer> arr) {
        Collections.reverse(arr);   // O(n) time, O(1) space
    }

    // Time: O(n) | Space: O(1)
    public static void main(String[] args) {
        List<Integer> arr =
                new ArrayList<>(Arrays.asList(1, 4, 3, 2, 6, 5));

        reverseArray(arr);

        for (int i = 0; i < arr.size(); i++)
            System.out.print(arr.get(i) + " ");
    }
}