package pl.wsb.hotel;

import java.time.LocalDate;

public class RoomReservation {
    private LocalDate date;
    private boolean isConfirmed = false;
    private Client client;
    private Room room;

    // constructor //
    public RoomReservation(LocalDate date, boolean isConfirmed, Client client, Room room){
        this.date = date;
        this.isConfirmed = isConfirmed;
        this.client = client;
        this.room = room;
    }

    public void confirmReservation(){
        this.isConfirmed = true;
    }

    // Getters //
    public Client getClient(){
        return client;
    }

    public Room getRoom(){
        return room;
    }

    public LocalDate getDate(){
        return date;
    }

    public boolean isConfirmed(){
        return isConfirmed;
    }
}
