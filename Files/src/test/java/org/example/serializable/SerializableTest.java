package org.example.serializable;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;

import static org.junit.jupiter.api.Assertions.*;

class SerializableTest {
    @Test
    void testSerializeData() {
        Main.serializeData();
    }

    @Test
    void testDeserializeData() {
        Main.deserializeData();
    }


}