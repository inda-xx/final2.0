### Task: Create a Simple Game Application in Java

In this task, you will design and implement a simple 2D console-based game application in Java. The game will feature **player movement**, a **scoring system**, and **enemy interactions**. This project will integrate core programming concepts, such as **using data from files to instantiate objects**, **designing classes**, and **programming creatively**. By the end of this task, you will have a fully functional game that demonstrates your understanding of object-oriented programming, file handling, and creative problem-solving.

---

### **Game Overview:**
The game is a grid-based survival game where a player moves around a small grid while avoiding randomly placed enemies. The player gains points by collecting items scattered around the grid. The game ends if the player collides with an enemy or collects all items.

---

### **Task Requirements:**

1. **Player Movement:**
   - The player can move up, down, left, or right within the grid using keyboard inputs (e.g., `W`, `A`, `S`, `D`).
   - The player cannot move outside the boundaries of the grid.

2. **Scoring System:**
   - Items are randomly placed on the grid, and the player earns points by collecting them.
   - Display the current score after every move.

3. **Enemy Interactions:**
   - Enemies are randomly placed on the grid and remain stationary.
   - If the player moves to a grid cell occupied by an enemy, the game ends.

4. **Dynamic Object Creation:**
   - The game grid, enemies, and collectible items must be dynamically created based on data read from an external file (e.g., a text file).

5. **Object-Oriented Design:**
   - The game must be designed using multiple well-structured classes (e.g., `Player`, `Enemy`, `Item`, `GameGrid`).
   - Classes should have clear responsibilities and methods.

6. **Creative Programming:**
   - You are encouraged to implement additional features (e.g., multiple levels, moving enemies, power-ups) to make the game more engaging.

---

### **Step-by-Step Guide:**

#### **Step 1: Design Classes**
Start by designing the core classes for the game. Below is a suggestion for the classes and their responsibilities:

- **`Player` Class:**
  - Attributes: `x` (row position), `y` (column position), `score`
  - Methods: `moveUp()`, `moveDown()`, `moveLeft()`, `moveRight()`, `addScore(points)`

- **`Enemy` Class:**
  - Attributes: `x` (row position), `y` (column position)

- **`Item` Class:**
  - Attributes: `x` (row position), `y` (column position), `points`

- **`GameGrid` Class:**
  - Attributes: `width`, `height`, `Player`, list of `Enemy` objects, list of `Item` objects
  - Methods: `populateGridFromFile(filePath)`, `drawGrid()`, `checkCollisions()`

##### **Example Code Snippet:**
Here’s a skeleton of the `Player` class to get you started:
```java
public class Player {
    private int x;
    private int y;
    private int score;

    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.score = 0;
    }

    public void moveUp() {
        this.x -= 1;
    }

    public void moveDown() {
        this.x += 1;
    }

    public void moveLeft() {
        this.y -= 1;
    }

    public void moveRight() {
        this.y += 1;
    }

    public void addScore(int points) {
        this.score += points;
    }

    public int getScore() {
        return score;
    }

    // Getters for position
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
```

---

#### **Step 2: Use Data from Files to Instantiate Objects**
Create a text file (e.g., `gameData.txt`) to define the grid size, player starting position, enemy positions, and item positions/values. Below is an example of the file format:

```
Grid: 10x10
Player: 0,0
Enemy: 2,3
Enemy: 5,6
Item: 4,4,10
Item: 7,2,15
```

Write code to read this file and use the data to create and initialize objects for the game.

##### **Example Code Snippet for Reading the File:**
```java
import java.io.*;
import java.util.*;

public class GameGrid {
    private int width;
    private int height;
    private Player player;
    private List<Enemy> enemies = new ArrayList<>();
    private List<Item> items = new ArrayList<>();

    public void populateGridFromFile(String filePath) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;
        while ((line = reader.readLine()) != null) {
            String[] parts = line.split(": ");
            switch (parts[0]) {
                case "Grid":
                    String[] dimensions = parts[1].split("x");
                    width = Integer.parseInt(dimensions[0]);
                    height = Integer.parseInt(dimensions[1]);
                    break;
                case "Player":
                    String[] playerPos = parts[1].split(",");
                    int playerX = Integer.parseInt(playerPos[0]);
                    int playerY = Integer.parseInt(playerPos[1]);
                    player = new Player(playerX, playerY);
                    break;
                case "Enemy":
                    String[] enemyPos = parts[1].split(",");
                    int enemyX = Integer.parseInt(enemyPos[0]);
                    int enemyY = Integer.parseInt(enemyPos[1]);
                    enemies.add(new Enemy(enemyX, enemyY));
                    break;
                case "Item":
                    String[] itemData = parts[1].split(",");
                    int itemX = Integer.parseInt(itemData[0]);
                    int itemY = Integer.parseInt(itemData[1]);
                    int points = Integer.parseInt(itemData[2]);
                    items.add(new Item(itemX, itemY, points));
                    break;
            }
        }
        reader.close();
    }
}
```

