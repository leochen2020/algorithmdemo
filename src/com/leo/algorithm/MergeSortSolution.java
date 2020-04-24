package com.leo.algorithm;

import java.util.Arrays;

public class MergeSortSolution
{
    public static int countInversePairs(int[] sequence)
    {
        int len = sequence.length;

        if (len < 2)
            return 0;

        int[] copy = Arrays.copyOf(sequence, sequence.length);
        System.out.println("Copied sequence: " + Arrays.toString(copy));

        int[] helper = new int[len];
        return countInversePairs(copy, 0, len - 1, helper);
    }

    private static int countInversePairs(int[] mergedSequence, int left, int right, int[] helper)
    {
        if (left == right)
            return 0;

        int mid = left + ((right - left) >> 1);
        int leftCount = countInversePairs(mergedSequence, left, mid, helper);
        int rightCount = countInversePairs(mergedSequence, mid + 1, right, helper);
        if (mergedSequence[mid] <= mergedSequence[mid + 1])
        {
            return leftCount + rightCount;
        }
        int crossCount = mergeSortAndCount(mergedSequence, left, mid, right, helper);

        return leftCount + rightCount + crossCount;
    }

    private static int mergeSortAndCount(int[] mergedSequence, int left, int mid, int right,
            int[] helper)
    {
        for (int i = left; i <= right; i++)
        {
            helper[i] = mergedSequence[i];
        }

        int i = left;
        int j = mid + 1;

        int count = 0;
        for (int k = left; k <= right; k++)
        {
            if (i == mid + 1 && j <= right)
            {
                mergedSequence[k] = helper[j];
                j++;
            }
            else if (j == right + 1 && i < mid + 1)
            {
                mergedSequence[k] = helper[i];
                i++;
            }
            else if (helper[i] <= helper[j])
            {
                mergedSequence[k] = helper[i];
                i++;
            }
            else
            {
                mergedSequence[k] = helper[j];
                j++;
                count += (mid - i + 1);
            }
        }
        return count;
    }

    public static void main(String[] args)
    {
        int[] sequence =
        { 7, 5, 6, 4 };
        System.out.println(countInversePairs(sequence));
    }
}
