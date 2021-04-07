package leetcode;


/**
 * 36. 有效的数独
 * @author dsx
 */
public class Solution17 {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int k = i / 3 + j / 3 * 3;
                    if (row[i][num] || col[j][num] || block[k][num]) {
                        return false;
                    } else {
                        row[i][num] = true;
                        col[j][num] = true;
                        block[k][num] = true;
                    }
                }
            }
        }
        return true;
    }


//    public boolean isValidSudoku(char[][] board) {
//        int[][] a = new int[9][9];
//        int[][] b = new int[9][9];
//        int[][] c = new int[9][9];
//
//        for (int i = 0; i < 9; i++) {
//            for (int j = 0; j < 9; j++) {
//                if (board[i][j] != 46) {
//                    for (int k = 0; k < j; k++) {
//                        if (board[i][j] == a[i][k]){
//                            return false;
//                        }
//                    }
//                    a[i][j] = board[i][j];
//                    for (int k = 0; k < i; k++) {
//                        if (board[i][j] == b[k][j]) {
//                            return false;
//                        }
//                    }
//                    b[i][j] = board[i][j];
//                    for (int k = i / 3 * 3; k < i / 3 * 3 + 3; k++) {
//                        for (int l = j / 3 * 3; l < j / 3 * 3 + 3; l++) {
//                            if (board[i][j] == c[k][l]) {
//                                return false;
//                            }
//                        }
//                    }
//                    c[i][j] = board[i][j];
//                }
//            }
//        }
//        return true;
//    }
}
