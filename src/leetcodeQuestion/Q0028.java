package leetcodeQuestion;

public class Q0028 {

    public static void main(String[] args) {
        System.out.println(new Q0028().strStr("12312356", "35"));
    }

    public int strStr(String haystack, String needle) {
        if(needle.length() == 0) return 0;
        KMP kmp = new KMP(needle);
        return kmp.search(haystack, needle);
    }

}

class KMP {

    int[] next;

    public KMP(String needle) {
        next = new int[needle.length()];
        int j = 0, k = -1;
        next[0] = -1;
        while(j < needle.length()-1) {
            if(k == -1 || needle.charAt(j) == needle.charAt(k)) {
                j++;
                k++;
                next[j] = k;
            } else {
                k = next[k];
            }
        }
    }

    public int search(String haystack, String needle) {
        int i = 0, j = 0;
        while(i < haystack.length() && j < needle.length()) {
            if(j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                i++;
                j++;
            } else {
                j = next[j];
            }
        }
        if(j >= needle.length()) return i - needle.length();
        else return -1;
    }
}
