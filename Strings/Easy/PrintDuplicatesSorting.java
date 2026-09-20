import java.util.Arrays;

/*
 * Approach: Sort then Count Consecutive
 * Time Complexity:  O(n log n)  — sort dominates
 * Space Complexity: O(n)        — char array from toCharArray()
 * Sheet: Strings Row 7 — Print all Duplicates in the Input String
 *        (Ola + Amdocs)
 *
 * Logic:
 *   - Convert string to char array and sort.
 *   - Same characters are now adjacent.
 *   - Traverse: count consecutive identical characters.
 *   - Print characters with count > 1.
 *
 * NOTE: The order of output depends on sort order (alphabetical),
 *       NOT first occurrence order. Use the HashMap approach if
 *       first-occurrence order matters.
 */
public class PrintDuplicatesSorting {

    // Time: O(n log n) | Space: O(n)
    public static void printDuplicates(String s) {
        char[] arr = s.toCharArray();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length;) {
            int count = 1;
            while (i + count < arr.length && arr[i] == arr[i + count]) {
                count++;
            }

            if (count > 1) {
                System.out.print("['" + arr[i] + "', " + count + "], ");
            }

            i += count;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        printDuplicates("geeksforgeeks");
        // ['e', 4], ['g', 2], ['k', 2], ['s', 2],

        printDuplicates("programming");
        // ['g', 2], ['m', 2], ['r', 2],

        printDuplicates("mississippi");
        // ['i', 4], ['p', 2], ['s', 4],

        printDuplicates("abc");
        // (no output — no duplicates)
    }
}