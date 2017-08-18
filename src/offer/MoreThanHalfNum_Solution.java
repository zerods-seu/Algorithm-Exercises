package offer;


import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度
 * 为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一
 * 半，因此输出2。如果不存在则输出0。
 * @author zerods
 * @version 1.0 18/08/2017
 */
public class MoreThanHalfNum_Solution {
    public int moreThanHalfNum_Solution(int [] array) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : array) {
            if (map.get(a) == null) {
                map.put(a, 1);
            } else {
                map.put(a, map.get(a) + 1);
            }
        }
        int frequent_key = 0;
        Integer key_num = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int compare = entry.getValue().compareTo(key_num);
            if (compare > 0) {
                frequent_key = entry.getKey();
                key_num = entry.getValue();
            }
        }
        return key_num * 2 > array.length ? frequent_key : 0;

    }

    public static void main(String[] args) {
        System.out.println(new MoreThanHalfNum_Solution().moreThanHalfNum_Solution(new int[] {1,2,3,2,2,2,5,4,2}));
    }
}
