package org.example.serializable;

import org.example.jsonSerializable.Car;
import org.example.jsonSerializable.JsonSerialize;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileOutputStream;

import static org.junit.jupiter.api.Assertions.*;

class SerializableTest {

    // .dat TESTS
    @Test
    void testSerializeData() {
        Main.serializeData();
    }

    @Test
    void testDeserializeData() {
        Main.deserializeData();
    }

    // JSON tests
    @Test
    void testSerializeCar() {
        Car c = new Car("ModelEX", "Toyota");
        JsonSerialize.serializeCar(c, "/home/davmunher/ejemplo/car.json");
    }

}