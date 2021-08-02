package question48;

import java.util.Arrays;

public class Solve1 {

    public int search(int[] nums, int target) {
        int index = binarySearch(nums, target);
        if (index == -1) return 0;
        int count = 1;
        int left = index - 1, right = index + 1;
        while(left >= 0 && nums[left--] == nums[index]) count++;
        while(right <= nums.length-1 && nums[right++] == nums[index]) count++;
        return count;
    }

    public int binarySearch(int nums[], int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > target) right = mid - 1;
            else if(nums[mid] < target) left = mid + 1;
            else return mid;
        }
        return -1;
    }
}
