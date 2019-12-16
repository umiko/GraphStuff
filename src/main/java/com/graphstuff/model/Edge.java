package com.graphstuff.model;

public class Edge {

    private int v1,v2;
    private boolean directed = false;

    public int getV1() {
        return v1;
    }

    public int getV2() {
        return v2;
    }

    private Edge(){}

    public Edge(int v1, int v2){
        if(v1 < 1 || v2 < 1){
            throw new IllegalArgumentException();
        }
        this.v1 = v1;
        this.v2 = v2;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass()!= Edge.class)
            return super.equals(obj);
        Edge e = (Edge)obj;
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
}
