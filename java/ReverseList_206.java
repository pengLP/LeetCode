import swordfFingerOffer.list.ListNode;

/**
 * 206. 反转链表
 * 反转一个单链表。
 * */
public class ReverseList_206 {


    public ListNode reverseList(ListNode head) {

        ListNode h = new ListNode(0);
        ListNode p = h;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = p.next;
            p.next = head;
            head = head.next;
        }
        return h.next;

    }
}
