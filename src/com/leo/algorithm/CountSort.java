package com.leo.algorithm;

import java.util.Arrays;

public class CountSort
{
    public static void main(String[] args)
    {
        int[] array =
        { 95, 94, 91, 98, 99, 90, 99, 93, 91, 92 };
        int[] sortedArray = countSort(array);
        System.out.println(Arrays.toString(sortedArray));
    }

    private static int[] countSort(int[] arr)
    {
        int max = arr[0];
        int min = arr[0];
        // �ҳ������е������Сֵ
        for (int i = 0; i < arr.length; i++)
        {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        // ����ͳ�����鲢ͳ�ƶ�Ӧ��Ԫ�ظ���
        int[] help = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++)
        {
            help[arr[i] - min]++;
        }
        // ͳ�����������Σ���ߵ�Ԫ�ص���ǰ���Ԫ��֮��
        for (int i = 1; i < help.length; i++)
        {
            help[i] += help[i - 1];
        }
        // �������ԭʼ���飬��ͳ���������ҵ���ȷ��λ�ã�������������
        int[] res = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--)
        {
            // ��sortedArray�ĵ�ǰλ�ø�ֵ
            res[help[arr[i] - min] - 1] = arr[i];
            // ��countArray��λ�õ�ֵ--
            help[arr[i] - min]--;
        }
        return res;
    }
}
