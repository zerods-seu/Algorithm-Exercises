package offer;

/**
 * 输入两个链表，找出它们的第一个公共结点
 *
 * @author zerods
 * @version 1.0 09/09/2017
 */
public class FindFirstCommonNode {
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        ListNode tmp = pHead1;
        int len_1 = 0;
        int len_2 = 0;
        while (tmp != null) {
            len_1++;
            tmp = tmp.next;
        }

        tmp = pHead2;
        while (tmp != null) {
            len_2++;
            tmp = tmp.next;
        }

        int more = len_1 - len_2;
        if (more > 0) {
            int i = 0;
            while (i++ < more) {
                pHead1 = pHead1.next;
            }
        } else if (more < 0) {
            int i = 0;
            while (i++ <= more) {
                pHead2 = pHead2.next;
            }
        }

        while (pHead1 != pHead2) {
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;
        }

        return pHead1;
    }

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        ListNode n4 = new ListNode(4);
        ListNode n5 = new ListNode(5);
        ListNode n6 = new ListNode(6);
        ListNode n7 = new ListNode(7);

        n1.next = n2;
        n2.next = n3;
        n3.next = n6;

        n4.next = n5;
        n5.next = n6;

        n6.next = n7;

        System.out.println(new FindFirstCommonNode().FindFirstCommonNode(n1, n4).val);
    }
}
