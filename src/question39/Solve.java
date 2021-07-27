package question39;

public class Solve {

    public static void main(String[] args) {
        System.out.println(new Solve().findNthDigit(18));
    }

    //多举举两位数的例子就行了
    //要注意，n在int的范围内，但是Math.pow(10, digit-1)有可能超出int的范围，所以要写成num
    //另外Integer.valueof(char)比Integer.parseInt(str)省时
    public int findNthDigit(int n) {
        //先将特例写出来
        if(n <= 9) return n;
        n--;
        //先判断是几位数
        int digit = 1;
        while(n > 9 * (long)Math.pow(10, digit-1) * digit) {
            n -= 9 * (long)Math.pow(10, digit-1) * digit;
            digit++;
        }
        String number = String.valueOf((long)Math.pow(10, digit - 1) + n / digit);
        int count = n % digit;
        return Integer.valueOf(number.charAt(count) - '0');
    }
}
