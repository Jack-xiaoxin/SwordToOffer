package question44;

import java.util.List;
import java.util.ArrayList;

public class Solve {

    public int nthUglyNumber(int n) {
        if(n <= 0) return 0;
        if(n == 1) return 1;
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0, k = 0;
        list.add(1);
        while(list.size() <= n-1) {
            int temp = Math.min(list.get(i)*2, Math.min(list.get(j)*3, list.get(k)*5));
            if(temp == list.get(i) * 2) i++;
            if(temp == list.get(j) * 3) j++;
            if(temp == list.get(k) * 5) k++;
            list.add(temp);
        }
        return list.get(list.size() - 1);
    }
}
