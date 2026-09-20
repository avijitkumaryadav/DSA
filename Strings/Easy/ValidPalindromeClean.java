/*
 * Approach: Clean string, then compare with reverse
 * Time Complexity:  O(n)  — build clean string O(n) + reverse O(n) + compare O(n)
 * Space Complexity: O(n)  — cleaned string + reversed string
 * Sheet: Strings Row 1 — Valid Palindrome
 *        (Amazon + Cisco + D-E-Shaw + Facebook + FactSet + Morgan Stanley + Paytm + Zoho)
 *
 * Logic:
 *   1. Build a "clean" string: lowercase only, alphanumeric only.
 *   2. Compare clean with reverse(clean).
 *   3. Return true if they match.
 *
 * NOTE: Uses extra space. The two-pointer approach is more space-efficient.
 */
public class ValidPalindromeClean {

    // Time: O(n) | Space: O(n)
    public static boolean isPalindrome(String s) {
        StringBuilder clean = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetterOrDigit(c)) {
                clean.append(Character.toLowerCase(c));
            }
        }

        String cleaned = clean.toString();
        String reversed = clean.reverse().toString();

        return cleaned.equals(reversed);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome("race a car"));                     // false
        System.out.println(isPalindrome(" "));                              // true
        System.out.println(isPalindrome("0P"));                             // false
    }
}