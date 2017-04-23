package offer;

import java.util.List;
import java.util.Stack;

/**
 * 非递归方式访问一颗二叉树
 * @author zerods
 * @version 1.0 2017/3/16
 */

public class TraverseBinary {
    public static void preOrder(List<Integer> list, TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                list.add(root.val);
                root = root.left;
            }
            if (root == null) {
                root = stack.pop();
                root = root.right;
            }
        }
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    public static void inOrder(List<Integer> list, TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (root == null) {
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }

    public static void postOrder(List<Integer> list, TreeNode root) {
        if (root == null) return;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = null;
        TreeNode last = null;
        stack.push(root);
        while (!stack.isEmpty()) {
            current = stack.peek();
            if ((current.left == null && current.right == null) ||
                    (last != null && (last == current.right || last == current.left))) {
                list.add(current.val);
                stack.pop();
                last = current;
            } else {
                if (current.right != null) stack.push(current.right);
                if (current.left != null) stack.push(current.left);
            }
        }

        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();
    }
}
