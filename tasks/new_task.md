![Task Image](images/task_image_20250111_154119.png)

### Task: Create a Simple Game Application with Player Movement, Scoring System, and Enemy Interactions

---

#### **Task Overview**
In this task, you will design and implement a simple game in Java. The game should allow a player to move around a grid, collect points, and avoid enemies. The game will utilize object-oriented principles, read game data (e.g., enemy positions or level configurations) from a file, and encourage creative solutions in gameplay design.

This task integrates three key learning goals:
1. **Using Data from Files to Instantiate Objects**: Read game configuration data (such as the initial positions of enemies and items) from a file and use it to create objects dynamically.
2. **Designing Classes**: Design classes for the player, enemies, game objects, and the game logic. You’ll demonstrate a solid understanding of object-oriented principles by creating modular, reusable, and maintainable code.
3. **Programming Creatively**: Use your creativity to design the scoring system, enemy behaviors, and game mechanics.

You are encouraged to experiment and iterate on your design, creating a small but functional and engaging game. This task is designed to be completed over one week.

---

### **Requirements**

Your game MUST include the following features:
1. **Player Movement**: The player should be able to move up, down, left, and right within the bounds of the game grid. 
2. **Scoring System**: Points should be awarded when the player interacts with specific objects (e.g., collecting items or completing objectives).
3. **Enemy Interactions**: Enemies should move around the grid and interact with the player (e.g., reducing the score or ending the game if they collide with the player).
4. **File Input**: The game must read initial configurations (e.g., player starting position, enemy positions, and item positions) from a file.
5. **Class Design**: You must create separate, well-structured classes for game entities (e.g., `Player`, `Enemy`, `GameObject`, `Game`).
6. **Creativity**: Implement at least one additional feature of your choice (e.g., power-ups, multiple levels, or a timer-based challenge).

---

### **Step-by-Step Instructions**

#### **Step 1: Understanding the File Input**
The game will read its initial configuration from a text file (e.g., `gameConfig.txt`). The file will contain information such as:
```
Player: 2,3
Enemy: 4,5
Enemy: 1,7
Item: 3,3
GridSize: 10,10
```

- The first line specifies the player's starting position (row and column).
- Each subsequent line specifies the positions of enemies and items.
- The `GridSize` determines the size of the game grid.

You will read this file, parse the data, and use it to instantiate game objects dynamically. 

**Hint**: Use Java's `BufferedReader` and `FileReader` classes to read the file. Split the lines to extract the relevant information.

**Code Snippet**:
```java
import java.io.*;
import java.util.*;

public class GameFileReader {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader("gameConfig.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(": ");
                String type = parts[0];
                String[] data = parts[1].split(",");
                
                if (type.equals("Player")) {
                    int row = Integer.parseInt(data[0]);
                    int col = Integer.parseInt(data[1]);
                    System.out.println("Player starts at (" + row + ", " + col + ")");
                }
                // Add logic for Enemy and Item
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
```

---

#### **Step 2: Designing Classes**
Design the following classes with clear responsibilities:
1. **`Player`**: Represents the player. Contains fields for the position (`row`, `col`) and methods for moving.
2. **`Enemy`**: Represents an enemy. Contains fields for the position and methods for enemy movement.
3. **`Item`**: Represents items that the player can collect for points.
4. **`Game`**: Manages the game loop, grid, and interactions between objects.

**Example**:
```java
public class Player {
    private int row;
    private int col;

    public Player(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public void move(String direction) {
        switch (direction) {
            case "UP": row--; break;
            case "DOWN": row++; break;
            case "LEFT": col--; break;
            case "RIGHT": col++; break;
        }
    }

    public int getRow() { return row; }
    public int getCol() { return col; }
}
```

---

#### **Step 3: Implementing the Game Logic**
In the `Game` class, implement the following:
- A **game loop** that updates the grid and checks for interactions (e.g., collisions between the player and enemies or items).
- A method to handle **player input** for movement.
- A scoring system that awards points for collecting items.

