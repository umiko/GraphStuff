package com.graphstuff.algorithm;

import com.graphstuff.model.*;

import java.util.*;


public class BFS {

    private boolean isStrict = false;
    private EdgeList el;
    private HashMap<Integer, Node> nodeHashMap = new HashMap<>();

    private int rootNodeId;
    private int targetNodeId;
    private final int WHITE = 0;
    private final int BLACK = 1;

    public BFS(EdgeList el, int rootNodeId, int targetNodeId, boolean isStrict){
        this.isStrict = isStrict;
        this.el = el;
        this.rootNodeId = rootNodeId;
        this.targetNodeId = targetNodeId;
    };

    public GraphSearchResult search(){
        Queue<Node> q = new LinkedList<>();
        Node u,v;
        boolean isTargetFound = false;

        nodeHashMap.put(rootNodeId, new Node(el,rootNodeId, null));
        q.add(nodeHashMap.get(rootNodeId));
        q.peek().setDistanceToRoot(0);

        while(!q.isEmpty()){
            u = q.remove();
            for(int vId : u.getNeighbourIds()){
                if((v = nodeHashMap.get(vId)) == null){
                    nodeHashMap.put(vId, v = new Node(el,vId, u.getVertId()));
                }
                if(v.getColor() == WHITE){
                    v.setColor(BLACK);
                    v.setParentId(u.getVertId());
                    v.setDistanceToRoot(u.getDistanceToRoot()+1);
                    q.add(v);

                    if(v.getVertId() == targetNodeId){
                        isTargetFound = true;
                    }
                }
            }
            u.setColor(BLACK);
        }

        return new GraphSearchResult(nodeHashMap, targetNodeId, rootNodeId, isTargetFound);

    };



}
