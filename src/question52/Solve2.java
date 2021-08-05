package question52;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solve2 {

    public static void main(String[] args) {
        new Solve2().findContinuousSequence(9);
    }

    public int[][] findContinuousSequence(int target) {
        List<int[]> list = new ArrayList<>();
        int p1 = 1, p2 = 2, cur = p1 + p2;
        while(p2 <= target / 2 + 1) {
            if(cur < target) cur += ++p2;
            else if(cur > target) cur -= p1++;
            else {
                int[] temp = new int[p2-p1+1];
                for(int i = 0; i < temp.length; i++) temp[i] = p1 + i;
                list.add(temp);
                cur -= p1++;
            }
        }
        int[][] result = new int[list.size()][];
        for(int i = 0; i < result.length; i++) result[i] = list.get(i);
        return result;
    }
}
