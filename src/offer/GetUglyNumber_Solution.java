package offer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 把只包含因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含因子7。
 * 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数
 *
 * @author zerods
 * @version 1.0 29/08/2017
 */
public class GetUglyNumber_Solution {
    /*public int GetUglyNumber_Solution(int index) {
        Map<Integer, Boolean> ib = new HashMap<>();
        int count = 0;
        for (int j = 1; ;j++) {
            if (isUglyNumber(ib, j)) {
                ib.put(j, true);
                count++;
                if (count == index) {
                    return j;
                }
            }
        }
    }

    public boolean isUglyNumber(Map<Integer, Boolean> ib, int n) {
        if (n == 1) return true;
        else if (n < 1) return false;
        else {
            return (n % 2 == 0 && ib.get(n / 2) != null)
                    || (n % 3 == 0 && ib.get(n / 3) != null)
                    || (n % 5 == 0 && ib.get(n / 5) != null);
        }
    }*/

    public int GetUglyNumber_Solution(int index) {
        if (index <= 0) return 0;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);

        int pos2 = 0;
        int pos3 = 0;
        int pos5 = 0;
        while (list.size() < index) {
            int val2 = list.get(pos2) * 2;
            int val3 = list.get(pos3) * 3;
            int val5 = list.get(pos5) * 5;

            int addVal = Math.min(val2, Math.min(val3, val5));
            list.add(addVal);

            if (addVal == val2) pos2++;
            if (addVal == val3) pos3++;
            if (addVal == val5) pos5++;
        }

        System.out.println(list);
        return list.get(list.size() - 1);
    }

    @Test
    public void test_2() {
//        for (int i = 1; i < 100; i++) {
        System.out.println("第" + 10 + "个丑数是" + GetUglyNumber_Solution(10));
//        }
    }
}
