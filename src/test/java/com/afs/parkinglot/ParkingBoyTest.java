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

    @Test
    public void should_return_two_car_when_get_car_with_two_correct_ticket() {
        //given
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = List.of(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Ticket ticket1 = parkingBoy.parkCar(car1);
        Ticket ticket2 = parkingBoy.parkCar(car2);
        //when
        Car result1 = parkingBoy.fetchCar(ticket1);
        Car result2 = parkingBoy.fetchCar(ticket2);
        //then
        assertEquals(car1, result1);
        assertEquals(car2, result2);
    }

    @Test
    public void should_return_null_when_ticket_is_wrong() {
        //given
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = List.of(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Ticket ticket = parkingBoy.parkCar(car);
        //when
        Car result = parkingBoy.fetchCar(new Ticket(parkingLot, car, 11));
        //then
        assertNull(result);
    }

    @Test
    public void should_return_null_when_ticket_is_used() {
        //given
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = List.of(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Ticket ticket = parkingBoy.parkCar(car);
        parkingBoy.fetchCar(ticket);
        //when
        Car result = parkingBoy.fetchCar(ticket);
        //then
        assertNull(result);
    }
//
    @Test
    public void should_return_null_when_parklot_is_no_position() {
        //given
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = List.of(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        for (int i = 0; i < 10; i++) {
            parkingBoy.parkCar(car);
        }
        //when
        Ticket ticket = parkingBoy.parkCar(car);
        //then
        assertNull(ticket);
    }

    @Test
    public void should_log_error_message_when_parklot_is_no_position() {
        //given
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = List.of(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        for (int i = 0; i < 10; i++) {
            parkingBoy.parkCar(car);
        }
        //when
        Ticket ticket = parkingBoy.parkCar(car);
        //then
        assertEquals("No available position.", byteArrayOutputStream.toString());
    }

    @Test
    public void should_log_error_message_when_ticket_is_error() {
        //given
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = List.of(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Ticket ticket = parkingBoy.parkCar(car);
        Ticket errorTicket = new Ticket(parkingLot, new Car(2), ticket.getPosition());
        //when
        parkingBoy.fetchCar(errorTicket);
        //then
        assertEquals("Unrecognized parking ticket.", byteArrayOutputStream.toString());
    }

    @Test
    public void should_log_error_message_when_ticket_is_used() {
        //given
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot();
        List<ParkingLot> parkingLots = List.of(parkingLot);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        Ticket ticket = parkingBoy.parkCar(car);
        //when
        parkingBoy.fetchCar(ticket);
        parkingBoy.fetchCar(ticket);
        //then
        assertEquals("Unrecognized parking ticket.", byteArrayOutputStream.toString());
    }

    @Test
    public void should_return_first_parkingLot_when_first_parkingLot_is_not_full() {
        //given
        Car car1 = new Car(1);
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(10);
        List<ParkingLot> parkingLots = List.of(parkingLot1, parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        //when
        for (int i = 0; i < parkingLot1.getCapacity(); i++) {
            Ticket ticket = parkingBoy.parkCar(car1);
            assertEquals(parkingLot1, ticket.getParkingLot());
        }
    }
    @Test
    public void should_return_first_parkingLot_when_first_parkingLot_hava_position_in_any_case() {
        //given
        Car car1 = new Car(1);
        ParkingLot parkingLot1 = new ParkingLot(10);
        ParkingLot parkingLot2 = new ParkingLot(10);
        List<ParkingLot> parkingLots = List.of(parkingLot1, parkingLot2);
        ParkingBoy parkingBoy = new ParkingBoy(parkingLots);
        //when
        Ticket ticket = null;
        for (int i = 0; i < parkingLot1.getCapacity(); i++) {
            ticket = parkingBoy.parkCar(car1);
        }
        for (int i = 0; i < parkingLot2.getCapacity()-1; i++) {
            parkingBoy.parkCar(car1);
        }
        parkingBoy.fetchCar(ticket);
        Ticket ticket1 = parkingBoy.parkCar(car1);
        //then
        assertEquals(parkingLot1, ticket1.getParkingLot());


    }


}
