package question42;

public class Solve2 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(new Solve2().maxValue(grid));
    }

    public int maxValue(int[][] grid) {
        int[] gift = new int[grid[0].length];
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(i == 0 && j == 0) gift[j] = grid[i][j];
                else if(i == 0) gift[j] = gift[j-1] + grid[i][j];
                else if(j == 0) gift[j] = gift[j] + grid[i][j];
                else gift[j] = Math.max(gift[j], gift[j-1]) + grid[i][j];
            }
        }
        return gift[grid[0].length-1];
    }
}
