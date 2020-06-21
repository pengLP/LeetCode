package swordfFingerOffer;

/**
 * 面试题33. 二叉搜索树的后序遍历序列
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifyPostorder_33 {

    public boolean verifyPostorder(int[] postorder) {

        if (postorder == null || postorder.length == 0)
            return false;
        int start = 0, end = postorder.length - 1;
        return check(postorder, start, end);

    }

    public boolean check(int[] postorder, int start, int end) {
        if (start >= end)
            return true;
        int root = postorder[end];
        int mid = start;
        for (; mid < end; mid++) {
            if (postorder[mid] > root)
                break;
        }
        int j = mid;
        for (; j < end; j++) {
            if (postorder[j] < root)
                return false;
        }
        boolean left = true, right = true;
        if (mid > start)
            left = check(postorder, start, mid - 1);
        if (mid < end)
            right = check(postorder, mid, end - 1);
        return left && right;
    }

    public static void main(String[] args) {
        VerifyPostorder_33 verifyPostorder_33 = new VerifyPostorder_33();
        System.out.println(verifyPostorder_33.verifyPostorder(new int[]{1, 6, 2, 6, 5}));
    }

}
