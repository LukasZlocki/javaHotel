package pl.wsb.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
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
}
