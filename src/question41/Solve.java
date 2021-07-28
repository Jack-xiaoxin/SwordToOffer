package question41;

public class Solve {

    public static void main(String[] args) {
        System.out.println(new Solve().translateNum(12258));
    }

    public int translateNum(int num) {
        String str = String.valueOf(num);
        return recur(str);
    }

    public int recur(String str) {
        if(str.length() == 0) return 0;
        if(str.length() == 1) return 1;
        if(str.length() == 2) {
            int temp = Integer.parseInt(str);
            if(temp >= 10 && temp <= 25) return 2;
            else return 1;
        }
        int cur = Integer.parseInt(str.substring(0, 2));
        if(cur >= 10 && cur <= 25) return recur(str.substring(1)) + recur(str.substring(2));
        else return recur(str.substring(1));
    }
}
