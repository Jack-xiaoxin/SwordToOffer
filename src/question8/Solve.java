package question8;

public class Solve {

    public static void main(String[] args) {
        System.out.println(solve(new int[]{3, 1, 3}));
    }

    public static int solve(int[] nums) {
        if(nums == null || nums.length == 0) throw new RuntimeException("输入不合法");
        int right = nums.length - 1;
        int left = 0;

        //删除右边的黑色部分
        while(right >=1 && nums[right] == nums[left]) right--;

        //如果数组已经有序，直接返回第一个
        if(nums[left] <= nums[right]) return nums[left];

        while(left < right) {
            int mid = (left + right) / 2;
            if(nums[mid] <=  nums[right]) right = mid;
            else left = mid + 1;
        }

        return nums[left];
    }
}
