## Task: Create a Simple Game Application in Java

### Overview
For this task, you will design and implement a simple game application in Java. The game will include **player movement**, a **scoring system**, and **enemy interactions**. You will demonstrate your understanding of object-oriented programming by designing robust classes, using data from files to dynamically create objects, and applying creative problem-solving to enhance the gameplay experience.

Your game should allow a player to navigate a 2D grid-based game world while collecting "points" and avoiding enemies. The game world, player, and enemies will be initialized using data read from external files. You will also implement a scoring system to track the player's performance.

This task is divided into smaller steps, each aligned with the weekly learning goals. Use the provided scaffolding and guidelines to structure your solution.

---

### **Step 1: Design the Classes**
**Learning Goal Integration**: "Designing Classes"

Start by identifying the core components of your game. These components should include:
1. **Player**: Represents the player character.
2. **Enemy**: Represents enemies on the game grid.
3. **GameWorld**: Represents the 2D grid-based game world.

For each class:
- Define its responsibilities and attributes.
- Implement appropriate methods to support game functionality.

#### Example:
```java
// Example Player class structure
public class Player {
    private int x; // X-coordinate on the grid
    private int y; // Y-coordinate on the grid
    private int score; // Player's score

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.score = 0;
    }

    public void move(String direction) {
        // Logic to update player position based on the input direction (e.g., "up", "down")
    }

    public void increaseScore(int points) {
        score += points;
    }

    public int getScore() {
        return score;
    }

    // Getters and setters for x and y
}
```

**Task**:
- Design and implement the `Enemy` and `GameWorld` classes. Each enemy should have a position (x, y) and behavior (e.g., moving randomly or staying still).
- Use principles of cohesion and clear interfaces to ensure your classes are well-structured.

---

### **Step 2: Use Data from Files to Instantiate Objects**
**Learning Goal Integration**: "Using Data from Files to Instantiate Objects"

You will use external files to define the initial state of the game. These files will include:
1. **GameWorld configuration**: Specifies the size of the grid and the positions of items (e.g., points to collect).
2. **Player configuration**: Specifies the starting position of the player.
3. **Enemy configuration**: Specifies the positions and types of enemies.

#### Example File Format:
- **gameworld.txt**:
```
GRID_SIZE: 10x10
POINT: 3,4
POINT: 7,2
```

- **player.txt**:
```
START_POSITION: 0,0
```

- **enemies.txt**:
```
ENEMY: 5,5
ENEMY: 8,3
```

#### Example: Reading File Data
```java
import java.io.*;
import java.util.*;

public class FileReaderExample {
    public static List<String> readFile(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        }
        return lines;
    }
}
```

**Task**:
- Write methods to parse these files and extract meaningful data.
- Use the extracted data to instantiate the game world, player, and enemy objects dynamically.
- Handle file I/O exceptions gracefully, ensuring your program does not crash if a file is missing or corrupted.

---

### **Step 3: Implement Game Functionality**
**Learning Goal Integration**: "Programming Creatively"

Now that you have your classes and objects in place, implement the core game functionalities:
1. **Player Movement**: Allow the player to move within the grid using simple commands (e.g., "up", "down", "left", "right"). Ensure that the player cannot move outside the grid boundaries.
2. **Scoring System**: When the player moves to a cell containing a point, increase the player's score and remove the point from the grid.
3. **Enemy Interactions**: Detect when the player encounters an enemy. When this happens, display a message and end the game.

#### Example: Game Loop
```java
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        GameWorld world = new GameWorld(10, 10); // Example instantiation
        Player player = new Player(0, 0);

        while (true) {
            System.out.println("Enter move (up, down, left, right): ");
            String move = scanner.nextLine();
            player.move(move);
            
            if (world.checkCollision(player)) {
                System.out.println("Game Over! You collided with an enemy.");
                break;
            }
            
            if (world.checkPointCollected(player)) {
                player.increaseScore(10);
                System.out.println("Point collected! Current score: " + player.getScore());
            }
        }
    }
}
```

**Task**:
- Write methods in the `GameWorld` class to check for collisions and point collection.
- Enhance the game creatively by adding new features. For example:
  - Timed gameplay (e.g., the player must collect a certain number of points within a time limit).
  - Different types of enemies with unique behaviors.
  - Bonus points that appear randomly on the grid.

---

### **Step 4: Test and Refine**
**Learning Goal Integration**: "Programming Creatively"

