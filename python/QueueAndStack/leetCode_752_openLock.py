""".
打开转盘锁
你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。

锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。

列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。

字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，返回 -1。

"""
from queue import Queue
from collections import deque
class Solution:

    """
    单向广度优先搜索，超时
    """
    # def openLock(self, deadends, target: str) -> int:
    #     path = Queue()
    #     start = "0000"
    #     path.put(start)
    #     visit = []
    #     count = 0
    #     while(path.empty() != True):
    #         for s in range(path.qsize()):
    #             item = path.get()
    #             neibors = self.findNeibors(item)
    #             for i in neibors:
    #                 if (i == target):
    #                     count += 1
    #                     return count
    #                 if(i not  in deadends and i not in visit) :
    #                     visit.append(i)
    #                     path.put(i)
    #         count += 1
    #     return -1
    #
    # def findNeibors(self , currLock):
    #     res = []
    #     for i in range(4):
    #         temp = list(currLock)
    #         temp[i] = str((int(temp[i]) + 1) % 10)
    #         res.append("".join(temp))
    #         temp = list(currLock)
    #         temp[i] = str((int(temp[i])+10 - 1) % 10)
    #         res.append("".join(temp))
    #     return res
    #
    # """
    # 双向广度优先搜索
    # """
    # def openLock(self, deadends, target: str) -> int:
    #     if (deadends.count(target) > 0 or deadends.count("0000") > 0):
    #         return -1
    #     s , e = [],[]
    #     s.append("0000")
    #     e.append(target)
    #     count = 0
    #     visit = []
    #     while(len(s) > 0 and len(e) > 0):
    #         if(len(s) > len(e)):
    #             t = s
    #             s = e
    #             e = t
    #         l3 = []
    #         for curLock in s:
    #             neibors = self.findNeibors(curLock)
    #             for neibor in neibors:
    #                 if(e.count(neibor) > 0):
    #                     count += 1
    #                     return count
    #                 if(deadends.count(neibor) == 0 and visit.count(neibor) == 0):
    #                     l3.append(neibor)
    #                     visit.append(neibor)
    #         count += 1
    #         s = l3
    #     return -1
    #

    def openLock(self , deadends , target):
        deadends = set(deadends)
        if "0000" in deadends:
            return -1
        queue = deque()
        queue.append(["0000" , 0])
        count = 0
        while(queue):
            node , cnt = queue.popleft()
             



if __name__ == '__main__':
    s = Solution()
    print(s.openLock(deadends = ["0201","0101","0102","1212","2002"], target = "0202"))
