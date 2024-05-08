package pl.wsb.hotel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.wsb.hotel.exceptions.ClientNotFoundException;
import pl.wsb.hotel.exceptions.RoomNotFoundException;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class HotelTest {
    Room room1 = new Room("1111", "room1", 25.10, 1, true, true, true, 1, true, true );
    Room room2 = new Room("2222", "room2", 50.10, 2, true, true, true, 2, true, true );
    Room room3 = new Room("3333", "room13", 75.10, 3, false, false, false, 3, false, false );
    Client client1 = new Client("11", "client1firstname", "client1lastname", LocalDate.of(2019, Month.AUGUST, 11), "Poland", 11111111, "client1@thismail.com");
    Client client2 = new Client("22", "client2firstname", "client2lastname", LocalDate.of(1999, Month.AUGUST, 12), "England", 22222222, "client2@thismail.com");
    Client client3 = new Client("33", "client3firstname", "client3lastname", LocalDate.of(1969, Month.AUGUST, 13), "USA", 33333333, "client3@thismail.com");
    Hotel hotel1 = new Hotel("hotel1");
    String clientId;

    @Test
    void testAddingClientAndCheckIfGeneratedIdCoversAddedClient(){
        // Arrange //
        Hotel hotel = new Hotel("hotel");
        clientId = hotel.addClient("client1firstname", "client1lastname", LocalDate.of(1997, Month.AUGUST, 12));
        // Assert //
        assertEquals("client1firstname client1lastname", hotel.getClientFullName(clientId));
    }

    @Test
    void testFullNameConsistWithFirstAndSecondName(){
        // Arrange //
        Hotel hotel = new Hotel("hotel");
        String clientId = hotel.addClient("client1firstname", "client1lastname", LocalDate.of(1997, Month.AUGUST, 12));
        // Assert //
        assertEquals("client1firstname client1lastname", hotel.getClientFullName(clientId));
    }

    @Test
    void testNullWhenNoClientWithGivenClientId(){
        // Assert //
        Assertions.assertNull(null, hotel1.getClientFullName("falseClientId"));
    }

    @Test
    void testCalculatingUnderageClients(){
        // Arrange //
        String underageClientId = hotel1.addClient("clientunderagefirstname", "clientunderagelastname", LocalDate.of(2020, Month.AUGUST, 12));
        // Assert //
        assertEquals(1, hotel1.getNumberOfUnderageClients());
    }

    @Test
    void testAddRoomToHotelAndCheckIfGeneratedIdCoversAddedRoom(){
        // Arrange //
        String roomId = hotel1.addRoom(99.12, 5, false, "testroom");
        // Assert //
        assertEquals(99.12, hotel1.getRoomArea(roomId));
    }

    @Test
    void testGetRoomAreaByRoomId(){
        // Arrange //
        String areaRoomId = hotel1.addRoom(100.20, 3, false, "testroomarea");
        // Assert //
        assertEquals(100.20, hotel1.getRoomArea(areaRoomId));
    }

    @Test
    void testGetRoomAreaByFalseRoomId(){
        // Assert //
        assertEquals(0, hotel1.getRoomArea("falseRoomId"));
    }

    @Test
    void testGetNumberOfRoomsWithKingSizeBed(){
        // Arrange //
        Hotel hotelKingSize = new Hotel("KingSizeTest");
        String kingSize1RoomId = hotelKingSize.addRoom(45.20, 1, true, "testroomarea");
        String kingSize2RoomId = hotelKingSize.addRoom(25.20, 1, true, "testroomarea");
        // Assert //
        assertEquals(2, hotelKingSize.getNumberOfRoomsWithKingSizeBed(1));
    }

    @Test
    void testRoomsWithNoKingSizeBed(){
        // Arrange //
        Hotel hotelNoKingSize = new Hotel("KingSizeTest");
        String kingSize1RoomId = hotelNoKingSize.addRoom(45.20, 1, false, "testroomarea");
        String kingSize2RoomId = hotelNoKingSize.addRoom(25.20, 1, false, "testroomarea");
        // Assert //
        assertEquals(0, hotelNoKingSize.getNumberOfRoomsWithKingSizeBed(1));
    }

    @Test
    void testAddReservationWithNoValidCustomerId(){
        // Arrange
        ClientNotFoundException exception = assertThrows(ClientNotFoundException.class, () -> {
            hotel1.addNewReservation("falseClientId", "falseRoomId", LocalDate.of(2020, Month.AUGUST, 12));
        });
        // Assert //
        assertEquals("Client not found in database.", exception.getMessage());
    }

    /* ToDo: fix test here
    @Test
    void testAddReservationWithNoValidRoomId(){
        // Arrange
        Hotel hotelReservation1 = new Hotel("reservationTest");
        String reservationClientId = hotelReservation1.addClient("client1firstname", "client1lastname", LocalDate.of(1997, Month.AUGUST, 12));
        RoomNotFoundException exception1 = assertThrows(RoomNotFoundException.class, () -> {
            hotel1.addNewReservation(reservationClientId , "falseRoomId", LocalDate.of(2020, Month.AUGUST, 12));
        });
        // Assert //
        assertEquals("Room not found in database.", exception1.getMessage());
    }

    @Test
    void testAddReservationWithNoAvailableRoomAtSpecificDate(){
        // Arrange
        LocalDate specificDate = LocalDate.of(2021, Month.AUGUST, 21);
        Hotel hotelReservation2 = new Hotel("reservationTest2");
        String roomId = hotelReservation2.addRoom(45.20, 1, false, "testroomarea");
        String clientId = hotelReservation2.addClient("client", "client", LocalDate.of(2020, Month.AUGUST, 12));
        String reservationId = hotelReservation2.addNewReservation(clientId, roomId, specificDate);

        String reservationClientId = hotelReservation2.addClient("client1firstname", "client1lastname", LocalDate.of(1997, Month.AUGUST, 12));
        RoomNotFoundException exception1 = assertThrows(RoomNotFoundException.class, () -> {
            hotel1.addNewReservation(reservationClientId , "falseRoomId", specificDate);
        });
        // Assert //
        assertEquals("Room not found in database.", exception1.getMessage());
    }
    */

}



