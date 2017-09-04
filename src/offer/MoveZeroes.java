package offer;

import java.util.Arrays;

/**
 * Given an array nums, write a function to move all 0's to the end of it
 * while maintaining the relative order of the non-zero elements.
 * <p>
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function,
 * nums should be [1, 3, 12, 0, 0].
 * <p>
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 * @author zerods
 * @version 1.0 02/09/2017
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if (nums.length <= 1) return;
        int ordered = nums.length - 1;
        int nonZeroIndex = 0;
        int zeroIndex = 0;
        while (ordered >= 0 && nums[ordered] == 0) {
            ordered--;
        }

        while (true) {
            // 找第一个0元素，如果没找到，直接跳出
            while (zeroIndex <= ordered && nums[zeroIndex] != 0) {
                zeroIndex++;
            }
            if (zeroIndex > ordered) break;

            // 否则，找到了0元素，与其后面第一个非零元素交换
            nonZeroIndex = zeroIndex + 1;
            while (nonZeroIndex <= ordered && nums[nonZeroIndex] == 0) {
                nonZeroIndex++;
            }
            if (nonZeroIndex > ordered) break;

            swap(nums, nonZeroIndex, zeroIndex++);
            if (nonZeroIndex == ordered) {
                ordered--;
            }
        }

        System.out.println(Arrays.toString(nums));
    }


    public void moveZeroes1(int[] nums) {
        if (nums.length <= 1) return;
        int nonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex++] = nums[i];
            }
        }
        while (nonZeroIndex < nums.length) {
            nums[nonZeroIndex++] = 0;
        }

        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes2(int[] nums) {
        if (nums.length <= 1) return;
        int nonZeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                if (i != nonZeroIndex)
                    swap(nums, i, nonZeroIndex++);
                else nonZeroIndex++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    /**
     * 没有保持原有数组的顺序，不稳定
     *
     * @param nums
     */
    public void moveZeroesWithOutOrder(int[] nums) {
        int lo = 0, hi = nums.length - 1;
        while (lo < hi) {
            while (nums[lo] != 0) lo++;
            while (nums[hi] == 0) hi--;
            if (lo < hi) swap(nums, lo++, hi--);
        }
        System.out.println(Arrays.toString(nums));
    }

    // 交换数组两个位置的元素
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 0, 3, 2, 0, 1, 0, 12, 7, 0};
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{0, 0};
        new MoveZeroes().moveZeroes1(nums);
    }
}
