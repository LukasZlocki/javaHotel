package pl.wsb.hotel;

import java.util.ArrayList;
import java.util.List;

public class Hotel {
    String name;
    List<SpecialService> specialServices;
    List<Client> clients;
    List<RoomReservation> reservations;

    // constructor //
    public Hotel(String name){
        this.name = name;
        this.specialServices = new ArrayList<>();
        this.clients = new ArrayList<>();
        this.reservations = new ArrayList<>();
    }

    // constructor //
    public Hotel(String name, List<SpecialService> specialServices, List<Client> clients, List<RoomReservation> reservations ){
        this.name = name;
        this.specialServices = specialServices;
        this.clients = clients;
        this.reservations = reservations;
    }



}
