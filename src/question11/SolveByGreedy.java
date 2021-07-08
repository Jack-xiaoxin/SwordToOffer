package question11;

public class SolveByGreedy {

    //解法：尽量分成3和2的长度，优先分成3的，如果最后是4，分成2*2的，而不是3*1的
    public int cuttingRope(int n) {
        if(n == 2) return 1;
        if(n == 3) return 3;
        int res = 1;
        while(n > 4) {
            n -= 3;
            res *= 3;
        }
        res *= n;
        return res;

    }
}
