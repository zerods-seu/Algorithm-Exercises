package offer;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数P。并将P对1000000007取模的结果输出。
 * 即输出P%1000000007
 * <p>
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 * 数据范围：
 * 对于%50的数据,size<=10^4
 * 对于%75的数据,size<=10^5
 * 对于%100的数据,size<=2*10^5
 *
 * @author zerods
 * @version 1.0 09/09/2017
 */
public class InversePairs {
    public int InversePairs(int[] array) {
        int[] res = new int[]{0};
        int len = array.length;
        if (len < 2) {
            return 0;
        } else {
            mergeSort(array, 0, len - 1, res);
            return res[0] % 1000000007;
        }
    }

    public void mergeSort(int[] array, int lo, int hi, int[] res) {
        if (lo == hi) return;
        int mid = lo + (hi - lo) / 2;
        mergeSort(array, lo, mid, res);
        mergeSort(array, mid + 1, hi, res);
        merge(array, lo, mid, hi, res);
    }

    private void merge(int[] array, int lo, int mid, int hi, int[] res) {
        int i = lo;
        int j = mid + 1;
        int[] c = new int[hi - lo + 1];
        int k = 0;

        while (i <= mid && j <= hi) {
            int compare = array[i] - array[j];
            if (compare <= 0) {
                c[k++] = array[i++];
            } else {
                c[k++] = array[j++];
                res[0] += (mid - i + 1);
                if (res[0] > 1000000007) {
                    res[0] = res[0] % 1000000007;
                }
            }
        }

        while (i <= mid) {
            c[k++] = array[i++];
        }
        while (j <= hi) {
            c[k++] = array[j++];
        }

        k = 0;
        for (int r = lo; r <= hi; r++) {
            array[r] = c[k++];
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, 2, 3, 4, 9, 5, 6, 7};
        System.out.println(new InversePairs().InversePairs(array));
    }
}
