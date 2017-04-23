package offer;

import java.util.Stack;

/**
 * @author zerods
 * @version 1.0 2017/3/16
 */
public class ReverseWord {
    public static String reverse(String s) {
        if (s.length() == 0) {
            return null;
        }
        StringBuilder rs = new StringBuilder();

        int len = s.length();
        int index = 0;
        Stack<Character> stack = new Stack<>();
        int countOfWord = 0;
        while (index < len - 1) {
            while (index < len && s.charAt(index) != ' ') {
                stack.push(s.charAt(index));
                index++;
            }
            while (!stack.isEmpty()) {
                rs.append(stack.pop());
            }
            if (index != len) {
                rs.append(' ');
                index++;
            }
        }
        return rs.toString();
    }

    public static void main(String[] args) {
        System.out.print(reverse("Hello"));
    }
}
