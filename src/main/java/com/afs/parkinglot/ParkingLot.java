package com.afs.parkinglot;

public class ParkingLot {
    private int capacity;
    private int size;

    public ParkingLot(int capacity) {
        this.capacity = capacity;
        size = 0;
    }

    public ParkingLot() {
    }

    ;

    public Ticket parkCar(Car car) {
        if (car == null || car.getId() == null) {
            return null;
        }
        Ticket ticket = new Ticket(this, car);
        size++;
        return ticket;
    }

    public Car fetchCar(Ticket ticket) {

        return new Car();
    }
}
