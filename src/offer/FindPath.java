package offer;

import java.util.ArrayList;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数
 * 的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过
 * 的结点形成一条路径。

 * @author zerods
 * @version 1.0 2017/4/13
 */
public class FindPath {
    public static ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> valsList = new ArrayList<>();
        if (root == null) {return valsList;}
        if (root.left == null && root.right == null) {
            if (root.val == target) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(root.val);
                valsList.add(list);
                return valsList;
            } else {
                return null;
            }
        } else {
            int newTarget = target - root.val;
            return merge(FindPath(root.left, newTarget), FindPath(root.right, newTarget), root.val);
        }
    }

    private static ArrayList<ArrayList<Integer>> merge(ArrayList<ArrayList<Integer>> left, ArrayList<ArrayList<Integer>> right, int rootVal) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (left != null) {
            for (ArrayList<Integer> listLeft : left) {
                ArrayList<Integer> listResult = new ArrayList<>();
                listResult.add(rootVal);
                listResult.addAll(listLeft);
                result.add(listResult);
            }
        }
        if (right != null) {
            for (ArrayList<Integer> listRight : right) {
                ArrayList<Integer> listResult = new ArrayList<>();
                listResult.add(rootVal);
                listResult.addAll(listRight);
                result.add(listResult);
            }
        }

        return result;
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(10);
//        TreeNode rootL = new TreeNode(5);
//        TreeNode rootR = new TreeNode(12);
//        TreeNode rootLL = new TreeNode(4);
//        TreeNode rootLR = new TreeNode(7);
//        TreeNode rootRL = new TreeNode(6);
//        TreeNode rootRR = new TreeNode(7);

//        root.left = rootL;
//        root.right = rootR;
//        rootL.left = rootLL;
//        rootL.right = rootLR;
//        rootR.left = rootRL;
//        rootR.right = rootRR;

        ArrayList<ArrayList<Integer>> lists = FindPath(new TreeNode(1), 0);
        for (ArrayList<Integer> list : lists) {
            System.out.println(list);
        }
    }
}
