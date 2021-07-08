package question10;

public class SolveByDFS {

    private int count = 0;

    public int movingCount (int m, int n, int k) {
        if(m < 0 || n < 0) return -1;
        boolean[][] isVisited = new boolean[m][n];
        dfs(m, n, k, isVisited, 0, 0);
        return count;
    }

    public void dfs(int m, int n, int k, boolean[][] isVisited, int x, int y) {
        //坐标越界或已经访问过
        if(x < 0 || x >= m || y < 0 || y >= n || isVisited[x][y]) return ;
        isVisited[x][y] = true;  //标记该坐标访问过了

        //当已经确认机器人可以进入该坐标之后，才需要从这个坐标向四个方向扩散
        if(getSum(x, y) <= k) {
            count++;
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            for(int i = 0; i < 4; i++) {
                int a = x + dx[i];
                int b = y + dy[i];
                dfs(m, n, k, isVisited, a, b);
            }
        } else return ;
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
