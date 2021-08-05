package question53;

public class Solve2 {

    public static void main(String[] args) {
        System.out.println(new Solve2().reverseLeftWords("abcdefg", 2)); //cdefgab

        // abcdefg  gfedcba
    }

    public String reverseLeftWords(String s, int n) {
        char[] chars = s.toCharArray();
        rotate(chars, 0, chars.length-1);
        rotate(chars, 0, chars.length-n-1);
        rotate(chars, chars.length-n, chars.length-1);
        return String.valueOf(chars);
    }

    public void rotate(char[] chars, int left, int right) {
        while(left <= right) {
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
