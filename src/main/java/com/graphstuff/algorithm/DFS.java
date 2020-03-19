package com.graphstuff.algorithm;

import com.graphstuff.model.DFSTree;
import com.graphstuff.model.EdgeList;
import com.graphstuff.model.GraphSearchResult;
import com.graphstuff.model.Node;

import java.util.ArrayList;
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
        return new GraphSearchResult(generateForest(), targetNodeId, rootNodeId, isTargetFound);
    }

    public ArrayList<DFSTree> generateForest(){
        ArrayList<DFSTree> forest = new ArrayList<>();
        for (int i = 1; i < el.getVMax(); i++){
            if(nodeHashMap.get(i) == null) {
                nodeHashMap.put(i, new Node(el, i, null));
            }
            if(nodeHashMap.get(i).getColor()==WHITE){
                forest.add(visit(nodeHashMap.get(i)));
            }
        }
        return forest;
    }

    public DFSTree visit(Node u){
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
        return new DFSTree(nodeHashMap, u.getVertId());
    }
}
