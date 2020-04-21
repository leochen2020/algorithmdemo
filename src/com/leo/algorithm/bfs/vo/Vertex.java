package com.leo.algorithm.bfs.vo;

import java.util.LinkedList;

public class Vertex
{
    private int id; // ����ı�ʶ
    private LinkedList<Vertex> neighbors; // ���������ھӶ���
    private boolean isSerched; // ��������Ƿ���������
    private Vertex predecessor; // ��������ǰ����������¼·����

    public Vertex(int id)
    {
        this.id = id;
    }

    public void addNeighbor(Vertex... vertexes)
    {
        this.neighbors = new LinkedList<>();
        for (Vertex vertex : vertexes)
        {
            this.neighbors.add(vertex);
        }
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public LinkedList<Vertex> getNeighbors()
    {
        return neighbors;
    }

    public void setNeighbors(LinkedList<Vertex> neighbors)
    {
        this.neighbors = neighbors;
    }

    public boolean isSerched()
    {
        return isSerched;
    }

    public void setSerched(boolean isSerched)
    {
        this.isSerched = isSerched;
    }

    public Vertex getPredecessor()
    {
        return predecessor;
    }

    public void setPredecessor(Vertex predecessor)
    {
        this.predecessor = predecessor;
    }
}
