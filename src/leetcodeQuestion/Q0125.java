package leetcodeQuestion;

public class Q0125 {

    public static void main(String[] args) {
        System.out.println(new Q0125().isPalindrome("A man, a plan, a canal: Panama"));
    }

    public boolean isPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if(isAlphabetOrNumber(cur)) {
                if(isUpper(cur)) sb.append((char)(cur+32));
                else sb.append(cur);
            }
        }
        String str1 = sb.toString();
        String str2 = sb.reverse().toString();
        return str1.equals(str2);
    }

    private boolean isAlphabetOrNumber(char ch) {
        if(ch >= 'a' && ch <= 'z') return true;
        else if(ch >= 'A' && ch <= 'Z') return true;
        else if(ch >= '0' && ch <= '9') return true;
        return false;
    }

    private boolean isUpper(char ch) {
        if(ch >= 'A' && ch <= 'Z') return true;
        return false;
    }
}
