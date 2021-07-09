package question12;

public class Solve1 {

    public static void main(String[] args) {
        System.out.println(hammingWeight(0b00000000000000000000000010000000));
    }

    public static int hammingWeight(int n) {
        int count = 0;
        int temp = 1;
        while(n != 0) {
            if((n & temp) == 1) count++;
            n >>>= 1;
        }
        return count;
    }
}
