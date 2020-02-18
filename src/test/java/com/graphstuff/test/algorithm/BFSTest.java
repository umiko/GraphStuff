package com.graphstuff.test.algorithm;

import com.graphstuff.algorithm.BFS;
import com.graphstuff.model.EdgeList;
import com.graphstuff.model.GraphSearchResult;
import com.graphstuff.parser.EdgeListFileParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class BFSTest {

    EdgeList el;
    File f;
    BFS bfs;

    @BeforeEach
    void setUp() {
        f = new File("src/test/resources/k3_3.txt");
        el = new EdgeList(EdgeListFileParser.parseFile(f));
        bfs = new BFS(el, 1,3,false);
    }

    @Test
    void search() {
        GraphSearchResult res = bfs.search();
        res.printResult();
    }
}