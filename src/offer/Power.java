package offer;

/**
 * 计算n次方
 * @author zerods
 * @version 1.0 2017/3/23
 */
public class Power {
    public static double power(double base, int exponent) {
        if (base == 0 || base == 1) {
            return base;
        } else if (exponent == 0) {
            return 1;
        } else if (exponent == 1) {
            return base;
        } else if (exponent < 0) {
            return 1 / power(base, -exponent);
        } else if (exponent % 2 == 0) {
            double sum = power(base, exponent / 2);
            return sum * sum;
        } else {
            return power(base, exponent - 1) * base;
        }
    }

    public static void main(String[] args) {
        for (int i = 5; i < 10; i++) {
            System.out.println("the square of " + i + " is " + power(i, -2));
        }

        for (int i = 5; i < 10; i++) {
            System.out.println("the tube of " + i + " is " + power(i, -3));
        }
    }
}
