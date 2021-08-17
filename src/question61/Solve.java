package question61;

import java.util.Arrays;

public class Solve {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solve().constructArr(new int[]{1, 2, 3})));
    }

    public int[] constructArr(int[] a) {
        if(a == null || a.length == 0) return new int[0];
        int[] result = new int[a.length];
        int[] left = new int[a.length], right = new int[a.length];
        left[0] = 1;
        for(int i = 1; i < a.length; i++) {
            left[i] = left[i-1] * a[i-1];
        }
        right[right.length-1] = 1;
        for(int i = right.length - 2; i >= 0; i--) {
            right[i] = right[i+1] * a[i+1];
        }
        for(int i = 0; i < a.length; i++) {
            result[i] = left[i] * right[i];
        }
        return result;
    }
}
