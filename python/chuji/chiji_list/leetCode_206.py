"""
反转链表
反转一个单链表。
"""
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def reverseList(self, head: ListNode) -> ListNode:
        h = ListNode(0)
        while(head):
            p = head.next
            head.next = h.next
            h.next = head
            head = p
        return h.next
if __name__ == '__main__':
    head = ListNode(1)
    i = 2
    test = head
    while (i < 6):
        node = ListNode(i)
        test.next = node
        test = test.next
        i += 1

    s = Solution()


    test = s.reverseList(head)
    while (test):
        print(test.val)
        test = test.next
