package com.graphstuff.model;

public interface IGraphRepresentation {
    public EdgeList toEdgeList();

    public IncidenceMatrix toIncidenceMatrix();

    public AdjacencyMatrix toAdjacencyMatrix();

    public AdjacencyList toAdjacencyList();
};
