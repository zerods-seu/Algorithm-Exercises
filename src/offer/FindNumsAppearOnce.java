package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目：
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 * //num1,num2分别为长度为1的数组。传出参数
 * //将num1[0],num2[0]设置为返回结果
 *
 * @author zerods
 * @version 1.0 10/09/2017
 */
public class FindNumsAppearOnce {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        Map<Integer, Integer> map = new HashMap<>();
        boolean first = true;
        for (int i = 0; i < array.length; i++) {
            map.put(array[i], map.get(array[i]) == null ? 1 : 2);
        }
        for (Integer i : map.keySet()) {
            if (map.get(i) == 1) {
                if (first) {
                    num1[0] = i;
                    first = false;
                } else {
                    num2[0] = i;
                    return;
                }
            }
        }
    }

    public void FindNumsAppearOnce2(int[] array, int num1[], int num2[]) {
        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            sum ^= array[i];
        }
        int offset = findPosOfOne(sum);
        int pos = partition(array, offset);
        num1[0] = 0;
        int i = 0;
        while (i < pos) {
            num1[0] ^= array[i++];
        }
        num2[0] = 0;
        while (i < array.length) {
            num2[0] ^= array[i++];
        }
    }

    private int findPosOfOne(int num) {
        int i = 0;
        while ((num & 0x1) == 0) {
            num = num >>> 1;
            i++;
        }

        return i;
    }

    private int partition(int[] array, int offset) {
        int l = -1;
        int r = array.length;

        while (l <= r) {
            while (((array[++l] >>> offset) & 0x1) == 0) {
                if (l > r) break;
            }
            while (((array[--r] >>> offset) & 0x1) == 1) {
                if (r < l) break;
            }

            int tmp = array[l];
            array[l] = array[r];
            array[r] = tmp;
        }

        return l;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 2, 3, 4, 3, 5, 5};
        int[] num1 = new int[1];
        int[] num2 = new int[2];

        new FindNumsAppearOnce().FindNumsAppearOnce2(array, num1, num2);

        System.out.println(num1[0] + " " + num2[0]);
    }
}
