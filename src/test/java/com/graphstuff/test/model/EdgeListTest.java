package com.graphstuff.test.model;

import com.graphstuff.model.*;
import com.graphstuff.parser.EdgeListFileParser;
import org.junit.jupiter.api.*;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Spliterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class EdgeListTest {

    EdgeList el;
    File f;

    @BeforeEach
    @Test
    @DisplayName("EdgeList Constructor")
    void EdgeListConstructor(){
        f = new File("src/test/resources/k3_3.txt");
        el = new EdgeList(EdgeListFileParser.parseFile(f));
        el = new EdgeList(f);
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
        assertEquals(9,el.size());
        el.addEdge(new Edge(2,3));
        assertEquals(10, el.size());
    }

    @Test
    @DisplayName("Test getting edge by ID")
    void getEdge(){
        assertEquals(new Edge(1,4), el.getEdge(1));
    }

    @Test
    @DisplayName("Test getVMax")
    void getVMax(){
        assertEquals(6, el.getVMax());
    }

    @Test
    void toIncidenceMatrix() {
        assertEquals(el.toIncidenceMatrix(), new IncidenceMatrix(f));
    }

    @Test
    void toAdjacencyMatrix() {
        assertEquals(el.toAdjacencyMatrix(), new AdjacencyMatrix(f));
    }

    @Test
    void toAdjacencyList() {
        assertEquals(el.toAdjacencyList(), new AdjacencyList(f));
    }

    @Test
    void getSearchableStructure() {
        assertEquals(el.getSearchableStructure(), el);
    }

    @Test
    void foreach(){
        ArrayList<Edge> edges = new ArrayList<>();
        el.forEach(edge -> edges.add(edge));
        assertEquals(el.getEdgeList(), edges);
    }

    @Test
    void iter(){
        ArrayList<Edge> edges = new ArrayList<>();
        Iterator<Edge> iter = el.iterator();
        iter.forEachRemaining(edge -> edges.add(edge));
        assertEquals(el.getEdgeList(), edges);
    }

    @Test
    void spliter(){
        ArrayList<Edge> edges = new ArrayList<>();
        Spliterator<Edge> spliter = el.spliterator();
        spliter.forEachRemaining(edge -> edges.add(edge));
        assertEquals(el.getEdgeList(), edges);
    }
}