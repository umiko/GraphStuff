package com.graphstuff.test.model;

import com.graphstuff.model.Edge;
import com.graphstuff.model.EdgeList;
import com.graphstuff.parser.EdgeListFileParser;
import org.junit.jupiter.api.*;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EdgeListTest {

    EdgeList el;

    @BeforeEach
    @Test
    @DisplayName("EdgeList Constructor")
    void EdgeListConstructor(){
        el = new EdgeList(EdgeListFileParser.parseFile(new File("src/test/resources/k1_1.txt")));
        el = new EdgeList(new File("src/test/resources/k1_1.txt"));
    }

    @Test
    @DisplayName("Test Adding a new Edge")
    void add() {
        el.addEdge(new Edge(2,3));
        assertEquals(el.getEdgeList().get(el.size()-1), new Edge(2,3));
    }

    @Test
    @DisplayName("Test Size")
    void size(){
        assertEquals(1,el.size());
        el.addEdge(new Edge(2,3));
        assertEquals(2, el.size());
    }

    @Test
    @DisplayName("Test getting edge by ID")
    void getEdge(){
        assertEquals(new Edge(1,2), el.getEdge(1));
        el.addEdge(new Edge(2,3));
        assertEquals(new Edge(2,3), el.getEdge(2));
    }

    @Test
    @DisplayName("Test getVMax")
    void getVMax(){
        assertEquals(2, el.getVMax());
        el = new EdgeList(new File("src/test/resources/k3_3.txt"));
        assertEquals(6, el.getVMax());
    }
}