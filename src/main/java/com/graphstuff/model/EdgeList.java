package com.graphstuff.model;

import com.graphstuff.parser.EdgeListFileParser;


import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class EdgeList implements IGraphRepresentation, Iterable<Edge> {
    private boolean isStrict = false;
    private boolean isDirected = false;
    private boolean isWeighted = false;
    private ArrayList<Edge> edges;

    //region accessors

    public boolean isStrict() {
        return isStrict;
    }

    public void setStrict(boolean strict) {
        isStrict = strict;
    }

    public boolean isDirected() {
        return isDirected;
    }

    public void setDirected(boolean directed) {
        isDirected = directed;
    }

    public boolean isWeighted() {
        return isWeighted;
    }

    public void setWeighted(boolean weighted) {
        isWeighted = weighted;
    }

    //endregion

    //region constructors

    private EdgeList(){}

    public EdgeList(ArrayList<Edge> edges){
        this.edges = edges;
    }

    public EdgeList(File f){
        this.edges = EdgeListFileParser.parseFile(f);
    }

    //endregion

    public void addEdge(Edge e){
        edges.add(e);
    }

    public ArrayList<Edge> getEdgeList(){
        return edges;
    }

    public int size(){
        return edges.size();
    }

    public Edge getEdge(int edgeId) {
        return edges.get(edgeId-1);
    }

    public int getVMax(){
        int vmax = 0;
        for (Edge e : edges) {
            vmax = Math.max(vmax, Math.max(e.getV1(), e.getV2()));
        }
        return vmax;
    }

    public ArrayList<Edge> getEdgesByVertex(int v){
        ArrayList<Edge> el = new ArrayList<>();
        for (Edge e : edges) {
            if(e.contains(v)){
                el.add(e);
            }
        }
        return el;
    }

    public IncidenceMatrix toIncidenceMatrix(){
        return new IncidenceMatrix(this);
    }

    public AdjacencyMatrix toAdjacencyMatrix(){
        return new AdjacencyMatrix(this);
    }

    public AdjacencyList toAdjacencyList(){
        return new AdjacencyList(this);
    }

    @Override
    public EdgeList toEdgeList() {
        return this;
    }

    @Override
    public Iterator<Edge> iterator() {
        return edges.iterator();
    }

    @Override
    public void forEach(Consumer<? super Edge> action) {
        edges.forEach(action);
    }

    @Override
    public Spliterator<Edge> spliterator() {
        return edges.spliterator();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EdgeList)) return false;

        EdgeList edges1 = (EdgeList) o;

        return edges.equals(edges1.edges);
    }
}
