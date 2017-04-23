package offer;

import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 在该栈中，调用min,push,pop的时间复杂度都是O(1)
 * @author zerods
 * @version 1.0 2017/4/2
 */
public class StackWithMin {
    private Stack<Integer> aux = new Stack<>();
    private Stack<Integer> data = new Stack<>();

    public void push(int node) {
        data.push(node);
        if (!aux.isEmpty()) {
            if (node <= min()) {
                aux.push(node);
            }
        } else {
            aux.push(node);
        }
    }

    public void pop() {
        int a = data.pop();
        if (a == min()) {
            aux.pop();
        }
    }

    public int top() {
        return data.peek();
    }

    public int min() {
        return aux.peek();
    }

    public static void main(String[] args) {
        StackWithMin stackWithMin = new StackWithMin();
        stackWithMin.push(3);
        System.out.println(stackWithMin.min());
        stackWithMin.push(5);
        System.out.println(stackWithMin.min());
        stackWithMin.push(1);
        System.out.println(stackWithMin.min());
        stackWithMin.push(4);
        System.out.println(stackWithMin.min());
        stackWithMin.push(2);
        stackWithMin.pop();
        System.out.println(stackWithMin.min());
        stackWithMin.pop();
        System.out.println(stackWithMin.min());
        stackWithMin.pop();
        System.out.println(stackWithMin.min());
        stackWithMin.pop();
        System.out.println(stackWithMin.min());
        stackWithMin.pop();
//        System.out.println(stackWithMin.min());

    }
}
