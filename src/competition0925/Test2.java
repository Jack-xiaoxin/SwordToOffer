package competition0925;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.ArrayList;

public class Test2 {

    int count  = 0;

    public static void main(String[] args) {
        int[] position = {0, 0};
        int[][] terrain = {{0, 0}, {0, 0}};
        int[][] obstacle = {{0, 0}, {0, 0}};
        int[][] result = new Test2().bicycleYard(position, terrain, obstacle);
        for(int[] res : result) {
            System.out.println(Arrays.toString(res));
        }
    }

    public int[][] bicycleYard(int[] position, int[][] terrain, int[][] obstacle) {
        List<int[]> result = new ArrayList<>();
        int[][] visited = new int[terrain.length][terrain[0].length];
        recursion(position, terrain, obstacle, 1, visited, result);
        result.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o1[1];
            }
        });
        result.sort(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[][] res = new int[result.size()][];
        for(int i = 0; i < result.size(); i++) {
            res[i] = result.get(i);
        }
        return res;
    }

    public void recursion(int[] position, int[][] terrain, int[][] obstacle, int speed, int[][] visited, List<int[]> result) {
        //默认按照上下左右的顺序来走
        //往上走
        int x = position[0];
        int y = position[1];
        int maxX = terrain.length;
        int maxY = terrain[0].length;
        visited[x][y] = 1;
        if(speed == 1 && count > 0) result.add(new int[]{x, y});
        if(x > 0 && speed + terrain[x][y] - terrain[x-1][y] - obstacle[x-1][y] > 0 && visited[x-1][y] == 0) {
            position[0] = x-1;
            position[1] = y;
            speed = speed + terrain[x][y] - terrain[x-1][y] - obstacle[x-1][y];
            count += 1;
            recursion(position, terrain, obstacle, speed, visited, result);
        }
        //往左走
        if(y > 0 && speed + terrain[x][y] - terrain[x][y-1] - obstacle[x][y-1] > 0 && visited[x][y-1] == 0) {
            position[0] = x;
            position[1] = y-1;
            speed = speed + terrain[x][y] - terrain[x][y-1] - obstacle[x][y-1];
            recursion(position, terrain, obstacle, speed, visited, result);
        }
        //往下走
        if(x < maxX-1 && speed + terrain[x][y] - terrain[x+1][y] - obstacle[x+1][y] > 0 && visited[x+1][y] == 0) {
            position[0] = x+1;
            position[1] = y;
            speed = speed + terrain[x][y] - terrain[x+1][y] - obstacle[x+1][y];
            recursion(position, terrain, obstacle, speed, visited, result);
        }
        //往右走
        if(y < maxY-1 && speed + terrain[x][y] - terrain[x][y+1] - obstacle[x][y+1] > 0 && visited[x][y+1] == 0) {
            position[0] = x;
            position[1] = y+1;
            speed = speed + terrain[x][y] - terrain[x][y+1] - obstacle[x][y+1];
            recursion(position, terrain, obstacle, speed, visited, result);
        }
    }
}
