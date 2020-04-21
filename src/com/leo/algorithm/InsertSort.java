package com.leo.algorithm;

public class InsertSort
{
    private int[] array;
    private int length;

    public InsertSort(int[] array)
    {
        this.array = array;
        this.length = array.length;
    }

    public void display()
    {
        for (int a : array)
        {
            System.out.print(a + " ");
        }
        System.out.println();
    }

    /*
     * �������򷽷�
     */
    public void doInsertSort()
    {
        for (int index = 1; index < length; index++)
        {// ������ҵ�index������Ϊ�Ƚ϶�������ݵ�index
            int temp = array[index];// �����Ƚϵ�����
            int leftindex = index - 1;
            while (leftindex >= 0 && array[leftindex] > temp)
            {// ���ȵ�����߻���������tempС������ʱ������ѭ��
                array[leftindex + 1] = array[leftindex];
                leftindex--;
            }
            array[leftindex + 1] = temp;// ��temp�ŵ���λ��
        }
    }

    public static void main(String[] args)
    {
        int[] array =
        { 38, 65, 97, 76, 13, 27, 49 };
        InsertSort is = new InsertSort(array);
        System.out.println("����ǰ������Ϊ��");
        is.display();
        is.doInsertSort();
        System.out.println("����������Ϊ��");
        is.display();
    }
}
