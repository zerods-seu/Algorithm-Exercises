package offer;

/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
 * @author zerods
 * @version 1.0 2017/3/26
 */
public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode first = head;
        ListNode second = head.next;

        ListNode tmp;
        while (second != null) {
            tmp = second.next;
            second.next = first;
            first = second;
            second = tmp;
        }
        head.next = null;

        return first;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);

        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

//        while (l1 != null) {
//            System.out.print(l1.val + " ");
//            l1 = l1.next;
//        }

        l1 = reverseList(l1);

        while (l1 != null) {
            System.out.print(l1.val + " ");
            l1 = l1.next;
        }
    }
}
