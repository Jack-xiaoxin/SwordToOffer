package leetcodeQuestion;

public class Q0005 {

    public static void main(String[] args) {
        System.out.println(new Q0005().longestPalindrome2("aacabdkacaa"));
    }

    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        int resultI = 0, resultJ = 0, max = 0;
        for(int i = 0; i < len; i++) {
            dp[i][i] = true;
            if(i > 0) dp[i][i-1] = true;
            for(int j = i+1; j < len; j++) {
                if(s.charAt(i) == s.charAt(j)) {
                    if(j == i + 1) dp[i][j] = true;
                    else dp[i][j] = dp[i+1][j-1];
                } else dp[i][j] = false;
                if(dp[i][j] && j - i > max) {
                    resultI = i;
                    resultJ = j;
                }
            }
        }
        return s.substring(resultI, resultJ+1);
    }

    //超出了时间限制
    public String longestPalindrome1(String s) {
        if(s == null || s.length() == 0) return "";
        int max = 0, resultI = 0, resultJ = 0;
        for(int i = 0; i < s.length(); i++) {
            for(int j = i; j < s.length(); j++) {
                if(isPalindrome(s.substring(i, j+1)) && j - i > max) {
                    resultI = i;
                    resultJ = j;
                    max = j - i;
                }
            }
        }
        return s.substring(resultI, resultJ+1);
    }

    public boolean isPalindrome(String s) {
        int left = 0, right = s.length()-1;
        while(left <= right) {
            if(s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    //中心扩散法
    public String longestPalindrome2(String s) {
        if(s == null || s.length() == 0) return "";
        int max = 1, resultI = 0, resultJ = 0;
        //从第一个数开始往外扩，直到倒数第二个数为止
        for(int i = 0; i < s.length(); i++) {
            int len1 = panduan(s, i, i);
            int len2 = panduan(s, i, i+1);
            int len = Math.max(len1, len2);
            if(len > max) {
                max = len;
                resultI = i - (len-1) / 2;
                resultJ = resultI + max - 1;
            }
        }
        return s.substring(resultI, resultJ + 1);
    }

    public int panduan(String s, int left, int right) {
        int len = 0;
        while(left >= 0 && right < s.length()) {
            if(s.charAt(left) == s.charAt(right)) len = right - left + 1;
            else break;
            left--;
            right++;
        }
        return len;
    }

    //动态规划
    public String longestPalindrome3(String s) {
        if(s == null || s.length() == 0) return "";
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        //首先确定动态规划的边界条件
        for(int i = 0; i < len; i++) {
            dp[i][i] = true;
            if(i+1 < len && s.charAt(i) == s.charAt(i+1)) dp[i][i+1] = true;
        }
        //开始进行动态规划，因为我们在边界条件中确定了子串长度为1和为2时的情况，所以这里直接从dp[i][i+2]开始判断
        for(int L = 3; L <= len; L++) {
            for(int i = 0; i < len; i++) {
                if(i + L - 1 >= len) break;
                if(s.charAt(i) == s.charAt(i + L - 1)) dp[i][i+L-1] = dp[i+1][i+L-2];
            }
        }
        //找出最长的那个
        int max = 1;
        int resultI = 0, resultJ = 0;
        for(int i = 0; i < len; i++) {
            for(int j = i; j < len; j++) {
                if(dp[i][j] && j - i + 1 > max) {
                    max = j - i + 1;
                    resultI = i;
                    resultJ = j;
                }
            }
        }
        return s.substring(resultI, resultJ+1);
    }

}
