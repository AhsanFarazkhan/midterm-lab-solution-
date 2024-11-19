package domain;

public class Student {
    private String name;
    private int distanceFromHome;  // This is the distance we will use for the filter
    private boolean feePaid;
    private String roomType;
    private boolean servicesSelected;

    public Student(String name, int distanceFromHome, boolean feePaid) {
        this.name = name;
        this.distanceFromHome = distanceFromHome;  // Initialize the distance
        this.feePaid = feePaid;
        this.servicesSelected = false;
    }

    // Getter for distance from home
    public int getDistanceFromHome() {
        return distanceFromHome;
    }

    // Other getters and setters...
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFeePaid() {
        return feePaid;
    }

    public void setFeePaid(boolean feePaid) {
        this.feePaid = feePaid;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public boolean isServicesSelected() {
        return servicesSelected;
    }

    public void setServicesSelected(boolean servicesSelected) {
        this.servicesSelected = servicesSelected;
    }
}
