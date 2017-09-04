package offer;

import java.util.Arrays;

/**
 * Given an array and a value, remove all instances of that value in place
 * and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this in place
 * with constant memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave
 * beyond the new length.
 * <p>
 * Example:
 * Given input array nums = [3,2,2,3], val = 3
 * <p>
 * Your function should return length = 2, with the first two elements of
 * nums being 2.
 *
 * @author zerods
 * @version 1.0 04/09/2017
 */
public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length < 1) return 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            while (left < nums.length && nums[left] != val) left++;
            while (right >= 0 && nums[right] == val) right--;
            if (left <= right)
                swap(nums, left++, right--);
        }

        System.out.println(Arrays.toString(nums));
        return left;
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{};
        System.out.println(new RemoveElement().removeElement(nums, 2));
    }
}
