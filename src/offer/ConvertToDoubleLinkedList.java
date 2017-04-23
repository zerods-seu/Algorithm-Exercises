package offer;
/**
 public class TreeNode {
     int val = 0;
     TreeNode left = null;
     TreeNode right = null;

     public TreeNode(int val) {
        this.val = val;
     }
 }
 */

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 * @author zerods
 * @version 1.0 2017/4/19
 */
public class ConvertToDoubleLinkedList {
    public TreeNode convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) {
            return null;
        }
        if (pRootOfTree.left != null) {
            pRootOfTree.left = convert(pRootOfTree.left);
            TreeNode newLeft = rightMost(pRootOfTree.left);
            pRootOfTree.left = newLeft;
            newLeft.right = pRootOfTree;
        }
        if (pRootOfTree.right != null) {
            pRootOfTree.right = convert(pRootOfTree.right);
            TreeNode newRight = leftMost(pRootOfTree.right);
            pRootOfTree.right = newRight;
            newRight.left = pRootOfTree;
        }
        return leftMost(pRootOfTree);

    }

    private TreeNode rightMost(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    private TreeNode leftMost(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        TreeNode nodeL = new TreeNode(6);
        TreeNode nodeR = new TreeNode(14);
        TreeNode nodeLL = new TreeNode(4);
        TreeNode nodeLR = new TreeNode(8);
        TreeNode nodeRL = new TreeNode(12);
        TreeNode nodeRR = new TreeNode(16);
        root.left = nodeL;
        root.right = nodeR;
        nodeL.left = nodeLL;
        nodeL.right = nodeLR;
        nodeR.left = nodeRL;
        nodeR.right = nodeRR;

        TreeNode head = new ConvertToDoubleLinkedList().convert(root);
    }
}
