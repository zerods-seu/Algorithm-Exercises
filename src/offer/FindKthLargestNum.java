package offer;

import java.util.Arrays;

/**
 * 在一个无序数组里找第K大的数
 * 比如 array = [3, 4, 1, 2]，第一大的数是4，第四大的数是1。
 * @author zerods
 * @version 1.0 27/08/2017
 */
public class FindKthLargestNum {
    public static void main(String[] args) {
//        findKthLargest(array, 2);
//        quickSort(array);
//        System.out.println(Arrays.toString(array));

        for (int i = 1; i <= 9; i++) {
            int[] array = { 3, 4, 1, 2, 9, 8, 6, 5, 7 };
            System.out.println(findKthLargest(array,i));
        }
    }

    public static int findKthLargest(int[] array, int k) {
        k = array.length - k;
        if (k < 0 || k > array.length) {
            return -1;
        }
        int lo = 0;
        int hi = array.length - 1;
        int p = 0;
        while (true) {
            p = partition(array, lo, hi);
            if (p < k) {
                lo = p + 1;
            } else if (p > k) {
                hi = p - 1;
            } else {
                break;
            }
        }
        return array[p];
    }

    public static void quickSort(int[] array) {
        if (array.length > 1)
            quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int lo, int hi) {
        if (lo + 1 >= hi) {
            return;
        }
        int p = partition(array, lo, hi);
        quickSort(array, lo, p - 1);
        quickSort(array, p + 1, hi);
    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[low];
        int i = low, j = high + 1;
        while (i < j) {
            for (i++; i < high && array[i] < pivot; i++) {;}
            for (j--; j > low && array[j] > pivot; j--) {;}
            if (i < j) {
                swap(array, i, j);
            }
        }
        swap(array, low, j);
        return j;
    }

    private static void swap(int[] array, int i, int j) {
        if (array[i] != array[j]) {
            array[i] = array[i] ^ array[j];
            array[j] = array[i] ^ array[j];
            array[i] = array[i] ^ array[j];
        }
    }
}
