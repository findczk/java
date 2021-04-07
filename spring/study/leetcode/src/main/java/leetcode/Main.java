package leetcode;

import java.util.*;

public class Main {

    public static void main(String[] arg) {
        Scanner sc = new Scanner(System.in);
        int[][] board = new int[9][9];
        while (sc.hasNext()) {
            for (int i = 0; i < 9; i++)
            {
                for (int j = 0; j < 9; j++)
                {
                    board[i][j] = sc.nextInt();
                }
            }
        }
        Main main = new Main();
        main.solveSudoku(board);

        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }


    //用于记录还有几个空格
    int count = 0;
    //用于记录没有被使用的数字，false表示未被使用
    boolean[][] col = new boolean[9][9];
    boolean[][] row = new boolean[9][9];
    boolean[][] block = new boolean[9][9];

    public void solveSudoku(int[][] board) {
        //初始化已经使用的数字
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != 0) {
                    int num = board[i][j];
                    int k = i / 3 * 3 + j / 3;
                    col[i][num] = true;
                    row[j][num] = true;
                    block[k][num] = true;
                }else {
                    count++;
                }
            }
        }

        solveSudoku(board, 0, 0);
    }

    private void solveSudoku(int[][] board,int i,int j) {
        if (count == 0) {
            return;
        }

        if (board[i][j] != 0){
            if (j + 1 < 9) {
                solveSudoku(board, i, j + 1);
            }else {
                solveSudoku(board, i + 1, 0);
            }
        }else {
            int k = i / 3 * 3 + j / 3;
            //循环找到一个未被使用的数字
            for (int l = 0; l < 9; l++) {
                if (count > 0 && !col[i][l] && !row[j][l] && !block[k][l]) {
                    count--;
                    board[i][j] = l;
                    col[i][l] = true;
                    row[j][l] = true;
                    block[k][l] = true;
                    if (j + 1 < 9) {
                        solveSudoku(board, i, j + 1);
                    } else {
                        solveSudoku(board, i + 1, 0);
                    }
                    if (count > 0) {
                        count++;
                        board[i][j] = 0;
                        col[i][l] = false;
                        row[j][l] = false;
                        block[k][l] = false;
                    }
                }
            }
        }
    }


}
