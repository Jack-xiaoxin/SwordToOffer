package leetcodeQuestion;

public class Q0190 {

    public int reverseBits(int n) {
        int result = 0;
        int base = 1;
        for(int i = 0; i < 32; i++) {
            if((n & (base << i) ) == 0) {
                //这一位是0，把它反成1
                result += base << i;
            }
        }
        return result;
    }
}
