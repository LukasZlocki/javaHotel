package pl.wsb.hotel;

public class Room {
    private String id;
    private String description;
    private  double area;
    private int floor;
    private boolean hasKingSizeBed;
    private boolean hasBalcony;
    private boolean hasFridge;
    private int numberOfBeds;
    private boolean hasTV;
    private boolean hasWifi;

    // constructor
    public Room(String id, String description, double area, int floor, boolean hasKingSizeBed, boolean hasBalcony, boolean hasFridge, int numberOfBeds, boolean hasTV, boolean hasWifi) {
        this.id = id;
        this.description = description;
        this.area = area;
        this.floor = floor;
        this.hasKingSizeBed = hasKingSizeBed;
        this.hasBalcony = hasBalcony;
        this.hasFridge = hasFridge;
        this.numberOfBeds = numberOfBeds;
        this.hasTV = hasTV;
        this.hasWifi = hasWifi;
    }
}
