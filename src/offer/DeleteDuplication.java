package offer;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，
 * 返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 *
 * @author zerods
 * @version 1.0 12/09/2017
 */
public class DeleteDuplication {
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }

        ListNode newHead = findStart(pHead);
        if (newHead == null) {
            return null;
        }

        ListNode front = newHead;
        ListNode cur = newHead.next;

        while (cur != null) {
            int val = cur.val;
            if (cur.next != null) {
                if (cur.next.val != val) {
                    front.next = cur;
                    front = cur;
                    cur = cur.next;
                } else {
                    while (cur != null && val == cur.val) {
                        cur = cur.next;
                    }
                    if (cur == null) {
                        front.next = cur;
                    }
                }
            } else {
                front.next = cur;
                cur = cur.next;
            }

        }

        return newHead;
    }

    private ListNode findStart(ListNode pHead) {
        ListNode front = pHead;
        ListNode cur = pHead;
        int curNum = cur.val;

        while (cur != null) {
            if ((cur.next != null && cur.next.val != curNum) || cur.next == null) {
                return front;
            }
            while (cur != null && cur.val == curNum) {
                cur = cur.next;
            }
            front = cur;
            if (front == null) {
                return null;
            }
            curNum = cur.val;
        }

        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(5);
        ListNode node8 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        ListNode node = new DeleteDuplication().deleteDuplication(node1);

        while (node != null) {
            System.out.println(node.val);
            node = node.next;
        }

    }
}
