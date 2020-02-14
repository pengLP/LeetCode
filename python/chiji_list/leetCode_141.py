"""
环形链表
给定一个链表，判断链表中是否有环。

为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
"""

class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def hasCycle(self, head: ListNode) -> bool:
        if(head == None):
            return False
        if(head.next == None):
            return False
        fast = head.next
        slow = head
        while(fast and slow):
            if(fast == slow):
                return True
            if(fast.next == None):
                return False
            fast = fast.next.next
            slow = slow.next
        return False


if __name__ == '__main__':
    head = ListNode(3)
    second = ListNode(2)
    three = ListNode(0)
    four = ListNode(-4)
    head.next = second
    second.next = three
    three.next = four
    four.next = head
    s = Solution()
    print(s.hasCycle(head))
    # i = 2
    # test = head
    # while (i < 3):
    #     node = ListNode(i)
    #     test.next = node
    #     test = test.next
    #     i += 1