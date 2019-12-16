package com.graphstuff.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Set;

public class AdjacencyList {

    private EdgeList el;

    private AdjacencyList(){}

    public AdjacencyList(EdgeList el){
        this.el = el;
    }

    public AdjacencyList(File f){
        this.el = new EdgeList(f);
    }

    public int[] getAdjacencyListByVertex(int v) {
        ArrayList<Edge> edges = el.getEdgesByVertex(v);
        int[] al = new int[edges.size()];
        for (int i =0; i< edges.size(); i++){
            al[i] = edges.get(i).getOther(v);
        }
        return al;
    }

    public ArrayList<int[]> getRawAdjacencyList(){
        ArrayList<int[]> al = new ArrayList<>();
        for (int i = 0; i<el.getVMax(); i++){
            al.add(getAdjacencyListByVertex(i+1));
        }
        return al;
    }
}