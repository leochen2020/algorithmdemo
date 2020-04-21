package com.leo.algorithm;

import java.util.ArrayList;
import java.util.List;

public class Parenthesis
{
    private List<String> res = new ArrayList<String>();

    public List<String> generateParenthesis(int n)
    {
        dfs(n, n, "");
        System.out.println(res);
        return res;
    }

    private void dfs(int left, int right, String curStr)
    {
        if (left == 0 && right == 0)
        { // �������Ŷ���ʣ���ˣ��ݹ���ֹ
            res.add(curStr);
            return;
        }

        if (left > 0)
        { // ��������Ż�ʣ��Ļ�������ƴ��������
            dfs(left - 1, right, curStr + "(");
        }
        if (right > left)
        { // ���������ʣ�����������ʣ��Ļ�������ƴ��������
            dfs(left, right - 1, curStr + ")");
        }
    }

    public static void main(String[] args)
    {
        Parenthesis pt = new Parenthesis();
        pt.generateParenthesis(3);
    }
}
