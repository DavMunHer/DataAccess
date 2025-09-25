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
    }
}