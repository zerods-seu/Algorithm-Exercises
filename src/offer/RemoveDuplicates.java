package offer;

import org.junit.Test;

import java.util.Arrays;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once
 * and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * <p>
 * For example,
 * Given input array nums = [1,1,2],
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 1 and 2
 * respectively. It doesn't matter what you leave beyond the new length.
 *
 * @author zerods
 * @version 1.0 04/09/2017
 */
public class RemoveDuplicates {
    public int removeDuplicates(int[] nums) {
        int nonDuplicates = 0;
        int k = 0;
        int cur = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > cur) {
                cur = nums[i];
                nonDuplicates++;
                nums[k++] = cur;
            }
        }

        System.out.println(Arrays.toString(nums));
        return nonDuplicates;
    }

    @Test
    public void removeDuplicatesTest() {
        int[] nums = new int[]{1, 1, 2, 2, 3, 4, 5, 5, 6};
        assert removeDuplicates(nums) == 6;
    }
}
