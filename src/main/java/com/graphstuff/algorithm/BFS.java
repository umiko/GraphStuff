package com.graphstuff.algorithm;

import com.graphstuff.model.Graph;
import com.graphstuff.model.GraphSearchResult;
import com.graphstuff.model.Node;

import java.util.Deque;
import java.util.Queue;

public class BFS {
    public static GraphSearchResult search(ISearchable searchable, int root, int target){
        Deque<Node> workload = null;
        Node rootNode = new Node(root, 0,0, null);

        workload.add(rootNode);


        return null;
    };
}
