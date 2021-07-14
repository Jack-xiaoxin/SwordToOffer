package question16;

public class Solve {

    public static void main(String[] args) {
        String num = "12e+5";
        System.out.println(num + " : " + solve(num));
    }

    public static boolean solve(String num) {
        num = num.trim();
        if(num == null || num.length() == 0) return false;  //为了防止" "的情况
        String num1 = "";
        String num2 = "";
        int index = num.indexOf('e');
        if(index == -1) index = num.indexOf('E');
        if(index == -1) return isZhengShu(num) || isXiaoshu(num);
        else {
            num1 = num.substring(0, index);
            num2 = num.substring(index+1);
            if(num1.length() > 0 && num2.length() > 0)
                return (isZhengShu(num1) || isXiaoshu(num1)) && isZhengShu(num2);
            else return false;
        }
    }

    public static Boolean isZhengShu(String num) {
        if(num.charAt(0) == '-' || num.charAt(0) == '+') num = num.substring(1);
        if(num == null || num.length() == 0) return false;
        for(int i = 0; i < num.length(); i++) {
            if(!(num.charAt(i) >= '0' && num.charAt(i) <= '9')) return false;
        }
        return true;
    }

    public static Boolean isXiaoshu(String num) {
        if(num.charAt(0) == '-' || num.charAt(1) == '+') num = num.substring(1);
        if(num == null || num.length() == 0) return false;
        int count = 0;
        for(int i = 0; i < num.length(); i++) {
            if(num.charAt(i) == '.') count++;
            else if(!(num.charAt(i) >= '0' && num.charAt(i) <= '9')) return false;
        }
        //为了防止"."的情况
        if(count == 1 && num.length() > 0) return true;
        else return false;
    }
}