**Code Snippet**:
```java
public class Game {
    private Player player;
    private List<Enemy> enemies;
    private List<Item> items;
    private int score = 0;

    public Game(Player player, List<Enemy> enemies, List<Item> items) {
        this.player = player;
        this.enemies = enemies;
        this.items = items;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter move (UP, DOWN, LEFT, RIGHT): ");
            String direction = scanner.nextLine();
            player.move(direction);

            // Check for item collection
            for (Iterator<Item> it = items.iterator(); it.hasNext();) {
                Item item = it.next();
                if (item.getRow() == player.getRow() && item.getCol() == player.getCol()) {
                    score += 10; // Award points
                    it.remove();
                    System.out.println("Item collected! Score: " + score);
                }
            }

            // Check for collisions with enemies
            for (Enemy enemy : enemies) {
                if (enemy.getRow() == player.getRow() && enemy.getCol() == player.getCol()) {
                    System.out.println("Game Over! Final Score: " + score);
                    return;
                }
            }
        }
    }
}
```

---

#### **Step 4: Adding Creative Features**
- Introduce additional functionality, such as:
  - **Power-Ups**: Items that grant temporary immunity or extra points.
  - **Enemy AI**: Make enemies move toward the player.
  - **Level Progression**: Load new configurations from files when all items are collected.

Be creative and make the game engaging!

---

### **Deliverables**
1. A fully functional

### **Exercise 1: Understanding File Input and Object Instantiation**

#### **Objective**
This exercise focuses on the theoretical understanding of reading data from files, parsing it, and using it to dynamically create objects in Java. Students will explore critical concepts of file I/O, data integrity, and object-oriented programming.

---

#### **Instructions**
Answer the following questions based on your understanding of file input and object instantiation in Java:

---

1. **Understanding File Formats and Parsing**
   1.1. Why do we need to use structured file formats (e.g., key-value pairs, comma-separated values) when reading data for a program?  
   1.2. Suppose you have the following configuration file:
   ```
   Player: 5,5
   Enemy: 2,3
   Enemy: 4,6
   Item: 1,1
   GridSize: 8,8
   ```
   - (a) What considerations should be made when parsing this file to ensure that all data is correctly extracted?  
   - (b) Describe how you would handle corrupted or missing data in the file (e.g., if a line is missing or incorrectly formatted).

2. **Converting File Data into Objects**
   - 2.1. Explain the steps involved in reading a file line by line and instantiating objects (e.g., creating `Player`, `Enemy`, or `Item` objects) based on the data in each line.  
   - 2.2. Why is it important to validate the data before using it to create objects? Provide an example of incorrect data that could cause runtime issues if not validated.

3. **Error Handling in File Input**
   - 3.1. Describe two common exceptions that might occur when reading a file in Java using `FileReader` or `BufferedReader`.  
   - 3.2. How would you implement error handling to ensure that your program does not crash when a file-related error occurs? Provide a brief explanation or pseudocode example.

4. **Dynamic Object Creation**
   - 4.1. Imagine you are working on a game where multiple types of objects (e.g., `Player`, `Enemy`, and `Item`) need to be created dynamically based on file input. What role does polymorphism play in ensuring that your code remains maintainable and flexible?  
   - 4.2. What challenges might arise when creating objects dynamically, and how can you overcome them?

---

#### **Expected Output**
Students should submit a written response (approximately 1–2 pages) addressing each question. Answers should demonstrate an understanding of file formats, parsing techniques, error handling, and object instantiation.

---

### **Exercise 2: Principles of Class Design**

#### **Objective**
This exercise focuses on the fundamentals of designing well-structured classes in Java. Students will explore concepts such as class responsibilities, cohesion, and the use of design patterns to create modular and maintainable code.

---

#### **Instructions**
Answer the following questions and scenarios to deepen your understanding of class design principles:

---

1. **Identifying Class Responsibilities**
   - 1.1. Consider the following entities in the game:
     - **Player**: Represents the user-controlled character.
     - **Enemy**: Represents opponents moving around the grid.
     - **Item**: Represents objects that the player can collect for points.
     - **Game**: Manages the game logic, including the grid, interactions, and score.
     
     For each of these entities, identify their key responsibilities and the fields and methods they should contain. Write your answer in the following format:  
     - **Class Name**:  
       - **Fields**:  
       - **Methods**:  

   - 1.2. Why is it important to keep the responsibilities of a class limited to a single concept? Explain how violating this principle can lead to issues in larger programs.

2. **Cohesion and Coupling**
   - 2.1. Define the terms **cohesion** and **coupling** in the context of class design.  
   - 2.2. Provide an example from the given game scenario where high cohesion is achieved.  
   - 2.3. Provide an example of tight coupling between two classes in a poorly designed version of the game. How can this tight coupling be reduced?

