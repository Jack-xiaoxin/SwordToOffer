package question49;

import apple.laf.JRSUIUtils;

public class Solve2 {

    private int count;

    public int kthLargest(TreeNode root, int k) {
        int count = getNum(root);
        return getResult(root, count - k);
    }

    public int getResult(TreeNode root, int k) {
        if(k <= 0) return 0;
        if(root != null) {
            int result = getResult(root.left, k);
            k--;
            if(k == 0) result += root.val;
            result += getResult(root.right, k);
            return result;
        }
        return 0;
    }

    public int getNum(TreeNode root) {
        if(root != null) {
            return 1 + getNum(root.left) + getNum(root.right);
        }
        return 0;
    }
}


