import swordfFingerOffer.list.ListNode;

/**
 * 25. K 个一组翻转链表
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 */
public class ReverseKGroup_25 {

    private Object o = new Object();

    public void A() {
        synchronized (o) {
            System.out.println("A");
            B();
        }
    }

    public void B() {
        synchronized (o) {
            System.out.println("B");
        }
    }

}
