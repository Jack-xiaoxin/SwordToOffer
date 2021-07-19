package question29;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Solve {

    //思路：遍历二叉树
    //注意：target可能为负数。
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        if(root == null) return null;

        if(root.val <= target) {
            path.add(root.val);
            recur(root, result, path, root.val, target);
        }
        return result;
    }

    public void recur(TreeNode root, List<List<Integer>> result, List<Integer> path, int sum, int target) {
        if(root.left == null && root.right == null && sum == target) {
            List<Integer> temp = new ArrayList<>();
            temp.addAll(path);
            result.add(temp);
        }
        if(root.left != null){
            path.add(root.left.val);
            recur(root.left, result, path, sum+root.left.val, target);
        }
        if(root.right != null) {
            path.add(root.right.val);
            recur(root.right, result, path, sum + root.right.val, target);
        }
        path.remove(path.size()-1);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
