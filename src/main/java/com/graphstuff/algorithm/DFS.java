package com.graphstuff.algorithm;

import com.graphstuff.model.EdgeList;
import com.graphstuff.model.GraphSearchResult;
import com.graphstuff.model.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;


public class DFS {

    private boolean isStrict = false;
    private EdgeList el;
    private HashMap<Integer, Node> nodeHashMap = new HashMap<>();

    private int rootNodeId;
    private int targetNodeId;
    private final int WHITE = 0;
    private final int BLACK = 1;
    private int time = 0;
    private boolean isTargetFound = false;

    public DFS(EdgeList el, int rootNodeId, int targetNodeId, boolean isStrict){
        this.isStrict = isStrict;
        this.el = el;
        this.rootNodeId = rootNodeId;
        this.targetNodeId = targetNodeId;
    };

    public GraphSearchResult search(){
        nodeHashMap.put(rootNodeId, new Node(el,rootNodeId, null));
        visit(nodeHashMap.get(rootNodeId));

        return new GraphSearchResult(nodeHashMap, targetNodeId, rootNodeId, isTargetFound);
    }

    private void visit(Node u){
        time++;
        u.setTimeDiscovered(time);
        u.setColor(BLACK);
        Node v;
        for(int vId : u.getNeighbourIds()){
            if((v = nodeHashMap.get(vId)) == null){
                nodeHashMap.put(vId, v = new Node(el,vId, u.getVertId()));
            }
            if(v.getColor() == WHITE){
                if(v.getVertId() == targetNodeId){
                    isTargetFound = true;
                }
                v.setParentId(u.getVertId());
                visit(v);
            }
        }
        time++;
        u.setTimeFinished(time);
    }


}
