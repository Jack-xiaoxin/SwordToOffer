package leetcodeeveryday;

public class Q0811 {

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int i = n-1; i >= 0; i++) {
            dp[i][i] = 1;
            char chari = s.charAt(i);
            for(int j = i+1; j < n; j++) {
                char charj = s.charAt(j);
                if(chari == charj) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][n];
    }
}
