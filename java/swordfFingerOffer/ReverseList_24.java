package swordfFingerOffer;

import swordfFingerOffer.list.ListNode;

/**
 * 面试题24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * */
public class ReverseList_24 {

    public ListNode reverseList(ListNode head) {
        ListNode p = new ListNode(0);
        while (head != null) {
            ListNode q = head.next;
            head.next = p.next;
            p.next = head;
            head = q;
        }
        return p.next;
    }

}
