package com.leo.algorithm;

public class MoneyChangeSolution
{
    public static void changeMoney(int money)
    {
        System.out.println("��Ҫ����: " + money);
        int[] moneyLevel =
        { 1, 5, 10, 20, 50, 100 }; // ������Ǯ�ŵ�������
        for (int i = moneyLevel.length - 1; i >= 0; i--)
        { // �ȴ���ֵ����Ǯ��ʼȡ�����μ�С��ֵ
            int num = money / moneyLevel[i]; // ֽ����Ŀ
            int mod = money % moneyLevel[i]; // ʣ���Ǯ
            money = mod;
            if (num > 0)
            { // ��������ֵ��ֽ����Ŀ��Ϊ0
                System.out.println("��Ҫ" + num + "��" + moneyLevel[i] + "���");
            }
        }
    }

    public static void main(String[] args)
    {
        changeMoney(78);
    }
}
