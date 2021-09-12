package leetcodeQuestion;

public class Q0014 {

    public static void main(String[] args) {
        String[] strs = new String[2];
        strs[0] = "cir";
        strs[1] = "car";
        System.out.println(new Q0014().longestCommonPrefix(strs));
    }

    public String longestCommonPrefix(String[] strs) {
        String result = strs[0];
        for(int i = 1; i < strs.length; i++) {
            result = help(result, strs[i]);
        }
        return result;
    }

    public String help(String a, String b) {
        int num = 0;
        for(int i = 0, j = 0; i < a.length() & j < b.length(); i++, j++) {
            if(a.charAt(i) == b.charAt(j)) num++;
            else break;
        }
        return a.substring(0, num);
    }
}
