package com.leo.algorithm.bfs;

import java.util.LinkedList;

import com.leo.algorithm.bfs.vo.Vertex;

public class Main
{
    public static void main(String[] args)
    {
        // init data (����������Ŀ����ͼ)
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
            System.out.println("���·���� ");
            do
            {
                System.out.print(predecessor.getId() + " -> ");
                predecessor = predecessor.getPredecessor();
            } while (predecessor != null);
        }
        else
        {
            System.out.println("�����ڸ���㵽���յ��·��");
        }
    }

    public static boolean bfs(Vertex start, Vertex end)
    {
        LinkedList<Vertex> queue = new LinkedList<>();
        queue.addLast(start); // ��ӵ���β
        while (!queue.isEmpty())
        {
            Vertex vertex = queue.pollFirst(); // �Ӷ���ȡ��һ��Ԫ��
            // �����������Ƿ��Ѿ��������ˣ�������
            if (vertex.isSerched())
            {
                continue;
            }

            if (vertex == end)
            {
                // ��������յ��˾Ϳ��Է�����
                return true;
            }
            else
            {
                // ����������յ㣬��Ѹö�����Ե�����ھ�ȫ����ӵ�����ĩ��
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
