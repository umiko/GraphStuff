package com.graphstuff.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class DFSTree {
    HashMap<Integer, Node> tree;
    int rootId = 0;

    private final int WHITE = 0;
    private final int BLACK = 1;


    public DFSTree(HashMap<Integer, Node> tree, int rootId){
        this.tree = tree;
        this.rootId = rootId;
    }

    public EdgeList toTree(){
        Node currentNode;
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Edge> resultTreeEdges = new ArrayList<>();

        q.add(rootId);

        while (!q.isEmpty()){
            if((currentNode = tree.get(q.remove()))==null)
                return null;
            //add edge to nodes parent
            if(currentNode.getParentId() != -1)
                resultTreeEdges.add(new Edge(currentNode.getParentId(), currentNode.getVertId()));
            //add neighbours that have not been worked on yet to the queue
            for(int i : currentNode.getNeighbourIds()){
                //we are getting an already worked on node, so the role of the colours is reversed
                if(tree.get(i).getColor() == BLACK){
                    q.add(i);
                }
            }
            currentNode.setColor(WHITE);
        }
        return new EdgeList(resultTreeEdges);
    }
}
