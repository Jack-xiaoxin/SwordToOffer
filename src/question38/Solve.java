package question38;

public class Solve {

    public static void main(String[] args) {
        System.out.println(new Solve().countDigitOne(100));
    }

    public int countDigitOne(int n) {
        int count = 0;
        String number = String.valueOf(n);
        for(int i = 0; i < number.length(); i++) {
            count += help(number.substring(0, i), number.substring(i, i+1), number.substring(i+1));
        }
        return count;
    }

    public int help(String left, String cur, String right) {
        int count = 0;
        int curVal = Integer.parseInt(cur);
        if(left.length() == 0 && right.length() == 0) count = curVal >= 1 ? 1 : 0;
        else if(left.length() == 0) count = curVal > 1 ? (int)Math.pow(10, right.length()) : Integer.parseInt(right)+1;
        else if(right.length() == 0) count = curVal >= 1 ? Integer.parseInt(left)+1 : Integer.parseInt(left);
        else {
            count += Integer.parseInt(left) * (int)Math.pow(10, right.length());
            if(curVal == 1) count += Integer.parseInt(right) + 1;
            else if(curVal > 1) count += (int)Math.pow(10, right.length());
        }
        return count;
    }

}
