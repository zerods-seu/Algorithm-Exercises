package offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author zerods
 * @version 1.0 12/09/2017
 */
public class PrintTree {
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode curNode = null;
        queue.add(pRoot);
        int curCount = 1;
        int nextCount = 0;

        while (queue.size() > 0) {
            ArrayList<Integer> curFloorNums = new ArrayList<>();
            while (curCount > 0) {
                curNode = queue.remove();
                curFloorNums.add(curNode.val);
                curCount--;
                if (curNode.left != null) {
                    queue.add(curNode.left);
                    nextCount++;
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                    nextCount++;
                }
            }
            curCount = nextCount;
            nextCount = 0;
            res.add(curFloorNums);
        }

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        ArrayList<ArrayList<Integer>> list = new PrintTree().Print(root);
        for (ArrayList<Integer> list1 : list) {
            for (Integer i : list1) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
