package offer;

/**
 * 输入一个链表，反转链表后，输出链表的所有元素。
 
 * 基本思路：每次反转一个节点，关键是
 * 1.保存要反转节点(这里是current)的next引用，这里使用tmp来保存。
 * 2.将current的next引用指向previous
 * 3.将previous更改为current，current更改为tmp
 * 4.最后别忘了更改原始头结点的next引用
 
 * @author zerods
 * @version 1.0 2017/3/26
 */
public class ReverseList {
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
		
        ListNode previous = head;
        ListNode current = head.next;
		ListNode tmp;
        while (current != null) {
            tmp = current.next;
            current.next = previous;
            previous = current;
            current = tmp;
        }
        head.next = null;

        return previous;
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

        l1 = reverseList(l1);

        while (l1 != null) {
            System.out.print(l1.val + " ");
            l1 = l1.next;
        }
    }
}
