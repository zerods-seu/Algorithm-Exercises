package offer;

import java.util.ArrayList;

/**
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * <p>
 * 对应每个测试案例，输出两个数，小的先输出。
 *
 * @author zerods
 * @version 1.0 11/09/2017
 */
public class FindNumbersWithSum {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int resLo = -1;
        int resHi = -1;
        int curSum = 0;
        int len = array.length;
        int lo = 0;
        int hi = len - 1;

        while (lo < hi) {
            curSum = array[lo] + array[hi];
            if (curSum == sum) {
                res.add(array[lo]);
                res.add(array[hi]);
                return res;
            } else if (curSum < sum) {
                lo++;
            } else {
                hi--;
            }
        }

        return res;
    }
}
