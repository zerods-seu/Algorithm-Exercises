package offer;

import org.junit.Test;

import java.util.Arrays;

/**
 * Find the kth largest element in an unsorted array.
 * Note that it is the kth largest element in the sorted order,
 * not the kth distinct element.
 * <p>
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * <p>
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 *
 * @author zerods
 * @version 1.0 05/09/2017
 */
public class FindKthLargest {
    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, nums.length - k, 0, nums.length - 1);
    }

    private int findKthLargest(int[] nums, int k, int lo, int hi) {
        if (lo == hi) return nums[lo];
        int pos = partition(nums, lo, hi);
        if (k == pos) return nums[pos];
        else if (k < pos) return findKthLargest(nums, k, lo, pos - 1);
        else {
            return findKthLargest(nums, k, pos + 1, hi);
        }
    }

    private int partition(int[] nums, int lo, int hi) {
        if (lo == hi) return lo;
        int i = lo;
        int j = hi + 1;
        int cursor = nums[lo];
        while (true) {
            // find item on lo to swap
            while (nums[++i] < cursor) {
                if (i == hi) break;
            }
            // find item on hi to swap
            while (nums[--j] > cursor) {
                if (j == lo) break;
            }
            if (i >= j) {
                break;
            }
            swap(nums, i, j);
        }
        // put partitioning item v at a[j]
        swap(nums, lo, j);

        // now, a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    @Test
    public void test() {
        int[] nums = new int[]{1};
        System.out.println(partition(nums, 0, nums.length - 1));
        System.out.println(Arrays.toString(nums));
//        for (int i = 1; i <= nums.length; i++) {
//            System.out.println(findKthLargest(nums, i));
//        }
    }
}
