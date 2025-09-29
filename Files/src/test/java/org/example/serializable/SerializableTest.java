package org.example.serializable;

import com.fasterxml.jackson.databind.node.ArrayNode;
import org.example.jsonDeserialize.JSONOps;
import org.example.jsonDeserialize.JsonCsv;
import org.example.jsonSerialize.Car;
import org.example.jsonSerialize.JsonSerialize;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void testSerializeCars() {
        Car c = new Car("ModelEX", "Toyota");
        Car c2 = new Car("ModelEX2", "MyOwnBrand:P");

        List<Car> carList = List.of(c, c2);

        JsonSerialize.serializeCars(carList, "/home/davmunher/ejemplo/cars.json");
    }

    @Test
    void testSerializeBooks() {
        JSONOps.serializeList("/home/davmunher/ejemplo/books.json");
    }

    // Deserializing JSON
    @Test
    void testReadJsonCsv() {
        JsonCsv.readJsonCsv("language.json", "/home/davmunher/ejemplo/data.csv");
    }

    @Test
    void testReadJsonCsvJackson() {
        JsonCsv.readJsonCsvJackson("language.json", "/home/davmunher/ejemplo/data_1.csv");
    }

    @Test
    void testDeserializeBooks() {
        ArrayNode deserializedInfo = JSONOps.deserializeList("/home/davmunher/ejemplo/books.json");
        Assertions.assertEquals("123456789", deserializedInfo.get(0).get("isbn").asText());
    }
}