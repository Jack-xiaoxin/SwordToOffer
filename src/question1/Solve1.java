package question1;

import java.util.*;

public class Solve1 {

    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        System.out.println("solve1的结果：" + solve1(arr));
        System.out.println("solve2的结果：" + solve2(arr));
        System.out.println("solve3的结果：" + solve3(arr));
    }

    //排完序后，重复的元素是相邻的
    public static int solve1(int[] arr) {
        if(arr == null || arr.length == 0) return -1;
        Arrays.sort(arr);
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i-1]) return arr[i];
        }
        return -1;
    }

    //利用集合，当时set中出现前面出现过的元素时，就说明有重复元素了
    public static int solve2(int[] arr) {
        if(arr == null || arr.length == 0) return -1;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i])) return arr[i];
            else set.add(arr[i]);
        }
        return -1;
    }

    //最优解法，详情情况看博客 https://blog.csdn.net/qq_37054755/article/details/114652961
    public static int solve3(int[] arr) {
        if(arr == null || arr.length == 0) return -1;
        for(int i = 0; i < arr.length; i++) {
            while(arr[i] != i) {
                int m = arr[i];
                if(arr[m] == arr[i]) return arr[m];
                else {
                    int temp = arr[i];
                    arr[i] = arr[m];
                    arr[m] = temp;
                }
            }
        }
        return -1;
    }
}
