import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class Game {
    private static GameState gameState;

    public static void main(String[] args) {
        initializeGame();
        System.out.println("Welcome to the Game! Let's begin.");
        gameLoop();
    }

    private static void initializeGame() {
        Room start = new Room("You are at the starting point.");
        Room forest = new Room("You are in a forest, the trees are dense and mysterious.");
        Room cave = new Room("You are in a dark cave. You can hear the echo of dripping water.");
        Room river = new Room("You are at the riverbank, the water is calm and inviting.");

        start.addExit("north", forest);
        forest.addExit("south", start);
        forest.addExit("east", cave);
        forest.addExit("west", river);
        cave.addExit("west", forest);
        river.addExit("east", forest);

        gameState = new GameState(start);
    }

    private static void gameLoop() {
        while (true) {
            Room currentRoom = gameState.getCurrentRoom();
            currentRoom.lookAround();
            System.out.print("> ");
            String command = System.console().readLine();

            if (command.equals("exit")) {
                System.out.println("Thank you for playing!");
                break;
            }

            Room nextRoom = currentRoom.go(command);

            if (nextRoom != null) {
                gameState.setCurrentRoom(nextRoom);
            }
        }
    }
}

class GameState {
    private Room currentRoom;

    public GameState(Room startingRoom) {
        this.currentRoom = startingRoom;
    }

    public Room getCurrentRoom() {
        return currentRoom;
    }

    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }
}

class Room {
    private String description;
    private Map<String, Room> exits;

    public Room(String description) {
        this.description = description;
        this.exits = new HashMap<>();
    }

    public void addExit(String direction, Room room) {
        exits.put(direction, room);
    }

    public Room go(String direction) {
        if (!exits.containsKey(direction)) {
            System.out.println("You can't go that way.");
            return null;
        }
        return exits.get(direction);
    }

    public void lookAround() {
        System.out.println(description);
        System.out.println("Exits: " + exits.keySet());
    }
}