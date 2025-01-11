import java.util.HashMap;
import java.util.Map;

/**
 * The Room class contains information about a room (or some other place) that the player is currently in.
 * @author Gabriel Skoglund
 */
public class Room {

    /**
     * The exits map contains keys which are directions and values which are the rooms that
     * the exit leads to.
     */
    private Map<String, Room> exits = new HashMap<>();

    private String description;

    /**
     * Create a new room.
     * @param description the description of this room.
     */
    public Room(String description) {
        this.description = description;
    }

    /**
     * Add an exit from this room.
     * @param direction the direction in which the exit is.
     * @param toRoom the room that this exit leads to.
     */
    public void addExit(String direction, Room toRoom) {
        exits.put(direction, toRoom);
    }

    /**
     * Attempt to leave this room in the given direction.
     * @param direction the direction in which to move the player.
     * @return the room that the player ends up in. May be null if
     *         there is no exit from this room in that direction.
     */
    public Room go(String direction) {
        Room newRoom = exits.get(direction);
        if (newRoom == null){
            System.out.println("You can't go that way!");
            printExits();
        }
        return newRoom;
    }

    /**
     * Print the exits that are available from this room.
     */
    public void printExits() {
        System.out.print("There are exits in the directions: ");
        for (String direction : exits.keySet())
            System.out.print(direction + " ");
        System.out.println();
    }

    /**
     * Look around the current room, printing the room descriptions and the
     * available exits.
     */
    public void lookAround() {
        System.out.println(description);
        printExits();
    }
}