package com.leo.algorithm;

public class CoinChange
{
    public int change(int amount, int[] coins)
    {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++)
        {
            for (int j = 0; j < amount + 1; j++)
            {
                if (j - coins[i] >= 0)
                {
                    dp[j] += dp[j - coins[i]];
                }
            }
        }
        return dp[amount];
    }

    public static void main(String[] args)
    {
        int amount = 23;
        int[] coins =
        { 1, 2, 3, 5 };
        CoinChange test = new CoinChange();
        System.out.println(test.change(amount, coins));
    }
}
