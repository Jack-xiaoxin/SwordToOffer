package question10;

import java.util.LinkedList;
import java.util.Queue;

public class SolveByBFS {

    int count = 0;

    public static void main(String[] args) {
        SolveByBFS solve = new SolveByBFS();
        System.out.println(solve.movingCount(1, 2, 1));
    }

    public int movingCount(int m, int n, int k) {
        if(m < 0 || n < 0) return -1;
        boolean[][] isVisited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});

        while(queue.size() != 0) {
            int[] nowPos = queue.poll();
            int a = nowPos[0];
            int b = nowPos[1];
            if(a >= 0 && a < m && b >= 0 && b < n && getSum(a, b) <= k && !isVisited[a][b]) {
                isVisited[a][b] = true;
                count++;
                int[] dx = {1, -1, 0, 0};
                int[] dy = {0, 0, 1, -1};
                for(int i = 0; i < 4; i++) {
                    int x = a + dx[i];
                    int y = b + dy[i];
                    queue.add(new int[]{x, y});
                }
            }
        }

        return count;

    }

    public int getSum(int x, int y) {
        int sum = 0;
        while(x > 0) {
            sum += x % 10;
            x /= 10;
        }
        while(y > 0) {
            sum += y % 10;
            y /= 10;
        }
        return sum;
    }
}
