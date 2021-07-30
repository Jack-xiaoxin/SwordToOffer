package question43;

public class Solve {

    public static void main(String[] args) {
        System.out.println(new Solve().lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;

        StringBuilder sb = new StringBuilder();
        int[] dp = new int[s.length()];

        sb.append(s.charAt(0));
        dp[0]++;
        int max = 0;

        for(int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            int pos = sb.indexOf(""+cur);
            if(pos < 0) {
                sb.append(""+cur);
                dp[i] = sb.length();
            } else {
                sb.replace(0, pos+1, "");
                sb.append(""+cur);
                dp[i] = sb.length();
            }
            if(dp[i] > max) max = dp[i];
        }

        return max;
    }
}
