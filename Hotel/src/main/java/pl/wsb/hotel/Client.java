package pl.wsb.hotel;

import java.time.LocalDate;

public class Client {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate birthDate;

    // constructor
    public Client(String id, String firstName, String lastName, LocalDate birthDate){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }

    public LocalDate getAge(){
        return this.birthDate;
    }

    public String getFullName(){
        return String.format("%s %s", this.firstName, this.lastName);
    }

}
