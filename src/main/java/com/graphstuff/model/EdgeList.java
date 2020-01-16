package com.graphstuff.model;

import com.graphstuff.algorithm.ISearchable;
import com.graphstuff.parser.EdgeListFileParser;
import org.jetbrains.annotations.NotNull;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class EdgeList implements ISearchable, Iterable<Edge> {
    private ArrayList<Edge> edges;

    private EdgeList(){}

    public EdgeList(ArrayList<Edge> edges){
        this.edges = edges;
    }

    public EdgeList(File f){
        this.edges = EdgeListFileParser.parseFile(f);
    }

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
        int max = 0;
        for (Edge e : edges
             ) {
            if(e.getV1() > max)
                max = e.getV1();
            if (e.getV2()>max)
                max = e.getV2();
        }
        return max;
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
    public EdgeList getSearchableStructure() {
        return this;
    }

    @NotNull
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
