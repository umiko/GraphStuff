package com.graphstuff.model;

import com.graphstuff.algorithm.ISearchable;

public class AdvancedGraphModel implements ISearchable {
    EdgeList el;

    public void addEdge(Edge e){ el.addEdge(e);}

    public IncidenceMatrix toIncidenceMatrix(){
        return new IncidenceMatrix(el);
    }

    public AdjacencyMatrix toAdjacencyMatrix(){
        return new AdjacencyMatrix(el);
    }

    public AdjacencyList toAdjacencyList(){
        return new AdjacencyList(el);
    }

    @Override
    public EdgeList getSearchableStructure() {
        return el;
    }
}