---

#### **Step 3: Implement Game Logic**
- Write a game loop that:
  - Displays the grid and updates it after each move.
  - Accepts user input for player movement.
  - Checks for collisions with enemies or items.
  - Ends the game if the player collides with an enemy or collects all items.

##### **Example Code Snippet for the Game Loop:**
```java
import java.util.Scanner;

public class Game {
    public static void main(String[] args) throws IOException {
        GameGrid grid = new GameGrid();
        grid.populateGridFromFile("gameData.txt");
        Scanner scanner = new Scanner(System.in);

        boolean isGameOver = false;
        while (!is

### **Exercise 1: Understanding File I/O and Dynamic Object Creation**

#### **Objective:**
To ensure students understand the principles of file handling and how to use data from files to dynamically instantiate objects in Java.

---

#### **Instructions:**
Answer the following theoretical questions about file I/O and object instantiation in Java. Provide detailed explanations for each question.

1. **File Formats and Data Parsing:**
   - Explain the importance of choosing a structured file format (e.g., plain text, CSV, or JSON) for storing game data such as grid size, player position, enemy positions, and item details. 
   - If the input file is formatted as:
     ```
     Grid: 8x8
     Player: 1,1
     Enemy: 3,4
     Item: 6,6,20
     ```
     - How would you parse the information to extract the grid dimensions, player position, enemy position, and item data? Describe the process step-by-step.

2. **File I/O Classes in Java:**
   - Compare the `BufferedReader` class and the `Scanner` class for reading data from files in Java. Which one would you choose for this task, and why?
   - What are the potential pitfalls of using hardcoded file paths in your program? Suggest methods to make file handling more flexible.

3. **Dynamic Object Creation:**
   - Describe how data read from a file can be used to dynamically instantiate objects in Java. Use the example of creating a `Player` object from the line `Player: 1,1` in the input file.
   - Why is it important to validate the data read from a file before using it to instantiate objects? What errors might occur if the data is invalid?

4. **Code Readability and Maintainability:**
   - Explain why separating file parsing logic into its own method or class (e.g., `populateGridFromFile()` in the `GameGrid` class) improves code readability and maintainability.
   - How can you make your file-parsing method more robust to handle unexpected file formats or missing data?

---

#### **Expected Learning Outcomes:**
- Students will understand the importance of structured file formats and how to parse data systematically.
- They will be familiar with Java's file I/O classes and their use cases.
- They will grasp how to use file data to create objects dynamically and the importance of validating input data.
- They will learn best practices for organizing and maintaining code when dealing with file handling.

---

---

### **Exercise 2: Principles of Class Design**

#### **Objective:**
To help students internalize the principles of designing well-structured, object-oriented classes by analyzing and improving class designs.

---

#### **Instructions:**
Answer the following theoretical questions about object-oriented design principles. Use the `Player`, `Enemy`, `Item`, and `GameGrid` classes from the task description as examples where applicable.

1. **Class Responsibilities:**
   - For each of the following classes (`Player`, `Enemy`, `Item`, and `GameGrid`), describe their primary responsibilities in the context of the game.
   - Why is it important to assign clear responsibilities to each class? How does this impact the overall design of your program?

2. **Cohesion and Coupling:**
   - Define the concepts of cohesion and coupling in object-oriented design.
   - Evaluate the following scenario: Suppose the `GameGrid` class directly manipulates the `score` attribute of the `Player` class to update the player's score. Is this a good design choice? Justify your answer.

3. **Encapsulation and Access Modifiers:**
   - Explain why it is important to use encapsulation and appropriate access modifiers (e.g., `private`, `public`) when designing classes.
   - Consider the `Player` class from the task description. The `score` attribute is private, and there is a method `addScore(int points)` to modify it. Why is this better than making `score` a public attribute?

4. **Design Patterns in Class Design:**
   - Suggest how a design pattern (e.g., Factory Pattern, Singleton Pattern) might be used in the game application to improve the design of the `GameGrid` class or the dynamic creation of objects from file data.
   - Explain how the chosen design pattern would enhance flexibility or maintainability in your program.

5. **Extending the Design:**
   - Suppose you want to add a new type of object to the game, such as power-ups that temporarily boost the player's speed. How would you modify your class design to incorporate this new feature without disrupting the existing classes?

---

#### **Expected Learning Outcomes:**
- Students will understand how to assign clear responsibilities to classes and the importance of cohesive design.
- They will learn to evaluate and improve class designs by applying principles such as encapsulation, cohesion, and low coupling.
- Students will be introduced to the concept of design patterns and how they can improve flexibility and maintainability.
- They will think critically about how to extend their designs to accommodate new features.

---

#### **Submission Requirements:**
- For both exercises, students must submit written answers (typed or neatly handwritten) that demonstrate their understanding of the concepts.
- Encourage students to provide examples or diagrams where appropriate to clarify their explanations.

---

These exercises will lay the theoretical groundwork for the subsequent coding exercises by ensuring students understand the key concepts of file handling, dynamic object creation, and object-oriented design.

### **Exercise 3: Implementing File-Based Dynamic Object Creation**

#### **Objective:**
To help students transition from understanding file I/O and object creation conceptually to writing code that dynamically creates and initializes objects based on data stored in a file.

---

#### **Instructions:**
Write code to implement a simple version of the `populateGridFromFile()` method in the `GameGrid` class and test it by creating a basic grid with a player, enemies, and items. The goal is to successfully read data from a file and instantiate objects dynamically.

---

#### **Steps:**

1. **Set Up the Input File:**
   - Create a text file (e.g., `gameData.txt`) with the following sample data:
     ```
     Grid: 5x5
     Player: 2,2
     Enemy: 0,4
     Enemy: 4,0
     Item: 1,1,10
     Item: 3,3,15
     ```

2. **Write the Code:**
   - Implement a partial version of the `GameGrid` class that includes:
     - Attributes for grid size, player, enemies, and items.
     - The `populateGridFromFile(String filePath)` method to read the file and instantiate objects.

   ##### **Starter Code Skeleton:**
   ```java
   import java.io.*;
   import java.util.*;

   public class GameGrid {
       private int width;
       private int height;
       private Player player;
       private List<Enemy> enemies = new ArrayList<>();
       private List<Item> items = new ArrayList<>();

       public void populateGridFromFile(String filePath) throws IOException {
           BufferedReader reader = new BufferedReader(new FileReader(filePath));
           String line;
           while ((line = reader.readLine()) != null) {
               String[] parts = line.split(": ");
               switch (parts[0]) {
                   case "Grid":
                       String[] dimensions = parts[1].split("x");
                       width = Integer.parseInt(dimensions[0]);
                       height = Integer.parseInt(dimensions[1]);
                       break;
                   case "Player":
                       String[] playerPos = parts[1].split(",");
                       int playerX = Integer.parseInt(playerPos[0]);
                       int playerY = Integer.parseInt(playerPos[1]);
                       player = new Player(playerX, playerY);
                       break;
                   case "Enemy":
                       String[] enemyPos = parts[1].split(",");
                       int enemyX = Integer.parseInt(enemyPos[0]);
                       int enemyY = Integer.parseInt(enemyPos[1]);
                       enemies.add(new Enemy(enemyX, enemyY));
                       break;
                   case "Item":
                       String[] itemData = parts[1].split(",");
                       int itemX = Integer.parseInt(itemData[0]);
                       int itemY = Integer.parseInt(itemData[1]);
                       int points = Integer.parseInt(itemData[2]);
                       items.add(new Item(itemX, itemY, points));
                       break;
               }
           }
           reader.close();
       }

       // Temporary method to display the grid data
       public void printGridInfo() {
           System.out.println("Grid size: " + width + "x" + height);
           System.out.println("Player at: (" + player.getX() + ", " + player.getY() + ")");
           System.out.println("Enemies:");
           for (Enemy enemy : enemies) {
               System.out.println("  - (" + enemy.getX() + ", " + enemy.getY() + ")");
           }
           System.out.println("Items:");
           for (Item item : items) {
               System.out.println("  - (" + item.getX() + ", " + item.getY() + ") worth " + item.getPoints() + " points");
           }
       }
   }
   ```

   ##### **Player, Enemy, and Item Classes:**
   - Students should copy or adapt their implementations of the `Player`, `Enemy`, and `Item` classes from Exercise 1.

3. **Test Your Code:**
   - Write a `main` method to test the `populateGridFromFile` method. The test should:
     - Read the `gameData.txt` file.
     - Print out the grid size, player position, enemy positions, and item details to verify the data was loaded correctly.

   ##### **Example Test Code:**
   ```java
   public class Game {
       public static void main(String[] args) {
           GameGrid grid = new GameGrid();
           try {
               grid.populateGridFromFile("gameData.txt");
               grid.printGridInfo();
           } catch (IOException e) {
               System.out.println("Error reading game data file: " + e.getMessage());
           }
       }
   }
   ```

---

#### **Expected Output:**
For the provided `gameData.txt` file, the output should look like this:
```
Grid size: 5x5
Player at: (2, 2)
Enemies:
  - (0, 4)
  - (4, 0)
