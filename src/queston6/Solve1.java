package queston6;

public class Solve1 {
    public static void main(String[] args) {
        System.out.println("解法1的结果：" + solve1(5));
        System.out.println("解法2的结果：" + solve2(5));
    }

    //解法1：递归
    //存在重复计算的问题
    public static int solve1(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        return solve1(n-1) + solve1(n-2);
    }

    //解法2：较优
    public static int solve2(int n) {
        int p1 = 0, p2 = 1, p3 = 1;
        if(n <= 0) return p1;
        else if(n == 1) return p2;
        else {
            int k = 2;
            while(k <= n) {
                p3 = (p1 + p2) % 1000000007;
                p1 = p2;
                p2 = p3;
                k++;
            }
        }
        return p3;
    }
}
