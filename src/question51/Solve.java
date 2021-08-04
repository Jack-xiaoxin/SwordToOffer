package question51;

public class Solve {

    public static void main(String[] args) {
        new Solve().singleNumbers(new int[]{1, 2, 5 ,2});
    }

    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for(int i = 0; i < nums.length; i++) ret ^= nums[i];
        int digit = 1;
        while((ret & digit) == 0) digit <<= 1;
        int a = 0, b = 0;
        for(int i = 0; i < nums.length; i++) {
            if((nums[i] & digit) > 0) a ^= nums[i];
            else b ^= nums[i];
        }
        return new int[]{a, b};
    }
}
