package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * 作用:
 *
 * @projectName: day6-oo-parkinglot-starter
 * @package: com.afs.parkinglot
 * @className: ParkingBoyTest
 * @author: lhfy
 * @description: TODO
 * @date: 2025/9/8 19:30
 * @version: 1.0
 */

public class ParkingBoyTest {
    @Test
    public void should_return_ticket_when_car_park() {
        //given
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot(10);
        List<ParkingLot> parkingLots = List.of(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        //when
        Ticket ticket = parkingBoy.parkCar(car);
        //then
        assertNotNull(ticket);
    }
}
