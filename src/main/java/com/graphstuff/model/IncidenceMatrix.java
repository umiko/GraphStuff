package com.graphstuff.model;

import java.io.File;

public class IncidenceMatrix extends AdvancedGraphModel{

    private IncidenceMatrix(){}

    public IncidenceMatrix(EdgeList el){
        this.el = el;
    }

    public IncidenceMatrix(File f){
        this.el = new EdgeList(f);
    }

    public boolean lookup(int vertex, int edge){
        Edge e = el.getEdge(edge);
        return (e.getV1()==vertex || e.getV2()== vertex);
    }

    public boolean[][] getRawMatrix(){
        int vertMax = el.getVMax();
        int edgeMax = el.size();
        boolean [][] mat = new boolean[vertMax][edgeMax];
        for (int i = 0; i< vertMax; i++){
            for(int j = 0; j < edgeMax; j++){
                mat[i][j] = lookup(i+1,j+1);
            }
        }
        return mat;
    }
}
