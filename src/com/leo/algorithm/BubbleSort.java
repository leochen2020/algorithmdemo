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
            return; // ���ֻ��һ��Ԫ�ؾͲ���������

        for (int i = 0; i < n; ++i)
        {
            // ��ǰ�˳�ð��ѭ���ı�־λ,��һ�αȽ���û�н����κ�Ԫ�أ����������Ѿ����������
            boolean flag = false;
            for (int j = 0; j < n - i - 1; ++j)
            { // �˴�����ܻ����ʵ�j<n-i-1����Ϊð���ǰ�ÿ��ѭ���нϴ����Ʈ�����棬
              // �����±����Ǵ�0��ʼ�ģ�i�±�����Ѿ�����ĸ����͵ö��1���ܽ����i�����٣�j��ѭ��λ�ü�����
                if (arr[j] > arr[j + 1])
                { // �����������ڵ���������ģ�����
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    flag = true;
                }
            }
            if (!flag)
                break;// û�����ݽ����������Ѿ������˳�����
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
