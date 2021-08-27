package leetcodeQuestion;

public class Q0008 {

    public static void main(String[] args) {
        System.out.println(new Q0008().reverse(-2147483648));
    }

    public int reverse(int x) {
        StringBuffer sb = new StringBuffer(String.valueOf(x));
        String result = "";
        if(sb.charAt(0) == '-') result = '-' + sb.reverse().toString().substring(0, sb.length()-1);
        else result = sb.reverse().toString();

        if(result.charAt(0) == '-') {
            if(result.length() > String.valueOf(Integer.MIN_VALUE).length()) return 0;
            if(result.length() == String.valueOf(Integer.MIN_VALUE).length() &&
            result.compareTo(String.valueOf(Integer.MIN_VALUE)) > 0) return 0;
        } else {
            if(result.length() > String.valueOf(Integer.MAX_VALUE).length()) return 0;
            if(result.length() == String.valueOf(Integer.MAX_VALUE).length() && result.compareTo(String.valueOf(Integer.MAX_VALUE)) > 0) return 0;
        }
        return Integer.parseInt(result);
    }
}
