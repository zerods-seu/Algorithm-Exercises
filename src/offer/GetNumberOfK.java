package offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * @author zerods
 * @version 1.0 09/09/2017
 */
public class GetNumberOfK {
    /*public int GetNumberOfK(int [] array , int k) {
        int index = findIndexOfK(array, 0, array.length - 1, k);
        if (index == -1) return 0;
        int lo = index;
        int hi = index;
        while (lo > 0 && array[lo - 1] == k) {
            lo--;
        }
        while (hi < array.length - 1 && array[hi + 1] == k) {
            hi++;
        }

        return hi - lo + 1;
    }

    */

    public int GetNumberOfK(int[] array, int k) {
        int index = findIndexOfK(array, 0, array.length - 1, k);
        if (index == -1) return 0;
        int start = findFirstNumberOfK(array, 0, index - 1, k);
        start = (start == -1 ? index : start);
        int end = findLastNumberOfK(array, index + 1, array.length - 1, k);
        end = (end == -1 ? index : end);
        return end - start + 1;
    }

    private int findFirstNumberOfK(int[] array, int lo, int hi, int k) {
        int index = findIndexOfK(array, lo, hi, k);
        if (index > lo) {
            if (array[index - 1] != k) {
                return index;
            } else {
                return findFirstNumberOfK(array, lo, index - 1, k);
            }
        } else if (index == lo) {
            return lo;
        } else {
            return -1;
        }
    }

    private int findLastNumberOfK(int[] array, int lo, int hi, int k) {
        int index = findIndexOfK(array, lo, hi, k);
        if (index < hi) {
            if (array[index + 1] != k) {
                return index;
            } else {
                return findLastNumberOfK(array, index + 1, hi, k);
            }
        } else if (index == hi) {
            return hi;
        } else {
            return -1;
        }
    }

    private int findIndexOfK(int[] array, int lo, int hi, int k) {
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (array[mid] == k) {
                return mid;
            } else if (array[mid] > k) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 3, 3, 3, 4, 5};
        System.out.println(new GetNumberOfK().GetNumberOfK(array, 3));
        Math.abs(0);
    }
}
