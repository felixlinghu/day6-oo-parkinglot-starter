package com.afs.parkinglot;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(byteArrayOutputStream));
    }
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
    @Test
    public void should_return_car_when_get_car_with_correct_ticket() {
        //given
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot(10);
        List<ParkingLot> parkingLots = List.of(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Ticket ticket = parkingBoy.parkCar(car);
        //when
        Car result = parkingBoy.fetchCar(ticket);
        //then
        assertEquals(car, result);
    }

//    @Test
//    public void should_return_two_car_when_get_car_with_two_correct_ticket() {
//        //given
//        Car car1 = new Car(1);
//        Car car2 = new Car(2);
//        ParkingLot parkingLot = new ParkingLot();
//        Ticket ticket1 = parkingLot.parkCar(car1);
//        Ticket ticket2 = parkingLot.parkCar(car2);
//        //when
//        Car result1 = parkingLot.fetchCar(ticket1);
//        Car result2 = parkingLot.fetchCar(ticket2);
//        //then
//        assertEquals(car1, result1);
//        assertEquals(car2, result2);
//    }
//
//    @Test
//    public void should_return_null_when_ticket_is_wrong() {
//        //given
//        Car car = new Car(1);
//        ParkingLot parkingLot = new ParkingLot();
//        Ticket ticket = parkingLot.parkCar(car);
//        //when
//        Car result = parkingLot.fetchCar(new Ticket(parkingLot, car, 11));
//        //then
//        assertNull(result);
//    }
//
//    @Test
//    public void should_return_null_when_ticket_is_used() {
//        //given
//        Car car = new Car(1);
//        ParkingLot parkingLot = new ParkingLot();
//        Ticket ticket = parkingLot.parkCar(car);
//        parkingLot.fetchCar(ticket);
//        //when
//        Car result = parkingLot.fetchCar(ticket);
//        //then
//        assertNull(result);
//    }
//
//    @Test
//    public void should_return_null_when_parklot_is_no_position() {
//        //given
//        Car car = new Car(1);
//        ParkingLot parkingLot = new ParkingLot();
//        for (int i = 0; i < 10; i++) {
//            parkingLot.parkCar(car);
//        }
//        //when
//        Ticket ticket = parkingLot.parkCar(car);
//        //then
//        assertNull(ticket);
//    }
//
//    @Test
//    public void should_log_error_message_when_parklot_is_no_position() {
//        //given
//        Car car = new Car(1);
//        ParkingLot parkingLot = new ParkingLot();
//        for (int i = 0; i < 10; i++) {
//            parkingLot.parkCar(car);
//        }
//        //when
//        Ticket ticket = parkingLot.parkCar(car);
//        //then
//        assertEquals("No available position.", byteArrayOutputStream.toString());
//    }
//
//    @Test
//    public void should_log_error_message_when_ticket_is_error() {
//        //given
//        Car car = new Car(1);
//        ParkingLot parkingLot = new ParkingLot();
//        Ticket ticket = parkingLot.parkCar(car);
//        Ticket errorTicket = new Ticket(parkingLot, new Car(2), ticket.getPosition());
//        //when
//        parkingLot.fetchCar(errorTicket);
//        //then
//        assertEquals("Unrecognized parking ticket.", byteArrayOutputStream.toString());
//    }
//
//    @Test
//    public void should_log_error_message_when_ticket_is_used() {
//        //given
//        Car car = new Car(1);
//        ParkingLot parkingLot = new ParkingLot();
//        Ticket ticket = parkingLot.parkCar(car);
//        //when
//        parkingLot.fetchCar(ticket);
//        parkingLot.fetchCar(ticket);
//        //then
//        assertEquals("Unrecognized parking ticket.", byteArrayOutputStream.toString());
//    }
}
