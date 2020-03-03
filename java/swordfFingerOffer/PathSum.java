package swordfFingerOffer;

import swordfFingerOffer.list.ListNode;
import swordfFingerOffer.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题34. 二叉树中和为某一值的路径
 * 输入一棵二叉树和一个整数，打印出二叉树中节点值的和为输入整数的所有路径。
 * 从树的根节点开始往下一直到叶节点所经过的节点形成一条路径。
 * */

public class PathSum {


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null)
            return ans;
        dfs(ans , root , sum , 0 , new ArrayList<>());
        return ans;
    }

    private void dfs(List<List<Integer>> ans , TreeNode root , int sum , int tmpSum , List<Integer> path) {
        if (root == null)
            return;
        tmpSum += root.val;
        path.add(root.val);
        if (tmpSum == sum && root.left == null && root.right == null)
            ans.add(path);
        if (root.left != null) {
            dfs(ans , root.left , sum , tmpSum , path);
            path.remove(path.size() - 1);
        }
        if (root.right != null){
            dfs(ans , root.right , sum , tmpSum , path);
            path.remove(path.size() - 1);
        }

    }

}
