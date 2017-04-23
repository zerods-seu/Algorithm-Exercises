package offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * @author zerods
 * @version 1.0 2017/4/7
 */
public class PrintFromTopToBottom {
    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        if (root != null) {
            queue.add(root);
            while (!queue.isEmpty()) {
                TreeNode peek = queue.peek();
                list.add(peek.val);
                if (peek.left != null) queue.add(peek.left);
                if (peek.right != null) queue.add(peek.right);
                queue.remove();
            }
        }

        return list;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode();
//        root.left = new TreeNode(2);
//        root.right= new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(6);
//        root.right.right = new TreeNode(7);

        System.out.println(PrintFromTopToBottom(null));
    }
}
