package com.leo.algorithm;

import java.util.Arrays;

public class SelectionSort
{
    public static String selectionSort(int[] arr)
    {

        for (int i = 0; i < arr.length; i++)
        {
            // 最小数的索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++)
            {
                // 找到最小数，并记录最小数的索引
                if (arr[j] < arr[minIndex])
                {
                    minIndex = j;
                }
            }

            // 交换符合条件的数
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
        System.out.println("排序后的数组：" + selectionSort(arr));
    }
}
