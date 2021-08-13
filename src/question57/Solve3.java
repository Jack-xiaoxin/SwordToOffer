package question57;

public class Solve3 {

    public static void main(String[] args) {
        System.out.println(new Solve3().lastRemaining(5, 3));
    }

    public int lastRemaining(int n, int m) {
        int[] f = new int[n];
        f[0] = 0;
        for(int i = 1; i < n; i++) f[i] = (f[i-1] + m) % (i+1);
        return f[n-1];
    }
}
