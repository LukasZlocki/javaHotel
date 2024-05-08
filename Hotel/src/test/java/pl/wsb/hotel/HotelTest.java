package pl.wsb.hotel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

public class HotelTest {
    Room room1 = new Room("1111", "room1", 25.10, 1, true, true, true, 1, true, true );
    Room room2 = new Room("2222", "room2", 50.10, 2, true, true, true, 2, true, true );
    Room room3 = new Room("3333", "room13", 75.10, 3, false, false, false, 3, false, false );
    Client client1 = new Client("11", "client1firstname", "client1lastname", LocalDate.of(2019, Month.AUGUST, 11), "Poland", 11111111, "client1@thismail.com");
    Client client2 = new Client("22", "client2firstname", "client2lastname", LocalDate.of(1999, Month.AUGUST, 12), "England", 22222222, "client2@thismail.com");
    Client client3 = new Client("33", "client3firstname", "client3lastname", LocalDate.of(1969, Month.AUGUST, 13), "USA", 33333333, "client3@thismail.com");
    Hotel hotel1 = new Hotel("hotel1");

    @Test
    void testFullNameConsistWithFirstAndSecondName(){
        Assertions.assertEquals("client1firstname client1lastname", client1.getFullName());
    }

    @Test
    void testAddRoomToHotelAndCheckIfTheSameArea(){
        String roomId = hotel1.addRoom(99.12, 5, false, "testroom4");
        Assertions.assertEquals(99.12, hotel1.getRoomArea(roomId));
    }


    @Test
    void simpleTest(){
        int result = 2+3;
        Assertions.assertEquals(5, result);
    }

}
