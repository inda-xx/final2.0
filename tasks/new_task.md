### Task Description: Build a Simple Game Application in Java

**Theme**: Create a simple game application that includes **player movement**, a **scoring system**, and **enemy interactions**.

---

#### Background

In this task, you will build a **console-based game application** that demonstrates your ability to integrate key programming concepts into a creative and functional application. You’ll design and implement a game with the following features:

1. Player movement: The player can move across a grid-based game board.
2. Scoring system: The player collects points by interacting with objects on the board.
3. Enemy interactions: Enemies will randomly appear on the board, and the player must avoid them.

This task will help you practice **using data from files to instantiate objects**, **designing classes**, and **programming creatively**. You will also enhance your problem-solving skills, build robust object-oriented designs, and experiment with new ideas to make the game engaging.

---

#### Learning Goals

1. **Using Data from Files to Instantiate Objects**:
   - You will load the initial game board, player position, and enemy configurations from a file.
   - This will involve reading and parsing data from a text file and using it to create objects dynamically.

2. **Designing Classes**:
   - You will design and implement multiple classes (`Player`, `Enemy`, `GameBoard`, etc.) with appropriate responsibilities, fields, and methods.
   - You will focus on creating cohesive and maintainable object-oriented designs.

3. **Programming Creatively**:
   - You will have the opportunity to design the game mechanics creatively, such as scoring rules, enemy behavior, and board size.
   - Experimentation and iteration will be encouraged to refine the gameplay and improve the user experience.

---

#### Task Requirements

You will build a **console-based game** in Java that fulfills the following criteria:

1. **Game Setup via File Input**:
   - Create a text file (e.g., `game_config.txt`) to define:
     - The dimensions of the game board (e.g., 5x5 grid).
     - The initial position of the player (e.g., `(0, 0)`).
     - The positions of enemies and collectible items (e.g., enemies at `(2, 2)` and `(3, 3)`).
   - Use Java’s file I/O classes (`BufferedReader` or `Scanner`) to read this file and initialize the game state.

   **Sample File Format** (`game_config.txt`):
   ```
   BOARD_SIZE: 5x5
   PLAYER_START: 0,0
   ENEMIES: 2,2; 3,3
   ITEMS: 1,1; 4,4
   ```

2. **Object-Oriented Design**:
   - Design the following classes:
     - **`Player`**: Handles player position and movement logic.
     - **`Enemy`

### Exercise 1: Understanding File Input for Object Instantiation

#### Objective:
To ensure students understand the process of reading and parsing data from files and how this data can be used to instantiate and configure objects in a program.

---

#### Background:
In the game application, the initial game setup will be loaded from a text file (e.g., `game_config.txt`). This file contains information such as the board size, player position, enemy locations, and collectible item positions. Understanding how to read from a file, parse its contents, and use this data to initialize objects is a critical first step in building your game.

---

#### Instructions:
Answer the following conceptual questions. Use code snippets where necessary to support your answers.

1. **File Formats and Parsing**:
   - Explain the purpose of the `game_config.txt` file in the game application.
   - The sample file format is structured as key-value pairs (e.g., `BOARD_SIZE: 5x5`). Why is it important to use a clear and consistent file format for game configuration?

2. **File I/O**:
   - In Java, what classes and methods can be used to read a text file line by line? Provide a brief code snippet to demonstrate how to read the contents of `game_config.txt`.

3. **Parsing Data**:
   - If the line `PLAYER_START: 0,0` is read from the file, explain how you would extract the starting coordinates (0, 0) programmatically. Write a short code snippet to demonstrate this.

4. **Object Instantiation**:
   - Once the data (e.g., player coordinates) is extracted from the file, how can it be used to initialize an object in Java? Provide an example where you use the extracted data to create a `Player` object.

**Deliverable**:
Submit a document with your answers to the questions, including any code snippets. Ensure your explanations demonstrate a clear understanding of file reading, parsing, and object instantiation.

---

#### Expected Learning Outcome:
- Students will understand how to design and use structured file formats to store configuration data.
- Students will become familiar with Java’s file I/O classes and techniques for reading and parsing data.
- Students will see how parsed data can be used to dynamically instantiate objects.

