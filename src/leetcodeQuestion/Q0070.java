package leetcodeQuestion;

public class Q0070 {

    public static void main(String[] args) {
        System.out.println(new Q0070().climbStairs(3));
    }

    public int climbStairs(int n) {
        int n1 = 1, n2 = 2;
        if(n == 1) return n1;
        if(n == 2) return n2;
        int result = 0;
        for(int i = 3; i <= n; i++) {
            result = n1 + n2;
            n1 = n2;
            n2 = result;
        }
        return result;
    }
}
