import java.util.Scanner;

/*
 * Task: Find cumulative (combined) length of all input strings.
 * Time: O(n × L) where L is average string length
 * Space: O(n)
 * Sheet: Strings section — Prep (foundation)
 */
public class StringCumulativeLength {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of strings: ");
        int size = sc.nextInt();

        String[] array = new String[size];
        int totalLength = 0;

        System.out.println("Enter " + size + " strings:");
        for (int i = 0; i < size; i++) {
            array[i] = sc.next();
            totalLength += array[i].length();   // O(1) per string
        }

        System.out.println("Combined length: " + totalLength);

        sc.close();
    }
}