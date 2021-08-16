package question60;

public class Solve {

    public static void main(String[] args) {
        System.out.println(new Solve().add(1, 2));
    }

    public int add(int a, int b) {
        int sum = 0;
        do {
            sum = a ^ b;
            a = (a & b) << 1;
            b = sum;
        } while(a != 0);
        return sum;
    }
}
