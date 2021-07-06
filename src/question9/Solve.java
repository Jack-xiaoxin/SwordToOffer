package question9;

public class Solve {

    public static void main(String[] args) {
        char[][] board = {{'C','A','A'},{'A','A','A'},{'B','C','D'}};
//        char[][] board = {{'A', 'B'}};
//        char[][] board = {{'A', 'A'}};
        String word = "AAB";
        System.out.println(exist(board, word));
    }

    public static Boolean exist(char[][] board, String word) {
        if(board == null) return false;
        if(word == null || word.length() == 0) return true;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[i].length; j++) {
                if(board[i][j] == word.charAt(0)){
                    if(digui(board, word, i, j, 1)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static Boolean digui(char[][] board, String word, int i, int j, int index) {
        if(index >= word.length()) return true;
        char target = word.charAt(index);
        char temp = board[i][j];
        board[i][j] = ' ';
        if(i > 0 && board[i-1][j] == target)  if(digui(board, word, i-1, j, index+1)) return true;
        if(i < board.length-1 && board[i+1][j] == target) if(digui(board, word, i+1, j, index+1)) return true;
        if(j > 0 && board[i][j-1] == target) if(digui(board, word, i, j-1, index+1)) return true;
        if(j < board[i].length-1 && board[i][j+1] == target) if(digui(board, word, i, j+1, index+1)) return true;
        board[i][j] = temp;

        return false;
    }
}
