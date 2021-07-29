package question42;

public class Solve {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new Solve().maxValue(grid));
    }

    public int maxValue(int[][] grid) {
        int[][] gift = new int[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(i-1 < 0 && j-1 < 0) gift[i][j] = grid[i][j];
                else if(i-1 < 0) gift[i][j] = gift[i][j-1] + grid[i][j];
                else if(j-1 < 0) gift[i][j] = gift[i-1][j] + grid[i][j];
                else gift[i][j] = Math.max(gift[i-1][j], gift[i][j-1]) + grid[i][j];
            }
        }
        return gift[grid.length-1][grid[0].length-1];
    }
}