---

---

### Exercise 2: Principles of Object-Oriented Design

#### Objective:
To introduce students to the principles of designing well-structured classes for the game application, focusing on responsibilities, fields, and methods.

---

#### Background:
The game application will involve multiple classes, such as `Player`, `Enemy`, and `GameBoard`. Each class must be designed with specific responsibilities and a clear structure to ensure the program is maintainable and scalable. This exercise will help you think about class responsibilities and how they interact in the game.

---

#### Instructions:
Answer the following conceptual questions. Provide diagrams or code snippets where necessary to support your answers.

1. **Class Responsibilities**:
  

### Exercise 3: Implementing File Input for Game Initialization

#### Objective:
To apply the theoretical knowledge from Exercise 1 by writing code that reads and parses the `game_config.txt` file, dynamically instantiates objects, and initializes the game state.

---

#### Background:
In this exercise, you will write the code responsible for loading the initial game configuration from a file. You will parse the data, extract relevant information, and use it to create and initialize the appropriate objects (e.g., `Player`, `Enemy`, and collectible items). This exercise bridges the gap between understanding file input conceptually and implementing it in a program.

---

#### Instructions:
1. **Create the Game Configuration File**:
   - Create a sample `game_config.txt` file in your project directory with the following content:
     ```
     BOARD_SIZE: 5x5
     PLAYER_START: 0,0
     ENEMIES: 2,2; 3,3
     ITEMS: 1,1; 4,4
     ```

2. **Write the `GameInitializer` Class**:
   - Implement a class called `GameInitializer` with a method `loadGameConfig(String filename)` that:
     1. Reads the `game_config.txt` file line by line.
     2. Parses the lines to extract the game board size, player start position, enemy positions, and item positions.
     3. Initializes and returns a `GameBoard` object with the extracted data.

3. **Define the `GameBoard` Class**:
   - Create a `GameBoard` class with the following fields:
     - `int rows`, `int columns`: Represents the dimensions of the board.
     - `Player player`: Represents the player object.
     - `List<Enemy> enemies`: A list of enemy objects.
     - `List<Item> items`: A list of collectible item objects.
   - Include appropriate constructors, getters, and setters.

4. **Instantiate Objects**:
   - Use the parsed data to instantiate a `Player` object, a list of `Enemy` objects, and a list of `Item` objects. Add them to the `GameBoard`.

5. **Test the Implementation**:
   - Write a `main` method to test your implementation. Load the configuration file, initialize the game board, and print the game state (e.g., dimensions, player position, and enemy/item positions) to the console.

---

