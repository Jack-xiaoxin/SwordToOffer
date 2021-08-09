package question55;

import java.util.Arrays;

public class Solve {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solve().dicesProbability(2)));
    }

    public double[] dicesProbability(int n) {
        int[] nums = new int[6 * n + 1];
        help(1, 0, nums, n);
        double[] result = new double[5*n+1];
        for(int i = n; i <= 6 * n; i++) {
            result[i-n] = nums[i] / Math.pow(6, n);
        }
        return result;
    }

    public void help(int n, int count, int[] nums, int k) {
        if(n > k) return ;
        for(int i = 1; i <= 6; i++) {
            if(n == k) nums[count+i]++;
            help(n+1, count+i, nums, k);
        }
    }
}
