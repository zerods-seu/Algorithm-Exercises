package offer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。
 * 其中负数用补码表示。
 *
 * 这里考察的是位运算的一些知识，基本思路是：
 * 整数的每一位都与0x1进行&(位与)运算，将结果加到sum，
 * 最后再将该整数向右移一位。
 * @author zerods
 * @version 1.0 2017/3/23
 */
public class NumberOf1 {
    public static void main(String[] args) {
		// 测试
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
