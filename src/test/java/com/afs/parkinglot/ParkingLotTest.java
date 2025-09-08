package com.afs.parkinglot;

import org.junit.jupiter.api.Test;

import javax.smartcardio.Card;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {

    @Test
    public void should_return_ticket_when_car_park() {
        //given
        Car car = new Car(1);
        //when
        Ticket ticket = ParkingLot.parkCar(car);
        //then
        assertNotNull(ticket);
    }

    @Test
    public void should_return_car_when_get_car_with_correct_ticket() {
        //given
        Car car = new Car(1);
        Ticket ticket = ParkingLot.parkCar(car);
        //when
        Car result = ParkingLot.fetchCar(ticket);
        //then
        assertEquals(car, result);
    }

    @Test
    public void should_return_two_car_when_get_car_with_two_correct_ticket() {
        //given
        Car car1 = new Car(1);
        Car car2 = new Car(2);
        Ticket ticket1 = ParkingLot.parkCar(car1);
        Ticket ticket2 = ParkingLot.parkCar(car2);
        //when
        Car result1 = ParkingLot.fetchCar(ticket1);
        Car result2 = ParkingLot.fetchCar(ticket2);
        //then
        assertEquals(car1, result1);
        assertEquals(car2, result2);
    }

    @Test
    public void should_return_null_when_ticket_is_wrong() {
        //given
        Car car = new Car(1);
        Ticket ticket = ParkingLot.parkCar(car);
        //when
        Car result = ParkingLot.fetchCar(new Ticket());
        //then
        assertNull(result);
    }

    @Test
    public void should_return_null_when_ticket_is_used() {
        //given
        Car car = new Car(1);
        Ticket ticket = ParkingLot.parkCar(car);
        ParkingLot.fetchCar(ticket);
        //when
        Car result = ParkingLot.fetchCar(ticket);
        //then
        assertNull(result);
    }

    @Test
    public void should_return_null_when_parklot_is_no_position() {
        //given
        Car car = new Car(1);
        Ticket ticket = ParkingLot.parkCar(car);
        //when
        Car result = ParkingLot.fetchCar(ticket);
        //then
        assertNull(result);
    }

}
