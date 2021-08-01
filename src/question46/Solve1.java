package question46;

import java.util.Arrays;

public class Solve1 {

    int count = 0;

    public int reversePairs(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        divide(nums, 0, nums.length-1);
        return count;
    }

    public void divide(int[] nums, int left, int right) {
        if(right == left) return ;
        int mid = left + (right - left) / 2;
        divide(nums, left, mid);
        divide(nums, mid, right);
        merge(nums, left, mid, mid +1, right);
    }

    public void merge(int[] nums, int left1, int right1, int left2, int right2) {
        int[] arr1 = Arrays.copyOfRange(nums, left1, right1+1);
        int[] arr2 = Arrays.copyOfRange(nums, left2, right2+1);
        int p1 = arr1.length - 1;
        int p2 = arr2.length - 1;
        int p3 = right2;
        while(p1 >= 0 && p2 >= 0) {
            if(arr1[p1] > arr2[p2]) {
                count += p2 + 1;
                nums[p3--] = arr1[p1--];
            } else nums[p3--] = arr2[p2--];
        }
        while(p1 >= 0) nums[p3--] = arr1[p1--];
        while(p2 >= 0) nums[p3--] = arr2[p2--];
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
