package test;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class RoomTest {

    @Test
    public void testRoomDescription() {
        Room room = new Room("A small, dimly lit room.");
        assertEquals("A small, dimly lit room.", room.toString());
    }

    @Test
    public void testAddExitAndGoValidDirection() {
        Room room1 = new Room("Room 1");
        Room room2 = new Room("Room 2");
        room1.addExit("north", room2);

        Room result = room1.go("north");
        assertEquals(room2, result);
    }

    @Test
    public void testGoInvalidDirection() {
        Room room1 = new Room("Room 1");

        Room result = room1.go("invalidDirection");
        assertNull(result);
    }

    @Test
    public void testPrintExitsSingleExit() {
        Room room1 = new Room("Room 1");
        Room room2 = new Room("Room 2");
        room1.addExit("east", room2);

        room1.printExits();
    }

    @Test
    public void testPrintExitsMultipleExits() {
        Room room1 = new Room("Room 1");
        Room room2 = new Room("Room 2");
        Room room3 = new Room("Room 3");
        room1.addExit("north", room2);
        room1.addExit("south", room3);

        room1.printExits();
    }

    @Test
    public void testLookAroundWithExits() {
        Room room1 = new Room("You are in a cozy living room.");
        Room kitchen = new Room("You are in a modern kitchen.");
        room1.addExit("west", kitchen);

        room1.lookAround();
    }

    @Test
    public void testLookAroundWithoutExits() {
        Room room1 = new Room("You are in a dark cave.");
        room1.lookAround();
    }

    @Test
    public void testAddExitOverwritesExistingDirection() {
        Room room1 = new Room("Room 1");
        Room room2 = new Room("Room 2");
        Room room3 = new Room("Room 3");
        room1.addExit("east", room2);
        room1.addExit("east", room3);

        Room result = room1.go("east");
        assertEquals(room3, result);
    }

    @Test
    public void testGoWithNullDirection() {
        Room room1 = new Room("Room 1");
        Room result = room1.go(null);
        assertNull(result);
    }

    @Test
    public void testAddExitWithNullDirection() {
        Room room1 = new Room("Room 1");
        Room room2 = new Room("Room 2");
        room1.addExit(null, room2);

        Room result = room1.go(null);
        assertEquals(room2, result);
    }

    @Test
    public void testAddExitWithSelfReference() {
        Room room1 = new Room("Room 1");
        room1.addExit("loop", room1);

        Room result = room1.go("loop");
        assertEquals(room1, result);
    }

    @Test
    public void testExitsAreCaseSensitive() {
        Room room1 = new Room("Room 1");
        Room room2 = new Room("Room 2");
        room1.addExit("north", room2);

        Room result = room1.go("NORTH");  // Should not work due to case sensitivity
        assertNull(result);
    }
}