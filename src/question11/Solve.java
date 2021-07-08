package question11;

public class Solve {

    public int cuttingRope(int n) {
        if(n == 2) return 1;
        if(n == 3) return 2;
        int[] dp = new int[n+1];
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4; i <= n; i++) {
            int max = 0;
            for(int j = 2; j <= i/2; j++) {
                if(max < dp[j] * dp[i-j]) max = dp[j] * dp[i-j];
            }
            dp[i] = max;
        }
        return dp[n];
    }

}
