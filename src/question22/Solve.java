package question22;


import apple.laf.JRSUIUtils;

public class Solve {

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;

        TreeNode A = node1;
        TreeNode B = new TreeNode(3);

        System.out.println(new Solve().isSubStructure(A, B));
    }

    //判断B是不是A的子结构
    public Boolean isSubStructure(TreeNode A,TreeNode B) {
        if(A != null) {
            if(isEqual(A, B)) return true;
            return isSubStructure(A.left, B) || isSubStructure(A.right, B);
        }
        return false;
    }

    //判断两颗树是否相等
    public Boolean isEqual(TreeNode A, TreeNode B) {
        if(A == null && B != null) return false;
        if(A.val == B.val) {
            Boolean result = true;
            if(B.left != null) result =  result && isEqual(A.left, B.left);
            if(B.right != null) result  = result && isEqual(A.right, B.right);
            return result;
        }
        return false;
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
