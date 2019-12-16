package com.graphstuff.test.model;

import com.graphstuff.model.EdgeList;
import com.graphstuff.model.IncidenceMatrix;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class IncidenceMatrixTest {
    IncidenceMatrix im;

    @BeforeEach
    void IncidenceMatrixConstructor(){
        im = new IncidenceMatrix(new EdgeList(new File("src/test/resources/k3_3.txt")));
        im = new IncidenceMatrix(new File("src/test/resources/k3_3.txt"));
    }

    @Test
    @DisplayName("Test Lookup function")
    void lookup(){
        assertTrue(im.lookup(1,1));
        assertFalse(im.lookup(1,6));
    }

    @Test
    @DisplayName("Test returned Matrix")
    void getRawMatrix(){
        boolean[][] m = im.getRawMatrix();
        for (int i = 0; i<m.length; i++){
            for(int j = 0; j<m[i].length; j++){
                assertEquals(m[i][j], im.lookup(i+1,j+1));
            }
        }
    }
}
