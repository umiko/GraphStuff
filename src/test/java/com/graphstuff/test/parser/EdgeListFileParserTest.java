package com.graphstuff.test.parser;

import com.graphstuff.parser.EdgeListFileParser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

class EdgeListFileParserTest {
    static File[] files;

    @BeforeAll
    static void initFiles(){
        files = new File[3];
        files[0] = new File(EdgeListFileParserTest.class.getResource("k3_3.txt").getPath());
        files[1] = new File(EdgeListFileParserTest.class.getResource("k5.txt").getPath());
        files[2] = new File(EdgeListFileParserTest.class.getResource("petersen.txt").getPath());
    }

    @Test
    void DOTParserParseTest(){
        for (File f: files) {
            EdgeListFileParser.parseFile(f);
        }
    }
}