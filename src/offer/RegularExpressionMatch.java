package offer;

/**
 * 题目：正则表达式匹配
 * 题目描述：
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，
 * 而'*'表示它前面的字符可以出现任意次（包含0次）。 在本题中，匹配是指字符串的所有
 * 字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 * @author zerods
 * @version 1.0 12/09/2017
 */
public class RegularExpressionMatch {
    public boolean match1(char[] str, char[] pattern) {
        int len = str.length;
        int lenP = pattern.length;
        boolean flag = true;

        int i = 0;
        int j = 0;
        while (i < len && j < lenP) {
            if (str[i] == pattern[j]) {
                i++;
                j++;
            } else {
                if (pattern[j] == '.') {
                    i++;
                    j++;
                } else if (pattern[j] == '*') {
                    if (j > 0) {
                        char c = pattern[j - 1];
                        if (c == str[i - 1]) {
                            i++;
                            j++;
                        } else {
                            while (i < len && (c == str[i] || c == '.')) {
                                i++;
                            }
                            j++;
                        }
                    } else {
                        return false;
                    }
                } else if (j < lenP - 1 && pattern[j + 1] == '*') {
                    j += 2;
                } else {
                    return false;
                }
            }
        }

        if (i < len && j == lenP) {
            return false;
        } else if (i == len && j < lenP) {
            while (j < lenP) {
                if (pattern[j] != '*') {
                    flag = false;
                } else {
                    flag = true;
                }
                j++;
            }
        }
        return flag && true;
    }

    public boolean match(char[] str, char[] pattern) {
        if (str == null || pattern == null) {
            return false;
        }

        return matchHelper(str, 0, pattern, 0);
    }

    private boolean matchHelper(char[] str, int startIndex, char[] pattern, int patternIndex) {
        if (startIndex == str.length && patternIndex == pattern.length) return true;
        if (startIndex < str.length && patternIndex == pattern.length) return false;

        if (patternIndex + 1 < pattern.length && pattern[patternIndex + 1] == '*') {
            if ((startIndex != str.length && pattern[patternIndex] == str[startIndex])
                    || (pattern[patternIndex] == '.' && startIndex != str.length)) {
                return matchHelper(str, startIndex, pattern, patternIndex + 2)            //模式后移2，视为x*匹配0个字符
                        || matchHelper(str, startIndex + 1, pattern, patternIndex + 2)    //视为模式匹配1个字符
                        || matchHelper(str, startIndex + 1, pattern, patternIndex);        //*匹配1个，再匹配str中的下一个
            } else {
                return matchHelper(str, startIndex, pattern, patternIndex + 2);
            }
        }
        if ((startIndex != str.length && pattern[patternIndex] == str[startIndex])
                || (pattern[patternIndex] == '.' && startIndex != str.length)) {
            return matchHelper(str, startIndex + 1, pattern, patternIndex + 1);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(new RegularExpressionMatch().match("aaa".toCharArray(), "a.a".toCharArray()));
        System.out.println(new RegularExpressionMatch().match("aaa".toCharArray(), "ab*ac*a".toCharArray()));
        System.out.println(new RegularExpressionMatch().match("aaa".toCharArray(), "aa.a".toCharArray()));
        System.out.println(new RegularExpressionMatch().match("aaa".toCharArray(), "ab*a".toCharArray()));
        System.out.println(new RegularExpressionMatch().match("cab".toCharArray(), "c*a*b".toCharArray()));
        System.out.println(new RegularExpressionMatch().match("aa".toCharArray(), "a*".toCharArray()));
        System.out.println(new RegularExpressionMatch().match("aaa".toCharArray(), "ab*a*c*a".toCharArray()));

    }
}
