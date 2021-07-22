package Question31;

import com.sun.source.tree.Tree;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;

public class Solve {

    public static String preSeq = "";

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;

        Serialize(node1);
        System.out.println(preSeq);
        TreeNode root = Deserialize(preSeq);
        System.out.println("123");
    }

    public static String Serialize(TreeNode root) {
        if(root != null) {
            preSeq += "" + root.value + ",";
            Serialize(root.left);
            Serialize(root.right);
        } else {
            preSeq += "$,";
        }
        return preSeq;
    }

    public static TreeNode Deserialize(String data) {
        if(data == null || data.length() == 0) return null;
        Queue<String> queue = new LinkedList<>();
        for(String str : data.split(","))
            queue.offer(str);
        return help(queue);
    }

    public static TreeNode help(Queue<String> queue) {
        if(queue.isEmpty()) return null;
        String str = queue.poll();
        if(!str.equals("$")) {
            int number = Integer.parseInt(str);
            TreeNode root = new TreeNode(number);
            root.left = help(queue);
            root.right = help(queue);
            return root;
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