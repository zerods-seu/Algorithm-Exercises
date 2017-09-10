package offer;

/**
 * Given an array of n positive integers and a positive integer s, find the minimal length
 * of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 * <p>
 * For example, given the array [2,3,1,2,4,3] and s = 7,
 * the subarray [4,3] has the minimal length under the problem constraint.
 *
 * @author zerods
 * @version 1.0 09/09/2017
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0;
        int r = -1;
        int res = nums.length + 1;
        int sum = 0;

        while (l < nums.length) {
            if (r + 1 < nums.length && sum < s) {
                sum += nums[++r];
            } else {
                if (sum >= s)
                    res = Math.min(res, r - l + 1);
                sum -= nums[l++];
            }
        }

        if (res == nums.length + 1) {
            return 0;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2, 3, 1, 2, 4, 3, 7};
        MinSubArrayLen len = new MinSubArrayLen();
        System.out.println(len.minSubArrayLen(50, a));
    }
}
