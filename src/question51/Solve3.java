package question51;

public class Solve3 {

    //花里胡哨的高级写法
    public static void main(String[] args) {
        new Solve3().singleNumber(new int[]{3, 4, 3, 3});
    }

    public int singleNumber(int[] nums) {
        int[] digits = new int[32];
        for(int i = 0; i < nums.length; i++) {
            for(int j = 0; j < digits.length; j++) {
                if(( nums[i] & (1 << j) ) > 0) digits[j]++;
            }
        }
        int result = 0;
        for(int i = 0; i < digits.length; i++) {
            digits[i] %= 3;
            result += 1 << i;
        }
        return result;
    }
}
