package com.graphstuff.model;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.Collection;
/// Nodes have  children and parents, while vertices do only have neighbours
public class Node extends Vertex {
    private int color = 0;
    private int parentId = -1;
    private Collection<Integer> childIds = new ArrayList<>();

    //region accessors

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public Collection<Integer> getChildIds() {
        return childIds;
    }

    public void setChildIds(Collection<Integer> childIds) {
        this.childIds = childIds;
    }

    //endregion

    //region constructors

    public Node(int vertId) {
        super(vertId);
    }

    public Node(int vertId, Collection<Integer> childIds){
        super(vertId, childIds);
        this.childIds.addAll(childIds);
    }

    public Node(int nodeId, Collection<Integer> childIds, Integer parentId){
        this(nodeId, childIds);

        if( null!= parentId) {
            addNeighbourId(parentId);
            this.parentId = parentId;
        }
    }

    public Node(EdgeList el, int nodeId){
        super(el, nodeId);
        this.childIds = findChildIds(nodeId, el, null);
    }

    public Node(EdgeList el, int nodeId, Integer parentId){
        this(nodeId, findChildIds(nodeId, el, parentId), parentId);
    }

    //endregion

    public static ArrayList<Integer> findChildIds(int nodeId, EdgeList el, Integer parentId){
        ArrayList<Integer> childIds = Vertex.findNeighbourIds(el, nodeId);
        if(null != parentId)
            childIds.remove(parentId);
        return childIds;
    }

    public void addChildId(int n){
        if(!getNeighbourIds().contains(n))
            this.addNeighbourId(n);
        this.childIds.add(n);
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() == Node.class){
            Node that = (Node)obj;
            boolean childcomp = this.getChildIds().containsAll(that.getChildIds());
            return this.getParentId() == that.getParentId() && this.getColor() == that.getColor() && this.getChildIds().containsAll(that.getChildIds()) && super.equals(obj);
        }
        return super.equals(obj);
    }

    @Override
    public  String toString(){
        if(this.getParentId() == -1){
            return String.format("%s", this.getVertId());
        }
        return String.format("%s --> %s", this.getParentId(), this.getVertId());
    }
}
