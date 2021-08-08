package leetcodeeveryday;

public class Q0807 {

    public static void main(String[] args) {
        boolean result = new Q0807().circularArrayLoop1(new int[]{1, 2, 3, 4, 5});
        System.out.println(result);
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

    public boolean circularArrayLoop1(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) continue;
            int flag = nums[i] > 0 ? 1 : -1;
            int slow = i, fast = next(nums, i);
            while(nums[slow] * flag > 0 && nums[fast] * flag > 0) {
                if(slow == fast) {
                    if(slow != next(nums, slow)) return true;
                    else break;
                }
                slow = next(nums, slow);
                fast = next(nums, fast);
                if(nums[fast] * flag > 0) fast = next(nums, fast);
                else break;
            }
            slow = i;
            while(nums[slow] * flag > 0) {
                int temp = slow;
                slow = next(nums, slow);
                nums[temp] = 0;
            }
        }
        return false;
    }

    public int next(int[] nums, int cur) {
        int n = nums.length;
        return ((cur + nums[cur]) % n + n) % n;
    }
}