3. **Design Patterns and Reusability**
   - 3.1. What is a design pattern, and how can it help in solving recurring problems in software design?  
   - 3.2. Imagine you need to create multiple levels for the game, each with different configurations for the player, enemies, and items. Which design pattern could you use to make this process more modular and reusable? Explain your choice.

4. **Avoiding Common Pitfalls in Class Design**
   - 4.1. One common pitfall in class design is creating "God classes" that have too many responsibilities. In the context of this game, what would a "God class" look like, and why is it problematic?  
   - 4.2. Another pitfall is failing to use inheritance or interfaces where appropriate. Provide an example of how inheritance could be used in this game to simplify the design of `Player` and `Enemy` classes.

5. **Iterating on Class Design**
   - 5.1. Explain why class design is often an iterative process. How might your initial class design change as you add features like power-ups or multiple levels to the game?  
   - 5.2. What steps can you take to ensure that changes to one part of your code (e.g., adding a new type of game object) do not break other parts of your program?

---

#### **Expected Output**
Students should submit a written response (approximately 2–3 pages) covering each question. Diagrams or UML sketches are encouraged but not required. Answers should demonstrate an understanding of class responsibilities, cohesion, coupling, design patterns, and iterative development.

--- 

### **Pedagogical Value**
These exercises are designed to prepare students for the coding-intensive parts of the task by:
- Encouraging them to think critically about file input and object-oriented design before writing code.
- Building a solid foundation in concepts like cohesion, coupling, and error handling, which are essential for creating robust and maintainable software systems.
- Helping them connect theoretical concepts with practical applications in the context of the game development task. 



### Exercise 3: Parsing File Input and Instantiating Game Objects Programmatically

#### **Objective**
This exercise focuses on writing code to parse game configuration data from a file and use it to dynamically instantiate game objects. Students will practice integrating file I/O, data validation, and object-oriented principles.

---

#### **Instructions**
Write a Java program that reads a game configuration file (`gameConfig.txt`) and instantiates the following objects based on the file's contents:
- A **Player** object with a starting position.
- A list of **Enemy** objects, each with a specified position.
- A list of **Item** objects, each with a specified position.
- A **Game** object that manages all these components.

---

#### **Steps to Complete**

1. **Understand the File Format**  
   The `gameConfig.txt` file is formatted as follows:
   ```
   Player: 2,3
   Enemy: 4,5
   Enemy: 1,7
   Item: 3,3
   GridSize: 10,10
   ```

   Your task is to:
   - Parse the file line by line.
   - Extract and validate the data.
   - Create the appropriate objects (`Player`, `Enemy`, `Item`) based on the extracted data.

---

2. **Write the File Parsing Code**
    - Use Java's `BufferedReader` and `FileReader` classes to read the file.
    - Use the `split()` method to separate each line into its type (`Player`, `Enemy`, etc.) and its data (e.g., `2,3`).
    - For each type, instantiate the appropriate object and store it in the correct data structure:
      - A single `Player` object.
      - A `List<Enemy>` to store all enemies.
      - A `List<Item>` to store all items.
    - Validate all extracted data to ensure it is within the grid bounds (e.g., no positions outside the grid size).

---

3. **Implement Object Creation**
    - You should already have the `Player`, `Enemy`, and `Item` classes from Exercise 2. Use these classes to instantiate objects.
    - Ensure that the grid size (`GridSize`) is used to validate positions. If any object has a position outside the grid bounds, print an error message and skip the creation of that object.

---

4. **Output the Parsed Data**
   After parsing the file, print the following to verify correctness:
   - The player's starting position.
   - The positions of all enemies.
   - The positions of all items.
   - The grid size.

---

