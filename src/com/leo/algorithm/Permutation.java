package com.leo.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Permutation
{
    // ��Ŀ������Given a collection of distinct integers, return all possible
    // permutations.������һ�鲻ͬ�����������������еĿ�����ϣ�
    public List<List<Integer>> permute(int[] nums)
    {
        // һ��ȫ�ֱ��������ڱ������м���
        List<List<Integer>> list = new ArrayList<>();
        // ��������������û�и��Ӳ���
        backtrack(list, new ArrayList<>(), nums);
        System.out.println(list.toString());
        return list;
    }

    private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums)
    {
        // һ���ս�������Ҳ��������������ʱ��
        if (tempList.size() == nums.length)
        {
            // ȫ�ֱ�������һ�����������ļ���
            list.add(new ArrayList<>(tempList));
        }
        else
        {
            for (int i = 0; i < nums.length; i++)
            {
                if (tempList.contains(nums[i]))
                    continue;
                // ���tempListû�а���nums[i]������
                tempList.add(nums[i]);
                // �ݹ���ã���ʱ��tempListһֱ�ڱ仯��ֱ�������ս������Ž���
                backtrack(list, tempList, nums);
                System.out.println("tempList������:" + tempList + "-------" + "i��ֵ:" + i);
                // ���Ƴ�tempList���һ��Ԫ�ص����þ��Ƿ�����һ�ε���ʱ�����ݣ�Ҳ����ϣ������֮ǰ�Ľڵ���ȥ��������������������������ʵ�ֻ���
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args)
    {
        int[] nums =
        { 1, 2, 3 };
        (new Permutation()).permute(nums);
    }
}