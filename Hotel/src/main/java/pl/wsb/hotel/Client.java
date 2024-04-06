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

    // constructor
    public Client(String id, String firstName, String lastName, LocalDate birthDate, String country, int numberPhone, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.country = country;
        this.numberPhone = numberPhone;
        this.email = email;
    }

    public LocalDate getAge(){
        return this.birthDate;
    }

    public String getFullName(){
        return String.format("%s %s", this.firstName, this.lastName);
    }

}
