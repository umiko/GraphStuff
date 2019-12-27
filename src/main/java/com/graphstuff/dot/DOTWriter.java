package com.graphstuff.dot;

import com.graphstuff.model.Edge;
import com.graphstuff.model.Graph;

import java.io.File;

public class DOTWriter {
    private File output;
    private StringBuilder content;

    private DOTWriter(){};

    public DOTWriter(File f){
        content = new StringBuilder();
        output = f;
    }

    public DOTWriter(String path){
        content = new StringBuilder();
        output = new File(path);
    }

    public void toDOT(Graph g){
        setup(g);
        for (Edge e : g.getEdgeList()) {
            addEdge(e);
        }
        finish();
    }

    private void setup(Graph g){
        if(g.isStrict())
            content.append("strict ");
        content.append("graph {\n");
    }

    private void addEdge(Edge e){
        content.append(e.toString()+"\n");
    }

    private void finish(){
        content.append("}\n");
    }
}
