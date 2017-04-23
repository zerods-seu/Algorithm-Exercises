package offer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。
 * 其中负数用补码表示。
 * @author zerods
 * @version 1.0 2017/3/23
 */
public class NumberOf1 {
    public static void main(String[] args) {
        for (int i = -32; i < 32; i++) {
            System.out.printf("the number of 1 of %d is %d\n",  i + 1, numberOf1(i + 1));
        }
    }

    public static int numberOf1(int n) {
        int sum = 0;
        for (int i = 0; i < 32; i++) {
            sum += n & 0x1;
            n = n >> 1;
        }

        return sum;
    }
}
