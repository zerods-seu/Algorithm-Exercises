package offer;

import org.junit.Test;

import java.util.Arrays;

/**
 * Given an array with n objects colored red, white or blue, sort them so that objects
 * of the same color are adjacent, with the colors in the order red, white and blue.
 * <p>
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * <p>
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 *
 * @author zerods
 * @version 1.0 04/09/2017
 */
public class SortColors {
    public void sortColors(int[] nums) {
        int lt = -1;
        int rt = nums.length;
        while (lt + 1 < rt && nums[lt + 1] == 0) lt++;
        while (rt - 1 > lt && nums[rt - 1] == 2) rt--;

        for (int i = lt + 1; i < rt; /*i = Math.max(lt + 1, i)*/) {
            if (nums[i] == 0) {
                swap(nums, ++lt, i++);
            } else if (nums[i] == 2) {
                swap(nums, i, --rt);
            } else {
                i++;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    @Test
    public void test() {
        int[] nums = new int[]{2, 1, 1, 0};
        sortColors(nums);
        int[] nums1 = new int[]{2, 0};
        sortColors(nums1);
        int[] nums2 = new int[]{0, 2};
        sortColors(nums2);
        int[] nums3 = new int[]{1, 0};
        sortColors(nums3);
        int[] nums4 = new int[]{0, 1};
        sortColors(nums4);
        int[] nums5 = new int[]{0, 0};
        sortColors(nums5);
        int[] nums6 = new int[]{1, 1};
        sortColors(nums6);
        int[] nums7 = new int[]{2, 2};
        sortColors(nums7);

    }
}
