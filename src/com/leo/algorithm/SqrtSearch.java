package com.leo.algorithm;

public class SqrtSearch
{
    public static float sqrtSearch(float n)
    {
        float mid = 0.0f;
        if (n < -1e-6)
        {
            // 小于0，抛异常
            throw new IllegalArgumentException();
        }
        else if (Math.abs(n) >= -1e-6 && Math.abs(n) <= 1e-6)
        {
            return mid;
        }
        else
        {
            // 逐次逼近，默认平方根的不会超过n的一半
            float high = n / 2.0f;
            float low = 0.0f;
            while (Math.abs(high - low) > 1e-6)
            {
                // 首先找到中间值
                mid = low + (high - low) / 2;
                float tmp = mid * mid;
                // 比较并更新 high和low
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
