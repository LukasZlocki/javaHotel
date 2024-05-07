package pl.wsb.hotel;

import java.time.LocalDate;

public class RoomReservation {
    String reservationId; // add for lab03 special purpose
    private LocalDate date;
    private boolean isConfirmed = false;
    private Client client;
    private Room room;

    // constructor //
    public RoomReservation(String reservationId, LocalDate date, boolean isConfirmed, Client client, Room room){
        this.reservationId = reservationId;
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

    public String getReservationId(){
        return reservationId;
    }
}
