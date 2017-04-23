package offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注
 * 意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 * @author zerods
 * @version 1.0 2017/4/16
 */
class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return label + "";
    }
}

public class RandomListNodeTest {
    public static RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) { return null; }
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode head = new RandomListNode(pHead.label);
        map.put(pHead, head);
        RandomListNode cur = head;
        RandomListNode tmp;
        for (RandomListNode node = pHead; node != null; node = node.next) {
            if (node != pHead) {
                tmp = new RandomListNode(node.label);
                map.put(node, tmp);
                cur.next = tmp;
                cur = cur.next;
            }
        }

        for (RandomListNode node = pHead; node != null; node = node.next) {
            RandomListNode newNode = map.get(node);
            newNode.random = map.get(node.random);
        }

        return head;
    }

    public static void main(String[] args) {
        RandomListNode head = new RandomListNode(1);
        RandomListNode second = new RandomListNode(2);
        RandomListNode third = new RandomListNode(3);
        RandomListNode fourth = new RandomListNode(4);
        head.next = second;
        second.next = third;
        third.next = fourth;

        head.random = third;
        second.random = fourth;
        third.random = head;
        fourth.random = second;

        RandomListNode result = Clone(head);
    }
}
