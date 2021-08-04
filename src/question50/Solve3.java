package question50;

public class Solve3 {

    public boolean isBalanced(TreeNode root) {
        int result = help(root);
        if(result >= 0) return true;
        else return false;
    }

    public int help(TreeNode root) {
        if(root != null) {
            int ldepth = help(root.left);
            int rdepth = help(root.right);
            if(ldepth == -1 || rdepth == -1 || Math.abs(ldepth-rdepth) >= 2) return -1;
            else return Math.max(ldepth, rdepth) + 1;
        }
        return 0;
    }
}
