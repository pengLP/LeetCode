package swordfFingerOffer;

import swordfFingerOffer.list.ListNode;

/**
 * 面试题52. 两个链表的第一个公共节点
 * 输入两个链表，找出它们的第一个公共节点。
 * */
public class GetIntersectionNode_52 {

    public class Solution {
        public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
            if(headA == null || headB == null)
                return null;
            ListNode node1 = headA , node2 = headB;
            while(node1 != node2) {
                node1 = node1 == null ? headB : node1.next;
                node2 = node2 == null ? headA : node2.next;
            }
            return node1;
        }
    }

}
