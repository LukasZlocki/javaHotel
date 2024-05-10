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
        // Given
        Hotel hotel = new Hotel("hotel");
        String clientId = hotel.addClient("client1firstname", "client1lastname", LocalDate.of(1997, Month.AUGUST, 12));

        // When
        String fullNameOfImplementedClient = hotel.getClientFullName(clientId);

        // Then
        assertEquals("client1firstname client1lastname", fullNameOfImplementedClient);
    }

    @Test
    void testFullNameConsistWithFirstAndSecondName(){
        // Given
        Hotel hotel = new Hotel("hotel");
        String clientId = hotel.addClient("client1firstname", "client1lastname", LocalDate.of(1997, Month.AUGUST, 12));

        // When
        String clientFullName = hotel.getClientFullName(clientId);

        // Then
        assertEquals("client1firstname client1lastname", clientFullName);
    }

    @Test
    void testNullWhenNoClientWithGivenClientId(){
        // Given
        Hotel hotel = new Hotel("hotel");
        String falseClientId = "falseClientId";

        // When
        var falseClient = hotel.getClientFullName(falseClientId);

        // Then
        Assertions.assertNull(null, falseClient);
    }

    @Test
    void testCalculatingUnderageClients(){
        // Given
        Hotel hotel = new Hotel("hotel");
        String underageClientId = hotel.addClient("clientunderagefirstname", "clientunderagelastname", LocalDate.of(2020, Month.AUGUST, 12));

        // When
        int clientQuantity = hotel.getNumberOfUnderageClients();

        // Then
        assertEquals(1, clientQuantity );
    }

    @Test
    void testAddRoomToHotelAndCheckIfGeneratedIdCoversAddedRoom(){
        // Given
        Hotel hotel = new Hotel("hotel");
        String roomId = hotel.addRoom(99.12, 5, false, "testroom");

        // When
        double roomArea = hotel.getRoomArea(roomId);

        // Then
        assertEquals(99.12, roomArea);
    }

    @Test
    void testGetRoomAreaByRoomId(){
        // Given
        Hotel hotel = new Hotel("hotel");
        String areaRoomId = hotel.addRoom(100.20, 3, false, "testroomarea");

        // When
        double roomArea = hotel.getRoomArea(areaRoomId);

        // Then
        assertEquals(100.20, roomArea);
    }

    @Test
    void testGetRoomAreaByFalseRoomId(){
        // Given
        Hotel hotel = new Hotel("hotel");
        String falseRoomId = "falseRoomId";

        // When
        double returnValue = hotel.getRoomArea(falseRoomId);

        // Then
        assertEquals(0, returnValue);
    }

    @Test
    void testGetNumberOfRoomsWithKingSizeBed(){
        // Given
        Hotel hotelKingSize = new Hotel("KingSizeTest");
        String kingSize1RoomId = hotelKingSize.addRoom(45.20, 1, true, "testroomarea");
        String kingSize2RoomId = hotelKingSize.addRoom(25.20, 1, true, "testroomarea");

        // When
        int floor = 1;
        int kingSizeBedQuantity = hotelKingSize.getNumberOfRoomsWithKingSizeBed(floor);

        // Then
        assertEquals(2, kingSizeBedQuantity);
    }

    @Test
    void testRoomsWithNoKingSizeBed(){
        // Given
        Hotel hotelNoKingSize = new Hotel("KingSizeTest");
        String kingSize1RoomId = hotelNoKingSize.addRoom(45.20, 1, false, "testroomarea");
        String kingSize2RoomId = hotelNoKingSize.addRoom(25.20, 1, false, "testroomarea");

        // When
        int floor = 1;
        int kingSizeBedQuantity = hotelNoKingSize.getNumberOfRoomsWithKingSizeBed(floor);

        // Then
        assertEquals(0, kingSizeBedQuantity);
    }

    @Test
    void testAddReservationWithNoValidCustomerId(){
        // Given
        Hotel hotel = new Hotel("hotel");

        // When
        ClientNotFoundException exception = assertThrows(ClientNotFoundException.class, () -> {
            hotel.addNewReservation("falseClientId", "falseRoomId", LocalDate.of(2020, Month.AUGUST, 12));
        });

        // Then
        assertEquals("Client not found in database.", exception.getMessage());
    }


    @Test
    void testAddReservationWithNoValidRoomId() throws RoomNotFoundException{
        // Given
        Hotel hotel = new Hotel("reservationTest");

        // When
        String clientId = hotel.addClient("client1firstname", "client1lastname", LocalDate.of(1997, Month.AUGUST, 12));
        RoomNotFoundException exception = assertThrows(RoomNotFoundException.class, () -> {
            hotel.addNewReservation(clientId , "falseRoomId", LocalDate.of(2020, Month.AUGUST, 12));
        });

        // Then
        assertEquals("Room not found in database.", exception.getMessage());
    }

    @Test
    void testConfirmReservationByFailedReservationId(){
        // Given
        Hotel hotel = new Hotel("Reservation Test");

        // When
        ReservationNotFoundException exception = assertThrows(ReservationNotFoundException.class, () -> {
            hotel.confirmReservation("falseReservationId");
        });

        // Then
        assertEquals("Reservation not found.", exception.getMessage());
    }

    @Test
    void testConfirmReservationByReservationId() throws ClientNotFoundException, RoomNotFoundException {
        // Given
        Client client1 = new Client("11", "client1firstname", "client1lastname", LocalDate.of(2019, Month.AUGUST, 11), "Poland", 11111111, "client1@thismail.com");
        Room room1 = new Room("1111", "room1", 25.10, 1, true, true, true, 1, true, true );
        Hotel hotel = new Hotel("Reservation Test");
        String clientId = hotel.addClient("client1firstname", "client1lastname", LocalDate.of(2019, Month.AUGUST, 11));
        String roomId = hotel.addRoom(45.20, 1, true, "testroomarea");
        String reservationId = hotel.addNewReservation(clientId, roomId,LocalDate.of(2023, Month.AUGUST, 11));

        // When
        String reservation = hotel.confirmReservation(reservationId);

        // Then
        assertEquals(reservationId, reservation);
    }

    @Test
    void testIsRoomReservedByGoodRoomIdAndDateWhereRoomIsNotAvailable() throws ClientNotFoundException, RoomNotFoundException {
        // Given
        Client client1 = new Client("11", "client1firstname", "client1lastname", LocalDate.of(2019, Month.AUGUST, 11), "Poland", 11111111, "client1@thismail.com");
        Room room1 = new Room("1111", "room1", 25.10, 1, true, true, true, 1, true, true );
        Hotel hotel = new Hotel("Reservation Test");
        String clientId = hotel.addClient("client1firstname", "client1lastname", LocalDate.of(2019, Month.AUGUST, 11));
        String roomId = hotel.addRoom(45.20, 1, true, "testroomarea");
        String reservationId = hotel.addNewReservation(clientId, roomId,LocalDate.of(2023, Month.AUGUST, 11));

        // When
        LocalDate date = LocalDate.of(2023, Month.AUGUST, 11);

        // Then
        assertTrue(hotel.isRoomReserved(roomId, date));
    }

    @Test
    void testIsRoomReservedByGoodRoomIdAndDateWhereRoomIsAvailable() throws ClientNotFoundException, RoomNotFoundException {
        // Given
        Client client1 = new Client("11", "client1firstname", "client1lastname", LocalDate.of(2019, Month.AUGUST, 11), "Poland", 11111111, "client1@thismail.com");
        Room room1 = new Room("1111", "room1", 25.10, 1, true, true, true, 1, true, true );
        Hotel hotel = new Hotel("Reservation Test");
        String clientId = hotel.addClient("client1firstname", "client1lastname", LocalDate.of(2019, Month.AUGUST, 11));
        String roomId = hotel.addRoom(45.20, 1, true, "testroomarea");
        String reservationId = hotel.addNewReservation(clientId, roomId,LocalDate.of(2022, Month.AUGUST, 11));

        // When
        LocalDate date = LocalDate.of(2023, Month.AUGUST, 11);

        // Then
        assertFalse(hotel.isRoomReserved(roomId,date));
    }

    @Test
    void testGettingNumbersOfUnconfirmedReservations() throws ClientNotFoundException, RoomNotFoundException {
        // Given
        Client client1 = new Client("11", "client1firstname", "client1lastname", LocalDate.of(2019, Month.AUGUST, 11), "Poland", 11111111, "client1@thismail.com");
        Room room1 = new Room("1111", "room1", 25.10, 1, true, true, true, 1, true, true );
        Hotel hotel = new Hotel("Reservation Test");
        String clientId = hotel.addClient("client1firstname", "client1lastname", LocalDate.of(2019, Month.AUGUST, 11));
        String roomId = hotel.addRoom(45.20, 1, true, "testroomarea");
        String reservationId = hotel.addNewReservation(clientId, roomId,LocalDate.of(2022, Month.AUGUST, 11));

        // When
        LocalDate date = LocalDate.of(2022, Month.AUGUST, 11);
        int confirmedReservation = hotel.getNumberOfUnconfirmedReservation(date);

        // Then
        assertEquals(1, confirmedReservation);
    }

    @Test
    void testGetRoomIdsReservedByClient() throws ClientNotFoundException, RoomNotFoundException {
        // Given
        Hotel hotel = new Hotel("Reservation Test");
        String clientId = hotel.addClient("client1firstname", "client1lastname", LocalDate.of(2019, Month.AUGUST, 11));
        String roomId = hotel.addRoom(45.20, 1, true, "testroomarea");
        String reservationId1 = hotel.addNewReservation(clientId, roomId,LocalDate.of(2022, Month.AUGUST, 11));
        String reservationId2 = hotel.addNewReservation(clientId, roomId,LocalDate.of(2021, Month.AUGUST, 11));
        String reservationId3 = hotel.addNewReservation(clientId, roomId,LocalDate.of(2020, Month.AUGUST, 11));

        // When
        Collection<String> clientRoomsIds = new ArrayList<>();
        clientRoomsIds = hotel.getRoomIdsReservedByClient(clientId);
        int roomsReservedByClient = hotel.getRoomIdsReservedByClient(clientId).size();

        // Then
        assertEquals(3, roomsReservedByClient);
    }
}



