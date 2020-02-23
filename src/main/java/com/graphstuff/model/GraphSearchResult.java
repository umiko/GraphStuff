package com.graphstuff.model;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class GraphSearchResult {
    private HashMap<Integer, Node> mappedNodes;
    private int targetNode, rootNode;
    private boolean isTargetFound;

    //region accessors

    public HashMap<Integer, Node> getMappedNodes() {
        return mappedNodes;
    }

    public void setMappedNodes(HashMap<Integer, Node> mappedNodes) {
        this.mappedNodes = mappedNodes;
    }

    public int getTargetNode() {
        return targetNode;
    }

    public void setTargetNode(int targetNode) {
        this.targetNode = targetNode;
    }

    public int getRootNode() {
        return rootNode;
    }

    public void setRootNode(int rootNode) {
        this.rootNode = rootNode;
    }

    public boolean isTargetFound() {
        return isTargetFound;
    }

    public void setTargetFound(boolean targetFound) {
        isTargetFound = targetFound;
    }

    //endregion

    public GraphSearchResult(HashMap<Integer, Node> mappedNodes, int targetNode, int rootNode, boolean isTargetFound){
        this.mappedNodes = mappedNodes;
        this.targetNode = targetNode;
        this.rootNode = rootNode;
        this.isTargetFound = isTargetFound;
    }

    public void printResult(){
        System.out.println(this.toString());
    }

    @Override
    public String toString(){
        if(!isTargetFound)
            return "Target node was not found";
        StringBuilder sb = new StringBuilder();
        Deque<Node> route = new LinkedList<>();
        Node currentNode = mappedNodes.get(targetNode);
        //build path from target to root
        while (currentNode.getParentId() != -1){
            route.add(currentNode);
            currentNode = mappedNodes.get(currentNode.getParentId());
        }
        //add path node by node in reverse to the string
        while (route.size() != 0){
            sb.append(route.removeLast());
            sb.append("\n");
        }
        return sb.toString();
    }
}
