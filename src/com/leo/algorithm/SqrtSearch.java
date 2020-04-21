package com.leo.algorithm;

public class SqrtSearch
{
    public static float sqrtSearch(float n)
    {
        float mid = 0.0f;
        if (n < -1e-6)
        {
            // С��0�����쳣
            throw new IllegalArgumentException();
        }
        else if (Math.abs(n) >= -1e-6 && Math.abs(n) <= 1e-6)
        {
            return mid;
        }
        else
        {
            // ��αƽ���Ĭ��ƽ�����Ĳ��ᳬ��n��һ��
            float high = n / 2.0f;
            float low = 0.0f;
            while (Math.abs(high - low) > 1e-6)
            {
                // �����ҵ��м�ֵ
                mid = low + (high - low) / 2;
                float tmp = mid * mid;
                // �Ƚϲ����� high��low
                if ((tmp - n) > 1e-6)
                {
                    high = mid;
                }
                else if ((tmp - n) < -1e-6)
                {
                    low = mid;
                }
                else
                {
                    return mid;
                }
            }
        }
        return mid;
    }

    public static void main(String[] args)
    {
        System.out.println(sqrtSearch(6));
    }

}
