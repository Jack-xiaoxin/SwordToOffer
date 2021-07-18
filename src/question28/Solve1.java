package question28;

public class Solve1 {

    //解法思路：根据左右中的后序遍历原则，最后一个元素会把数组序列分成两部分，一部分都大于它，一部分都小于它
    //按照这个特点去写代码
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length-1);
    }

    public boolean recur(int[] postorder, int left, int right) {
        if(left > right) return true;
        int root = postorder[right];
        int index = left;
        for(; index <= right; index++) {
            if(postorder[index] > root) break;
        }
        for(int i = index; i <= right; i++) {
            if(postorder[i] < root) return false;
        }
        return recur(postorder, left, index-1) && recur(postorder, index, right-1);
    }
}
