package pl.wsb.hotel;

public interface HotelCapability {

    // Clients: //
    void addClient(Client client);
    String getClientFullName ();
    int getNumberOfUndarageClients();

    // Rooms: //
    void addRoom();
    double getRoomArea();
    int getNumberOfRoomsWithKingSizeBed();

    // Room Reservations: //
    void addNewReservation();
    boolean confirmReservation();
    boolean isRoomReserved();
    int getNumberOfUnconfirmedReservations();
    int getRoomIdsReservedByClient();
}
