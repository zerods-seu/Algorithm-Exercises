package offer;

import java.util.ArrayList;

/**
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。
 * 现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 *
 * @author zerods
 * @version 1.0 11/09/2017
 */
public class FindContinuousSequence {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int hi = 2;
        int lo = 1;

        // 考虑到前面的数比较小，边界情况要考虑清楚
        while (lo > 0 && hi <= sum / 2 + 1) {
            int curSum = (lo + hi) * (hi - lo + 1) / 2;
            ArrayList<Integer> list = new ArrayList<>();
            if (curSum == sum) {
                addToList(lo, hi, list);
                res.add(list);
                lo++;
                hi++;
            } else if (curSum < sum) {
                hi++;
            } else {
                lo++;
            }
        }

        return res;
    }

    private void addToList(int lo, int hi, ArrayList<Integer> list) {
        for (int i = lo; i <= hi; i++) {
            list.add(i);
        }
    }


    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> res = new FindContinuousSequence().FindContinuousSequence(15);
        for (ArrayList a : res) {
            System.out.println(a);
        }
    }
}
