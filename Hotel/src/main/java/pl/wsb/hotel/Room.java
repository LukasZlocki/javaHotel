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

    // constructor //
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

    public String getId() {
        return id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public double getArea() {
        return area;
    }

    public int getFloor() {
        return floor;
    }

    public boolean hasKingSizeBed() {
        return hasKingSizeBed;
    }

    public boolean hasBalcony() {
        return hasBalcony;
    }

    public boolean hasFridge() {
        return hasFridge;
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }

    public void setNumberOfBeds(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    public boolean hasTV() {
        return hasTV;
    }

    public void setHasTV(boolean hasTV) {
        this.hasTV = hasTV;
    }

    public boolean hasWifi() {
        return hasWifi;
    }

    public void setHasWifi(boolean hasWifi) {
        this.hasWifi = hasWifi;
    }
}
