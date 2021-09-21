package leetcodeQuestion;

/**
 * 最大子序和
 */

public class Q0053 {

    public int maxSubArray(int[] nums)  {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if(dp[i-1] >= 0) dp[i] = dp[i-1] + nums[i];
            else dp[i] = nums[i];
            if(dp[i] > max) max = dp[i];
        }
        return max;
    }
}
