package com.afs.parkinglot;

public class Ticket {
   private ParkingLot parkingLot;
   private Car car;
   private int position;

    public int getPosition() {
        return position;
    }

    public Car getCar() {
        return car;
    }

    public ParkingLot getParkingLot() {
        return parkingLot;
    }

    public Ticket(ParkingLot parkingLot, Car car, int position) {
        this.parkingLot = parkingLot;
        this.car = car;
        this.position = position;
    }
}
