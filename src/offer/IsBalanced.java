package offer;

/**
 * @author zerods
 * @version 1.0 10/09/2017
 */
public class IsBalanced {
    public boolean IsBalanced_Solution(TreeNode root) {
        if (root.left != null && root.right != null) {
            return IsBalanced_Solution(root.left)
                    && IsBalanced_Solution(root.right)
                    && Math.abs(treeDepth(root.left) - treeDepth(root.right)) <= 1;
        } else if (root.left != null) {
            return treeDepth(root.left) <= 1 && IsBalanced_Solution(root.left);
        } else if (root.right != null) {
            return treeDepth(root.right) <= 1 && IsBalanced_Solution(root.right);
        } else {
            return true;
        }
    }

    private int treeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int nLelt = treeDepth(root.left);
        int nRight = treeDepth(root.right);

        return nLelt > nRight ? (nLelt + 1) : (nRight + 1);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t2.right = t5;
        t3.left = t6;
        t3.right = t7;

        System.out.println(new IsBalanced().IsBalanced_Solution(t1));
    }
}
