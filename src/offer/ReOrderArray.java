package offer;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于位于数
 * 组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位
 * 置不变。
 * @author zerods
 * @version 1.0 2017/3/25
 */
public class ReOrderArray {
    public static void reOrderArray(int [] array) {
//        int lo = 0;
//        int hi = array.length - 1;
//
//        while (lo < hi) {
//            while (array[lo] % 2 == 1) {
//                lo++;
//            }
//            while (array[hi] % 2 == 0) {
//                hi--;
//            }
//            if (lo < hi) {
//                array[lo] = array[lo] ^ array[hi];
//                array[hi] = array[lo] ^ array[hi];
//                array[lo] = array[lo] ^ array[hi];
//                lo++;
//                hi--;
//            }
//        }

//        int oddIndex = 0;
//        int evenIndex = 0;
//
//        while (oddIndex < array.length && evenIndex < array.length ) {
//            while (oddIndex < array.length && array[oddIndex] % 2 == 1) {
//                oddIndex++;
//            }
//            while (evenIndex < array.length && array[evenIndex] % 2 == 0) {
//                evenIndex++;
//            }
//            array[oddIndex] = array[oddIndex] ^ array[evenIndex];
//            array[evenIndex] = array[oddIndex] ^ array[evenIndex];
//            array[oddIndex] = array[oddIndex] ^ array[evenIndex];
//            oddIndex++;
//            evenIndex++;
//        }
//
        int oddIndex = 0;
        int evenIndex = array.length - 1;
        int i = 0;
        int j = array.length - 1;
        int[] arrCopy = new int[array.length];

        while (oddIndex < array.length) {
            if (array[oddIndex] % 2 == 1) {
                arrCopy[i++] = array[oddIndex];
            }
            oddIndex++;
        }


        while (evenIndex >= 0) {
            if (array[evenIndex] % 2 == 0) {
                arrCopy[j--] = array[evenIndex];
            }
            evenIndex--;
        }

        for (int k = 0; k < array.length; k++) {
            array[k] = arrCopy[k];
        }

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        reOrderArray(arr);
        System.out.println(Arrays.toString(arr));
    }
}
