package com.graphstuff.dot;

import com.graphstuff.model.BasicGraphModel;
import com.graphstuff.model.Edge;
import com.graphstuff.model.IGraphRepresentation;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class DOTWriter {
    private File output;
    private StringBuilder content;

    private DOTWriter(){};

    public DOTWriter(File output){
        content = new StringBuilder();
        this.output = output;
    }

    public DOTWriter(String outputPath){
        content = new StringBuilder();
        output = new File(outputPath);
    }

    public String toDOT(BasicGraphModel g){
        setup(g);
        g.toEdgeList().forEach(this::addEdge);
        finish();
        return content.toString();
    }

    private void setup(BasicGraphModel g){
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

    private void write(){
        try {
            Files.write(Paths.get(output.getPath()), content.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