- Test your game thoroughly to ensure all functionalities work as expected.
- Experiment with different configurations and gameplay mechanics to make the game more engaging.
- Collect feedback from classmates or friends and iterate on your design.

---

### Submission Requirements
- Source code for all classes (`Player`, `Enemy`, `GameWorld`, etc.).
- External data files (`gameworld.txt`, `player.txt`, `enemies.txt`).
- A short write-up (1-2 paragraphs) explaining your design decisions and any creative features you added.

### Evaluation Criteria
- Correct implementation of file reading and object instantiation.
- Well-designed classes with appropriate responsibilities.
- Creative enhancements to the game.
- Code quality, including readability, comments, and error handling.

---

This task integrates key programming concepts while allowing you to exercise creativity and problem-solving skills. Have fun building your game!

### Exercise 1: Understanding File I/O and Object Instantiation

This exercise focuses on the theoretical aspects of using data from files to instantiate objects. It will help students understand how external data sources can influence program behavior and how to handle file input/output in Java.

#### **Objective**
To ensure students understand:
1. File formats and their importance in coding tasks.
2. How to read and parse data from files in Java.
3. The process of using parsed data to create and initialize objects dynamically.
4. How to handle file-related exceptions.

#### **Tasks**
1. **File Format Analysis**  
   - Below are examples of file contents. For each file:
     - Describe what kind of data the file contains.
     - Explain how this data can be used in a program.
     - Suggest a possible Java data structure that could store this data once parsed.

   **File Examples**:  
   - `gameworld.txt`:  
     ```
     GRID_SIZE: 10x10  
     POINT: 3,4  
     POINT: 7,2  
     ```
   - `player.txt`:  
     ```
     START_POSITION: 0,0  
     ```
   - `enemies.txt`:  
     ```
     ENEMY: 5,5  
     ENEMY: 8,3  
     ```

2. **Understanding File I/O in Java**  
   - Consider the following Java code snippet for reading a file:
     ```java
     import java.io.*;
     import java.util.*;

     public class FileReaderExample {
         public static List<String> readFile(String fileName) throws IOException {
             List<String> lines = new ArrayList<>();
             try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
                 String line;
                 while ((line = br.readLine()) != null) {
                     lines.add(line);
                 }
             }
             return lines;
         }
     }
     ```
     Answer the following:
     - What is the role of `BufferedReader` in this code? Why is it used instead of `FileReader` alone?
     - What is the purpose of the `try` block with resources (`try (BufferedReader br = ...)`)?
     - How would you handle an exception if the file being read does not exist?

3. **Dynamic Object Instantiation**  
   - Imagine you have parsed the following data from `player.txt`: `START_POSITION: 2,3`.  
     - Write pseudocode (not Java code) that describes how you would use this information to create a `Player` object.
     - What challenges could arise when parsing and using data from files, and how might you address them in your program?

---

### Exercise 2: Principles of Class Design

This exercise focuses on the theoretical aspects of designing classes, with an emphasis on identifying responsibilities, defining clear interfaces, and ensuring cohesion.

#### **Objective**
To ensure students understand:
1. How to identify and assign responsibilities to different classes.
2. The importance of clear and cohesive class design in object-oriented programming.
3. The role of encapsulation, fields, methods, and interfaces in class design.

#### **Tasks**
1. **Class Responsibilities**  
   - For the game described in the main task, identify the primary responsibilities of the following classes:
     - `Player`
     - `Enemy`
     - `GameWorld`
   - For each class, list at least three attributes (fields) and three methods (behaviors) that align with its responsibilities.  
     Example:  
     ```
     Class: Player
     Responsibilities: Represent the player character, track position, collect points.
     Attributes: int x, int y, int score
     Methods: move(String direction), increaseScore(int points), getScore()
     ```

2. **Encapsulation and Interfaces**  
   - Explain the concept of encapsulation and why it is important in object-oriented programming.  
   - Consider the following method in a `Player` class:
     ```java
     public void move(String direction) {
         if (direction.equals("up")) {
             y--;
         } else if (direction.equals("down")) {
             y++;
         } else if (direction.equals("left")) {
             x--;
         } else if (direction.equals("right")) {
             x++;
         }
     }
     ```
     - What assumptions does this method make about the `x` and `y` fields?  
     - How could you modify this method to ensure that the player does not move outside the grid boundaries? Write pseudocode to describe your solution.

