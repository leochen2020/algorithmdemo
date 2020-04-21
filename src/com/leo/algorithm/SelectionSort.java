package com.leo.algorithm;

import java.util.Arrays;

public class SelectionSort
{
    public static String selectionSort(int[] arr)
    {

        for (int i = 0; i < arr.length; i++)
        {
            // ��С��������
            int minIndex = i;
            for (int j = i; j < arr.length; j++)
            {
                // �ҵ���С��������¼��С��������
                if (arr[j] < arr[minIndex])
                {
                    minIndex = j;
                }
            }

            // ����������������
            int tmp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = tmp;
        }

        return Arrays.toString(arr);
    }

    public static void main(String[] args)
    {
        int[] arr =
        { 111, 3, 5, 52, 74, 312, 75, 3, 764, 3, 2111, 7, 31 };
        System.out.println("���������飺" + selectionSort(arr));
    }
}
