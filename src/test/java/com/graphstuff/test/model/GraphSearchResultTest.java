package com.graphstuff.test.model;

import com.graphstuff.algorithm.DFS;
import com.graphstuff.model.EdgeList;
import com.graphstuff.model.GraphSearchResult;
import com.graphstuff.parser.EdgeListFileParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class GraphSearchResultTest {

    EdgeList el;
    File f;
    DFS dfs;
    GraphSearchResult result;

    @BeforeEach
    void setUp() {
        f = new File("src/test/resources/k3_3.txt");
        el = new EdgeList(EdgeListFileParser.parseFile(f));
        dfs = new DFS(el, 1,3,false);
        result = dfs.search();
    }

    @Test
    void mappedNodes() {
        assertFalse(result.getMappedNodes().isEmpty());
        assertEquals(6, result.getMappedNodes().size());
    }

    @Test
    void targetNode() {
        assertEquals(3, result.getTargetNode());
    }

    @Test
    void rootNode() {
        assertEquals(1, result.getRootNode());
    }

    @Test
    void isTargetFound() {
        assertTrue(result.isTargetFound());
    }

    @Test
    void testToString() {
        assertEquals("1 --> 4\n4 --> 2\n2 --> 5\n5 --> 3\n", result.toString());
    }
}