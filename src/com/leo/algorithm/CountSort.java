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
        // 找出数组中的最大最小值
        for (int i = 0; i < arr.length; i++)
        {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        // 创建统计数组并统计对应的元素个数
        int[] help = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++)
        {
            help[arr[i] - min]++;
        }
        // 统计数组做变形，后边的元素等于前面的元素之和
        for (int i = 1; i < help.length; i++)
        {
            help[i] += help[i - 1];
        }
        // 倒序遍历原始数组，从统计数组中找到正确的位置，输出到结果数组
        int[] res = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--)
        {
            // 给sortedArray的当前位置赋值
            res[help[arr[i] - min] - 1] = arr[i];
            // 给countArray的位置的值--
            help[arr[i] - min]--;
        }
        return res;
    }
}
