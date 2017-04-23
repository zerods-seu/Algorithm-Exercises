package offer;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。例
 * 如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列
 * {4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * @author zerods
 * @version 1.0 2017/3/15
 */
public class ReConstructBinaryTree {
    public TreeNode reconstruct(int[] pre, int[] in) {
//        if (pre.length == 0) return null;
//        TreeNode root = new TreeNode(pre[0]);
//        if (pre.length == 1) return root;
//        else {
//            int len = pre.length;
//            int rootIndex = 0;
//            while (in[rootIndex] != root.val) {rootIndex++;}
//            int[] preLeft = new int[rootIndex];
//            int[] preRight = new int[len - rootIndex - 1];
//            System.arraycopy(pre, 1, preLeft, 0, rootIndex);
//            System.arraycopy(pre, rootIndex + 1, preRight, 0, len - rootIndex - 1);
//
//            int[] inLeft = new int[rootIndex];
//            int[] inRight = new int[len - rootIndex - 1];
//            System.arraycopy(in, 0, inLeft, 0, rootIndex);
//            System.arraycopy(in, rootIndex + 1, inRight, 0, len - rootIndex - 1);
//
//            root.left = reconstruct(preLeft, inLeft);
//            root.right = reconstruct(preRight, inRight);
//            return root;
//        }
        if (pre.length == 0) return null;
        if (pre.length == 1) return new TreeNode(pre[0]);
        TreeNode root = new TreeNode(pre[0]);
        int len = pre.length;
        int rootIndex = 0;
        while (in[rootIndex] != root.val) {rootIndex++;}
        int[] preLeft = new int[rootIndex];
        int[] preRight = new int[len - rootIndex - 1];
        System.arraycopy(pre, 1, preLeft, 0, rootIndex);
        System.arraycopy(pre, rootIndex + 1, preRight, 0, len - rootIndex - 1);

        int[] inLeft = new int[rootIndex];
        int[] inRight = new int[len - rootIndex - 1];
        System.arraycopy(in, 0, inLeft, 0, rootIndex);
        System.arraycopy(in, rootIndex + 1, inRight, 0, len - rootIndex - 1);

        root.left = reconstruct(preLeft, inLeft);
        root.right = reconstruct(preRight, inRight);
        return root;
    }

    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode result = new ReConstructBinaryTree().reconstruct(pre, in);
        result.printTreePreOrder();
        System.out.println();

        result.printTreeInOrder();
        System.out.println();

        result.printTreePostOrder();
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    void printTreePreOrder() {
        System.out.print(this.val + " ");
        if (left != null) left.printTreePreOrder();
        if (right != null) right.printTreePreOrder();
    }

    void printTreeInOrder() {
        if (left != null) left.printTreeInOrder();
        System.out.print(this.val + " ");
        if (right != null) right.printTreeInOrder();
    }

    void printTreePostOrder() {
        if (left != null) left.printTreePostOrder();
        if (right != null) right.printTreePostOrder();
        System.out.print(this.val + " ");
    }

    @Override
    public String toString() {
        return val + "";
    }
}
