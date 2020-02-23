package com.graphstuff.test.algorithm;

import com.graphstuff.algorithm.DFS;
import com.graphstuff.model.EdgeList;
import com.graphstuff.model.GraphSearchResult;
import com.graphstuff.parser.EdgeListFileParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DFSTest {

    EdgeList el;
    File f;
    DFS dfs;

    @BeforeEach
    void setUp() {
        f = new File("src/test/resources/k3_3.txt");
        el = new EdgeList(EdgeListFileParser.parseFile(f));
        dfs = new DFS(el, 1,3,false);
    }

    @Test
    void search() {
        GraphSearchResult res = dfs.search();
        assertEquals("1 --> 4\n4 --> 2\n2 --> 5\n5 --> 3\n", res.toString());
        dfs =new DFS(el, 1,23,false);
        res = dfs.search();
        assertEquals("Target node was not found", res.toString());
    }
}