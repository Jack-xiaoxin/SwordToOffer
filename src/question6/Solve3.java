package question6;

public class Solve3 {

    public static void main(String[] args) {
        System.out.println(solve(4));
    }

    public static int solve(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int p1 = 1, p2 = 2, p3 = 0;
        for(int i = 3; i <= n; i++) {
            p3 = p2 + p1;
            p1 = p2;
            p2 = p3;
        }
        return p3;
    }
}