#### Starter Code:
```java
import java.io.*;
import java.util.*;

class GameInitializer {
    public static GameBoard loadGameConfig(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        int rows = 0, cols = 0;
        Player player = null;
        List<Enemy> enemies = new ArrayList<>();
        List<Item> items = new ArrayList<>();

        while ((line = reader.readLine()) != null) {
            if (line.startsWith("BOARD_SIZE:")) {
                String[] size = line.split(":")[1].trim().split("x");
                rows = Integer.parseInt(size[0]);
                cols = Integer.parseInt(size[1]);
            } else if (line.startsWith("PLAYER_START:")) {
                String[] position = line.split(":")[1].trim().split(",");
                int x = Integer.parseInt(position[0]);
                int y = Integer.parseInt(position[1]);
                player = new Player(x, y);
            } else if (line.startsWith("ENEMIES:")) {
                String[] enemyPositions = line.split(":")[1].trim().split(";");
                for (String pos : enemyPositions) {
                    String[] coords = pos.trim().split(",");
                    enemies.add(new Enemy(Integer.parseInt(coords[0]), Integer.parseInt(coords[1])));
                }
            } else if (line.startsWith("ITEMS:")) {
                String[] itemPositions = line.split(":")[1].trim().split(";");
                for (String pos : itemPositions) {
                    String[] coords = pos.trim().split(",");
                    items.add(new Item(Integer.parseInt(coords[0]), Integer.parseInt(coords[1])));
                }
            }
        }
        reader.close();
        return new GameBoard(rows, cols, player, enemies, items);
    }
}

// Define Player, Enemy, Item, and GameBoard classes here

public class Main {
    public static void main(String[] args) {
        try {
            GameBoard gameBoard = GameInitializer.loadGameConfig("game_config.txt");
            System.out.println(gameBoard); // Print the game state
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

#### Deliverable:
Submit your implementation of the `GameInitializer` and `GameBoard` classes, along with the output of your test program.

---

#### Expected Learning Outcome:
- Students will gain hands-on experience implementing file I/O and parsing techniques.
- Students will learn how to dynamically instantiate objects using data read from files.
- Students will practice designing and using interrelated classes (`GameBoard`, `Player`, etc.).

---

---

### Exercise 4: Game Logic and Player Movement

#### Objective:
To implement core game mechanics, including player movement and interactions with enemies and items on the board.

---

#### Background:
Now that the game board and objects are initialized, you will implement the logic to allow the player to move across the board, collect items, and avoid enemies. This exercise focuses on integrating object-oriented design with creative problem-solving to implement engaging game mechanics.

---

#### Instructions:
1. **Update the `Player` Class**:
   - Add a method `move(String direction)` to the `Player` class that allows the player to move up, down, left, or right based on the input direction (`"UP"`, `"DOWN"`, `"LEFT"`, `"RIGHT"`).
   - Ensure the player cannot move outside the boundaries of the board.

2. **Implement Game Logic in `GameBoard`**:
   - Add a method `updateGameState(String playerMove)` to the `GameBoard` class that:
     1. Updates the player's position based on the move direction.
     2. Checks if the player collects an item (removes the item from the board and increments the score).
     3. Checks if the player encounters an enemy (ends the game or reduces health).
   - Add a `score` field to track the player's score.

3. **Test the Game Logic**:
   - Write a simple game loop in the `main` method:
     1. Print the current game state (board dimensions, player position, score, etc.).
     2. Prompt the user for a move (e.g., "Enter move (UP/DOWN/LEFT/RIGHT): ").
     3. Update the game state and repeat until the player either quits or loses.

---

#### Starter Code:
```java
class Player {
    private int x, y;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(String direction, int boardRows, int boardCols) {
        switch (direction.toUpperCase()) {
            case "UP": if (x > 0) x--; break;
            case "DOWN":

### Exercise 5: Implementing Enemy Behavior and Board Visualization

#### Objective:
To enhance the game mechanics by implementing logic for dynamic enemy behavior and creating a visualization of the game board that updates after each move. This exercise will integrate file-based initialization, object-oriented design, and creative problem-solving into a cohesive gameplay experience.

---

#### Background:
In a dynamic game, enemies need to move and interact with the player. Additionally, a visual representation of the game board will provide a clear and engaging console-based interface for the player to track the game state. This exercise focuses on implementing enemy behavior and creating a board visualization to enhance gameplay.

---

#### Instructions:

1. **Update the `Enemy` Class**:
   - Add a method `move()` to the `Enemy` class that allows enemies to move one step in a random direction (`UP`, `DOWN`, `LEFT`, `RIGHT`).
   - Ensure enemies cannot move outside the boundaries of the board.
   - (Optional for creativity) Add behavior for enemies to avoid certain cells, such as those occupied by other enemies or the player.

   **Example Starter Code**:
   ```java
   public void move(int boardRows, int boardCols) {
       Random random = new Random();
       String[] directions = {"UP", "DOWN", "LEFT", "RIGHT"};
       String direction = directions[random.nextInt(directions.length)];
       switch (direction) {
           case "UP": if (x > 0) x--; break;
           case "DOWN": if (x < boardRows - 1) x++; break;
           case "LEFT": if (y > 0) y--; break;
           case "RIGHT": if (y < boardCols - 1) y++; break;
       }
   }
   ```

2. **Add a Board Visualization Method**:
   - Implement a `renderBoard()` method in the `GameBoard` class that prints a visual representation of the game board to the console.
   - Use the following symbols:
     - `P` for the player.
     - `E` for enemies.
     - `I` for collectible items.
     - `.` for empty cells.

   **Example Output**:
   ```
   Current Board:
   P . . . .
   . . I . .
   . . E . .
   . . . . .
   . . . . I
   ```

3. **Integrate Enemy Movement**:
   - Add a method `updateEnemyPositions()` in the `GameBoard` class that moves all enemies on the board after each player move.

4. **Test the Implementation**:
   - Update the game loop in the `main` method:
     1. After each player move, call `updateEnemyPositions()` to move enemies.
     2. Render the updated board using `renderBoard()`.

5. **Optional for Creativity**:
   - Add a "safe zone" mechanic where players can temporarily avoid enemies.
   - Add a "power-up" item that allows the player to eliminate nearby enemies.

---

#### Deliverable:
Submit the updated `Enemy` and `GameBoard` classes, along with the output of a test run showing the player and enemies moving on the board. Attach screenshots or console logs of the board visualization after each move.

---

#### Expected Learning Outcome:
- Students will learn how to implement dynamic, randomized behavior in objects (enemy movement).
- Students will practice designing and implementing methods for visualizing game state.
- Students will integrate multiple game mechanics to create a more engaging and functional application.

---

---

### Exercise 6: Adding Game Conditions and Expanding Gameplay

#### Objective:
To finalize the game by implementing win/lose conditions, scoring updates, and additional game mechanics such as health management or timed gameplay. This exercise will bring together all previous concepts to create a polished and functional console-based game.

---

#### Background:
With the player, enemies, and items in place, the game now needs a set of conditions to determine when the game ends and how the player scores. Additionally, this is an opportunity to expand gameplay slightly by adding features such as health management or a timer to increase the challenge for the player.

---

#### Instructions:

1. **Add Win and Lose Conditions**:
   - Implement logic to end the game in the following scenarios:
     - **Win Condition**: The player collects all items on the board.
     - **Lose Condition**: The player encounters an enemy.
   - Display an appropriate message when the game ends (e.g., "You Win!" or "Game Over!").

   **Hint**:
   - Use a method `isGameOver()` in the `GameBoard` class to check these conditions after each turn.

2. **Add a Scoring System**:
   - Track the player's score based on the number of items collected.
   - Display the player's score on the board or alongside the board after each turn.

3. **Add Health Management (Optional for Creativity)**:
   - Add a `health` field to the `Player` class, starting at 3.
   - If the player encounters an enemy, reduce their health by 1 instead of ending the game immediately.
   - End the game if the player's health reaches 0.

4. **Add Timed Gameplay (Optional for Creativity)**:
   - Track the number of turns taken by the player.
   - Add a time limit (e.g., 20 turns) to complete the game. If the player doesn’t win within the time limit, the game ends.

5. **Test the Complete Game**:
   - Write a final game loop in the `main` method that integrates all features:
     1. Render the board and display game stats (score, health, remaining turns).
     2. Prompt the player for a move.
     3. Update the game state (player movement, enemy movement, item collection).
     4. Check win/lose conditions and end the game if necessary.

6. **Optional for Creativity**:
   - Add multiple levels of difficulty by varying the board size, number of enemies, and item positions.
   - Add a "boss enemy" that moves differently or requires multiple encounters to defeat.

---

#### Starter Code:
```java
class GameBoard {
    private int rows, cols;
    private Player player;
    private List<Enemy> enemies;
    private List<Item> items;
    private int score;
    private int turnsLeft;

    public GameBoard(int rows, int cols, Player player, List<Enemy> enemies, List<Item> items) {
        this.rows = rows;
        this.cols = cols;
        this.player = player;
        this.enemies = enemies;
        this.items = items;
        this.score = 0;
        this.turnsLeft = 20; // Example time limit
    }

    public boolean isGameOver() {
        // Win condition: all items collected
        if (items.isEmpty()) {
            System.out.println("You Win!");
            return true;
        }
        // Lose condition: player encounters an enemy
        for (Enemy enemy : enemies) {
            if (player.getX() == enemy.getX() && player.getY() == enemy.getY()) {
                System.out.println("Game Over! You were caught by an enemy.");
                return true;
            }
        }
        // Lose