package com.leo.algorithm;

public class RadixSort
{
    public static void main(String[] args)
    {
        // ������������
        int[] arr =
        { 21, 56, 88, 195, 354, 1, 35, 12, 6, 7 };

        // ���û���������
//        lsdSort(arr);
        msdSort(arr);

        // �������������
        for (int i = 0; i < arr.length; i++)
        {
            System.out.print(arr[i] + "  ");
        }
    }

    // ����������Ԫ�ص����λ��
    public static int maxBin(int[] arr)
    {
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++)
        {
            int size = Integer.toString(arr[i]).length();
            maxLen = size > maxLen ? size : maxLen;
        }
        return maxLen;
    }

    // arr��Ҫ��������飬max���������������м�λ
    public static void lsdSort(int[] arr)
    {
        int maxBin = maxBin(arr);
        // count������������
        int[] count = new int[arr.length];
        // bucket������Ͱ����������������ʲô��Ͱ�ˣ��������ݣ�ȡ����
        int[] bucket = new int[arr.length];

        // k��ʾ�ڼ�λ��1�����λ��2����ʮλ��3�����λ
        for (int k = 1; k <= maxBin; k++)
        {
            // ��count�ÿգ���ֹ�ϴ�ѭ��������Ӱ��
            for (int i = 0; i < arr.length; i++)
            {
                count[i] = 0;
            }

            // �ֱ�ͳ�Ƶ�kλ��0,1,2,3,4,5,6,7,8,9������
            // ���±��ΪͰ
            // ����ѭ������ͳ��ÿ��Ͱ�е����ݵ�����
            for (int i = 0; i < arr.length; i++)
            {
                count[getFigure(arr[i], k)]++;
            }

            // ����count[i]��ȷ���������ݵ�λ��
            for (int i = 1; i < arr.length; i++)
            {
                count[i] = count[i] + count[i - 1];
            }
            // ִ�����ѭ��֮���count[i]���ǵ�i��Ͱ�ұ߽��λ��

            // ����ѭ��������װ�����Ͱ�У�ע���ǴӺ���ǰװ
            // �������ص㣬һ��Ҫ��ϸ���
            for (int i = arr.length - 1; i >= 0; i--)
            {
                int j = getFigure(arr[i], k);
                bucket[count[j] - 1] = arr[i];
                count[j]--;
            }

            // ��Ͱ�е�����ȡ��������ֵ��arr
            for (int i = 0, j = 0; i < arr.length; i++, j++)
            {
                arr[i] = bucket[j];
            }

        }
    }

    // �˺�������������i�ĵ�kλ��ʲô
    public static int getFigure(int i, int k)
    {
        int[] a =
        { 1, 10, 100 };
        return (i / a[k - 1]) % 10;
    }

    public static void msdSort(int[] arr)
    {
        int len = arr.length;
        // ȡ���������ֵ
        int max = arr[0];
        for (int i = 1; i < len; i++)
        {
            if (max < arr[i])
            {
                max = arr[i];
            }
        }

        int maxL = String.valueOf(max).length();// ��ȡ�������Ԫ�صĳ���
        int bit = new Double(Math.pow(10, maxL - 1)).intValue();
        int[][] t = new int[10][len]; // ׼��10�����ڴ��0-9��Ͱ��ÿ��Ͱ��������鳤��len��Ԫ��
        int[] num = new int[len]; // ��¼ÿ��Ͱ�д���Ԫ�صĸ���

        for (int a : arr)
        { // �����λ��Ͱ
            int m = (a / bit) % 10;
            t[m][num[m]] = a;
            num[m]++;
        }

        int index = 0;
        for (int i = 0; i < len; i++)
        {
            if (num[i] == 1)
            { // ���Ͱ��ֻ��һ������ֱ��ȡ��
                arr[index++] = t[i][0];
            }
            else if (num[i] > i)
            { // ���Ͱ�в�ֹһ�����������������arr2���ݹ�
                int[] arr2 = new int[num[i]];
                for (int j = 0; j < num[i]; j++)
                {
                    arr2[j] = t[i][j];
//                    msdSort(arr2); // �ݹ鷽��
                }
            }
        }
    }
}
