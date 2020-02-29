package com.graphstuff.algorithm;

import com.graphstuff.model.EdgeList;
import com.graphstuff.model.Node;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class TopSort implements Comparator<Node> {

    private EdgeList el;
    private HashMap<Integer, Node> nodeHashMap = new HashMap<>();
    private ArrayList<Node> resultList = new ArrayList<>();

    private int rootNodeId;
    private int time = 0;
    private final int WHITE = 0;
    private final int BLACK = 1;


    public TopSort(EdgeList el, int rootNodeId){
        this.el = el;
        this.rootNodeId = rootNodeId;
    }

    public ArrayList<Node> sort(){
        nodeHashMap.put(rootNodeId, new Node(el,rootNodeId, null));
        visit(nodeHashMap.get(rootNodeId));
        return resultList;
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
                v.setParentId(u.getVertId());
                visit(v);
            }
        }
        time++;
        u.setTimeFinished(time);
        resultList.add(0, u);
    }

    @Override
    public int compare(Node o1, Node o2) {
        return o1.getTimeFinished() - o2.getTimeFinished();
    }
}
