package pl.wsb.hotel;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientTest {

    @Test
    void testReturnId(){
        // Given
        Client client = new Client("111", "clientunderagefirstname", "clientunderagelastname", LocalDate.of(2020, Month.AUGUST, 12), "Poland", 1234567, "thisemail@mail.com");

        // When
        String clientId = client.getId();
        String clientFirstName = client.getFirstName();

        // Then
        assertEquals("111", clientId);
        assertEquals("clientunderagefirstname", clientFirstName);
    }
    @Test
    void testReturnFirstName(){
        // Given
        Client client = new Client("111", "clientunderagefirstname", "clientunderagelastname", LocalDate.of(2020, Month.AUGUST, 12), "Poland", 1234567, "thisemail@mail.com");

        // When
        String clientFirstName = client.getFirstName();

        // Then
        assertEquals("clientunderagefirstname", clientFirstName);
    }

    @Test
    void testReturnLastName(){
        // Given
        Client client = new Client("111", "clientunderagefirstname", "clientunderagelastname", LocalDate.of(2020, Month.AUGUST, 12), "Poland", 1234567, "thisemail@mail.com");

        // When
        String clientLastName = client.getLastName();

        // Then
        assertEquals("clientunderagelastname", clientLastName);
    }

    @Test
    void testgetBirthDate(){
        // Given
        Client client = new Client("111", "clientunderagefirstname", "clientunderagelastname", LocalDate.of(2020, Month.AUGUST, 12), "Poland", 1234567, "thisemail@mail.com");

        // When
        LocalDate dateBirth = client.getBirthDate();

        // Then
        assertEquals(LocalDate.of(2020, Month.AUGUST, 12), dateBirth);
    }

    @Test
    void testGetCountry(){
        // Given
        Client client = new Client("111", "clientunderagefirstname", "clientunderagelastname", LocalDate.of(2020, Month.AUGUST, 12), "Poland", 1234567, "thisemail@mail.com");

        // When
        String country = client.getCountry();

        // Then
        assertEquals("Poland", country);
    }

    @Test
    void testGetNumberPhone(){
        // Given
        Client client = new Client("111", "clientunderagefirstname", "clientunderagelastname", LocalDate.of(2020, Month.AUGUST, 12), "Poland", 1234567, "thisemail@mail.com");

        // When
        int phoneNb = client.getNumberPhone();

        // Then
        assertEquals(1234567, phoneNb);
    }

    @Test
    void testGetEmail(){
        // Given
        Client client = new Client("111", "clientunderagefirstname", "clientunderagelastname", LocalDate.of(2020, Month.AUGUST, 12), "Poland", 1234567, "thisemail@mail.com");

        // When
        String email = client.getEmail();

        // Then
        assertEquals("thisemail@mail.com", email);
    }

    @Test
    void testGetAge(){
        // Given
        Client client = new Client("111", "clientunderagefirstname", "clientunderagelastname", LocalDate.of(2020, Month.AUGUST, 12), "Poland", 1234567, "thisemail@mail.com");

        // When
        int age = client.getAge();

        // Then
        assertEquals(4, age);
    }

    @Test
    void testNullGetAge(){
        // Given
        Client client = new Client("111", "clientunderagefirstname", "clientunderagelastname", null, "Poland", 1234567, "thisemail@mail.com");

        // When
        int age = client.getAge();

        // Then
        assertEquals(0, age);
    }

    @Test
    void testGetAgeButInFuture(){
        // Given
        Client client = new Client("111", "clientunderagefirstname", "clientunderagelastname", LocalDate.of(2027, Month.AUGUST, 12), "Poland", 1234567, "thisemail@mail.com");

        // When
        int age = client.getAge();

        // Then
        assertEquals(0, client.getAge());
    }

    @Test
    void testGetFullName(){
        // Given
        Client client = new Client("111", "clientunderagefirstname", "clientunderagelastname", LocalDate.of(2020, Month.AUGUST, 12), "Poland", 1234567, "thisemail@mail.com");

        // When
        String fullName =  client.getFullName();

        // Then
        assertEquals("clientunderagefirstname clientunderagelastname",fullName);
    }
}
