package offer;

import org.junit.Test;

import java.util.Arrays;

/**
 * Follow up for "Remove Duplicates":
 * What if duplicates are allowed at most twice?
 * <p>
 * For example,
 * Given sorted array nums = [1,1,1,2,2,3],
 * <p>
 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2
 * and 3. It doesn't matter what you leave beyond the new length.
 *
 * @author zerods
 * @version 1.0 04/09/2017
 */
public class RemoveDuplicates2 {
    public int removeDuplicates(int[] nums) {
        int nonDuplicates = 0;
        int k = 0;
        int cur = Integer.MIN_VALUE;
        int curN = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > cur) {
                cur = nums[i];
                curN = 1;
                nonDuplicates++;
                nums[k++] = cur;
            } else {
                if (curN < 2) {
                    curN++;
                    nonDuplicates++;
                    nums[k++] = cur;
                }
            }
        }

        System.out.println(Arrays.toString(nums));
        return nonDuplicates;
    }

    @Test
    public void removeDuplicatesTest() {
        int[] nums = new int[]{1, 1, 2, 2, 2, 3, 4, 5, 5, 5, 6, 6, 7, 9, 9, 10};
//        assert removeDuplicates(nums) == 9;
        removeDuplicates(nums);
    }
}
