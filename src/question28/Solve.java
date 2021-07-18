package question28;

import java.util.Arrays;

public class Solve {

    //对该数组进行排序，可以得到中序遍历的数组
    //然后就看这个后序遍历和中序遍历能不能组成一颗树了
    public boolean verifyPostorder(int[] postorder) {
        int[] inorder = Arrays.copyOf(postorder, postorder.length);
        Arrays.sort(inorder);

        return recur(inorder, postorder, 0, inorder.length-1, 0, postorder.length-1);
    }

    public boolean recur(int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight) {
        if(inLeft > inRight || postLeft > postRight) return true;
        int num = postorder[postRight];
        for(int i = inLeft; i <= inRight; i++) {
            if(inorder[i] == num) {
                return recur(inorder, postorder, inLeft, i-1, postLeft, postLeft+i-inLeft-1)
                        && recur(inorder, postorder, i+1, inRight, postLeft+i-inLeft, postRight-1);
            }
        }
        return false;
    }
}
