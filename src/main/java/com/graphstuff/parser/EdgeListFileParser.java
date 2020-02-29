package com.graphstuff.parser;

import com.graphstuff.model.Edge;

import java.io.*;
import java.util.ArrayList;

public final class EdgeListFileParser {
    private EdgeListFileParser(){

    }

    public static ArrayList<Edge> parseFile(File f) {
        ArrayList<String> edgeStrings = readFile(f);
        edgeStrings.remove(0);
        ArrayList<Edge> edges = new ArrayList<>();
        Edge e;
        for (String s : edgeStrings){
            String[] vertices = s.split(" ");
            if(vertices.length != 2 && vertices.length != 3){
                throw new IllegalArgumentException("Illegal edge input");
            }
            else {
                e = new Edge(Integer.parseInt(vertices[0]), Integer.parseInt(vertices[vertices.length == 2 ? 1 : 2]));
                if (vertices.length == 3){
                    e.setWeight(Integer.parseInt(vertices[1]));
                }
                edges.add(e);
            }
        }
        return edges;
    }

    public static ArrayList<String> readFile(File f){
        try(FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr)){
            String line;
            ArrayList<String> content = new ArrayList<>();
            while((line=br.readLine()) != null){
                content.add(line);
            }
            return content;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
