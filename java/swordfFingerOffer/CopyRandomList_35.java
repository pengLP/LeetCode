package swordfFingerOffer;

import java.util.HashMap;
import java.util.Map;

/**
 * 面试题35. 复杂链表的复制
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 * */

class Node1 {
    int val;
    Node1 next;
    Node1 random;

    public Node1(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyRandomList_35 {

    public Node1 copyRandomList(Node1 head) {
        Map<Node1 , Node1> map = new HashMap<>();
        Node1 p = head;
        while (p != null) {
            map.put(p , new Node1(p.val));
            p = p.next;
        }

        p = head;
        while (p != null) {
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p = p.next;
        }
        return map.get(head);
    }

}
