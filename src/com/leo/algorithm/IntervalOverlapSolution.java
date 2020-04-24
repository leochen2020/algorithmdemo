package com.leo.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IntervalOverlapSolution
{
    public static List<int[]> eraseOverlapIntervals(int[][] intervals)
    {
        if (intervals.length == 0)
            return new ArrayList<int[]>();

        Arrays.sort(intervals, new Comparator<int[]>()
        {
            public int compare(int[] a, int[] b)
            {
                return a[1] - b[1];
            }
        });

        List<int[]> res = new ArrayList<int[]>(intervals.length);
        int end = intervals[0][1];
        for (int i = 1; i < intervals.length; i++)
        {
            int start = intervals[i][0];
            if (start < end)
            {
                res.add(intervals[i]);
            }
            else
            {
                end = intervals[i][1];
            }
        }

        for (int[] a : res)
        {
            System.out.println(Arrays.toString(a));
        }
        return res;
    }

    public static void main(String[] args)
    {
        int[][] intervals =
        {
                { 1, 2 },
                { 2, 3 },
                { 3, 4 },
                { 1, 3 } };

        eraseOverlapIntervals(intervals);
    }
}
