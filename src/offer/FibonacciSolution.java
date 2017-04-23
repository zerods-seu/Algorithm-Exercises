package offer;

import sun.applet.Main;

/**
 * @author zerods
 * @version 1.0 2017/3/22
 */
public class FibonacciSolution {
//    public static int Fibonacci(int n) {
//        if (n == 0) {
//            return 0;
//        } else if (n == 1 || n == 2) {
//            return 1;
//        } else {
//            return Fibonacci(n - 1) + Fibonacci(n - 2);
//        }
//    }

    public static int Fibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1 || n == 2) {
            return 1;
        } else {
            int one = 1;
            int two = 1;
            while (n-- > 2) {
                int sum = one + two;
                one = two;
                two = sum;
            }
            return two;
        }
    }

    public static void main(String[] args) {
        System.out.print(Fibonacci(1) + " ");
        System.out.print(Fibonacci(2) + " ");
        System.out.print(Fibonacci(3) + " ");
        System.out.print(Fibonacci(4) + " ");
        System.out.print(Fibonacci(5) + " ");
        System.out.print(Fibonacci(6) + " ");
        System.out.print(Fibonacci(7) + " ");
    }
}
