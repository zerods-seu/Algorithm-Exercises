package offer;

/**
 * 在古老的一维模式识别中,常常需要计算连续子向量的最大和,当向量全为正数的时候,问题很好解决。
 * 但是,如果向量中包含负数,是否应该包含某个负数,并期望旁边的正数会弥补它呢？
 * 例如:{6,-3,-2,7,-15,1,2,2},连续子向量的最大和为8(从第0个开始,到第3个为止)。(子向量的长度至少是1)
 *
 * @author zerods
 * @version 1.0 18/08/2017
 */
public class FindGreatestSumOfSubArray {

    public int findGreatestSumOfSubArray(int[] array) {
        int len = array.length;
        int nAll = array[len - 1];
        int nStart = array[len - 1];
        for (int i = len - 2; i >= 0; i--) {
            nStart = nStart < 0 ? 0 : nStart;
            nStart += array[i];
            nAll = nAll > nStart ? nAll : nStart;
        }

        return nAll;
    }
}
