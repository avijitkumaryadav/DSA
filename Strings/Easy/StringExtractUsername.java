import java.util.Scanner;

/*
 * Task: Extract username from email (everything before '@').
 * Time: O(n) — single pass, stops at '@'
 * Space: O(k) — k = length of username
 * Sheet: Strings section — Prep (foundation)
 */
public class StringExtractUsername {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter email: ");
        String email = sc.next();

        String userName = "";
        for (int i = 0; i < email.length(); i++) {
            if (email.charAt(i) == '@') {
                break;   // stop at '@'
            } else {
                userName += email.charAt(i);
            }
        }

        System.out.println("Username: " + userName);

        sc.close();
    }
}