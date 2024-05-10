package pl.wsb.hotel;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static pl.wsb.hotel.PremiumClient.premiumAccountType.PREMIUM;

public class PremiumClientTest {

    @Test
    void testPremiumClientConstructor(){
        // Given
        PremiumClient premiumClient = new PremiumClient("11", "firstname", "secondname", LocalDate.of(1997, Month.AUGUST, 12), "Poland", 123456, "thsemail@email.com", PREMIUM);

        // When
        String retrivePremiumClientId = premiumClient.getId();

        // Then
        assertEquals("11", retrivePremiumClientId );
    }

    @Test
    void testGetFullNameOfPremiumClient(){
        // Given
        PremiumClient premiumClient = new PremiumClient("11", "firstname", "secondname", LocalDate.of(1997, Month.AUGUST, 12), "Poland", 123456, "thsemail@email.com", PREMIUM);

        // When
        String retrivePremiumClientFullName = premiumClient.getFullName();

        // Then
        assertEquals("[ PREMIUM ] firstname secondname", retrivePremiumClientFullName);
    }
}
