package question50;

public class Solve {

    private int depth = 0;

    public int maxDepth(TreeNode root) {
        if(root == null) return depth;
        help(root, 1);
        return depth;
    }

    public void help(TreeNode root, int d) {
        if(root != null) {
            if(root.left == null && root.right == null && d > depth) depth = d;
            if(root.left != null) help(root.left, d+1);
            if(root.right != null) help(root.right, d+1);
        }
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
}
