package offer;

import org.testng.annotations.Test;

/**
 * Write a function that takes a string as input and reverse only
 * the vowels of a string.
 * <p>
 * Example 1:
 * Given s = "hello", return "holle".
 * <p>
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 * <p>
 * Note:
 * The vowels does not include the letter "y".
 *
 * @author zerods
 * @version 1.0 08/09/2017
 */
public class ReverseVowels {
    private boolean idVowel(char c) {
        return c == 65 || c == 97
                || c == 69 || c == 101
                || c == 73 || c == 105
                || c == 79 || c == 111
                || c == 85 || c == 117;
    }

    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length() - 1;
        StringBuilder sb = new StringBuilder(s);

        while (i < j) {
            while (i < j && !idVowel(sb.charAt(i))) {
                i++;
            }

            while (j > i && !idVowel(sb.charAt(j))) {
                j--;
            }

            if (i < j) {
                char c;
                c = sb.charAt(i);
                sb.setCharAt(i, s.charAt(j));
                sb.setCharAt(j, c);
                i++;
                j--;
            }

        }

        return sb.toString();
    }

    @Test
    public void test() {
        System.out.println(reverseVowels("hello"));
    }

    public static void main(String[] args) {
        System.out.println(new ReverseVowels().reverseVowels("hlll"));
    }
}
