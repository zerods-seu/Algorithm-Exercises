package offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 题目描述：输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串
 * abc,acb,bac,bca,cab和cba。
 *
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母
 * @author zerods
 * @version 1.0 16/08/2017
 */

public class StringPermutation {
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str == null || str.length() == 0) {
            return res;
        }
        char[] chars = str.toCharArray();

        permutationHelper(res, 0, chars);
        Collections.sort(res);
        System.out.println(Arrays.toString(chars));
        return res;
    }

    private void permutationHelper(ArrayList<String> res, int index, char[] chars) {
         if (index == chars.length - 1) {
             res.add(new String(chars));
         }
         for (int i = index; i < chars.length; i++) {
             if (i == index || chars[index] != chars[i]) {
                 swap(chars, index, i);
                 permutationHelper(res, index + 1, chars);
                 swap(chars, index, i);
             }
         }
    }

    public void swap(char[] chars, int i , int j) {
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
    }

    public static void main(String[] args) {
        StringPermutation sp = new StringPermutation();
        ArrayList<String> res = sp.Permutation("adbc");
        System.out.println(res);
    }
}
