package pl.wsb.hotel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

public class HotelTest {
    Room room1 = new Room("12345", "room1", 25.10, 1, true, true, true, 1, true, true );
    Client client1 = new Client("98765", "clien1firstname", "client1lastname", LocalDate.of(2019, Month.AUGUST, 16), "Poland", 11223344, "client1@thismail.com");
    Hotel hotel1 = new Hotel("hotel1");
    

    @Test
    void simpleTest(){
        int result = 2+3;
        Assertions.assertEquals(5, result);
    }

}
