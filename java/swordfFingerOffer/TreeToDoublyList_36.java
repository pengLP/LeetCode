package swordfFingerOffer;

class Node2 {
    public int val;
    public Node2 left;
    public Node2 right;

    public Node2() {}

    public Node2(int _val) {
        val = _val;
    }

    public Node2(int _val,Node2 _left,Node2 _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};

public class TreeToDoublyList_36 {

    private Node2 pre;

    public Node2 treeToDoublyList(Node2 root) {
        if (root == null)
            return null;
        Node2 head = root, tail = root;
        while (head.left != null) {
            head = head.left;
        }
        while (tail.right != null) {
            tail = tail.right;
        }
        inOrder(root);
        head.left = tail;
        tail.right = head;
        return head;

    }
    public void inOrder(Node2 root) {
        if (root == null)
            return;
        inOrder(root.left);
        root.left = this.pre;
        if (this.pre != null) this.pre.right = root;
        this.pre = root;
        inOrder(root.right);
    }

}
