package question56;

import java.util.Arrays;

public class Solve1 {

    public static void main(String[] args) {
        System.out.println(new Solve1().isStraight(new int[]{0, 0, 8, 5, 4}));
    }

    public boolean isStraight(int[] nums) {
        if(nums.length < 5) return false;
        int count = 0;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                count++;
                continue;
            } else if(i - count != 0 ){
                while(nums[i] - nums[i-1] != 1) {
                    if(count > 0) {
                        count--;
                        nums[i-1]++;
                    } else return false;
                }
            }
        }
        return true;
    }
}
