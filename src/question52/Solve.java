package question52;

public class Solve {

    public int[] twoSum(int[] nums, int target) {

        int p1 = 0, p2 = nums.length - 1;
        while(p1 <= p2) {
            if(nums[p1] + nums[p2] < target) p1++;
            else if(nums[p1] + nums[p2] > target) p2++;
            else return new int[]{nums[p1], nums[p2]};
        }
        return null;
    }
}
