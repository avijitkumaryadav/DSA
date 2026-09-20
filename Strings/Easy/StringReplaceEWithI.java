import java.util.Scanner;

/*
 * Task: Replace every 'e' with 'i' in the input string.
 * Time: O(n) — single pass
 * Space: O(n) — result string
 * Sheet: Strings section — Prep (foundation)
 */
public class StringReplaceEWithI {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.next();

        String result = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == 'e') {
                result += 'i';
            } else {
                result += str.charAt(i);
            }
        }

        System.out.println("Result: " + result);

        sc.close();
    }
}