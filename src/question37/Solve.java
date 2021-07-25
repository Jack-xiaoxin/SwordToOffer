package question37;

public class Solve {

    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(i == 0) dp[i] = nums[i];
            else dp[i] = dp[i-1] >= 0 ? dp[i-1]+nums[i] : nums[i];
            if(dp[i] > max) max = dp[i];
        }
        return max;
    }
}
