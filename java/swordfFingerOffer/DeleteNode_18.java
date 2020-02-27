package swordfFingerOffer;

import swordfFingerOffer.list.ListNode;


/**
 * 面试题18. 删除链表的节点
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * */
public class DeleteNode_18 {
    public ListNode deleteNode(ListNode head, int val) {
        ListNode p = head;
        if (p.val == val){
            return head.next;
        }
        while (p.next != null && p.next.val != val) {
            p = p.next;
        }
        ListNode q = p.next;
        p.next = q.next;
        q.next = null;
        return head;
    }
}
