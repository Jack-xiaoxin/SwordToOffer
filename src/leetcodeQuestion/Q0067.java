package leetcodeQuestion;

public class Q0067 {

    public static void main(String[] args) {
        System.out.println(new Q0067().addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while(i >= 0 && j >= 0) {
            int x1 = a.charAt(i--) - '0', x2 = b.charAt(j--) - '0';
            sb.append((x1 + x2 + carry) % 2);
            carry = (x1 + x2 + carry) / 2;
        }
        while(i >= 0) {
            int x = a.charAt(i--) - '0';
            sb.append((x + carry) % 2);
            carry = (x + carry) / 2;
        }

        while(j >= 0) {
            int x = b.charAt(j--) - '0';
            sb.append((x + carry) % 2);
            carry = (x + carry) / 2;
        }

        if(carry != 0) sb.append(carry);

        return sb.reverse().toString();
    }
}
