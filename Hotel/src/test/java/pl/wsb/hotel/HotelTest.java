package pl.wsb.hotel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.wsb.hotel.exceptions.ClientNotFoundException;
import pl.wsb.hotel.exceptions.ReservationNotFoundException;
import pl.wsb.hotel.exceptions.RoomNotFoundException;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HotelTest {


    @Test
    void testAddingClientAndCheckIfGeneratedIdCoversAddedClient(){
        // Arrange //
        Hotel hotel = new Hotel("hotel");
        String clientId = hotel.addClient("client1firstname", "client1lastname", LocalDate.of(1997, Month.AUGUST, 12));
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
        // Arrange //
        Hotel hotel = new Hotel("hotel");
        // Assert //
        Assertions.assertNull(null, hotel.getClientFullName("falseClientId"));
    }

    @Test
    void testCalculatingUnderageClients(){
        // Arrange //
        Hotel hotel = new Hotel("hotel");
        String underageClientId = hotel.addClient("clientunderagefirstname", "clientunderagelastname", LocalDate.of(2020, Month.AUGUST, 12));
        // Assert //
        assertEquals(1, hotel.getNumberOfUnderageClients());
    }

    @Test
    void testAddRoomToHotelAndCheckIfGeneratedIdCoversAddedRoom(){
        // Arrange //
        Hotel hotel = new Hotel("hotel");
        String roomId = hotel.addRoom(99.12, 5, false, "testroom");
        // Assert //
        assertEquals(99.12, hotel.getRoomArea(roomId));
    }

    @Test
    void testGetRoomAreaByRoomId(){
        // Arrange //
        Hotel hotel = new Hotel("hotel");
        String areaRoomId = hotel.addRoom(100.20, 3, false, "testroomarea");
        // Assert //
        assertEquals(100.20, hotel.getRoomArea(areaRoomId));
    }

    @Test
    void testGetRoomAreaByFalseRoomId(){
        // Assert //
        Hotel hotel = new Hotel("hotel");
        assertEquals(0, hotel.getRoomArea("falseRoomId"));
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
        Hotel hotel = new Hotel("hotel");
        ClientNotFoundException exception = assertThrows(ClientNotFoundException.class, () -> {
            hotel.addNewReservation("falseClientId", "falseRoomId", LocalDate.of(2020, Month.AUGUST, 12));
        });
        // Assert //
        assertEquals("Client not found in database.", exception.getMessage());
    }


    @Test
    void testAddReservationWithNoValidRoomId() throws RoomNotFoundException{
        // Arrange
        Hotel hotel = new Hotel("reservationTest");
        String clientId = hotel.addClient("client1firstname", "client1lastname", LocalDate.of(1997, Month.AUGUST, 12));
        RoomNotFoundException exception = assertThrows(RoomNotFoundException.class, () -> {
            hotel.addNewReservation(clientId , "falseRoomId", LocalDate.of(2020, Month.AUGUST, 12));
        });
        // Assert //
        assertEquals("Room not found in database.", exception.getMessage());
    }

    @Test
    void testConfirmReservationByFailedReservationId(){
        // Arrange //
        Hotel hotel = new Hotel("Reservation Test");
        ReservationNotFoundException exception = assertThrows(ReservationNotFoundException.class, () -> {
            hotel.confirmReservation("falseReservationId");
        });

        // Assert //
        assertEquals("Reservation not found.", exception.getMessage());
    }

    @Test
    void testConfirmReservationByReservationId() throws ClientNotFoundException, RoomNotFoundException {
        // Arrange //
        Client client1 = new Client("11", "client1firstname", "client1lastname", LocalDate.of(2019, Month.AUGUST, 11), "Poland", 11111111, "client1@thismail.com");
        Room room1 = new Room("1111", "room1", 25.10, 1, true, true, true, 1, true, true );
        Hotel hotel = new Hotel("Reservation Test");
        String clientId = hotel.addClient("client1firstname", "client1lastname", LocalDate.of(2019, Month.AUGUST, 11));
        String roomId = hotel.addRoom(45.20, 1, true, "testroomarea");
        String reservationId = hotel.addNewReservation(clientId, roomId,LocalDate.of(2023, Month.AUGUST, 11));
        // Act & Assert //
        assertEquals(reservationId, hotel.confirmReservation(reservationId));
    }

    @Test
    void testIsRoomReservedByGoodRoomIdAndDateWhereRoomIsNotAvailable() throws ClientNotFoundException, RoomNotFoundException {
        // Arrange //
        Client client1 = new Client("11", "client1firstname", "client1lastname", LocalDate.of(2019, Month.AUGUST, 11), "Poland", 11111111, "client1@thismail.com");
        Room room1 = new Room("1111", "room1", 25.10, 1, true, true, true, 1, true, true );
        Hotel hotel = new Hotel("Reservation Test");
        String clientId = hotel.addClient("client1firstname", "client1lastname", LocalDate.of(2019, Month.AUGUST, 11));
        String roomId = hotel.addRoom(45.20, 1, true, "testroomarea");
        String reservationId = hotel.addNewReservation(clientId, roomId,LocalDate.of(2023, Month.AUGUST, 11));

        // Assert
        assertTrue(hotel.isRoomReserved(roomId, LocalDate.of(2023, Month.AUGUST, 11)));
    }

    @Test
    void testIsRoomReservedByGoodRoomIdAndDateWhereRoomIsAvailable() throws ClientNotFoundException, RoomNotFoundException {
        // Arrange //
        Client client1 = new Client("11", "client1firstname", "client1lastname", LocalDate.of(2019, Month.AUGUST, 11), "Poland", 11111111, "client1@thismail.com");
        Room room1 = new Room("1111", "room1", 25.10, 1, true, true, true, 1, true, true );
        Hotel hotel = new Hotel("Reservation Test");
        String clientId = hotel.addClient("client1firstname", "client1lastname", LocalDate.of(2019, Month.AUGUST, 11));
        String roomId = hotel.addRoom(45.20, 1, true, "testroomarea");
        String reservationId = hotel.addNewReservation(clientId, roomId,LocalDate.of(2022, Month.AUGUST, 11));

        // Assert
        assertFalse(hotel.isRoomReserved(roomId, LocalDate.of(2023, Month.AUGUST, 11)));
    }

    @Test
    void testGettingNumbersOfUnconfirmedReservations() throws ClientNotFoundException, RoomNotFoundException {
        // Arrange //
        Client client1 = new Client("11", "client1firstname", "client1lastname", LocalDate.of(2019, Month.AUGUST, 11), "Poland", 11111111, "client1@thismail.com");
        Room room1 = new Room("1111", "room1", 25.10, 1, true, true, true, 1, true, true );
        Hotel hotel = new Hotel("Reservation Test");
        String clientId = hotel.addClient("client1firstname", "client1lastname", LocalDate.of(2019, Month.AUGUST, 11));
        String roomId = hotel.addRoom(45.20, 1, true, "testroomarea");
        String reservationId = hotel.addNewReservation(clientId, roomId,LocalDate.of(2022, Month.AUGUST, 11));

        // Assert
        assertEquals(1, hotel.getNumberOfUnconfirmedReservation(LocalDate.of(2022, Month.AUGUST, 11)));
    }

    @Test
    void testGetRoomIdsReservedByClient() throws ClientNotFoundException, RoomNotFoundException {
        // Arrange //
        Hotel hotel = new Hotel("Reservation Test");
        String clientId = hotel.addClient("client1firstname", "client1lastname", LocalDate.of(2019, Month.AUGUST, 11));
        String roomId = hotel.addRoom(45.20, 1, true, "testroomarea");
        String reservationId1 = hotel.addNewReservation(clientId, roomId,LocalDate.of(2022, Month.AUGUST, 11));
        String reservationId2 = hotel.addNewReservation(clientId, roomId,LocalDate.of(2021, Month.AUGUST, 11));
        String reservationId3 = hotel.addNewReservation(clientId, roomId,LocalDate.of(2020, Month.AUGUST, 11));

        // Act //
        Collection<String> clientRoomsIds = new ArrayList<>();
        clientRoomsIds = hotel.getRoomIdsReservedByClient(clientId);

        // Assert //
        assertEquals(3, hotel.getRoomIdsReservedByClient(clientId).size());
    }


}



