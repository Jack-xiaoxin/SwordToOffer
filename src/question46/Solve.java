package question46;

public class Solve {

    //这么写超时了
    public int reversePairs(int[] nums) {
        int count = 0;
        if(nums == null || nums.length == 0) return 0;
        for(int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            for(int j = i+1; j < nums.length; j++) {
                if(temp > nums[j]) count++;
            }
        }
        return count;
    }
}
