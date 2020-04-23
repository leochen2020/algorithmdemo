package com.leo.algorithm;

import java.util.Arrays;

public class CandySolution
{
    public static int distributeCandy(int[] ratings)
    {
        int sum = 1;
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);

        for (int i = 1; i < ratings.length; i++)
        {
            if (ratings[i] > ratings[i - 1])
            {
                candies[i] = candies[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--)
        {
            if (ratings[i] > ratings[i + 1])
            {
                candies[i] = Math.max(candies[i], candies[i + 1] + 1);
            }
            sum += candies[i];
        }

        return sum;
    }

    public static void main(String[] args)
    {
        int[] ratings =
        { 1, 2, 2 };
        System.out.println(distributeCandy(ratings));
    }

}