#### **Starter Code**
```java
import java.io.*;
import java.util.*;

public class GameConfigParser {
    public static void main(String[] args) {
        String fileName = "gameConfig.txt"; // Ensure this file exists in your working directory
        Player player = null;
        List<Enemy> enemies = new ArrayList<>();
        List<Item> items = new ArrayList<>();
        int gridRows = 0, gridCols = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(": ");
                String type = parts[0];
                String[] data = parts[1].split(",");

                switch (type) {
                    case "Player":
                        int playerRow = Integer.parseInt(data[0]);
                        int playerCol = Integer.parseInt(data[1]);
                        player = new Player(playerRow, playerCol);
                        break;
                    case "Enemy":
                        int enemyRow = Integer.parseInt(data[0]);
                        int enemyCol = Integer.parseInt(data[1]);
                        enemies.add(new Enemy(enemyRow, enemyCol));
                        break;
                    case "Item":
                        int itemRow = Integer.parseInt(data[0]);
                        int itemCol = Integer.parseInt(data[1]);
                        items.add(new Item(itemRow, itemCol));
                        break;
                    case "GridSize":
                        gridRows = Integer.parseInt(data[0]);
                        gridCols = Integer.parseInt(data[1]);
                        break;
                    default:
                        System.out.println("Unknown type: " + type);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        // Output the parsed data
        System.out.println("Grid Size: " + gridRows + "x" + gridCols);
        System.out.println("Player starting position: " + player.getRow() + "," + player.getCol());
        System.out.println("Enemies: " + enemies.size());
        System.out.println("Items: " + items.size());
    }
}
```

---

#### **Expected Output**
If the file contains the following:
```
Player: 2,3
Enemy: 4,5
Enemy: 1,7
Item: 3,3
GridSize: 10,10
```

Your program should output:
```
Grid Size: 10x10
Player starting position: 2,3
Enemies: 2
Items: 1
```

---

### Exercise 4: Implementing Basic Game Logic with Interactions

#### **Objective**
This exercise focuses on integrating the parsed game objects into a simple game loop. Students will implement basic game mechanics, including player movement, score tracking, and interactions with items and enemies.

---

#### **Instructions**
Write a Java program that:
1. Creates a game grid using the objects parsed in Exercise 3.
2. Allows the player to move around the grid.
3. Tracks the player's score when collecting items.
4. Ends the game if the player collides with an enemy.

---

#### **Steps to Complete**

1. **Create the Game Grid**
    - Use the grid size from Exercise 3 to define the grid.
    - Place the player, enemies, and items on the grid based on their positions.

---

2. **Implement Player Movement**
    - Allow the player to move up, down, left, or right using keyboard input.
    - Ensure that the player cannot move outside the grid bounds.

---

3. **Handle Interactions**
    - If the player moves to a position occupied by an item:
      - Remove the item from the grid.
      - Increase the player's score by 10 points.
    - If the player moves to a position occupied by an enemy:
      - Print a "Game Over" message.
      - End the game loop.

---

4. **Update the Grid**
    - After each move, print the grid to the console, showing the positions of the player, enemies, and items.

---

