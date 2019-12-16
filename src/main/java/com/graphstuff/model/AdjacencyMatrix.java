package com.graphstuff.model;

import java.io.File;

public class AdjacencyMatrix {
    private EdgeList el;

    private AdjacencyMatrix(){}

    public  AdjacencyMatrix(EdgeList el){
        this.el = el;
    }

    public AdjacencyMatrix(File f){
        this.el = new EdgeList(f);
    }

    public boolean lookup(int v1, int v2){
        for (Edge e : el.getEdgesByVertex(v1)) {
            if(v1 ==v2) {
                //self edges
                if(e.getV1()==e.getV2()){
                    return true;
                }
            }
            else if(e.contains(v2))
                return true;
        }
        return false;
    }

    public boolean[][] getRawMatrix(){
        int vertMax = el.getVMax();
        boolean [][] mat = new boolean[vertMax][vertMax];
        for (int i = 0; i< vertMax; i++){
            for(int j = 0; j < vertMax; j++){
                mat[i][j] = lookup(i+1,j+1);
            }
        }
        return mat;
    }


}
