package com.graphstuff.test.parser;

import com.graphstuff.model.Edge;
import com.graphstuff.model.EdgeList;
import com.graphstuff.parser.EdgeListFileParser;
import jdk.jfr.Description;
import jdk.jfr.Name;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("File Parser Tests")
class EdgeListFileParserTest {
    static File[] files =  new File[9];

    @BeforeAll
    static void initFiles(){
        //System.out.println(EdgeListFileParserTest.class.getResource("/").getPath());
        files[0] = new File("src/test/resources/simple.txt");
        files[1] = new File("src/test/resources/multi.txt");
        files[2] = new File("src/test/resources/k1_1.txt");
        files[3] = new File("src/test/resources/k3_3.txt");
        files[4] = new File("src/test/resources/k5.txt");
        files[5] = new File("src/test/resources/petersen.txt");
        files[6] = new File("src/test/resources/empty.txt");
        files[7] = new File("src/test/resources/brokenEL.txt");
        files[8] = new File("src/test/resources/bellmannford.txt");
    }

    @Test
    @DisplayName("Test Basic File Reading")
    void readFileTest(){
        assertEquals (new ArrayList<String>(){{add("A simple file");}}, EdgeListFileParser.readFile(files[0]));
        assertEquals (new ArrayList<String>(){{}}, EdgeListFileParser.readFile(files[6]));
        assertEquals(new ArrayList<String>(List.of("a", "multi", "line", "file")), EdgeListFileParser.readFile(files[1]));
        assertNull(EdgeListFileParser.readFile(new File("asd")));
    }

    @Test
    @DisplayName("Test Edge List Parsing")
    void parseFileTest(){
        assertEquals(new ArrayList<Edge>(List.of(new Edge(1, 2))), EdgeListFileParser.parseFile(files[2]));
        assertEquals(new ArrayList<Edge>(List.of(
                new Edge(1, 4),
                new Edge(1, 5),
                new Edge(1, 6),
                new Edge(2, 4),
                new Edge(2, 5),
                new Edge(2, 6),
                new Edge(3, 4),
                new Edge(3, 5),
                new Edge(3, 6)
        )), EdgeListFileParser.parseFile(files[3]));
        assertThrows(IllegalArgumentException.class, ()->{EdgeListFileParser.parseFile(files[7]);});
    }

}