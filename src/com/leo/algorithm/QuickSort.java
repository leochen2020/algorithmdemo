package com.leo.algorithm;

public class QuickSort
{
    /**
     * ��������
     * 
     * @param array
     */
    public static void quickSort(int[] array)
    {
        int len;
        if (array == null || (len = array.length) == 0 || len == 1)
        {
            return;
        }
        sort(array, 0, len - 1);
    }

    /**
     * ���ź����㷨���ݹ�ʵ��
     * 
     * @param array
     * @param left
     * @param right
     */
    public static void sort(int[] array, int left, int right)
    {
        if (left > right)
        {
            return;
        }
        // base�д�Ż�׼��
        int base = array[left];
        int i = left, j = right;
        while (i != j)
        {
            // ˳�����Ҫ���ȴ��ұ߿�ʼ�����ң�ֱ���ҵ���baseֵС����
            while (array[j] >= base && i < j)
            {
                j--;
            }

            // �ٴ������ұ��ң�ֱ���ҵ���baseֵ�����
            while (array[i] <= base && i < j)
            {
                i++;
            }

            // �����ѭ��������ʾ�ҵ���λ�û���(i>=j)�ˣ������������������е�λ��
            if (i < j)
            {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }

        // ����׼���ŵ��м��λ�ã���׼����λ��
        array[left] = array[i];
        array[i] = base;

        // �ݹ飬�������׼����������ִ�к�����ͬ���Ĳ���
        // i��������Ϊ������ȷ���õĻ�׼ֵ��λ�ã������ٴ���
        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }

    public static void main(String[] args)
    {
        int[] arr =
        { 10, 7, 2, 4, 7, 62, 3, 4, 2, 1, 8, 9, 19 };
        quickSort(arr);
        for (int a : arr)
        {
            System.out.print(a + " ");
        }
    }
}
