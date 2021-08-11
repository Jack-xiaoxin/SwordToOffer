package question56;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Solve2 {

    //只要数出每个数字间的差值就完事了
    //只要等于4就行
    public boolean isStraight(int[] nums) {
        if(nums.length < 5) return false;
        int gap = 0;
        int count = 0;
        Arrays.sort(nums);
        for(int i = 1; i < nums.length; i++) {
            if(nums[i-1] != 0) gap += nums[i] - nums[i-1];
        }
        return gap <= 4;
    }
}
