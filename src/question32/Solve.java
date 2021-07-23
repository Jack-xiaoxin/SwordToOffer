package question32;

import apple.laf.JRSUIUtils;
import com.sun.source.tree.Tree;
import com.sun.tools.javac.util.List;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solve {

    private String seq = "";

    //前序遍历进行序列化
    public String serialize(TreeNode root) {
        if(root != null) {
            seq += "" + root.value + ",";
            serialize(root.left);
            serialize(root.right);
        } else {
            seq += "$,";
        }
        return seq;
    }

    //前序遍历进行反序列化
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        Queue<String> queue = new LinkedList<>();
        queue.addAll(Arrays.asList(data.split(",")));
        return recur(queue);
    }

    public TreeNode recur(Queue<String> queue) {
        if(queue == null || queue.size() == 0) return null;
        String temp = queue.poll();
        if(!temp.equals("$")) {
            TreeNode node = new TreeNode(Integer.parseInt(temp));
            node.left = recur(queue);
            node.right = recur(queue);
            return node;
        } else {
            return null;
        }
    }
}

class TreeNode {
    int value;
    TreeNode left;
    TreeNode right;

    public TreeNode(int val) {
        this.value = val;
    }
}