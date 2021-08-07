package leetcodeeveryday;

public class Q0807 {

    public static void main(String[] args) {
        new Q0807().circularArrayLoop(new int[]{-1, -2, -3, -4, -5});
    }

    public boolean circularArrayLoop(int[] nums) {
        int sum = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++) {
            int index = i;
            int flag = nums[index] > 0 ? 1 : -1;
            while(nums[index] != 0) {
                if(flag * nums[index] < 0) break;
                if(Math.abs(nums[index]) > 1000){
                    if(nums[index] % nums.length == 0) {
                        nums[index] = 0;
                        break;
                    } else return true;
                }
                int temp = nums[index];
                nums[index] += nums.length * 1001 * flag;
                index = (((index + temp) % nums.length) + nums.length) % nums.length;
            }
            if(flag * nums[index] < 0) {
                index = i;
                while(flag * nums[index] > 0) {
                    int temp = nums[index];
                    nums[index] = 0;
                    index = (((index + temp) % nums.length) + nums.length) % nums.length;
                }
            } else if(nums[index] == 0) {
                index = i;
                while(nums[index] != 0) {
                    int temp = nums[index];
                    nums[index] = 0;
                    index = (((index + temp) % nums.length) + nums.length) % nums.length;
                }
            }
        }
        return false;
    }
}
