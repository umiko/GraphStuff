package com.graphstuff.model;

import java.util.ArrayList;
import java.util.Collection;

public class Vertex {
    private int vertId;
    private Collection<Integer> neighbourIds = new ArrayList<>();

    //region accessors

    public int getVertId() {
        return vertId;
    }

    public void setVertId(int vertId) {
        this.vertId = vertId;
    }

    public Collection<Integer> getNeighbourIds() {
        return neighbourIds;
    }

    public void setNeighbourIds(Collection<Integer> neighbourIds) {
        this.neighbourIds = neighbourIds;
    }

    //endregion

    //region constructors

    private Vertex(){
    }

    public Vertex(int vertId){
        this.vertId = vertId;
    }

    public Vertex(int vertId, Collection<Integer> neighbourIds){
        this.vertId = vertId;
        this.neighbourIds = neighbourIds;
    }

    public Vertex(EdgeList el, int vertId) {
        this.vertId = vertId;
        neighbourIds = findNeighbourIds(el, vertId);
    }

    //endregion

    public static ArrayList<Integer> findNeighbourIds(EdgeList el, int vertId){
        ArrayList<Integer> neighbourIds = new ArrayList<>();
        for (Edge e : el.getEdgesByVertex(vertId)){
            neighbourIds.add(e.getOther(vertId));
        }
        return neighbourIds;
    }

    public void addNeighbourId(int id){
        neighbourIds.add(id);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vertex) {
            Vertex that = (Vertex) obj;
            return this.getVertId() == that.getVertId() && that.getNeighbourIds().containsAll(this.getNeighbourIds());
        }
        return super.equals(obj);
    }
}
