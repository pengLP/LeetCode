"""
合并两个有序链表
将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
"""
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        if(l1 == None):
            return l2
        if(l2 == None):
            return l1
        head = None
        if(l1.val < l2.val):
            head = l1
            l1 = l1.next
        else:
            head = l2
            l2 = l2.next
        head.next = None
        r = head
        while(l1 and l2):
            if(l1.val < l2.val):
                p = l1.next
                l1.next = None
                r.next = l1
                l1 = p
            else:
                p = l2.next
                l2.next = None
                r.next = l2
                l2 = p
            r = r.next
        if(l1):
            r.next = l1
        if(l2):
            r.next = l2
        return head




if __name__ == '__main__':
    l1 = ListNode(1)
    i = 2
    test = l1
    while (i < 4):
        node = ListNode(i)
        test.next = node
        test = test.next
        i += 1

    l2 = ListNode(1)
    i = 2
    test = l2
    while (i < 4):
        node = ListNode(i)
        test.next = node
        test = test.next
        i += 1

    s = Solution()
    head = s.mergeTwoLists(l1,l2)
    while (head):
        print(head.val)
        head = head.next