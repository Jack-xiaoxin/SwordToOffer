package leetcodeeveryday;

public class Q0808 {

    public int tribonacci(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 1;
        int p0 = 0, p1 = 1, p2 = 1;
        int cur = 0;
        while(n >= 3) {
            cur = p0 + p1 + p2;
            p0 = p1;
            p1 = p2;
            p2 = cur;
            n--;
        }
        return cur;
    }
}