3. **Evaluating Class Design**  
   - The `Enemy` class represents enemies on the grid. Below are two possible designs for this class. Compare the two designs and discuss which one is better and why.  
     
     **Design A**:
     ```java
     public class Enemy {
         private int x, y;

         public Enemy(int x, int y) {
             this.x = x;
             this.y = y;
         }

         public void moveRandomly() {
             // Logic for random movement
         }
     }
     ```  
     
     **Design B**:
     ```java
     public class Enemy {
         private int x, y;
         private String behavior;

         public Enemy(int x, int y, String behavior) {
             this.x = x;
             this.y = y;
             this.behavior = behavior;
         }

         public void move() {
             if (behavior.equals("random")) {
                 // Logic for random movement
             } else if (behavior.equals("static")) {
                 // Logic for staying still
             }
         }
     }
     ```  
     - Which design is more extensible if you want to add new enemy behaviors in the future?  
     - How could you improve the chosen design further?

4. **Cohesion and Dependencies**  
   - What does it mean for a class to be "cohesive"?  
   - Consider the `GameWorld` class, which is responsible for managing the game grid. Suppose this class also directly handles player movement and scoring.  
     - Why might this be problematic in terms of cohesion?  
     - How could you refactor the design to address this issue?

---

### Deliverables for Exercises 1 & 2
Students should submit:
1. Written answers to all conceptual questions in both exercises.
2. Pseudocode solutions where required.
3. A short reflection (3-5 sentences) on what they learned about file I/O and class design through these exercises.  

---

### Pedagogical Value
- **Exercise 1**: Prepares students for file handling and dynamic object creation by focusing on the theoretical aspects of file I/O and parsing. Builds a strong foundation for the practical coding tasks in later steps.  
- **Exercise 2**: Deepens students' understanding of class design principles, ensuring they can design robust and maintainable classes for the game application.

### Exercise 3: Parsing Data and Initializing Objects

This exercise bridges the gap between theory and practice by requiring students to write code that parses data from files and uses it to dynamically create objects. It builds directly on the concepts from Exercise 1, moving students from understanding file I/O to applying it in a practical programming context.

---

#### **Objective**
To ensure students can:
1. Write Java code to read and parse data from files.
2. Dynamically instantiate objects using the parsed data.
3. Handle exceptions and validate input data.

---

### **Tasks**

