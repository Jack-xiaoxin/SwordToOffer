package question58;

public class Solve1 {

    public int maxProfit(int[] prices)  {
        if(prices == null || prices.length == 0) return 0;
        int max = 0;
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        for(int i = 1; i < prices.length; i++) {
            if(prices[i] - dp[i-1] > max) max = prices[i] - dp[i-1];
            if(prices[i] < dp[i-1]) dp[i] = prices[i];
            else dp[i] = dp[i-1];
        }
        return max;
    }
}
