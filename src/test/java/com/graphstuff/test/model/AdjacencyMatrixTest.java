package com.graphstuff.test.model;

import com.graphstuff.model.AdjacencyMatrix;
import com.graphstuff.model.EdgeList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdjacencyMatrixTest {
    private AdjacencyMatrix am;

    @BeforeEach
    @Test
    @DisplayName("Test Constructor")
    void AdjacencyMatrixConstructor(){
        am = new AdjacencyMatrix(new File("src/test/resources/k3_3.txt"));
        am = new AdjacencyMatrix(new EdgeList(new File("src/test/resources/k3_3.txt")));
    }

    @Test
    @DisplayName("Test lookup")
    void lookup(){
        assertTrue(am.lookup(1,5));
        assertFalse(am.lookup(3,2));
    }

    @Test
    @DisplayName("Test Raw Matrix")
    void getRawMatrix(){
        assertTrue(am.getRawMatrix()[1][3]);
        assertFalse(am.getRawMatrix()[0][0]);
        assertFalse(am.getRawMatrix()[1][2]);
    }
}
