package com.graphstuff.test.model;

import com.graphstuff.model.Edge;
import jdk.jfr.Name;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("Edge Tests")
class EdgeTest {
    private Edge e;

    @BeforeAll
    @Test
    @DisplayName("Constructor Test")
    void EdgeConstructorTest(){
        e = new Edge(1,2);
        assertThrows(IllegalArgumentException.class, ()->{new Edge(-2,-10);});
    }

    @Test
    @DisplayName("Getter Test")
    void EdgeGetterTest(){
        assertEquals(1, e.getV1());
        assertEquals(2, e.getV2());
    }

    @Test
    @DisplayName("Test equals method")
    void equals(){
        assertEquals(e, new Edge(1, 2));
        assertNotEquals(e, "sdjhask");
        assertNotEquals(e, new Edge(1,3));
    }

    @Test
    @DisplayName("Test get other vertex")
    void getOther(){
        assertEquals(e.getV2(), e.getOther(e.getV1()));
        assertThrows(IllegalArgumentException.class, ()->{e.getOther(123);});
    }

    @Test
    @DisplayName("Test toString")
    void toStringTest(){
        assertEquals(e.toString(), e.getV1()+" -- "+e.getV2());
    }
}