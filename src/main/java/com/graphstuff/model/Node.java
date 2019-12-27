package com.graphstuff.model;

import java.util.ArrayList;

public class Node {
    int id;
    int color;
    int distance;
    Node parent;
    ArrayList<Node> children;

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
    }

    public ArrayList<Node> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<Node> children) {
        this.children = children;
    }

    public Node(int id, int color, int distance, Node parent) {
        this.id = id;
        this.color = color;
        this.distance = distance;
        this.parent = parent;
    }
}
