package pl.wsb.hotel;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        // create client instance
        Client client1 = new Client("c1", "Lukas", "Kowalsky", LocalDate.of(1990, 3, 1));

        // create room instance
        Room room1 = new Room("r1", "room 1", 50.43, 1, true);

        // create reservation instance
        RoomReservation reservation1 = new RoomReservation(LocalDate.of(2024, 4, 4), false, client1, room1);
        reservation1.confirmReservation(); // confirming reservation

        // Basic check of instances
        System.out.println("customer 1 - basic information:");
        System.out.println("Name: " + client1.getFullName());
        System.out.println("Age: " + client1.getAge());

    }
}
