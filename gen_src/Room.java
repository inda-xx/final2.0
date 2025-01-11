// File: Room.java

import java.util.Map;
import java.util.HashMap;

public class Room {

    private Map<String, Room> exits;
    private String description;

    public Room(String description) {
        // Constructor
    }

    public void addExit(String direction, Room toRoom) {
        // Add an exit to the room
    }

    public Room go(String direction) {
        // Handle moving to a different room based on the direction
        return null;
    }

    public void printExits() {
        // Print all available exits from this room
    }

    public void lookAround() {
        // Describe the current room and list available exits
    }
}