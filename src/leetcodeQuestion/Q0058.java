package leetcodeQuestion;


public class Q0058 {

    public static void main(String[] args) {
        System.out.println(new Q0058().lengthOfLastWord("Hello world   "));
    }

    public int lengthOfLastWord(String s) {
        int len = 0;
        int index = s.length() - 1;
        while(index >= 0 && s.charAt(index) == ' ') index--;
        while(index >= 0 && s.charAt(index) != ' ') {
            index--;
            len++;
        }
        return len;
    }
}
