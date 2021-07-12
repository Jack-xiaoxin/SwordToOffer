package question12;

public class Solve1 {

    public static void main(String[] args) {
        System.out.println(hammingWeight(0b00000000000000000000000010000000));
    }

    public static int hammingWeight(int n) {
        int count = 0;
        int temp = 1;
        //因为不存在-0的说法，所以n=0时，就代表没有1了
        while(n != 0) {
            if((n & temp) == 1) count++;
            //>>>这个连符号位都能移
            n >>>= 1;
        }
        return count;
    }
}
