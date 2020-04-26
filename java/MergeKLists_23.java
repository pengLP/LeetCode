import swordfFingerOffer.list.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 23. 合并K个排序链表
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * */
public class MergeKLists_23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode listNode, ListNode t1) {
                return listNode.val - t1.val;
            }
        });
        for (ListNode listNode:lists) {
            if (listNode != null)
                queue.offer(listNode);
        }
        ListNode head = new ListNode(-1);
        ListNode node = head;
        while (!queue.isEmpty()) {
            ListNode p = queue.poll();
            node.next = p;
            if (p.next != null) {
                p = p.next;
                queue.offer(p);
            }
            node = node.next;
        }
        return head.next;
    }

}
