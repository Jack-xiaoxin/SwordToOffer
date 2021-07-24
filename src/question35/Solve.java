package question35;

import java.util.Arrays;

public class Solve {

    //解法一：直接排序
    public int[] getLeastNumbers(int[] arr, int k) {
        if(arr == null || arr.length == 0 || k <= 0) return new int[0];
        Arrays.sort(arr);
        int[] result = new int[k];
        for(int i = 0; i < k; i++) {
            result[i] = arr[i];
        }
        return result;
    }
}
