package question23;

public class Solve {

    public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        mirror(root);
        return root;
    }

    public void mirror(TreeNode root) {
        if(root != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            if(root.left != null) mirror(root.left);
            if(root.right != null) mirror(root.right);
        }
    }
}

class TreeNode {

    int val;

    TreeNode left;

    TreeNode right;

    public TreeNode(int val) {
        this.val = val;
    }
}
