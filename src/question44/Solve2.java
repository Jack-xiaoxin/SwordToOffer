package question44;

public class Solve2 {

    public int nthUglyNumber(int n) {
        int[] dp = new int[n+1];
        dp[1] = 1;
        int p1 = 1, p2 = 1, p3 = 1;
        for(int i = 2; i < n+1; i++) {
            dp[i] = Math.max(Math.max(dp[p1]*2, dp[p2]*3), dp[p3]*5);
            if(dp[i] == dp[p1] * 2) p1++;
            //因为会有数字重复，比如6，所以这里不能写成else if，直接写成if即可
            if(dp[i] == dp[p2] * 3) p2++;
            if(dp[i] == dp[p3] * 5) p3++;
        }
        return dp[n];
    }
}
