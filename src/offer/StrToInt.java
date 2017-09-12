package offer;

/**
 * 题目：将字符串转换成整数
 * 描述：
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 * <p>
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 *
 * @author zerods
 * @version 1.0 11/09/2017
 */
public class StrToInt {
    public int StrToInt(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int res = 0;
        int n = str.length();
        int symbol = 1;

        char[] chars = str.toCharArray();
        if (chars[0] == '-') {
            symbol = -1;
        }

        for (int i = (chars[0] == '-' || chars[0] == '+') ? 1 : 0; i < n; i++) {
            if (!(chars[i] >= '0' && chars[i] <= '9')) {
                return 0;
            }

            res = (res << 1) + (res << 3) + (chars[i] - '0');
            if ((symbol == 1 && chars[i] > Integer.MAX_VALUE)
                    || (symbol == -1 && chars[i] < Integer.MIN_VALUE)) {
                return 0;
            }
        }
        return res * symbol;
    }

    public static void main(String[] args) {
        System.out.println(new StrToInt().StrToInt("123"));
    }
}
