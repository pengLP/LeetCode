"""
回文链表
请判断一个链表是否为回文链表。
"""
class ListNode:
    def __init__(self, x):
        self.val = x
        self.next = None

class Solution:
    def isPalindrome(self, head: ListNode) -> bool:
        p = head
        len = 0
        while(p):

            p = p.next
            len+=1
        start = head
        end = head
        for i in range(int(len/2)):
            end = end.next
        if(len % 2 == 1):
            end = end.next

        end = self.reverseList(end)

        while(start and end):
            if(start.val != end.val):
                return False
            start = start.next
            end=end.next
        return True

    def reverseList(self, head: ListNode) -> ListNode:
        h = ListNode(0)
        while (head):
            p = head.next
            head.next = h.next
            h.next = head
            head = p
        return h.next

if __name__ == '__main__':
    head = ListNode(1)
    second = ListNode(2)
    three = ListNode(2)
    four = ListNode(1)
    head.next = second
    second.next = three
    three.next = four
    # i = 2
    # test = head
    # while (i < 3):
    #     node = ListNode(i)
    #     test.next = node
    #     test = test.next
    #     i += 1

    s = Solution()
    print(s.isPalindrome(head))