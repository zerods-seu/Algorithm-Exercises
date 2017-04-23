package offer;

import java.util.Stack;

/**
 * 输入一个链表，输出该链表中倒数第k个结点
 * @author zerods
 * @version 1.0 2017/3/26
 */
public class FindKthToTail {
    public static ListNode findKthToTail(ListNode head, int k) {
//        if (head == null) {
//            return null;
//        }
//        Stack<ListNode> nodeStack = new Stack<>();
//        int count = 0;
//        while (head.next != null) {
//            nodeStack.push(head);
//            head = head.next;
//        }
//
//        ListNode node = null;
//        while (count < k) {
//            node = nodeStack.pop();
//        }
//        return node;

        if (head == null) {
            return null;
        }
        int interval = 0;
        ListNode first = head;
        ListNode second = head;
        while (interval++ < k && second != null) {
            second = second.next;
        }
        if (interval == k) {
            return null;
        }
        while (second != null) {
            first = first.next;
            second = second.next;
        }

        return first;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println(findKthToTail(head, 6).val);
    }
}