Items:
  - (1, 1) worth 10 points
  - (3, 3) worth 15 points
```

---

#### **Learning Outcomes:**
- Students will gain hands-on experience with dynamic object creation based on file data.
- They will develop confidence in working with file I/O and parsing structured data.
- They will practice organizing their code in an object-oriented manner.

---

---

### **Exercise 4: Building the Core Gameplay Loop**

#### **Objective:**
To transition students from implementing object creation to integrating it with basic gameplay mechanics, such as player movement and collision detection.

---

#### **Instructions:**
Extend your implementation from Exercise 3 to add a simple game loop. The loop should handle player movement and display the grid after every move.

---

#### **Steps:**

1. **Extend the `GameGrid` Class:**
   - Add a `drawGrid()` method to visualize the grid in the console. Use symbols to represent the player (`P`), enemies (`E`), items (`I`), and empty spaces (`.`).

   ##### **Example Code for drawGrid():**
   ```java
   public void drawGrid() {
       for (int i = 0; i < height; i++) {
           for (int j = 0; j < width; j++) {
               if (player.getX() == i && player.getY() == j) {
                   System.out.print("P ");
               } else if (isEnemyAt(i, j)) {
                   System.out.print("E ");
               } else if (isItemAt(i, j)) {
                   System.out.print("I ");
               } else {
                   System.out.print(". ");
               }
           }
           System.out.println();
       }
   }

   private boolean isEnemyAt(int x, int y) {
       for (Enemy enemy : enemies) {
           if (enemy.getX() == x && enemy.getY() == y) {
               return true;
           }
       }
       return false;
   }

   private boolean isItemAt(int x, int y) {
       for (Item item : items) {
           if (item.getX() == x && item.getY() == y)

### **Exercise 5: Implementing Gameplay Logic**

#### **Objective:**
To integrate dynamic object creation, object-oriented design, and basic gameplay mechanics into a functional game loop where the player can move, collect items, and interact with enemies.

---

#### **Instructions:**
Extend your implementation from Exercises 3 and 4 to include core gameplay logic. The game loop should handle player movement, collision detection, scoring, and game-ending conditions.

---

#### **Steps:**

1. **Add Player Movement:**
   - Modify the `Game` class to accept player movement inputs (`W`, `A`, `S`, `D`) from the keyboard.
   - Ensure the player cannot move outside the boundaries of the grid.

   ##### **Example Code for Handling Movement:**
   ```java
   public void movePlayer(String direction) {
       switch (direction.toUpperCase()) {
           case "W":
               if (player.getX() > 0) player.moveUp();
               break;
           case "A":
               if (player.getY() > 0) player.moveLeft();
               break;
           case "S":
               if (player.getX() < height - 1) player.moveDown();
               break;
           case "D":
               if (player.getY() < width - 1) player.moveRight();
               break;
           default:
               System.out.println("Invalid input! Use W (up), A (left), S (down), D (right).");
       }
   }
   ```

2. **Implement Collision Detection:**
   - Add a `checkCollisions()` method in the `GameGrid` class to:
     - Check if the player collides with an enemy (end the game).
     - Check if the player collects an item (add points to the score and remove the item from the grid).

   ##### **Example Code for Collision Detection:**
   ```java
   public boolean checkCollisions() {
       // Check for collisions with enemies
       for (Enemy enemy : enemies) {
           if (player.getX() == enemy.getX() && player.getY() == enemy.getY()) {
               System.out.println("Game Over! You collided with an enemy.");
               return true; // Game ends
           }
       }

       // Check for collisions with items
       Iterator<Item> iterator = items.iterator();
       while (iterator.hasNext()) {
           Item item = iterator.next();
           if (player.getX() == item.getX() && player.getY() == item.getY()) {
               player.addScore(item.getPoints());
               System.out.println("You collected an item worth " + item.getPoints() + " points!");
               iterator.remove(); // Remove the item from the grid
           }
       }

       return false; // Game continues
   }
   ```

3. **Add a Main Game Loop:**
   - Modify the `Game` class to include a loop where:
     - The grid is drawn after each move.
     - The player inputs a direction to move.
     - Collisions are checked.
     - The game ends if there are no remaining items or the player collides with an enemy.

   ##### **Example Code for the Game Loop:**
   ```java
   public static void main(String[] args) {
       GameGrid grid = new GameGrid();
       try {
           grid.populateGridFromFile("gameData.txt");
           Scanner scanner = new Scanner(System.in);

           boolean isGameOver = false;
           while (!isGameOver) {
               grid.drawGrid();
               System.out.println("Your score: " + grid.getPlayer().getScore());
               System.out.print("Enter move (W/A/S/D): ");
               String move = scanner.nextLine();
               grid.movePlayer(move);

               // Check for collisions
               isGameOver = grid.checkCollisions();

               // Check if all items are collected
               if (grid.getItems().isEmpty()) {
                   System.out.println("Congratulations! You collected all items!");
                   isGameOver = true;
               }
           }
       } catch (IOException e) {
           System.out.println("Error reading game data file: " + e.getMessage());
       }
   }
   ```

4. **Test Your Game:**
   - Use the `gameData.txt` file from Exercise 3 to test the game.
   - Verify that:
     - The player can move within the grid.
     - Items are collected and the score updates correctly.
     - The game ends when the player collides with an enemy or collects all items.

---

#### **Expected Output:**
A functional game where:
- The player can move around the grid using keyboard inputs.
- Items are collected, and the score updates dynamically.
- The game ends when the player collides with an enemy or collects all items.

---

#### **Learning Outcomes:**
- Students will apply their knowledge of file handling, object-oriented design, and basic gameplay mechanics to create an interactive program.
- They will gain experience implementing game loops and handling user input in a structured way.
- They will practice debugging and testing their code to ensure correctness.

---

---

### **Exercise 6: Extending the Game with Advanced Features**

#### **Objective:**
To challenge students to creatively extend their game by adding advanced features that enhance gameplay and demonstrate mastery of programming concepts.

---

#### **Instructions:**
Extend your game to include at least **two additional features** from the list below. You are encouraged to design and implement your own feature as well.

---

#### **Feature Options:**

1. **Moving Enemies:**
   - Modify the `Enemy` class to allow enemies to move randomly after each player move.
   - Ensure that enemies do not move outside the grid.

   ##### **Suggested Implementation:**
   ```java
   public void moveEnemies() {
       Random rand = new Random();
       for (Enemy enemy : enemies) {
           int direction = rand.nextInt(4); // 0 = up, 1 = down, 2 = left, 3 = right
           switch (direction) {
               case 0: if (enemy.getX() > 0) enemy.moveUp(); break;
               case 1: if (enemy.getX() < height - 1) enemy.moveDown(); break;
               case 2: if (enemy.getY() > 0) enemy.moveLeft(); break;
               case 3: if (enemy.getY() < width - 1) enemy.moveRight(); break;
           }
       }
   }
   ```

2. **Power-Ups:**
   - Add a new class, `PowerUp`, with an attribute for the type of power-up (e.g., "Extra Points" or "Shield").
   - When the player collects a power-up, apply its effect (e.g., add 50 points or allow the player to survive one enemy collision).

3. **Multiple Levels:**
   - Design the game to progress through multiple levels where:
     - Each level has a different grid size, enemy count, and item placement.
     - The next level starts automatically after all items are collected in the current level.
   - Use a separate file for each level's data (e.g., `level1.txt`, `level2.txt`).

4. **Time-Limited Gameplay:**
   - Add