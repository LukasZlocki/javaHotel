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

    @Override
    public String addClient(String firstName, String lastName, LocalDate birthDate) {
        return null;
    }

    @Override
    public String getClientFullName(String clientId) {
        return null;
    }

    @Override
    public int getNumberOfUnderageClients() {
        return 0;
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
