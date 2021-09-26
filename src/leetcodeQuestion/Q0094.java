package leetcodeQuestion;

import java.util.List;
import java.util.ArrayList;

public class Q0094 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        inOrderList(root, result);
        return result;
    }

    public void inOrderList(TreeNode root, List<Integer> result) {
        if(root == null) return ;
        inOrderList(root.left, result);
        result.add(root.val);
        inOrderList(root.right, result);
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode() {};
     TreeNode(int val) { this.val = val; }
     TreeNode(int val, TreeNode left, TreeNode right) {
         this.val = val;
         this.left = left;
         this.right = right;
     }
 }
