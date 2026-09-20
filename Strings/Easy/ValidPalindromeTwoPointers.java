/*
 * Approach: Two Pointers (Expected / Optimal)
 * Time Complexity:  O(n)  — single pass
 * Space Complexity: O(1)  — no extra space
 * Sheet: Strings Row 1 — Valid Palindrome
 *        (Amazon + Cisco + D-E-Shaw + Facebook + FactSet + Morgan Stanley + Paytm + Zoho)
 *
 * Logic:
 *   - left pointer at 0, right pointer at n-1.
 *   - Skip non-alphanumeric characters on both sides.
 *   - Compare lowercase characters at left and right.
 *   - If they differ → return false.
 *   - If pointers meet/cross → return true.
 *
 * Key Insight:
 *   In-place comparison without extra string.
 *   Uses Character.isLetterOrDigit() and Character.toLowerCase().
 */
public class ValidPalindromeTwoPointers {

    // Time: O(n) | Space: O(1)
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;

        while (left < right) {
            // Skip non-alphanumeric on the left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }
            // Skip non-alphanumeric on the right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare lowercase characters
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome("A man, a plan, a canal: Panama")); // true
        System.out.println(isPalindrome("race a car"));                     // false
        System.out.println(isPalindrome(" "));                              // true
        System.out.println(isPalindrome("0P"));                             // false
    }
}