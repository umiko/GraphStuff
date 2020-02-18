package com.graphstuff.model;

import com.graphstuff.algorithm.ISearchable;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class Graph implements ISearchable {
    private boolean isStrict = false;
    private EdgeList el;
    private HashMap<Integer, Node> nl = new HashMap<>();

    public boolean isStrict() {
        return isStrict;
    }

    public void setStrict(boolean strict) {
        isStrict = strict;
    }

    @Override
    public EdgeList getSearchableStructure() {
        return el;
    }

    private void generateNodeList(){
        for (int i = 0; i < el.getVMax(); i++){
            generateNode(i, el.getEdgesByVertex(i));
        }
    }

    private void generateNode(int nodeId, Collection<Edge> edges){
    }
}
