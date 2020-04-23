package com.leo.algorithm;

public class MoneyChangeSolution
{
    public static void changeMoney(int money)
    {
        System.out.println("需要找零: " + money);
        int[] moneyLevel =
        { 1, 5, 10, 20, 50, 100 }; // 把所有钱放到数组中
        for (int i = moneyLevel.length - 1; i >= 0; i--)
        { // 先从面值最大的钱开始取，依次减小面值
            int num = money / moneyLevel[i]; // 纸张数目
            int mod = money % moneyLevel[i]; // 剩余的钱
            money = mod;
            if (num > 0)
            { // 如果这个面值的纸张数目不为0
                System.out.println("需要" + num + "张" + moneyLevel[i] + "块的");
            }
        }
    }

    public static void main(String[] args)
    {
        changeMoney(78);
    }
}
