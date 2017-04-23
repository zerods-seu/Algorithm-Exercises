package offer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为
 * 该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某
 * 栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，但
 * 4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是
 * 相等的）
 * @author zerods
 * @version 1.0 2017/4/2
 */
public class IsPopOrder {
    public static boolean isPopOrder(int[] pushA,int [] popA) {
        int len = pushA.length;
        if (len == 0) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        stack.push(pushA[0]);
        int i = 1;

        while (j < len) {
            if (stack.peek() != popA[j]) {
                if (i == len) {
                    return false;
                }
                while (pushA[i] != popA[j] && i < len) {
                    stack.push(pushA[i]);
                    i++;
                }
                if (pushA[i] == popA[j]) {
                    i++;
                    j++;
                }
            } else {
                stack.pop();
                j++;
            }

        }

        return true;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5};
//        int[] b = {4, 3, 5, 1, 2};
//        int[] b = {4, 3, 5, 2, 1};
        int[] b = {4, 5, 3, 2, 1};
        System.out.println(isPopOrder(a, b));
    }
}
