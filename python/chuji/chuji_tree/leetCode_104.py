"""
二叉树的最大深度
给定一个二叉树，找出其最大深度。
二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
说明: 叶子节点是指没有子节点的节点。
"""
class TreeNode:
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None

def creat(str):
    print(str)
    list = []
    for i in range(len(str)):
        if(str != None):
            list.append(TreeNode(str[i]))
        else:
            list.append(None)
    print(list)

class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        print(root)
if __name__ == '__main__':
    creat([3,9,20,None,None,15,7])