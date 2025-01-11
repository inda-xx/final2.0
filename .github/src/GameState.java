/**
 * The GameState class contains information about the current state of the game.
 * In this basic version, this only includes what room the player is in, but
 * could be extended to include things like if the player has won the game,
 * how many health points the player has, which items the player has picked up
 * and other relevant information.
 *
 * @author Gabriel Skoglund
 */
public class GameState {
    private Room currentRoom;

    /**
     * Create a new GameState with the player starting in the given room
     * @param startingRoom the room the player starts in.
     */
    public GameState(Room startingRoom) {
        currentRoom = startingRoom;
    }

    /**
     * @return The room the player is currently in.
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Update the room that the player is in.
     * @param currentRoom the new current room.
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}