package fundamental;


public class StringBuilderDemo {

    public static void main(String[] args) {
        //说明，StringBuffer的长度由里面包含的字符串的长度决定，并不是像字符串数组那样的
        StringBuffer sb = new StringBuffer();
        sb.append("123");
        sb.append(456);
        System.out.println(sb.length());
        System.out.println(sb.toString());
    }
}
