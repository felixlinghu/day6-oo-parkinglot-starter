package com.afs.parkinglot;

import java.util.Objects;

public class Car {
    private Integer id;

    public Car(Integer id) {
        this.id = id;
    }
    public Car() {
    }

    public Integer getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Objects.equals(id, car.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
