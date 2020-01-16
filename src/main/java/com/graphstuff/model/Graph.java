package com.graphstuff.model;

import com.graphstuff.algorithm.ISearchable;

import java.io.File;
import java.util.ArrayList;

public class Graph implements ISearchable {
    private boolean isStrict = false;
    EdgeList el;

    public boolean isStrict() {
        return isStrict;
    }

    private Graph(){};

    public Graph(EdgeList el){
        this.el = el;
    }

    public Graph(File f){
        this(new EdgeList(f));
    }

    public Graph(ISearchable graph, boolean isStrict){

        this.el = graph.getSearchableStructure();
        this.isStrict = isStrict;
    }

    public Graph(File f, boolean isStrict){
        this(new EdgeList(f), isStrict);
    }

    public ArrayList<Edge> getEdgeList() {
        return el.getEdgeList();
    }

    @Override
    public EdgeList getSearchableStructure() {
        return el;
    }
}
