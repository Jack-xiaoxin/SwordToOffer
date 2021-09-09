package leetcodeQuestion;

public class Q0009 {

    public static void main(String[] args) {
        boolean result = new Q0009().isPalindrome(121);
        System.out.println(result);
    }

    public boolean isPalindrome(int x) {
        String A = String.valueOf(x);
        for(int i = 0; i < A.length() / 2; i++) {
            if(A.charAt(i) != A.charAt(A.length() - i - 1)) return false;
        }
        return true;
    }
}
