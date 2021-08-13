package question57;

import java.util.List;

import java.util.ArrayList;

public class Solve2 {

    public static void main(String[] args) {
        System.out.println(new Solve2().lastRemaining(5, 3));
    }

    public int lastRemaining(int n, int m) {
        List<Integer> list = new ArrayList<>();
        int index = 0;
        for(int i = 0; i < n; i++) list.add(i);
        while(list.size() != 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }
}
