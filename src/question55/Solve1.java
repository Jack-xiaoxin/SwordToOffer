package question55;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solve1 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solve1().dicesProbability(2)));
    }

    public double[] dicesProbability(int n) {
        if(n <= 0) return new double[0];
        double[][] dp = new double[n+1][6*n+1];
        for(int i = 1; i <= n; i++) {
            for(int j = i; j <= i * 6; j++) {
                if(i == 1) dp[i][j] = 1;
                else {
                    for(int k = 1; k < j && k <= 6; k++) {
                        dp[i][j] += dp[i-1][j-k];
                    }
                }
            }
        }
        for(int i = n; i <= 6*n; i++) {
            dp[n][i] /= Math.pow(6, n);
        }
        return Arrays.copyOfRange(dp[n], n, 6*n);
    }
}
