package offer;

/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表
 * 当然我们需要合成后的链表满足单调不减规则。
 * @author zerods
 * @version 1.0 2017/3/28
 */
public class MergeLinkedList {
    public static ListNode merge(ListNode list1, ListNode list2) {
        ListNode list3 = new ListNode(0);
        ListNode tmp = list3;
        while (list1 != null & list2 != null) {
            if (list1.val < list2.val) {
                list3.next = list1;
                list3 = list3.next;
                list1 = list1.next;
            } else {
                list3.next = list2;
                list3 = list3.next;
                list2 = list2.next;
            }
        }

        if (list1 != null) {
            list3.next = list1;
        }
        if (list2 != null) {
            list3.next = list2;
        }
        return tmp.next;
    }

    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(5);
        ListNode fourth = new ListNode(7);
        list1.next = second;
        second.next = third;
        third.next = fourth;

        ListNode list2 = new ListNode(2);
        ListNode second2 = new ListNode(4);
        ListNode third2 = new ListNode(6);
        ListNode fourth2 = new ListNode(8);

        list2.next = second2;
        second2.next = third2;
        third2.next = fourth2;

        ListNode mergeList = merge(list1, list2);
        for (ListNode tmp = mergeList; mergeList != null; mergeList = mergeList.next) {
            System.out.print(mergeList.val + " ");
        }
    }
}
