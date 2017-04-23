package offer;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。
 * 队列中的元素为int类型
 * @author zerods
 * @version 1.0 2017/3/15
 */
public class QueueWithTwoStacks {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
         stack1.push(node);
    }

    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public static void main(String[] args) {
        QueueWithTwoStacks queueWithTwoStacks = new QueueWithTwoStacks();
        queueWithTwoStacks.push(1);
        queueWithTwoStacks.push(2);
        queueWithTwoStacks.push(3);
        queueWithTwoStacks.push(4);
        System.out.println(queueWithTwoStacks.pop());
        System.out.println(queueWithTwoStacks.pop());
        System.out.println(queueWithTwoStacks.pop());
    }
}
