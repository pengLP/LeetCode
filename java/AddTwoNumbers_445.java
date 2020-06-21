import swordfFingerOffer.list.ListNode;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 445. 两数相加 II
 * 给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。
 * 它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 */
public class AddTwoNumbers_445 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode head1 = reverse(l1);
        ListNode head2 = reverse(l2);
        int carry = 0;
        ListNode res = new ListNode(-1);
        ListNode curr = res;
        while (head1 != null || head2 != null) {
            int x = head1 == null ? 0 : head1.val;
            int y = head2 == null ? 0 : head2.val;
            int num = (x + y + carry) % 10;
            ListNode node = new ListNode(num);
            curr.next = node;
            curr = node;
            carry = (x + y + carry) / 10;
            if (head1 != null) head1 = head1.next;
            if (head2 != null) head2 = head2.next;
        }
        if (carry > 0) {
            ListNode node = new ListNode(carry);
            curr.next = node;
        }
        return reverse(res.next);

    }

    // 链表反转
    public ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }


    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            if (i == 2)
                iterator.remove();

        }
        System.out.println(list);
    }


}
