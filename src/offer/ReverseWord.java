package offer;

import java.util.Stack;

/**
 * 题目：单词翻转。输入一个英文句子，翻转句子中单词的顺序
 * 但单词内字符的顺序不变，句子中单词以空格符隔开。为简单起见，
 * 标点符号和普通字母一样处理。例如，输入“I am a student.”，
 * 则输出“student. a am I”。
 *
 * 基本思路：遇到非空格符的word压入栈，反转，空格符直接添加到
 * StringBuider中
 * @author zerods
 * @version 1.0 2017/3/16
 */
public class ReverseWord {
    public static String reverse(String s) {
        if (s.length() <= 1 || s.trim().equals("")) {
            return s;
        }
        StringBuilder rs = new StringBuilder();

        int len = s.length();
        int index = 0;
        Stack<Character> stack = new Stack<>();
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
        System.out.println(reverse("xixi, ,  Hello, my love."));
    }
}

