package com.leo.algorithm.dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class FullPermutationSolution {
    public static List<List<Integer>> permute(int[] nums) {
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        boolean[] used = new boolean[len];
        Deque<Integer> path = new ArrayDeque<>();
        dfs(nums, len, 0, used, path, res);

        return res;
    }

    private static void dfs(int[] nums, int len, int depth, boolean[] used, Deque<Integer> path,
                            List<List<Integer>> res) {
        if (depth == len) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if (used[i]) {
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums, len, depth + 1, used, path, res);
            // »ØËÝ£¬³·»Ø×´Ì¬
            used[i] = false;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        int[] nums =
                {1, 2, 3};
        List<List<Integer>> res = permute(nums);
        for (List<Integer> l : res) {
            System.out.println(l.toString());

        }
    }
}
