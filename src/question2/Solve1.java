package question2;

public class Solve1 {

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 8, 9},{2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        System.out.println(solve(arr, 12));
    }

    /**
     * 思路：从右上角开始找，假设右上角的数字为m，如果m>value，删除所在行，如果m<value，删除所在列
     * 当然，从左下角往上找也可以
     */
    public static boolean solve(int[][] arr, int value) {
        if(arr == null || arr.length == 0) return false;
        int row = 0, col = arr[row].length-1;
        while(row < arr.length && col >= 0) {
            if(arr[row][col] > value) col--;
            else if(arr[row][col] < value) row++;
            else return true;
        }
        return false;
    }
}
