package pl.wsb.hotel;

import java.time.LocalDate;

public class Client {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;
    private String country;
    private int numberPhone;
    private String email;

    // constructor //
    public Client(String id, String firstName, String lastName, LocalDate birthDate, String country, int numberPhone, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.country = country;
        this.numberPhone = numberPhone;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getCountry(){
        return country;
    }

    public int getNumberPhone(){
        return numberPhone;
    }

    public String getEmail(){
        return email;
    }

    public int getAge() {
        if (this.birthDate == null) {
            return 0; // nadano specjalne znaczenie, dodac obsluge wyjatku. A co gdy dat w przyszlosci ? co sie stanie jak dzialac.
        }
        if (LocalDate.now().getYear() - this.birthDate.getYear() < 0) {
            return 0; // nadano specjalne znaczenie, dodac obsluge wyjatku. A co gdy dat w przyszlosci ? co sie stanie jak dzialac.
        }
        return LocalDate.now().getYear() - this.birthDate.getYear();

    }

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }
}
