package queston6;

public class Solve2 {

    public static void main(String[] args) {
        
    }

    public static int solve(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        else return solve(n-1) + solve(n-2);
    }
}
