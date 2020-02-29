package com.graphstuff.model;

public class Edge {

    private int v1,v2, weight = 0;
    private boolean directed = false;

    public int getV1() {
        return v1;
    }

    public int getV2() {
        return v2;
    }

    public boolean isDirected() {
        return directed;
    }

    public void setDirected(boolean directed) {
        this.directed = directed;
    }

    public int getWeight() { return weight;}

    public void setWeight(int weight){
        this.weight = weight;
    }

    private Edge(){}

    public Edge(int v1, int v2){
        if(v1 < 1 || v2 < 1){
            throw new IllegalArgumentException();
        }
        this.v1 = v1;
        this.v2 = v2;
    }

    public Edge(int v1, int v2, int weight){
        if(v1 < 1 || v2 < 1){
            throw new IllegalArgumentException();
        }
        this.v1 = v1;
        this.v2 = v2;
        this.weight = weight;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass()!= Edge.class)
            return super.equals(obj);
        Edge e = (Edge)obj;
        if(!directed)
            return(this.v1 == e.getV1() && this.v2 == e.getV2() || this.v2 == e.getV1() && this.v1 == e.getV2());
        return(this.v1 == e.getV1() && this.v2 == e.getV2());
    }

    public boolean contains(int v){
        return (getV1()==v || getV2()==v);
    }

    public int getOther(int v){
        if(contains(v))
            return getV1()==v ? getV2() : getV1();
        throw new IllegalArgumentException("This edge does not contain "+v+".");
    }

    @Override
    public String toString() {
        if(!directed)
            return v1 + " -- "+v2;
        return v1 + " -> " + v2;
    }
}
