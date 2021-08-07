package question54;

import java.util.Arrays;

public class Solve1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solve1().maxSlidingWindow(new int[]{2,3,4,2,6,2,5,1}, 3)));
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0) return new int[0];
        int[] resultIndex = new int[nums.length-k+1];
        int maxInex = getMaxIndex(nums, 0, k-1);
        resultIndex[0] = maxInex;
        for(int i = 1; i < resultIndex.length; i++) {
            //说明最大数滑出了窗口，此时就重新找
            if(maxInex == i-1) maxInex = getMaxIndex(nums, i, k+i-1);
            else if(nums[i+k-1] > nums[maxInex]) maxInex = i+k-1;
            resultIndex[i] = maxInex;
        }
        int[] result = new int[resultIndex.length];
        for(int i = 0; i < resultIndex.length; i++)  result[i] = nums[resultIndex[i]];
        return result;
    }

    public int getMaxIndex(int[] nums, int left, int right) {
        int maxIndex = left;
        for(int i = left; i <= right; i++) {
            if(nums[maxIndex] < nums[i]) maxIndex = i;
        }
        return maxIndex;
    }
}
