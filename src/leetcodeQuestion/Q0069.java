package leetcodeQuestion;

public class Q0069 {



    public int mySqrt(int x) {
        int i = 0;
        while(i * i < x) i++;
        if(i*i == x) return i;
        else return i-1;
    }
}
