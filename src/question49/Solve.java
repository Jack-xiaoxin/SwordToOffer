package question49;

import java.util.List;
import java.util.ArrayList;

public class Solve {

    public int kthLargest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list.get(list.size() - k);
    }

    public void inOrder(TreeNode root, List<Integer> list) {
        if(root != null) {
            inOrder(root.left, list);
            list.add(root.val);
            inOrder(root.right, list);
        }
    }
}

class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;
}
