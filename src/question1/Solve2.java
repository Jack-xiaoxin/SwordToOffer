package question1;

import java.util.HashSet;
import java.util.Set;

public class Solve2 {
    public static void main(String[] args) {
        int[] arr = {1,3,4,2,2};
        System.out.println("solve1的结果是是：" + solve1(arr));
        System.out.println("solve2的结果是是：" + solve2(arr));
    }

    //利用set集合，时间复杂度O(n)，空间复杂度O(n)
    public static int solve1(int[] arr) {
        if(arr == null || arr.length == 0) return -1;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] <1 || arr[i] > arr.length-1) return -1;
            if(set.contains(arr[i])) return arr[i];
            else set.add(arr[i]);
        }
        return -1;
    }

    //不能修改原数组，只能使用O(1)空间，时间复杂度小于O(n^2)
    //那么就使用下面这种二分法吧，时间复杂度为O(n*log2n)
    //解法思路在博客：https://blog.csdn.net/qq_37054755/article/details/114652961
    public static int solve2(int[] arr) {
        //检验数组是否合法
        if(arr == null || arr.length == 0) return -1;
        for(int i = 0; i < arr.length; i++) if(arr[i] < 1 && arr[i] >= arr.length) return -1;

        //开始
        int low = 1, high = arr.length-1;
        while(low < high) {
            int mid = (low+high) / 2;
            int count = countNum(arr, low, mid);
            if(count > mid - low + 1) high = mid;
            else low = mid +1;
        }
        return low;
    }

    public static int countNum(int[] arr, int low, int high) {
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] >= low && arr[i] <= high) count++;
        }
        return count;
    }
}
