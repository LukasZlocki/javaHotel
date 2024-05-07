package pl.wsb.hotel;

import pl.wsb.hotel.exceptions.ClientNotFoundException;
import pl.wsb.hotel.exceptions.ReservationNotFoundException;
import pl.wsb.hotel.exceptions.RoomNotFoundException;
import pl.wsb.hotel.exceptions.RoomReservedException;
import pl.wsb.hotel.interfaces.HotelCapability;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

public class Hotel implements HotelCapability {
    private String name;
    private List<SpecialService> specialServices;
    private List<Client> clients;
    private List<RoomReservation> reservations;
    private List<Room> rooms;

    // constructor //
    public Hotel(String name){
        this.name = name;
        this.specialServices = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.reservations = new ArrayList<>();
        this.rooms = new ArrayList<>();
    }

    // constructor //
    public Hotel(String name, List<SpecialService> specialServices, List<Client> clients, List<RoomReservation> reservations, List<Room> rooms ){
        this.name = name;
        this.specialServices = specialServices;
        this.clients = clients;
        this.reservations = reservations;
        this.rooms = rooms;
    }

    private String idGenerator(){
        String newId = "";
        Random random = new Random();

        for (int i = 0; i < 24; i++) {
            newId = newId + random.nextInt(10);
        }
        return newId;
    }

    // check if room is in database
    private boolean isRoomInDatabase(int roomId){
        for(Room room : rooms){
            if(room.getId().equals(roomId)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String addClient(String firstName, String lastName, LocalDate birthDate) {
        String newCustomerId = idGenerator();
        Client client = new Client(newCustomerId, firstName, lastName, birthDate, "", 0, "");
        clients.add(client);
        return newCustomerId;
    }

    @Override
    public String getClientFullName(String clientId) {
        for (Client client : clients){
            if(client.getId().equals(clientId)){
                return client.getFullName();
            }
        }
        return null; // no client with given id found
    }

    @Override
    public int getNumberOfUnderageClients() {
        int underageClientsNumber = 0;
        for (Client client : clients){
            if(client.getAge() <= 18){
                underageClientsNumber++;
            }
        }
        return underageClientsNumber;
    }

    @Override
    public String addRoom(double area, int floor, boolean hasKingSizeBed, String description) {
        String newRoomId = idGenerator();
        Room room = new Room(newRoomId, description, area, floor, hasKingSizeBed, false, false, 1,false, false);
        rooms.add(room);
        return newRoomId;
    }

    @Override
    public double getRoomArea(String roomId) {
        double roomArea;
        for (Room room : rooms){
            if(room.getId().equals(roomId)){
                return room.getArea();
            }
        }
        return 0; // no room with given roomId
    }

    @Override
    public int getNumberOfRoomsWithKingSizeBed(int floor) {
        int roomsWithKingSizeBed = 0;
        for(Room room : rooms){
            if(room.getFloor() == floor){
                roomsWithKingSizeBed++;
            }
        }
        return roomsWithKingSizeBed;
    }

    @Override
    public String addNewReservation(String clientId, String roomId, LocalDate date) throws ClientNotFoundException, RoomNotFoundException, RoomReservedException {
        Client clientFinal = null;
        Room roomFinal = null;
        String newReservationId;

        // check if client is in database //
        for(Client client : clients){
            if(client.getId().equals(clientId)){
                clientFinal = client;
            }
            else{
                throw new ClientNotFoundException("Client not found in database.");
            }
        }

        // check if room is in database //
        for(Room room : rooms){
            if(room.getId().equals(roomId)){
                roomFinal = room;
            }
            else{
                throw new RoomNotFoundException("Room not found in database.");
            }
        }

        // check if room is available at specific date //
        for (RoomReservation reservation : reservations){
            if(reservation.getDate().equals(date)){
                if(reservation.getRoom().getId().equals(roomId)){
                    throw new RoomReservedException(roomId, date);
                }
            }
        }

        // perform reservation //
        newReservationId = idGenerator();
        RoomReservation reservation = new RoomReservation(newReservationId, date, false, clientFinal, roomFinal);
        reservations.add(reservation);
        return newReservationId;
    }

    @Override
    public String confirmReservation(String reservationId) throws ReservationNotFoundException {
        for(RoomReservation reservation : reservations){
            if(reservation.getReservationId().equals(reservationId)){
                reservation.confirmReservation();
                return reservation.getReservationId();
            }
        }
        throw new ReservationNotFoundException("Reservation not found.");
    }

    @Override
    public boolean isRoomReserved(String roomId, LocalDate date) throws RoomNotFoundException {
        for(RoomReservation reservation : reservations){
            if(reservation.getDate().equals(date)){
                if(reservation.getRoom().getId().equals(roomId)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public int getNumberOfUnconfirmedReservation(LocalDate date) {
        return 0;
    }

    @Override
    public Collection<String> getRoomIdsReservedByClient(String clientId) throws ClientNotFoundException {
        return null;
    }
}
