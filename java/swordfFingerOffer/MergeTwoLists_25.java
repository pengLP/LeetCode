package swordfFingerOffer;

import swordfFingerOffer.list.ListNode;

/**
 * 面试题25. 合并两个排序的链表
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * */
public class MergeTwoLists_25 {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        if (l2 == null)
            return l1;
        ListNode head;
        if (l1.val < l2.val) {
            head = l1;
            l1 = l1.next;
        }else {
            head = l2;
            l2 = l2.next;
        }
        head.next = null;
        ListNode r = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                ListNode p = l1.next;
                r.next = l1;
                l1.next = null;
                l1 = p;
            }else {
                ListNode p = l2.next;
                r.next = l2;
                l2.next = null;
                l2 = p;
            }
            r = r.next;
        }

        if (l1 == null) {
            r.next = l2;
        }
        if (l2 == null) {
            r.next = l1;
        }
        return head;
    }
}
