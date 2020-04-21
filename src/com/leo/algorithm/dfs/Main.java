package com.leo.algorithm.dfs;

/** 迷宫解密之深度优化搜索 */
/*
 * 迷宫解密也可以称为迷宫最短路径路线问题 这也是一个深度优化搜索的案例应用场景 在游戏之中也很常见这种算法比如现在比较活的游戏lol中点击
 * 小地图，我们的角色就会按照那条计算出来的最短路径前进。这其中就涉及到深度优化搜索的身影。
 * 一般我们采用这种方法，我们都应该事先建立一个与之相对应的模型，如果是图，我们可以建立一个 类似于二维数组一样的模型与之对应。
 * 现在我们需要解决的问题是如果一个人在一个点去另外一个点的最短路径的问题 并计算出最短路径 我们定义的模型如下：采用二维数组 {[0,0,1,0],
 * [0,0,0,0], [0,0,1,0], [0,1,0,0], [0,0,0,1]} 其中0代表可以走的地方 1代表不能走的地方 (x,y) x代表行
 * y代表列 （0，0）坐标是我们的起点 （3，2） 代表目的地 求出到达目的地的最短路径(注意一次只能走一步 上下左右 但是不能越界)
 */
public class Main
{
    // 定义一个参照数组 相当于记录所走的地方
    private static int[][] book = new int[5][4];
    // 定义地图 初始化地图
    private static int[][] a =
    {
            { 0, 0, 1, 0 },
            { 0, 0, 0, 0 },
            { 0, 0, 1, 0 },
            { 0, 1, 0, 0 },
            { 0, 0, 0, 1 } };
    // 定义四个方向 上下左右 上=x-1,y不变 下=x+1,y不变 左=x不变,y-1 右=x不变,y+1
    // 根据这个特性我们可以将这四个方向定义成一个二维数组
    private static int[][] direction =
    {
            { -1, 0 },
            { 1, 0 },
            { 0, 1 },
            { 0, -1 } };
    // 定义一个走的步数
    private static int stepSum = 9999;

    /** 这是每一次走的函数 */
    // x y 相等于 行和列 因为数组是从0开始的所以xy也是从0开始
    public static void dfs(int tx, int ty, int step)
    {
        // System.out.println(tx +":"+ty+":"+step);
        // x,y 这里表示xy点已经被走过了所以需要标记
        // book[tx][ty] = 1;
        // 如果到达了目的地就需要return
        if (tx == 3 && ty == 2)
        {
            // 表示到达目的地 这里还需要记录所走的步数
            if (step < stepSum)
            {
                stepSum = step;
            }
            // 将所走的路径遍历出来 也就是book二维数组中等于1的
            for (int m = 0; m < 5; m++)
            {
                for (int n = 0; n < 4; n++)
                {
                    if (book[m][n] == 1)
                    {
                        System.out.print("(" + m + "," + n + ")");
                    }
                }
            }
            System.out.print("步数是:" + step);
            System.out.println();
            return;
        }
        // 因为每一步都有四种走法
        for (int i = 0; i < direction.length; i++)
        {
            int x = tx + direction[i][0];
            int y = ty + direction[i][1];
            // 需要判断xy有没有越界以及xy的点是不是可以走的点
            if (x >= 0 && x < 5 && y >= 0 && y < 4 && a[x][y] == 0 && book[x][y] == 0)
            {
                book[x][y] = 1;
                dfs(x, y, step + 1);
                // step--;
                // 这一步很重要 相当于走了一趟之后重新走的时候撤掉标记
                book[x][y] = 0;
            }
        }
        // return;
    }

    public static void main(String[] args)
    {
        book[0][0] = 1;
        dfs(0, 0, 0);
    }
}