#### **Starter Code**
```java
import java.util.*;

public class Game {
    private Player player;
    private List<Enemy> enemies;
    private List<Item> items;
    private int score = 0;

    public Game(Player player, List<Enemy> enemies, List<Item> items) {
        this.player = player;
        this.enemies = enemies;
        this.items = items;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("Enter move (UP, DOWN, LEFT

### **Exercise 5: Advanced Game Features and Refinement**

#### **Objective**
This exercise builds upon the foundational game logic implemented in Exercise 4. Students will introduce advanced features such as enemy movement, a timer-based scoring system, and additional game mechanics. This exercise focuses on integrating multiple concepts, refining the game experience, and improving code quality.

---

#### **Instructions**
Extend the game by adding the following features:

1. **Enemy Movement**:  
   - Enemies must move around the grid after each player move.
   - Use random movement (e.g., randomly move up, down, left, or right) for each enemy.
   - Ensure that enemies do not move outside the grid bounds.

2. **Timer-Based Scoring**:
   - Add a timer to the game that affects the scoring system.
   - Every 5 seconds of gameplay, deduct 5 points from the player's score to simulate a time-based challenge.
   - Ensure the timer runs concurrently with the game loop.

3. **Game Status Display**:
   - After each player move, display the following information in the console:
     - The current grid (showing the positions of the player, enemies, and items).
     - The player's score.
     - The time elapsed since the game started.

4. **Refactor the Code for Modularity**:
   - Extract repetitive or complex logic (e.g., movement, collision detection) into separate methods in the appropriate classes.
   - Ensure that your code adheres to principles of object-oriented programming, such as encapsulation and modularity.

---

#### **Steps to Complete**

1. **Add Enemy Movement**  
   - Modify the `Enemy` class to include a `move()` method:
     ```java
     public void move(int gridRows, int gridCols) {
         Random random = new Random();
         int direction = random.nextInt(4); // 0 = UP, 1 = DOWN, 2 = LEFT, 3 = RIGHT
         switch (direction) {
             case 0: if (row > 0) row--; break; // Move UP
             case 1: if (row < gridRows - 1) row++; break; // Move DOWN
             case 2: if (col > 0) col--; break; // Move LEFT
             case 3: if (col < gridCols - 1) col++; break; // Move RIGHT
         }
     }
     ```

   - Update the game loop to call the `move()` method for each enemy after each player move.

---

2. **Add a Timer and Adjust Scoring**  
   - Use Java's `System.currentTimeMillis()` to track the elapsed time since the game started.
   - Deduct 5 points from the player's score every 5 seconds:
     ```java
     long startTime = System.currentTimeMillis();
     while (true) {
         long elapsedTime = (System.currentTimeMillis() - startTime) / 1000; // Time in seconds
         if (elapsedTime % 5 == 0 && elapsedTime > 0) {
             score -= 5;
             System.out.println("Time penalty applied! Score: " + score);
         }
     }
     ```

---

3. **Refactor Code for Reusability**
   - Create helper methods such as:
     - `checkCollisions()` in the `Game` class to handle player-enemy and player-item interactions.
     - `displayGrid()` in the `Game` class to render the grid and display the game status.
   - Example of refactoring:
     ```java
     private void checkCollisions() {
         // Check for item collection
         for (Iterator<Item> it = items.iterator(); it.hasNext();) {
             Item item = it.next();
             if (item.getRow() == player.getRow() && item.getCol() == player.getCol()) {
                 score += 10; // Award points
                 it.remove();
                 System.out.println("Item collected! Score: " + score);
             }
         }
         // Check for collisions with enemies
         for (Enemy enemy : enemies) {
             if (enemy.getRow() == player.getRow() && enemy.getCol() == player.getCol()) {
                 System.out.println("Game Over! Final Score: " + score);
                 System.exit(0); // End the game
             }
         }
     }
     ```

---

4. **Test and Debug**  
   - Test the game thoroughly to ensure that:
     - Enemies move correctly and stay within grid bounds.
     - The player's score updates correctly based on time penalties and item collection.
     - The game status is displayed accurately after every move.

---

#### **Expected Output**
After completing this exercise, your game should:
- Include moving enemies that pose a dynamic challenge to the player.
- Penalize the player for taking too long to complete the game.
- Display a clear and updated game status after every move.

---

### **Exercise 6: Creative Expansion with Advanced Mechanics**

#### **Objective**
This final exercise challenges students to expand their game creatively by implementing advanced game mechanics. Students will demonstrate mastery of file I/O, class design, object-oriented principles, and creative problem-solving.

---

#### **Instructions**
Choose **two** of the following advanced features to implement in your game. You are encouraged to experiment and design your own unique solutions.

---

### **Feature Options**

1. **Power-Ups**  
   - Introduce a new type of grid object (`PowerUp`).
   - When the player collects a power-up, they gain a temporary advantage, such as:
     - Immunity to enemies for 5 moves.
     - Double points for the next item collected.
   - Implement the logic to apply and track the effects of power-ups.

   **Hint**: Use a counter to track how many moves the player has left with the power-up effect.

---

2. **Level Progression**  
   - Add a feature where the game progresses to a new level when all items on the current grid are collected.
   - Each level should:
     - Load a new configuration from a file (e.g., `level2Config.txt`).
     - Introduce more enemies or a larger grid size to increase the difficulty.
   - Implement logic to transition between levels without restarting the game.

---

3. **Enemy AI**  
   - Enhance enemy behavior by making them move toward the player's position instead of moving randomly.
   - Use simple pathfinding logic to calculate the direction that brings the enemy closer to the player (e.g., compare row and column differences).
   - Ensure that enemies still stay within the grid bounds.

   **Hint**: Use basic conditional statements to implement this feature. For example:
   ```java
   if (enemyRow < playerRow) enemyRow++;
   else if (enemyRow > playerRow) enemyRow--;
   ```

---

4. **Custom Grid and Difficulty Settings**  
   - Allow the player to customize the grid size and difficulty level at the start of the game.
   - Difficulty levels can affect:
     - The number of enemies.
     - The number of items.
     - The frequency of time penalties.
   - Validate user input to ensure valid grid sizes and difficulty levels.

---

5. **High Score Tracking