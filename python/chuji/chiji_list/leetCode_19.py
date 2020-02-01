"""
删除链表的倒数第N个节点
给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
"""
class ListNode(object):
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution(object):
    def removeNthFromEnd(self, head, n):
        p1 = head
        p2 = head
        for i in range(n):
            p2 = p2.next
        if(p2 == None):
            return head.next
        print(p2.val)
        while(p2.next):
            p2 = p2.next
            p1 = p1.next
        p1.next = p1.next.next
        return head



if __name__ == '__main__':
    head = ListNode(1)
    i = 2
    test = head
    while(i < 3):
        node = ListNode(i)
        test.next = node
        test = test.next
        i += 1

    s = Solution()
    head = s.removeNthFromEnd(head,1)

    test = head
    while (test):
        print(test.val)
        test = test.next