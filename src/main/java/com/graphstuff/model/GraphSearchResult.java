package com.graphstuff.model;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class GraphSearchResult {
    private HashMap<Integer, Node> mappedNodes;
    private int targetNode, rootNode;
    private boolean isTargetFound;
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
        Node currentNode = null;
        route.add(currentNode = mappedNodes.get(targetNode));
        int nextParent = Integer.MAX_VALUE;

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
