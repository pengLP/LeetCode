package swordfFingerOffer;


import swordfFingerOffer.tree.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 面试题37. 序列化二叉树
 * 请实现两个函数，分别用来序列化和反序列化二叉树。
 * */
public class Codec_37 {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null)
            return "[]";
        StringBuffer res = new StringBuffer("[");
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            if(tmp != null) {
                res.append(tmp.val + ",");
                queue.add(tmp.left);
                queue.add(tmp.right);
            }else {
                res.append("null,");
            }
        }
        return res.substring(0 , res.length() - 1) + "]";
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null && data.equals("[]"))
            return null;
        String res = data.substring(1 , data.length() - 1);
        String values[] = res.split(",");
        int index = 0;
        TreeNode node = getTreeNode(values[index++]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            tmp.left = getTreeNode(values[index++]);
            tmp.right = getTreeNode(values[index++]);
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            if (tmp.right != null)
                queue.add(tmp.right);

        }
        return node;
    }

    public TreeNode getTreeNode(String s) {
        if(s.equals("null"))
            return null;
        return new TreeNode(Integer.valueOf(s));

    }

    public static void main(String[] args) {
        Codec_37 codec_37 = new Codec_37();
        System.out.println(codec_37.deserialize("[1,2,3,null,null,4,5]"));
    }
}
