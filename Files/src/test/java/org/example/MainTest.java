package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void listFiles() {
        Main.listFiles("/home/davmunher/ejemplo");
    }

    @Test
    void testListFiles() {
        Main.listFiles("/home/davmunher/ejemplo", "txt");
    }

    @Test
    void testCreateAndWriteFiles() {
        Main.createAndWriteFiles("/home/davmunher/ejemplo/", 7);
    }

    @Test
    void testFindWord() {
        int times = Main.findWord("/home/davmunher/ejemplo/1.txt", "file");
        assertEquals(1, times);
    }

}