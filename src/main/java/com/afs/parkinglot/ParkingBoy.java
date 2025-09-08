package com.afs.parkinglot;

import java.util.List;

/**
 * 作用:
 *
 * @projectName: day6-oo-parkinglot-starter
 * @package: com.afs.parkinglot
 * @className: ParkingBoy
 * @author: lhfy
 * @description: TODO
 * @date: 2025/9/8 19:32
 * @version: 1.0
 */

public class ParkingBoy {
    private List<ParkingLot> parkingLots;

    public ParkingBoy(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }

    public Ticket parkCar(Car car) {
        for (ParkingLot parkingLot : parkingLots) {
            if (parkingLot.getAvailablePosition() > 0) {
                return parkingLot.parkCar(car);
            }
        }
        System.out.print("No available position.");
        return null;
    }

    public Car fetchCar(Ticket ticket) {
        return ticket.getParkingLot().fetchCar(ticket);
    }
}
