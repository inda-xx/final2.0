// Room.java
import java.util.Map;
import java.util.HashMap;

public class Room {
    // Fields to store room description and exits
    private Map<String, Room> exits;
    private String description;

    // Constructor to initialize the room with a description
    public Room(String description) {
        // Implementation here
    }

    // Method to add an exit to a room
    public void addExit(String direction, Room toRoom) {
        // Implementation here
    }

    // Method to move to a new room in a given direction
    public Room go(String direction) {
        // Logic to determine the new room
        return null; // Placeholder return
    }

    // Method to print all available exits in this room
    public void printExits() {
        // Implementation here
    }

    // Method to look around the room (description and exits)
    public void lookAround() {
        // Implementation here
    }
}