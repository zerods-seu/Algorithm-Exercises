package offer;

import org.junit.Test;

import java.util.Arrays;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * <p>
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold
 * additional elements from nums2. The number of elements initialized in nums1 and nums2 are m
 * and n respectively.
 *
 * @author zerods
 * @version 1.0 04/09/2017
 */
public class MergeSortedArray {
    //    public void merge(int[] nums1, int m, int[] nums2, int n) {
//        if (n == 0) {
//            return;
//        }
//        int len = m + n;
//        int head = m, tail = m;
//        int j = 0;
//
//        for (int i = 0; i < m; i++) {
//            if (nums1[i] > nums2[j]) {
//                nums1[tail++] = nums1[i];
//                if (head < tail && nums1[head] < nums2[j]) {
//                    nums1[i] = nums1[head++];
//                } else {
//                    nums1[i] = nums2[j++];
//                }
//            } else {
//                if (head < tail) {
//                    nums1[tail++] = nums1[i];
//                    if (nums1[head] < nums2[j]) {
//                        nums1[i] = nums1[head++];
//                    } else {
//                        nums1[i] = nums2[j++];
//                    }
//                }
//            }
//        }
//
//        for (int i = m; i < len; i++) {
//            if (head < tail && nums1[head] < nums2[j]) {
//                nums1[i] = nums1[head++];
//            } else {
//                nums1[i] = nums2[j++];
//            }
//        }
//    }
    public void merge(int[] A, int m, int[] B, int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i > -1 && j > -1) {
            A[k--] = A[i] > B[j] ? A[i--] : B[j--];
        }
        while (j > -1) {
            A[k--] = B[j--];
        }
    }

    @Test
    public void test() {
//        int[] nums1 = new int[10];
//        int[] nums2 = new int[5];
//        for (int i = 0; i < 5; i++) {
//            nums1[i] = i;
//            nums2[i] = i * 2;
//        }
        int[] nums1 = {1};
        int[] nums2 = {};
        merge(nums1, 1, nums2, 0);
//        for (int i = 0; i < 10; i++) {
        System.out.println(Arrays.toString(nums1));
//        }
    }
}
