package com.graphstuff.parser;

import com.graphstuff.model.Edge;

import java.io.*;
import java.util.ArrayList;

public final class EdgeListFileParser {
    private EdgeListFileParser(){

    }

    public static Edge[] parseFile(File f) {
        String[] content = readFile(f);
        return new Edge[0];
    }

    private static String[] readFile(File f){
        try(FileReader fr = new FileReader(f); BufferedReader br = new BufferedReader(fr)){
            String line;
            ArrayList<String> content = new ArrayList<>();
            while((line=br.readLine()) != null){
                content.add(line);
            }
            return content.toArray(new String[content.size()]);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
