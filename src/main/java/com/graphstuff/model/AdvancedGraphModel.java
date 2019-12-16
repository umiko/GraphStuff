package com.graphstuff.model;

public class AdvancedGraphModel {
    EdgeList el;

    public IncidenceMatrix toIncidenceMatrix(){
        return new IncidenceMatrix(el);
    }

    public AdjacencyMatrix toAdjacencyMatrix(){
        return new AdjacencyMatrix(el);
    }

    public AdjacencyList toAdjacencyList(){
        return new AdjacencyList(el);
    }
}
