package pl.wsb.hotel;

public class Room {
    private String id;
    private String description;
    private  double area;
    private int floor;
    private boolean hasKingSizeBed;

    // constructor
    public Room(String id, String description, double area, int floor, boolean hasKingSizeBed){
        this.id = id;
        this.description = description;
        this.area = area;
        this.floor = floor;
        this.hasKingSizeBed = hasKingSizeBed;
    }
}
