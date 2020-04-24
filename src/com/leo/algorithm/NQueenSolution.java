package com.leo.algorithm;

import java.util.ArrayList;
import java.util.List;

public class NQueenSolution
{
    int rows[];
    // "mains" diagonals
    int mains[];
    // "secondarys" diagonals
    int secondarys[];
    int n;
    // output
    List<List<String>> output = new ArrayList<List<String>>();
    // queens positions
    int queens[];

    public boolean isNotUnderAttack(int row, int col)
    {
        int res = rows[col] + mains[row - col + n - 1] + secondarys[row + col];
        return (res == 0) ? true : false;
    }

    public void placeQueen(int row, int col)
    {
        queens[row] = col;
        rows[col] = 1;
        mains[row - col + n - 1] = 1;
        secondarys[row + col] = 1;
    }

    public void removeQueen(int row, int col)
    {
        queens[row] = 0;
        rows[col] = 0;
        mains[row - col + n - 1] = 0;
        secondarys[row + col] = 0;
    }

    public void addSolution()
    {
        List<String> solution = new ArrayList<String>();
        for (int i = 0; i < n; ++i)
        {
            int col = queens[i];
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < col; ++j)
                sb.append(".");
            sb.append("Q");
            for (int j = 0; j < n - col - 1; ++j)
                sb.append(".");
            solution.add(sb.toString());
        }
        output.add(solution);
    }

    public void backtrack(int row)
    {
        for (int col = 0; col < n; col++)
        {
            if (isNotUnderAttack(row, col))
            {
                placeQueen(row, col);
                // if n queens are already placed
                if (row + 1 == n)
                    addSolution();
                // if not proceed to place the rest
                else
                    backtrack(row + 1);
                // backtrack
                removeQueen(row, col);
            }
        }
    }

    public List<List<String>> solveNQueens(int n)
    {
        this.n = n;
        rows = new int[n];
        mains = new int[2 * n - 1];
        secondarys = new int[2 * n - 1];
        queens = new int[n];

        backtrack(0);
        return output;
    }

    public static void main(String[] args)
    {
        NQueenSolution s = new NQueenSolution();
        List<List<String>> output = s.solveNQueens(8);
        for (List<String> a : output)
        {
            for (String ss : a)
            {
                System.out.println(ss);
            }
            System.out.println("============");
        }
        System.out.println("There are totally " + output.size() + " solutions");
    }
}
