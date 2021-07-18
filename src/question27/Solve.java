package question27;

import java.util.*;

public class Solve {

    //解法：树的层序遍历，用队列来做就可以
    public int[] levelOrder(TreeNode root) {
        if(root == null) return new int[0];
        List<Integer> resultList = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            TreeNode temp = queue.poll();
            resultList.add(temp.val);
            if(temp.left != null) queue.add(temp.left);
            if(temp.right != null) queue.add(temp.right);
        }
        int[] result = new int[resultList.size()];
        for(int i = 0; i < result.length; i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
}
