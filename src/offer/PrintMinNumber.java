package offer;

import java.util.*;

/**
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * @author zerods
 * @version 1.0 29/08/2017
 */
public class PrintMinNumber {

    public String printMinNumber_2(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        String[] strs = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strs[i] = String.valueOf(numbers[i]);
        }
        List<String> list = Arrays.asList(strs);

        Collections.sort(list, (o1, o2) -> (o1 + o2).compareTo(o2 + o1));

        return String.join("", list);
    }

    /**
     * 求所有的排列
     * @param numbers
     * @return
     */
    public String printMinNumber_1(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return "";
        }
        String[] strs = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strs[i] = String.valueOf(numbers[i]);
        }
        return permutation(strs).get(0);
    }

    public ArrayList<String> permutation(String[] strs) {
        ArrayList<String> res = new ArrayList<>();
        permutationHelper(res, 0, strs);
        Collections.sort(res);
        return res;
    }

    private void permutationHelper(ArrayList<String> res, int index, String[] strs) {
        if (index == strs.length - 1) {
            String item = String.join("", Arrays.asList(strs));
            res.add(item);
        }
        for (int i = index; i < strs.length; i++) {
            if (i == index || strs[index] != strs[i]) {
                swap(strs, index, i);
                permutationHelper(res, index + 1, strs);
                swap(strs, index, i);
            }
        }
    }

    public void swap(String[] strs, int i , int j) {
        String tmp = strs[i];
        strs[i] = strs[j];
        strs[j] = tmp;
    }

    public static void main(String[] args) {
//        int[] testArray = new int[] { 3, 32, 321 };
        int[] testArray = new int[] { 3, 2, 1, 0, 0 };
        System.out.println(new PrintMinNumber().printMinNumber_2(testArray));
    }
}
