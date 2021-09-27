package leetcodeQuestion;

import java.util.List;

import java.util.ArrayList;

public class Q0101 {

    public boolean isSymmetric(TreeNode root) {
        List<Integer> inorderList = new ArrayList<>();
        inorder(root, inorderList);
        int len = inorderList.size();
        for(int i = 0; i < inorderList.size(); i++) {
            if(inorderList.get(i) != inorderList.get(len-i-1)) return false;
        }
        return true;
    }

    public void inorder(TreeNode root, List<Integer> inorderList) {
        if(root == null) return;
        inorder(root.left, inorderList);
        inorderList.add(root.val);
        inorder(root.right, inorderList);
    }
}
