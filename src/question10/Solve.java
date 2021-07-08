package question10;

public class Solve {

    public static void main(String[] args) {
        System.out.println(movingCount(16,8,4));
    }

    public static int movingCount(int m, int n, int k) {

        int count = 0;
        int[][] map = new int[m][n];

        count = digui(map, 0, 0, k );
        return count;
    }

    public static int digui(int[][] map, int i, int j, int k) {
        if(getSum(i, j) > k) return 0;
        if(i>=0 && i <= map.length-1 && j >=0 && j <=map[i].length-1 && map[i][j] != 1) {
            map[i][j] = 1;
            return 1 + digui(map, i - 1, j, k)
                    + digui(map, i+1, j, k)
                    +digui(map, i, j-1, k)
                    +digui(map, i, j+1, k);
        }
        return 0;
    }

    public static int getSum(int i, int j) {
        int temp = 0;
        while(i != 0) {
            temp += i % 10;
            i /= 10;
        }
        while(j != 0) {
            temp += j % 10;
            j /= 10;
        }
        return temp;
    }
}
