package com.graphstuff.algorithm;

import com.graphstuff.model.*;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;


public class BFS {

    private boolean isStrict = false;
    private EdgeList el;
    private HashMap<Integer, Node> nodeHashMap = new HashMap<>();

    private int rootNodeId;
    private int targetNodeId;

    public BFS(EdgeList el, int rootNodeId, int targetNodeId, boolean isStrict){
        this.isStrict = isStrict;
        this.el = el;
        this.rootNodeId = rootNodeId;
        this.targetNodeId = targetNodeId;
    };

    public GraphSearchResult search(){
        Deque<Integer> workload = new LinkedList<>();
        Deque<Integer> parents = new LinkedList<>();
        Node currentNode = null;
        Integer previousParentId = -1;
        int childcounter = 0;
        boolean targetNodeReached = false;
        workload.add(rootNodeId);
        //work until there is no work left or the target node is found
        while (workload.size() > 0 && !targetNodeReached){
            //if there is no currentNode, it must be the first iteration, create a root node
            if(null == (currentNode = nodeHashMap.get(workload.getFirst())) || workload.getFirst() != currentNode.getVertId())
                nodeHashMap.put(workload.getFirst(),currentNode = new Node(el, workload.getFirst(), previousParentId == -1 ?null:previousParentId));
            //if the node has not been traversed yet, do that
            if(currentNode.getColor()==0){
                //do work
                if (currentNode.getVertId()==targetNodeId)
                    targetNodeReached = true;
                workload.addAll(currentNode.getChildIds());
                currentNode.setColor(1);
                currentNode.setParentId(previousParentId);
            }
            //remove the last worked on nodeid from the queue
            if(childcounter==0)
                previousParentId = parents.removeFirst();
            else
                workload.removeFirst();
            childcounter--;
        }

        return new GraphSearchResult(nodeHashMap, targetNodeId, rootNodeId, targetNodeReached);
    };



}
