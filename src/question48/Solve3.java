package question48;

public class Solve3 {

    public int findNumber(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > mid) right = mid - 1;
            else if(nums[mid] < mid) left = mid + 1;
            else return mid;
        }
        return -1;
    }
}
