package question49;

public class Solve2 {

    private int count;

    private int result;

    public int kthLargest(TreeNode root, int k) {
        getResult(root, count - k);
        return result;
    }

    public void getResult(TreeNode root, int k) {
        if(root.right != null && count < k) getResult(root.right, k);
        count++;
        if(count == k) result = root.val;
        if(root.left != null && count < k) getResult(root.left, k);
    }
}


