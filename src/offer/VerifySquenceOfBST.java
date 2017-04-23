package offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的
 * 后序遍历的结果。如果是则输出Yes,否则输出No。假设
 * 输入的数组的任意两个数字都互不相同.
 * 5, 7, 6, 9, 11, 10, 8 --> true
 * 7, 4, 6, 5 --> false
 * @author zerods
 * @version 1.0 2017/4/9
 */
public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) return false;
        return verifySquenceOfBST(sequence, 0, sequence.length - 1, true);
    }

    private boolean verifySquenceOfBST(int[] sequence, int lo, int hi,  boolean flag) {
        if (lo >= hi) {return true;}
        int rootVal = sequence[hi];
        int i = lo;
        while (sequence[i] < rootVal) {
            i++;
        }
        for (int j = i; j < hi; j++) {
            if (sequence[j] < rootVal) {
                return false;
            }
        }
        return flag && verifySquenceOfBST(sequence, lo, i - 1, true) &&
                verifySquenceOfBST(sequence, i, hi - 1, true);
    }

    public static void main(String[] args) {
//        System.out.println(new VerifySquenceOfBST().VerifySquenceOfBST(new int[] {5, 7, 6, 9, 11, 10, 8}));
        System.out.println(new VerifySquenceOfBST().VerifySquenceOfBST(new int[] {7, 4, 6, 5}));
    }
}
