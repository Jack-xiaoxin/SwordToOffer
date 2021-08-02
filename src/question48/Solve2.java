package question48;

public class Solve2 {

    public int missingNumber(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > mid) right = mid - 1;
            else left = mid + 1;
        }
        return left;
    }
}
