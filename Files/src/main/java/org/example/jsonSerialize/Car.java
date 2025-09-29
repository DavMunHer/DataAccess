package org.example.jsonSerialize;

public class Car {
    private static long idGenerator = 0;
    private long id;
    private String model;
    private String brand;

    public Car() {
        this.id = ++idGenerator;
    }

    public Car(String model, String brand) {
        this.id = ++idGenerator;
        this.model = model;
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
