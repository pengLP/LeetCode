import swordfFingerOffer.tree.TreeNode;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * 根据一棵树的前序遍历与中序遍历构造二叉树。
 * */

public class BuildTree_105 {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length == 0 || inorder.length == 0)
            return null;
        TreeNode treeNode = new TreeNode(preorder[0]);
        int index = getNum(treeNode.val , inorder);
        treeNode.left = buildTree(Arrays.copyOfRange(preorder, 1, 1 + index), Arrays.copyOfRange(inorder, 0 , index));
        treeNode.right = buildTree(Arrays.copyOfRange(preorder, 1 + index, preorder.length), Arrays.copyOfRange(inorder, index + 1 , inorder.length));
        return treeNode;
    }

    private int getNum(int val, int[] inorder) {

        for (int i = 0;i < inorder.length; i++) {
            if (inorder[i] == val)
                return i;
        }
        AtomicInteger integer = new AtomicInteger();
        integer.addAndGet(1);
        return -1;
    }


}
