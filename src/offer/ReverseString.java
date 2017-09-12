package offer;

/**
 * @author zerods
 * @version 1.0 11/09/2017
 */
public class ReverseString {
    public String ReverseSentence(String str) {
        int len = str.length();
        if (len <= 1) {
            return str;
        }

        int start = 0, end = 0;
        StringBuilder sb = new StringBuilder();
        while (start < len) {
            while (start < len && str.charAt(start) == ' ') {
                sb.append(' ');
                start++;
                end++;
            }
            while (end < len && str.charAt(end) != ' ') {
                end++;
            }
            if (start < end)
                sb.append(reverseString(str.substring(start, end)));
            start = end;
        }

        return reverseString(sb.toString());
    }

    private String reverseString(String str) {
        if (str.length() <= 1) return str;

        char[] chars = str.toCharArray();
        int lo = 0, hi = chars.length - 1;
        while (lo < hi) {
            char tmp = chars[lo];
            chars[lo++] = chars[hi];
            chars[hi--] = tmp;
        }

        return new String(chars);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseString().ReverseSentence("  I am a student! "));
    }
}
