package pl.wsb.hotel;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClientTest {

    @Test
    void testReturnId(){
        // Arrange
        Client client = new Client("111", "clientunderagefirstname", "clientunderagelastname", LocalDate.of(2020, Month.AUGUST, 12), "Poland", 1234567, "thisemail@mail.com");
        // Assert
        assertEquals("111", client.getId());
        assertEquals("clientunderagefirstname", client.getFirstName());
    }
    @Test
    void testReturnFirstName(){
        // Arrange
        Client client = new Client("111", "clientunderagefirstname", "clientunderagelastname", LocalDate.of(2020, Month.AUGUST, 12), "Poland", 1234567, "thisemail@mail.com");
        // Assert
        assertEquals("clientunderagefirstname", client.getFirstName());
    }

    @Test
    void testReturnLastName(){
        // Arrange
        Client client = new Client("111", "clientunderagefirstname", "clientunderagelastname", LocalDate.of(2020, Month.AUGUST, 12), "Poland", 1234567, "thisemail@mail.com");
        // Assert
        assertEquals("clientunderagelastname", client.getLastName());
    }

    @Test
    void testgetBirthDate(){
        // Arrange
        Client client = new Client("111", "clientunderagefirstname", "clientunderagelastname", LocalDate.of(2020, Month.AUGUST, 12), "Poland", 1234567, "thisemail@mail.com");
        // Assert
        assertEquals(LocalDate.of(2020, Month.AUGUST, 12), client.getBirthDate());
    }

    @Test
    void testGetCountry(){
        // Arrange
        Client client = new Client("111", "clientunderagefirstname", "clientunderagelastname", LocalDate.of(2020, Month.AUGUST, 12), "Poland", 1234567, "thisemail@mail.com");
        // Assert
        assertEquals("Poland", client.getCountry());
    }

    @Test
    void testGetNumberPhone(){
        // Arrange
        Client client = new Client("111", "clientunderagefirstname", "clientunderagelastname", LocalDate.of(2020, Month.AUGUST, 12), "Poland", 1234567, "thisemail@mail.com");
        // Assert
        assertEquals(1234567, client.getNumberPhone());
    }

    @Test
    void testGetEmail(){
        // Arrange
        Client client = new Client("111", "clientunderagefirstname", "clientunderagelastname", LocalDate.of(2020, Month.AUGUST, 12), "Poland", 1234567, "thisemail@mail.com");
        // Assert
        assertEquals("thisemail@mail.com", client.getEmail());
    }

    @Test
    void testGetAge(){
        // Arrange
        Client client = new Client("111", "clientunderagefirstname", "clientunderagelastname", LocalDate.of(2020, Month.AUGUST, 12), "Poland", 1234567, "thisemail@mail.com");
        // Assert
        assertEquals(4, client.getAge());
    }

    @Test
    void testNullGetAge(){
        // Arrange
        Client client = new Client("111", "clientunderagefirstname", "clientunderagelastname", null, "Poland", 1234567, "thisemail@mail.com");
        // Assert
        assertEquals(0, client.getAge());
    }

    @Test
    void testGetAgeButInFuture(){
        // Arrange
        Client client = new Client("111", "clientunderagefirstname", "clientunderagelastname", LocalDate.of(2027, Month.AUGUST, 12), "Poland", 1234567, "thisemail@mail.com");
        // Assert
        assertEquals(0, client.getAge());
    }

    @Test
    void testGetFullName(){
        // Arrange
        Client client = new Client("111", "clientunderagefirstname", "clientunderagelastname", LocalDate.of(2020, Month.AUGUST, 12), "Poland", 1234567, "thisemail@mail.com");
        // Assert
        assertEquals("clientunderagefirstname clientunderagelastname", client.getFullName());
    }
}
