package com.graphstuff.test.algorithm;

import com.graphstuff.algorithm.DFS;
import com.graphstuff.algorithm.TopSort;
import com.graphstuff.model.EdgeList;
import com.graphstuff.model.Node;
import com.graphstuff.parser.EdgeListFileParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TopSortTest {

    EdgeList el;
    File f;
    TopSort topSort;

    @BeforeEach
    void setUp() {
        f = new File("src/test/resources/k3_3.txt");
        el = new EdgeList(EdgeListFileParser.parseFile(f));
        topSort = new TopSort(el, 1);
    }


    @Test
    void sort() {
        DFS dfs = new DFS(el,1,3, false);
        HashMap<Integer, Node> nodes = dfs.search().getMappedNodes();
        ArrayList<Node> resultNodes = topSort.sort();
        int[] expectedOrder = {1,4,2,5,3,6};
        for (int i = 0; i< resultNodes.size(); i++){
            assertEquals(resultNodes.get(i).getVertId(), nodes.get(expectedOrder[i]).getVertId());
        }
    }

    @Test
    void compare() {
        Node n1 = new Node(1);
        Node n2 = new Node(2);

        n1.setTimeFinished(27);
        n2.setTimeFinished(21);
        assertTrue(topSort.compare(n1,n2) > 0);
        n1.setTimeFinished(15);
        assertTrue(topSort.compare(n1,n2) < 0);
        n1.setTimeFinished(21);
        assertEquals(0, topSort.compare(n1, n2));
    }
}