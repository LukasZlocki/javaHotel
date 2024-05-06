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

    @Override
    public String addClient(String firstName, String lastName, LocalDate birthDate) {
        String newCustomerId = idGenerator();
        Client client = new Client(newCustomerId, firstName, lastName, birthDate, "", 0, "");
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
        int underageClients = 0;
        for (Client client : clients){
            if(client.getAge() <= 18){
                underageClients++;
            }
        }
        return underageClients;
    }

    @Override
    public String addRoom(double area, int floor, boolean hasKingSizeBed, String description) {
        return null;
    }

    @Override
    public double getRoomArea(String roomId) {
        return 0;
    }

    @Override
    public int getNumberOfRoomsWithKingSizeBed(int floor) {
        return 0;
    }

    @Override
    public String addNewReservation(String clientId, String roomId, LocalDate date) throws ClientNotFoundException, RoomNotFoundException, RoomReservedException {
        return null;
    }

    @Override
    public String confirmReservation(String reservationId) throws ReservationNotFoundException {
        return null;
    }

    @Override
    public boolean isRoomReserved(String roomId, LocalDate date) throws RoomNotFoundException {
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
