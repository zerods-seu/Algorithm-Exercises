package offer;

/**
 * 题目：构建乘积数组
 * <p>
 * 描述：给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],
 * 其中B中的元素
 * B[i] = A[0] * A[1] * ... * A[i-1] * A[i+1] *...* A[n-1]。
 * 注意：不能使用除法
 *
 * @author zerods
 * @version 1.0 12/09/2017
 */
public class ConstructMultiplyArray {
    public int[] multiply(int[] A) {
        int len = A.length;
        int[] B = new int[len];
        if (len > 0) {
            B[0] = 1;
            for (int i = 1; i < len; i++) {
                B[i] = B[i - 1] * A[i - 1];
            }
            int tmp = 1;
            for (int j = len - 2; j >= 0; j--) {
                tmp *= A[j + 1];
                B[j] *= tmp;
            }
        }

        return B;
    }
}
