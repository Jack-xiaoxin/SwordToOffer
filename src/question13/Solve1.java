package question13;

public class Solve1 {

    private int flag = 1;

    public double myPow(double x, int n) {
        if(abs(x) < 0.000000000001 && n < 0) return 0;
        if(n < 0) return 1 / digui(x, -n);
        else return digui(x, n);
    }

    public double digui(double x, int n) {
        if(n == 0) return 1;
        double result = digui(x, n / 2);
        if(n % 2 == 0) return result * result;
        else return result * result * x;
    }

    public double abs(double x) {
        if(x < 0) return -x;
        else return x;
    }
}
