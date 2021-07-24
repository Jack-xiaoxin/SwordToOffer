package question34;

public class Solve {

    public int majorityElement(int[] nums) {
        //先验证一下
        if(nums == null || nums.length == 0) return -1;
        //初始化为第一个数
        int cnt = 1;
        int number = nums[0];
        //如果数字相同，cnt+1，如果不同，数字减1，如果cnt为0，重新初始化
        for(int i = 1; i < nums.length; i++) {
            if(cnt == 0) {
                number = nums[i];
                cnt++;
            } else if(number == nums[i]) cnt++;
            else cnt--;
        }
        //验证number是不是次数超过一半的数
        cnt = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == number) cnt++;
        }
        if(cnt > nums.length) return number;
        else throw new RuntimeException("这个数不存在");
    }
}
