package com.leo.algorithm;

public class BubbleSort
{
    private void print(int[] arr)
    {
        for (int i : arr)
        {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public void bubbleSort(int[] arr, int n)
    {
        if (n <= 1)
            return; // 如果只有一个元素就不用排序了

        for (int i = 0; i < n; ++i)
        {
            // 提前退出冒泡循环的标志位,即一次比较中没有交换任何元素，这个数组就已经是有序的了
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j)
            { // 此处你可能会疑问的j<n-i-1，因为冒泡是把每轮循环中较大的数飘到后面，
              // 数组下标又是从0开始的，i下标后面已经排序的个数就得多减1，总结就是i增多少，j的循环位置减多少
                if (arr[j] > arr[j + 1])
                { // 即这两个相邻的数是逆序的，交换
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag)
                break;// 没有数据交换，数组已经有序，退出排序
        }
    }

    public static void main(String[] args)
    {
        int[] arr =
        { 2, 4, 7, 6, 8, 5, 9 };
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.print(arr);
        bubbleSort.bubbleSort(arr, arr.length);
        bubbleSort.print(arr);
    }
}
