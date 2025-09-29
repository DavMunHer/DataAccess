package org.example.serializable;

import org.example.jsonSerializable.Car;
import org.example.jsonSerializable.JsonSerialize;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void testSerializeCars() {
        Car c = new Car("ModelEX", "Toyota");
        Car c2 = new Car("ModelEX2", "MyOwnBrand:P");

        List<Car> carList = List.of(c, c2);

        JsonSerialize.serializeCars(carList, "/home/davmunher/ejemplo/cars.json");
    }

}