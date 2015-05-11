package com.task.task14;

import java.io.PrintWriter;

/**
 * Class representing an undirected graph
 * @author Sergey
 */
class MyGraph {

    private int vertexCount;
    private ArrayList2d<Boolean> twoDArrayList;

    public MyGraph(int vertexCount) {
        this.vertexCount = vertexCount;

        twoDArrayList = new ArrayList2d<Boolean>();

        for (int i = 0; i < vertexCount; i++) {
            for (int j = 0; j < vertexCount; j++) {
                twoDArrayList.Add(Boolean.FALSE, i);
            }
        }
    }

    public void addEdge(int i, int j) {
        if (i >= 0 && i < vertexCount && j > 0 && j < vertexCount) {
            twoDArrayList.set(i, j, Boolean.TRUE);
            twoDArrayList.set(j, i, Boolean.TRUE);
        }
    }
    public void removeEdge(int i, int j) {
        if (i >= 0 && i < vertexCount && j > 0 && j < vertexCount) {
            twoDArrayList.set(i, j, Boolean.FALSE);
            twoDArrayList.set(j, i, Boolean.FALSE);
        }
    }
    public void print(PrintWriter out) {
        twoDArrayList.print(out);
    }
}
