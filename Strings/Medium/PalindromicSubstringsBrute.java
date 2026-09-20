/*
 * Approach: Brute Force
 * Time Complexity:  O(n^3)  — O(n^2) substrings, each checked in O(n)
 * Space Complexity: O(1)    — only index variables
 * Sheet: Strings Row 12 — Palindromic Substrings (Microsoft)
 *
 * NOTE: Slow for large inputs. Use only for understanding.
 */
public class PalindromicSubstringsBrute {

    // Time: O(n^3) | Space: O(1)
    public static int countSubstrings(String s) {
        int n = s.length();
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (isPalindrome(s, i, j)) count++;
            }
        }

        return count;
    }

    private static boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(countSubstrings("abc")); // 3
        System.out.println(countSubstrings("aaa")); // 6
        System.out.println(countSubstrings("a"));   // 1
    }
}