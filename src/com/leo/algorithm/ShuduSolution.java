package com.leo.algorithm;

public class ShuduSolution
{
    public static boolean isValidSudoku(char[][] board)
    {
        int[][] rows = new int[9][10];// 哈希表存储每一行的每个数是否出现过，默认初始情况下，每一行每一个数都没有出现过
        // 整个board有9行，第二维的维数10是为了让下标有9，和数独中的数字9对应。
        int[][] cols = new int[9][10];// 存储每一列的每个数是否出现过，默认初始情况下，每一列的每一个数都没有出现过
        int[][] boxes = new int[9][10];// 存储每一个box的每个数是否出现过，默认初始情况下，在每个box中，每个数都没有出现过。整个board有9个box。
        for (int i = 0; i < 9; i++)
        {
            for (int j = 0; j < 9; j++)
            {
                // 遍历到第i行第j列的那个数,我们要判断这个数在其所在的行有没有出现过，
                // 同时判断这个数在其所在的列有没有出现过
                // 同时判断这个数在其所在的box中有没有出现过
                if (board[i][j] == '.')
                    continue;
                int num = board[i][j] - '0';
                rows[i][num]++;
                cols[j][num]++;
                boxes[(i / 3) * 3 + j / 3][num]++;
                if (rows[i][num] + cols[j][num] + boxes[(i / 3) * 3 + j / 3][num] > 3)
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        char[][] board =
        {
                { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' },
                { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' },
                { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' },
                { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' },
                { '4', '.', '.', '.', '8', '.', '.', '7', '9' } };
        System.out.println(isValidSudoku(board));
    }
}
