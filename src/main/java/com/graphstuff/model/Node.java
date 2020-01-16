package com.graphstuff.model;

import java.util.ArrayList;

public class Node {
    private int id;
    private int color;
    private int distance;
    private Node parent;
    private ArrayList<Node> children;

    public int getId() {
        return id;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
        parent.addChild(this);
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    public void addChild(Node n){
        this.children.add(n);
    }

    public Node(int id, int color, int distance, Node parent) {
        this.id = id;
        this.color = color;
        this.distance = distance;
        this.parent = parent;
        this.children = new ArrayList<Node>();
        if(null != parent)
            parent.addChild(this);
    }
}
