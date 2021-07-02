package question7;

import java.util.ArrayList;
import java.util.List;

public class Solve {

    public static void main(String[] args) {
        int[] ages = {11, 22, 11, 12, 5, 123 , 45, 64};
        System.out.println(solve(ages));
    }

    public static List<Integer> solve(int[] ages) {
        int[] countAge = new int[200];
        for(int age : ages) countAge[age]++;
        List<Integer> ageSort = new ArrayList<>();
        for(int i = 0; i < 200; i++) {
            int temp = countAge[i];
            while(temp-- > 0) ageSort.add(i);
        }
        return ageSort;
    }
}
