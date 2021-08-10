package leetcodeeveryday;

public class Q0810 {

    public static void main(String[] args) {
        System.out.println(new Q0810().numberOfArithmeticSlices(new int[]{1, 2, 3, 8, 9, 10}));
    }

    public int numberOfArithmeticSlices(int[] nums) {
        if(nums.length < 2) return 0;
        int count = 0;
        int p1 = 0;
        while(p1 + 2 < nums.length) {
            if(nums[p1] - nums[p1+1] == nums[p1+1] - nums[p1+2]) {
                int p2 = p1 + 2;
                while(p2 < nums.length && nums[p1] - nums[p1+1] == nums[p2-1] - nums[p2] ) p2++;
                count += getCount(p2 - p1);
                p1 = p2;
            } else p1++;
        }
        return count;
    }

    public int getCount(int n) {
        int count = 0;
        int k = 2;
        while(k < n) {
            count += n - k;
            k++;
        }
        return count;
    }
}
