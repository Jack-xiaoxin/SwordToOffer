package question59;

public class Solve {
    public int sumNums(int n) {
        return help(n);
    }

    public int help(int n) {
        int sum = n;
        boolean flag = (n > 0) && (sum += help(n-1)) > 0;
        return sum;
    }
}
