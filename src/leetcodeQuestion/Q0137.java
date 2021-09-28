package leetcodeQuestion;

public class Q0137 {

    public static void main(String[] args) {
//        Integer a = 1 << 31;
//        Integer b = -4;
//        System.out.println(Integer.bitCount(b));
//        System.out.println(a & b);
        System.out.println(new Q0137().singleNumber(new int[]{-2,-2,1,1,4,1,4,4,-4,-2}));
    }

    public int singleNumber(int[] nums) {
        int base = 1;
        int result = 0;
        for(int i = 0; i < 32; i++) {
            int count = 0;
            for(int j = 0; j < nums.length; j++) {
                if((nums[j] & (base << i)) != 0) count++;
            }
            result += (base << i) * (count % 3);
        }
        return result;
    }
}
