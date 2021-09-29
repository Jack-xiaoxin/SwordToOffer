package leetcodeQuestion;

public class Q0191 {

    public int hammingWeight(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++) {
            if(((1 << i) & n) != 0) result++;
        }
        return result;
    }
}
