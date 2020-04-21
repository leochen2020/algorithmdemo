package com.leo.algorithm.bfs;

import java.util.LinkedList;

import com.leo.algorithm.bfs.vo.Vertex;

public class Main
{
    public static void main(String[] args)
    {
        // init data (对照上面题目给的图)
        Vertex[] vertexes = new Vertex[9];
        for (int i = 0; i < vertexes.length; i++)
        {
            vertexes[i] = new Vertex(i);
        }
        vertexes[0].addNeighbor(vertexes[1], vertexes[3]);
        vertexes[1].addNeighbor(vertexes[0], vertexes[2]);
        vertexes[2].addNeighbor(vertexes[1], vertexes[4], vertexes[5]);
        vertexes[3].addNeighbor(vertexes[0], vertexes[5], vertexes[6]);
        vertexes[4].addNeighbor(vertexes[2], vertexes[8]);
        vertexes[5].addNeighbor(vertexes[2], vertexes[3], vertexes[6], vertexes[8]);
        vertexes[6].addNeighbor(vertexes[3], vertexes[5], vertexes[7]);
        vertexes[7].addNeighbor(vertexes[6], vertexes[8]);
        vertexes[8].addNeighbor(vertexes[4], vertexes[5], vertexes[7]);
        // start search
        Vertex start = vertexes[0];
        Vertex end = vertexes[8];
        boolean hasPath = bfs(start, end);
        if (hasPath)
        {
            // print path
            Vertex predecessor = end;
            System.out.println("最短路径： ");
            do
            {
                System.out.print(predecessor.getId() + " -> ");
                predecessor = predecessor.getPredecessor();
            } while (predecessor != null);
        }
        else
        {
            System.out.println("不存在该起点到该终点的路径");
        }
    }

    public static boolean bfs(Vertex start, Vertex end)
    {
        LinkedList<Vertex> queue = new LinkedList<>();
        queue.addLast(start); // 添加到队尾
        while (!queue.isEmpty())
        {
            Vertex vertex = queue.pollFirst(); // 从队首取出一个元素
            // 如果这个顶点是否已经检索过了，则跳过
            if (vertex.isSerched())
            {
                continue;
            }

            if (vertex == end)
            {
                // 如果到了终点了就可以返回了
                return true;
            }
            else
            {
                // 如果还不是终点，这把该顶点可以到达的邻居全部添加到队列末端
                for (Vertex neighbor : vertex.getNeighbors())
                {
                    if (neighbor.getPredecessor() == null && neighbor != start)
                    {
                        neighbor.setPredecessor(vertex);
                    }
                    queue.addLast(neighbor);
                }
            }
            vertex.setSerched(true);
        }
        return false;
    }
}