1. **Parsing GameWorld Data**
   - Write a method that reads a file named `gameworld.txt` containing the grid size and point positions. The file has the following format:
     ```
     GRID_SIZE: 10x10
     POINT: 3,4
     POINT: 7,2
     ```
   - Parse the grid size and store it as two integers (`width` and `height`).
   - Parse the point positions into a list of `Point` objects (you can use Java's `Point` class or create your own).

   **Method Signature**
   ```java
   public class GameWorld {
       private int width;
       private int height;
       private List<Point> points;

       public void loadGameWorld(String fileName) throws IOException {
           // Your implementation here
       }
   }
   ```

   **Requirements**
   - Use `BufferedReader` for file reading.
   - Validate the data format (e.g., ensure the grid size matches the `NxM` pattern, and points are in `x,y` format).
   - Handle exceptions gracefully (e.g., file not found, malformed data).

2. **Parsing and Instantiating Player**
   - Write a method that reads a file named `player.txt` containing the player's starting position. The file has the following format:
     ```
     START_POSITION: 2,3
     ```
   - Parse the starting position and use it to instantiate a `Player` object.

   **Method Signature**
   ```java
   public static Player loadPlayer(String fileName) throws IOException {
       // Your implementation here
   }
   ```

   **Requirements**
   - Validate that the position is within the game grid's boundaries (use the `width` and `height` from the `GameWorld` object).
   - Handle exceptions for missing or invalid data.

3. **Parsing and Instantiating Enemies**
   - Write a method that reads a file named `enemies.txt` containing enemy positions. The file has the following format:
     ```
     ENEMY: 5,5
     ENEMY: 8,3
     ```
   - Parse the enemy positions and instantiate a list of `Enemy` objects.

   **Method Signature**
   ```java
   public static List<Enemy> loadEnemies(String fileName) throws IOException {
       // Your implementation here
   }
   ```

   **Requirements**
   - Validate that each enemy position is within the grid boundaries.
   - Handle exceptions for missing or invalid data.

4. **Testing and Integration**
   - Write a `Main` class with a `main` method that:
     1. Loads the game world using the `loadGameWorld` method.
     2. Loads the player using the `loadPlayer` method.
     3. Loads the enemies using the `loadEnemies` method.
   - Print the loaded data to the console to verify correctness:
     ```
     Game World: 10x10
     Points: (3,4), (7,2)
     Player: (2,3)
     Enemies: (5,5), (8,3)
     ```

---

### **Deliverables**
- Implementations of `loadGameWorld`, `loadPlayer`, and `loadEnemies`.
- A `Main` class that demonstrates file parsing and object instantiation.

---

### **Evaluation Criteria**
- Correct parsing of data from files.
- Accurate instantiation of objects using parsed data.
- Appropriate handling of exceptions and invalid input.
- Code readability and proper use of comments.

---

### Exercise 4: Implementing Basic Game Functionality

This exercise builds on the objects and data created in Exercise 3, requiring students to implement basic game functionality. It transitions from initialization to interaction, setting the stage for the full game implementation in later tasks.

---

#### **Objective**
To ensure students can:
1. Implement basic functionality for game objects.
2. Use object interactions to simulate game mechanics (e.g., player movement, point collection, and enemy collisions).
3. Write a simple game loop to test interactions.

---

### **Tasks**

1. **Player Movement**
   - Add a `move(String direction)` method to the `Player` class that allows the player to move up, down, left, or right. Ensure the player cannot move outside the grid boundaries.
   
   **Method Signature**
   ```java
   public void move(String direction, int gridWidth, int gridHeight) {
       // Your implementation here
   }
   ```

   **Requirements**
   - Accept movement commands (`"up"`, `"down"`, `"left"`, `"right"`).
   - Prevent the player from moving outside the grid (e.g., if the player is at `(0,0)` and moves `"up"`, their position should remain `(0,0)`).

2. **Point Collection**
   - Add a method to the `GameWorld` class that checks if the player is on a cell containing a point. If so, remove the point from the grid and increase the player's score.

   **Method Signature**
   ```java
   public boolean checkPointCollected(Player player) {
       // Your implementation here
   }
   ```

   **Requirements**
   - Use the player's position (`x`, `y`) to check for points on the grid.
   - Remove the collected point from the `points` list.
   - Return `true` if a point was collected, otherwise return `false`.

3. **Enemy Interactions**
   - Add a method to the `GameWorld` class that checks if the player has collided with an enemy. If so, return `true`.

   **Method Signature**
   ```java
   public boolean checkCollision(Player player, List<Enemy> enemies) {
       // Your implementation here
   }
   ```

   **Requirements**
   - Compare the player's position with each enemy's position.
   - Return `true` if a collision is detected, otherwise return `false`.

4. **Game Loop**
   - Write a simple game loop in the `Main` class that:
     1. Displays the player's current position, score, and remaining points.
     2. Accepts movement commands from the user.
     3. Updates the player's position based on the command.
     4. Checks for point collection and collisions after each move.
     5. Ends the game if the player collides with an enemy.

   **Example Output**
   ```
   Current Position: (2,3)
   Score: 0
   Remaining Points: 2
   Enter move (up, down, left, right): up

   Current Position: (2,2)
   Score: 10
   Remaining Points: 

### Exercise 5: Adding Advanced Gameplay Features

This exercise focuses on enhancing the game application by introducing **advanced gameplay mechanics** and **polishing the existing functionality**. Students will expand their understanding of object-oriented programming by implementing new features like timed gameplay, enemy behaviors, and bonus points. This exercise consolidates concepts from previous steps while encouraging creativity and problem-solving.

---

#### **Objective**
To ensure students can:
1. Extend existing classes to add new functionality.
2. Implement gameplay mechanics that involve timers, randomization, and dynamic updates.
3. Use object-oriented principles to keep the code modular and maintainable.

---

### **Tasks**

1. **Bonus Points**
   - Modify the `GameWorld` class to include **bonus points** that appear randomly on the grid for a limited time.
   - A bonus point should:
     - Be worth more than a regular point (e.g., `50` points instead of `10`).
     - Appear at a random position on the grid after every `5` moves.
     - Disappear after `3` moves if not collected.

   **Implementation Steps**:
   - Add a `bonusPoint` attribute to the `GameWorld` class to track the current bonus point's position (use a `Point` object).
   - Add a method `generateBonusPoint()` that randomly selects a position on the grid for the bonus point.
   - Update the `checkPointCollected` method to handle bonus points (i.e., increase the player’s score by `50` and reset the `bonusPoint` attribute to `null`).
   - Add a counter to track the number of moves made by the player and remove the bonus point after `3` moves if it hasn’t been collected.

   **Method Signatures**:
   ```java
   public void generateBonusPoint();
   public boolean checkBonusPointCollected(Player player);
   ```

2. **Timed Gameplay**
   - Add a **timer** to the game that limits the total gameplay duration (e.g., `60 seconds`).
   - If the timer runs out, display a "Game Over" message and the player’s final score.

   **Implementation Steps**:
   - Use Java’s `System.currentTimeMillis()` method to track the start time of the game.
   - Modify the game loop to check the elapsed time after every move. End the game if the time exceeds `60 seconds`.

   **Example Code Snippet**:
   ```java
   long startTime = System.currentTimeMillis();
   long timeLimit = 60000; // 60 seconds

   while (true) {
       long elapsedTime = System.currentTimeMillis() - startTime;
       if (elapsedTime > timeLimit) {
           System.out.println("Time's up! Game Over.");
           break;
       }
   }
   ```

3. **Enhanced Enemy Behaviors**
   - Extend the `Enemy` class to support different behaviors:
     - **Static**: The enemy does not move.
     - **Random**: The enemy moves to a random adjacent cell on the grid after every player move.
     - **Chasing**: The enemy moves one step closer to the player’s position after every player move.

   **Implementation Steps**:
   - Add a `behavior` attribute to the `Enemy` class.
   - Modify the `move()` method to handle the three types of behaviors.
   - Use the `Math.abs()` function to calculate the distance between the enemy and the player for the **chasing** behavior.

   **Method Signature**:
   ```java
   public void move(Player player, int gridWidth, int gridHeight);
   ```

4. **Game Over Conditions**
   - Update the game loop to include the following game over conditions:
     - The player collides with an enemy.
     - The timer runs out.
     - The player collects all regular and bonus points.

   **Example Output**:
   ```
   Current Position: (2,3)
   Score: 60
   Remaining Points: 0
   Timer: 10 seconds left
   Enter move (up, down, left, right): down

   Current Position: (2,4)
   Score: 110
   Bonus Point Collected!
   Game Over! You Win!
   ```

---

### **Deliverables**
- A fully functional game with bonus points, timed gameplay, and enhanced enemy behaviors.
- Updated `Player`, `Enemy`, and `GameWorld` classes with the new features.
- A `Main` class that demonstrates the gameplay mechanics.

---

### **Evaluation Criteria**
- Correct implementation of bonus points, timed gameplay, and enemy behaviors.
- Smooth integration of new features into the existing code.
- Proper use of object-oriented principles (e.g., encapsulation, modularity).
- Code readability and adherence to best practices.

---

---

### Exercise 6: Finalizing and Polishing the Game Application

This exercise serves as the **culmination of the project**, challenging students to refine their game, add creative enhancements, and ensure robustness. Students will focus on **polishing the gameplay experience**, **testing thoroughly**, and adding a **unique creative feature** of their choice.

---

#### **Objective**
To ensure students can:
1. Refactor and test their code to ensure robustness and maintainability.
2. Apply creative problem-solving to add a unique feature to the game.
3. Create a polished final product that demonstrates mastery of the course concepts.

---

### **Tasks**

1. **Refactoring and Testing**
   - Refactor your code to improve readability, modularity, and efficiency. Focus on:
     - Reducing duplicated code.
     - Ensuring methods are small and focused on a single responsibility.
     - Adding comments and documentation to explain the code.
   - Write a **test plan** that includes:
     - Test cases for player movement (e.g., boundary conditions, valid/invalid inputs).
     - Test cases for point collection and bonus points.
     - Test cases for enemy collisions and behaviors.
     - Test cases for game over conditions (e.g., timer expiration, all points collected).
   - Implement a **debug mode** that prints the internal state of the game (e.g., player position, enemy positions, points remaining) for testing purposes.

   **Example Debug Output**:
   ```
   Debug Mode:
   Player: (2,3)
   Enemies: [(5,5) - Static, (7,2) - Chasing]
   Points: [(3,4), (7,2)]
   Bonus Point: (6,6)
   ```

2. **Adding a Unique Feature**
   - Add at least **one new creative feature** to your game. Examples include:
     - **Power-Ups**: Items the player can collect to gain temporary abilities (e.g., invincibility, faster movement).
     - **Levels**: Add multiple levels to the game, each with a different grid size, number of points, and enemy behaviors.
     - **Obstacles**: Add obstacles to the grid that block player and enemy movement.
     - **Multiplayer Mode**: Allow two players to take turns moving on the grid and competing for points.

   **Implementation Steps**:
   - Design and document your feature before implementing it.
   - Ensure the feature integrates