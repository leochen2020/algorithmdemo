package com.leo.algorithm.bfs.vo;

import java.util.LinkedList;

public class Vertex
{
    private int id; // 顶点的标识
    private LinkedList<Vertex> neighbors; // 这个顶点的邻居顶点
    private boolean isSerched; // 这个顶点是否被搜索过了
    private Vertex predecessor; // 这个顶点的前驱，用来记录路径的

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
