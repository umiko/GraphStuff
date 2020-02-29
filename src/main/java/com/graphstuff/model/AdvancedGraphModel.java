package com.graphstuff.model;

public abstract class AdvancedGraphModel extends GraphInformation implements IGraphRepresentation{
    EdgeList el;

    public void addEdge(Edge e){ el.addEdge(e);}

    public Edge getEdge(int index){
        return el.getEdge(index);
    }

    public IncidenceMatrix toIncidenceMatrix(){
        return new IncidenceMatrix(el);
    }

    public AdjacencyMatrix toAdjacencyMatrix(){
        return new AdjacencyMatrix(el);
    }

    public AdjacencyList toAdjacencyList(){
        return new AdjacencyList(el);
    }

    public EdgeList toEdgeList() {
        return el;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AdvancedGraphModel)) return false;

        AdvancedGraphModel that = (AdvancedGraphModel) o;

        return el.equals(that.el);
    }
}
