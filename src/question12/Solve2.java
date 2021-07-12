package question12;

public class Solve2 {

    public int hammingWeight(int n) {
        int count = 0;
        while(n != 0) {
            count++;
            //n = n & (n-1) 可以让这个二进制数的最后一个1变成0
            n = n & (n-1);
        }
        return count;
    }
}
