package com.graphstuff.test.model;

import com.graphstuff.model.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    Node n;
    Node n2;

    @BeforeEach
    void setup(){
        n = new Node(1,1,0,null);
        n2 = new Node(2,0,1,n);
    }

    @Test
    void getId() {
        assertEquals(1, n.getId());
        assertEquals(2, n2.getId());
    }

    @Test
    void getColor() {
        assertEquals(1, n.getColor());
        assertEquals(0, n2.getColor());
    }

    @Test
    void setColor() {
        n.setColor(2);
        assertEquals(n.getColor(), 2);
    }

    @Test
    void getParent() {
        assertNull(n.getParent());
        assertEquals(n, n2.getParent());
    }

    @Test
    void setParent() {
        n.setParent(n2);
        assertEquals(n2, n.getParent());
    }

    @Test
    void getDistance() {
       assertEquals(n2.getDistance(), 1);
    }

    @Test
    void setDistance() {
        n.setDistance(2);
        assertEquals(n.getDistance(), 2);
    }

    @Test
    void getChildren() {
        assertEquals(n2, n.getChildren().get(0));
    }

    @Test
    void setChildren() {
        Node n3 = new Node(3,4,5, n2);
        n2.setChildren(new ArrayList<Node>(){{add(n3);}});
        assertEquals(n3, n2.getChildren().get(0));
    }
}