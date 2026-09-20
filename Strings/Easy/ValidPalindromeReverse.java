/*
 * Approach: Reverse and Compare (one-liner style)
 * Time Complexity:  O(n)  — build clean, reverse, compare
 * Space Complexity: O(n)  — clean string + reversed string
 * Sheet: Strings Row 1 — Valid Palindrome
 *
 * Logic:
 *   Build clean string, then compare clean with its reverse using
 *   StringBuilder.reverse() in a single line.
 *
 * NOTE: Uses more space than the two-pointer approach. Include this
 *       as an alternative "clean code" answer.
 */
public class ValidPalindromeReverse {

    // Time: O(n) | Space: O(n)
    public static boolean isPalindrome(String s) {
        StringBuilder clean = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                clean.append(Character.toLowerCase(c));
            }
        }

        return clean.toString().equals(clean.reverse().toString());
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome("race a car"));                     // false
        System.out.println(isPalindrome(" "));                              // true
    }
}