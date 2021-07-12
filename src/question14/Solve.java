package question14;

import java.math.BigDecimal;

public class Solve {

    public int[] printNumbers(int n) {
        if(n == 0) return null;
        int num = (int) Math.pow(10, n) - 1;
        int[] result = new int[n+1];
        for(int i = 1; i <= num; i++) {
            result[i-1] = i;
        }
        return result;
    }
}
