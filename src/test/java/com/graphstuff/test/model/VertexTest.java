package com.graphstuff.test.model;

import com.graphstuff.model.EdgeList;
import com.graphstuff.model.Node;
import com.graphstuff.model.Vertex;
import com.graphstuff.parser.EdgeListFileParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class VertexTest {
    Vertex v1;
    Vertex v2;
    Vertex v3;

    EdgeList el;
    File f;

    @BeforeEach
    void setUp() {
        f = new File("src/test/resources/k3_3.txt");
        el = new EdgeList(EdgeListFileParser.parseFile(f));
        el = new EdgeList(f);

        ArrayList<Integer> neighbours = new ArrayList<>();
        neighbours.add(4);
        neighbours.add(5);
        neighbours.add(6);
        v1 = new Vertex(1);
        v2 = new Vertex(2, neighbours);
        v3 = new Vertex(el, 3);
    }

    @Test
    void getVertId() {
        assertEquals(1, v1.getVertId());
        assertEquals(2, v2.getVertId());
    }

    @Test
    void setVertId() {
        v1.setVertId(23);
        assertEquals(23, v1.getVertId());
    }

    @Test
    void getNeighbourIds() {
        ArrayList<Integer> neighbours = new ArrayList<>();
        neighbours.add(4);
        neighbours.add(5);
        neighbours.add(6);
        assertTrue(v2.getNeighbourIds().containsAll(neighbours));
    }

    @Test
    void setNeighbourIds() {
        ArrayList<Integer> neighbours = new ArrayList<>();
        neighbours.add(4);
        neighbours.add(5);
        neighbours.add(12);
        v1.setNeighbourIds(neighbours);
        assertTrue(v1.getNeighbourIds().containsAll(neighbours));
    }

    @Test
    void findNeighbourIds() {
        ArrayList<Integer> neighbours = new ArrayList<>();
        neighbours.add(4);
        neighbours.add(5);
        neighbours.add(6);
        assertTrue(Vertex.findNeighbourIds(el, 1).containsAll(neighbours));
    }

    @Test
    void addNeighbourId() {
        v1.addNeighbourId(25);
        assertTrue(v1.getNeighbourIds().contains(25));
    }

    @Test
    void testEquals() {
        ArrayList<Integer> neighbours = new ArrayList<>();
        neighbours.add(4);
        neighbours.add(5);
        neighbours.add(6);
        assertEquals(v2, new Vertex(2, neighbours));
        assertNotEquals(v1,v2);
        assertNotEquals(v1, new String("asdjsd"));
    }
}