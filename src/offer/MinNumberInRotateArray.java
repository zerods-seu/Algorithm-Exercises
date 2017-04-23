package offer;

import java.util.Arrays;

/**
 *  把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
    输入一个非递减（递增）排序的数组的一个旋转，输出旋转数组的最小元素。
    例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
    NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * @author zerods
 * @version 1.0 2017/3/15
 */
public class MinNumberInRotateArray {
    public static int minNumberInRotateArray(int[] array) {
        if (array.length == 0) {
            return 0;
        } else if (array.length == 1) {
            return array[0];
        } else if (array.length == 2) {
            return array[0] < array[1] ? array[0] : array[1];
        }

        int lo = 0;
        int hi = array.length - 1;
        int mid = lo + (hi - lo) / 2;

        int minNum = array[lo];

        if (array[mid] >= array[mid - 1] && array[mid] > array[mid + 1]) {
            // 最大值情况
            return Math.min(minNum, array[mid + 1]);
        } else if (array[mid] < array[mid - 1] && array[mid] <= array[mid + 1]) {
            // 最小值情况
            return Math.min(minNum, array[mid]);
        } else if (array[mid] >= array[mid - 1] && array[mid] <= array[mid + 1]) {
            // 处于递增的情况, 位于非旋转部分情况，即前面
            if (array[mid] > minNum) {
                return minNumberInRotateArray(Arrays.copyOfRange(array, mid + 1, hi + 1));
            } else {
                // 位于旋转部分的情况，即后面, 则最小值位于前半部分
                return minNumberInRotateArray(Arrays.copyOfRange(array, 0, mid));
            }
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] a = {3, 4, 5, 6, 1, 2, 3};
        int[] b = {1, 2, 3, 4, 5, 6};
        int[] c = {1};
        int[] d = {1, 2};
        int[] e = {2, 1};
        int[] f = {2, 2, 3, 4, 5, 6, 2};
        int[] g = {1, 1, 1, 1, 1, 0, 1};

        System.out.println(minNumberInRotateArray(a));
        System.out.println(minNumberInRotateArray(b));
        System.out.println(minNumberInRotateArray(c));
        System.out.println(minNumberInRotateArray(d));
        System.out.println(minNumberInRotateArray(e));
        System.out.println(minNumberInRotateArray(f));
        System.out.println(minNumberInRotateArray(g));
    }
}
