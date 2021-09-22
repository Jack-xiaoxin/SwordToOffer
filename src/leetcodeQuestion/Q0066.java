package leetcodeQuestion;

import java.util.Arrays;

public class Q0066 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q0066().plusOne(new int[]{9})));
    }

    public int[] plusOne(int[] digits) {
        int[] result = new int[digits.length+1];
        int carry = 0;
        int index = 0;
        for(int i = digits.length-1; i >= 0; i--) {
            if(i == digits.length-1) {
                result[index++] = (carry + digits[i] + 1) % 10;
                carry = (carry + digits[i] + 1) / 10;
            }
            else {
                result[index++] = (carry + digits[i]) % 10;
                carry = (carry + digits[i]) / 10;
            }
        }
        if(carry > 0) result[index++] = carry;
        if(result[result.length-1] == 0) result = Arrays.copyOfRange(result, 0, result.length-1);
        for(int i = 0; i < result.length/2; i++) {
            int temp = result[i];
            result[i] = result[result.length-i-1];
            result[result.length-i-1] = temp;
        }
        return result;
    }
}
