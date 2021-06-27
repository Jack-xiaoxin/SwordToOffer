package question3;

public class Solve1 {

    public static void main(String[] args) {
        String str = "we are happy";
        System.out.println("solve1的解法：" + solve1(str));
        System.out.println("solve2的解法：" + solve2(str));
    }

    //1、解法1：暴力解
    public static String solve1(String str) {
        if(str == null || str.length() == 0) return " ";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') sb.append("%20");
            else sb.append(str.charAt(i));
        }
        return sb.toString();
    }

    //2、解法2：从后往前遍历，O(1)做法
    public static String solve2(String str) {
        if(str == null || str.length() == 0) return "";
        StringBuilder sb = new StringBuilder(str);
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) == ' ') sb.append("  ");
        }
        int p1 = str.length() - 1, p2 = sb.length() - 1;
        while(p1 <= p2 && p1 >= 0) {
            if(str.charAt(p1) == ' ') {
                sb.setCharAt(p2--, '0');
                sb.setCharAt(p2--, '2');
                sb.setCharAt(p2--, '%');
                p1--;
            } else {
                sb.setCharAt(p2--, str.charAt(p1--));
            }
        }
        return sb.toString();
    }


}
