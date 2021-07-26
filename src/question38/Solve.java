package question38;

public class Solve {

    public static void main(String[] args) {
        System.out.println(new Solve().countDigitOne(13));
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

    }

}
