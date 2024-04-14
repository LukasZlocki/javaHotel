package pl.wsb.hotel;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // create client instance //
        //Client client1 = new Client("001", "klient1firstname", "klient1lasttname", LocalDate.of(2994, 9, 21), "Poland", 123456789, "client1@example.com");
        Client client1 = new Client("001", "klient1firstname", "klient1lasttname",null, "Poland", 123456789, "client1@example.com");

        // create room instance //
        Room room1 = new Room("101", "Standard Room", 25.0, 1, true, false, true, 2, true, true);

        // create reservation instance //
        RoomReservation reservation1 = new RoomReservation(LocalDate.of(2024, 4, 4), false, client1, room1);

        // Basic check of instances //
        System.out.println("customer 1 - basic information:");
        System.out.println("Name: " + client1.getFullName());
        System.out.println("Age: " + client1.getAge());

        System.out.println("Reservation details:");
        System.out.println("Client: " + reservation1.getClient().getFullName());
        System.out.println("Room: " + reservation1.getRoom().getDescription());
        System.out.println("Reservation date: " + reservation1.getDate());
        System.out.println("Confirmed: " + reservation1.isConfirmed());

        reservation1.confirmReservation();

        System.out.println("\nAfter confirmation:");
        System.out.println("Confirmed: " + reservation1.isConfirmed());

        // tests lab 02 //
        System.out.println("\nLAB02 class extensions");
        // add client premium //
        PremiumClient premiumClient2 = new PremiumClient("001", "premiumklient2firstname", "premiumklient2lastname",null, "Poland", 123456789, "premiumclient2@example.com", PremiumClient.premiumAccountType.PREMIUM);
        System.out.println("premium client name: " + premiumClient2.getFullName());
    }
}