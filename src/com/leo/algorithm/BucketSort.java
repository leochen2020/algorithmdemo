package com.leo.algorithm;

import java.util.ArrayList;
import java.util.Collections;

public class BucketSort
{
    public static void bucketSort(int[] arr)
    {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++)
        {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        // Ͱ��
        int bucketNum = (max - min) / arr.length + 1;
        ArrayList<ArrayList<Integer>> bucketArr = new ArrayList<>(bucketNum);
        for (int i = 0; i < bucketNum; i++)
        {
            bucketArr.add(new ArrayList<Integer>());
        }

        // ��ÿ��Ԫ�ط���Ͱ
        for (int i = 0; i < arr.length; i++)
        {
            int num = (arr[i] - min) / (arr.length);
            bucketArr.get(num).add(arr[i]);
        }

        // ��ÿ��Ͱ��������
        for (int i = 0; i < bucketArr.size(); i++)
        {
            Collections.sort(bucketArr.get(i));
        }

        System.out.println(bucketArr.toString());

    }

    public static void main(String[] args)
    {
        int[] array =
        { 11, 6, 4, 1, 2, 3, 7, 9, 10 };
        bucketSort(array);
    }
}