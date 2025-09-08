package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import javax.smartcardio.Card;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    public void should_return_ticket_when_car_park() {
        //given
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot(10);
        //when
        Ticket ticket = parkingLot.parkCar(car);
        //then
        assertNotNull(ticket);
    }

    @Test
    public void should_return_car_when_get_car_with_correct_ticket() {
        //given
        Car car = new Car(1);
        ParkingLot parkingLot = new ParkingLot(10);
        Ticket ticket = parkingLot.parkCar(car);
        //when
        Car result = parkingLot.fetchCar(ticket);
        //then
        assertEquals(car, result);
    }

    @Test
    public void should_return_two_car_when_get_car_with_two_correct_ticket() {
        //given
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        ParkingLot parkingLot=new ParkingLot();
        Ticket ticket1 = parkingLot.parkCar(car1);
        Ticket ticket2 = parkingLot.parkCar(car2);
        //when
        Car result1 = parkingLot.fetchCar(ticket1);
        Car result2 = parkingLot.fetchCar(ticket2);
        //then
        assertEquals(car1, result1);
        assertEquals(car2, result2);
    }

    @Test
    public void should_return_null_when_ticket_is_wrong() {
        //given
        Car car = new Car(1);
        ParkingLot parkingLot=new ParkingLot();
        Ticket ticket = parkingLot.parkCar(car);
        //when
        Car result = parkingLot.fetchCar(new Ticket(parkingLot,car,11));
        //then
        assertNull(result);
    }

//    @Test
//    public void should_return_null_when_ticket_is_used() {
//        //given
//        Car car = new Car(1);
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
//        Ticket ticket = parkingLot.parkCar(car);
//        //when
//        Car result = parkingLot.fetchCar(ticket);
//        //then
//        assertNull(result);
//    }

}
