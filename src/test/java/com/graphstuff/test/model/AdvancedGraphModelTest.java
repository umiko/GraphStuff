package com.graphstuff.test.model;

import com.graphstuff.model.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class AdvancedGraphModelTest {
    File f;
    IncidenceMatrix im;

    @BeforeEach
    void setup(){
        f = new File("src/test/resources/k3_3.txt");
        im = new IncidenceMatrix(f);
    }

    @Test
    void addEdge() {
        im.addEdge(new Edge(1,7));
        assertEquals(im.getEdge(10), new Edge(1,7));
    }

    @Test
    void getEdge(){
        assertEquals(im.getEdge(1), new Edge(1,4));
    }

    @Test
    void toIncidenceMatrix() {
        assertEquals(im.toIncidenceMatrix(), im);
    }

    @Test
    void toAdjacencyMatrix() {
        assertEquals(im.toAdjacencyMatrix(), new AdjacencyMatrix(f));
    }

    @Test
    void toAdjacencyList() {
        assertEquals(im.toAdjacencyList(), new AdjacencyList(f));
    }

    @Test
    void getSearchableStructure() {
        assertEquals(im.toEdgeList(), new EdgeList(f));
    }
}