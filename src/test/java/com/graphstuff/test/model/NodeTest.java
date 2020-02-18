package com.graphstuff.test.model;

import com.graphstuff.model.EdgeList;
import com.graphstuff.model.Node;
import com.graphstuff.parser.EdgeListFileParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class NodeTest {

    Node n1;
    Node n2;
    Node n3;

    EdgeList el;
    File f;

    @BeforeEach
    void setUp() {
        f = new File("src/test/resources/k3_3.txt");
        el = new EdgeList(EdgeListFileParser.parseFile(f));
        el = new EdgeList(f);

        n1 = new Node(el, 1);
        n2 = new Node(el, 2, 1);
        n2.setColor(1);
        n3 = new Node(3);
    }

    @Test
    void getColor() {
        assertEquals(0, n1.getColor());
        assertEquals(1, n2.getColor());
    }

    @Test
    void setColor() {
        assertEquals(0, n1.getColor());
        n1.setColor(1);
        assertEquals(1, n1.getColor());
    }

    @Test
    void getParentId() {
        assertEquals( -1, n1.getParentId());
        assertEquals(1, n2.getParentId());
    }

    @Test
    void setParentId() {
        n1.setParentId(3);
        assertEquals(3, n1.getParentId());
    }

    @Test
    void getChildIds() {
        ArrayList<Integer> childs = new ArrayList<>();
        childs.add(4);
        childs.add(5);
        childs.add(6);
        assertTrue(n1.getChildIds().containsAll(childs));
        childs.add(2);
        assertFalse(n1.getChildIds().containsAll(childs));
    }

    @Test
    void setChildIds() {
        ArrayList<Integer> childs = new ArrayList<>();
        childs.add(4);
        childs.add(5);
        childs.add(6);
        Node test = new Node(23);
        test.setChildIds(childs);
        assertTrue(test.getChildIds().containsAll(childs));
    }

    @Test
    void findChildIds() {
        assertTrue(n1.getChildIds().containsAll(Node.findChildIds(1,el,null)));
    }

    @Test
    void addChildId() {
        n1.addChildId(2);
        ArrayList<Integer> childs = new ArrayList<>();
        childs.add(2);
        childs.add(4);
        childs.add(5);
        childs.add(6);
        assertTrue(n1.getChildIds().containsAll(childs));
    }

    @Test
    void testEquals() {
        ArrayList<Integer> childs = new ArrayList<>();
        childs.add(4);
        childs.add(5);
        childs.add(6);
        Node test = new Node(2, childs,1 );
        n2.setColor(0);
        assertEquals(n2, test);
        assertNotEquals(n1,test);
        assertNotEquals(n1, new String("asdfksa"));
    }

    @Test
    void testToString() {
        assertTrue("1 --> 2".equals(n2.toString()));
        assertTrue("1".equals(n1.toString()));
    }
}