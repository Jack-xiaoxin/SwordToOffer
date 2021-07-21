package question31;

public class Solve {

    Node pre = null;

    Node head = null;

    Node tail = null;

    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        recur(root);
        head.left = tail;
        tail.right = head;
        return head;
    }

    public void recur(Node root) {
        if(root != null) {
            recur(root.left);
            if(pre == null) head = root;
            else {
                root.left = pre;
                pre.right = root;
            }
            pre = root;
            tail = root;
            recur(root.right);
        }
    }
}

class Node {

    int val;

    Node left;

    Node right;
}