package com.afs.parkinglot;

import java.util.HashMap;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ParkingLot {
    public int getCapacity() {
        return capacity;
    }

    private int capacity;
    private final static int CAPICITY = 10;
    private HashMap<Ticket, Car> parkingRecordSheet = new HashMap<>();

    public ParkingLot(int capacity) {
        this.capacity = capacity;
    }

    public ParkingLot() {
        this.capacity = CAPICITY;
    }

    public Ticket parkCar(Car car) {
        if (parkingRecordSheet.size() >= capacity) {
            System.out.print("No available position.");
        }
        return IntStream.rangeClosed(1, capacity).boxed()
                .filter(position -> parkingRecordSheet.keySet().stream().noneMatch(ticket -> ticket.getPosition() == position))
                .findFirst()
                .map(positon ->
                        {
                            Ticket ticket = new Ticket(this, car, positon);
                            parkingRecordSheet.put(ticket, car);
                            return ticket;
                        }
                ).orElse(null);

    }

    public Car fetchCar(Ticket ticket) {
        if (!parkingRecordSheet.containsKey(ticket)) {
            System.out.print("Unrecognized parking ticket.");
        }
        return parkingRecordSheet.remove(ticket);
    }

    public int getAvailablePosition() {
        return capacity - parkingRecordSheet.size();
    }
}
