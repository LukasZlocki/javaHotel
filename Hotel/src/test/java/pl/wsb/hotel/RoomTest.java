package pl.wsb.hotel;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoomTest {

    @Test
    void testAddRoom(){
        // Given
        Room room = new Room("11", "testroom", 25.12, 1, true, true, true, 3, true, true);

        // When
        String retriveId = room.getId();

        // Then
        assertEquals("11", retriveId);
    }

    @Test
    void testSettingNewDescription(){
        // Given
        Room room = new Room("11", "testroom", 25.12, 1, true, true, true, 3, true, true);

        // When
        String newDescription = "new room descr";
        room.setDescription(newDescription);
        String newDescrCheck = room.getDescription();

        // Then
        assertEquals(newDescription, newDescrCheck);

    }

    @Test
    void testRetriveArea(){
        // Given
        double area = 25.12;
        Room room = new Room("11", "testroom", area , 1, true, true, true, 3, true, true);

        // When
        double areaRetrived = room.getArea();

        // Then
        assertEquals(area, areaRetrived);

    }

    @Test
    void testGetFloor(){
        // Given
        int floor = 5;
        Room room = new Room("11", "testroom", 25.12 , floor, true, true, true, 3, true, true);

        // When
        int floorRetrived = room.getFloor();

        // Then
        assertEquals(floor, floorRetrived);

    }

    @Test
    void testHasKingSizeBed(){
        // Given
        boolean hasKingSizeBed = true;
        Room room = new Room("11", "testroom", 25.12 , 1, hasKingSizeBed, true, true, 3, true, true);

        // When
        boolean hasKingSizeBedRetrived = room.hasKingSizeBed();

        // Then
        assertEquals(hasKingSizeBed, hasKingSizeBedRetrived);

    }

    @Test
    void testHasBalcony(){
        // Given
        boolean hasBalcony = true;
        Room room = new Room("11", "testroom", 25.12 , 1, true, hasBalcony, true, 3, true, true);

        // When
        boolean hasBalconyRetrived = room.hasBalcony();

        // Then
        assertEquals(hasBalcony, hasBalconyRetrived);
    }

    @Test
    void testHasFridge(){
        // Given
        boolean hasFridge = true;
        Room room = new Room("11", "testroom", 25.12 , 1, true, true, hasFridge, 3, true, true);
        // When
        boolean hasFridgeRetrived = room.hasFridge();

        // Then
        assertEquals(hasFridge, hasFridgeRetrived);
    }

    @Test
    void testGetNumbersOfBeds(){
        // Given
        int beds = 3;
        Room room = new Room("11", "testroom", 25.12 , 1, true, true, true, beds, true, true);

        // When
        int bedsRetrived = room.getNumberOfBeds();

        // Then
        assertEquals(beds, bedsRetrived );
    }

    @Test
    void testSetNumbersOfBeds(){
        // Given
        int beds = 3;
        Room room = new Room("11", "testroom", 25.12 , 1, true, true, true, beds, true, true);

        // When
        int newNumberOfBeds = 20;
        room.setNumberOfBeds(newNumberOfBeds);
        int bedsRetrived = room.getNumberOfBeds();

        // Then
        assertEquals(newNumberOfBeds , bedsRetrived );
    }

    @Test
    void testHasTv(){
        // Given
        boolean hasTV = true;
        Room room = new Room("11", "testroom", 25.12 , 1, true, true, true, 3, hasTV , true);

        // When
        boolean hasTvRetrived = room.hasTV();

        // Then
        assertEquals(hasTV , hasTvRetrived  );
    }


}
