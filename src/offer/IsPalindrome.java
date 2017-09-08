package offer;

import org.junit.Test;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * <p>
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 *
 * @author zerods
 * @version 1.0 07/09/2017
 */
public class IsPalindrome {
    public boolean isPalindrome(String s) {
        s = s.toUpperCase();
        int len = s.length();
        int lo = 0;
        int hi = len - 1;

        while (lo < hi) {
            while (lo < len && !isAlphanumeric(s.charAt(lo))) {
                lo++;
            }
            while (hi >= 0 && !isAlphanumeric(s.charAt(hi))) {
                hi--;
            }

            if (lo < len && hi >= 0 && (s.charAt(lo) != s.charAt(hi))) {
                return false;
            } else {
                lo++;
                hi--;
            }
        }

        return true;
    }

    private boolean isAlphanumeric(char c) {
        return ((c > 47 && c < 58) || (c > 64 && c < 91)) ? true : false;
    }


    public String reverseString(String s) {
        StringBuilder sbd = new StringBuilder(s);
        int lo = 0;
        int hi = s.length() - 1;

        while (lo < hi) {
            char tmp = sbd.charAt(lo);
            sbd.setCharAt(lo, sbd.charAt(hi));
            sbd.setCharAt(hi, tmp);
            lo++;
            hi--;
        }

        return sbd.toString();
    }

    @Test
    public void test() {
        // System.out.println(isPalindrome(",."));
        System.out.println(reverseString(""));
    }
}
