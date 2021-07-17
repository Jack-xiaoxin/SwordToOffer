package question24;

public class Solve {

    public static void main(String[] args) {
        System.out.println(new Solve().spiralOrder(new int[3][3]));
    }

    //解题思路：按照右、下、左、上的方向来走，然后不断缩小边界，一旦发现上>下，或者左>右边界，立即停止遍历。
    public int[] spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return null;
        int[] result = new int[matrix.length * matrix[0].length];
        int index = 0;

        int up = 0, down = matrix.length-1, left = 0, right = matrix[left].length-1;
        while(up <= down || left <= right) {
            //往右
            if(left <= right) {
                for(int j = left; j <= right; j++) result[index++] = matrix[up][j];
                up++;
            } else break;
            //往下
            if(up <= down) {
                for(int i = up; i <= down; i++) result[index++] = matrix[i][right];
                right--;
            } else break;
            //往左
            if(left <= right) {
                for(int j = right; j >= left; j--) result[index++] = matrix[down][j];
                down--;
            } else break;
            //往上
            if(up <= down) {
                for(int i = down; i >= up; i--) result[index++] = matrix[i][left];
                left++;
            } else break;
        }
        return result;
    }
}
