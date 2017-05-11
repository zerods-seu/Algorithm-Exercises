package offer;

import java.util.ArrayList;

/**
 * 输入一个链表，从尾到头打印链表每个节点的值
 *
 * 基本思路1：创建结果和辅助两个ArrayList，再利用
 * 栈的思想进行反向打印
 * 基本思路2：使用递归，先打印子链表，再打印node中的值。
 * Created by zerods on 2017/3/14.
 */
public class printListFromTailToHead {
	public static ArrayList<Integer> print(ListNode listNode) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        ArrayList<Integer> aux = new ArrayList<>();
        int i = 0;
        while (listNode != null) {
            aux.add(listNode.val);
            i++;
            listNode = listNode.next;
        }
        i--;
        while (i >= 0) {
            arrayList.add(aux.get(i));
            aux.set(i--, null);
        }
        return arrayList;
    }
	
	public static ArrayList<Integer> print2(ListNode listNode) {
        ArrayList<Integer> integerList = new ArrayList<>();
        if (listNode != null) {
			// base case
            if (listNode.next == null) {
                integerList.add(listNode.val);
            } else {
				// recursive case
                integerList.addAll(print2(listNode.next));
                integerList.add(listNode.val);
            }
            return  integerList;
        }
        
        return integerList;
    }
	
	// 测试代码
    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        System.out.print(print(node));
    }
}

class ListNode {
    int val;
    ListNode next = null;

    public ListNode(int val) {
        this.val = val;
    }
}