![Task Image](images/task_image_20250111_163652.png)

### Task: Build a Simple Game Application in Java

**Overview**:  
In this task, you will design and implement a simple game application in Java. Your game will feature a player character that can move through a grid-like map, interact with enemies, and collect points through a scoring system. The game will load its initial configuration (e.g., player and enemy positions, map layout) from a file. This project will give you hands-on experience in designing classes, reading data from files to create objects dynamically, and applying creative problem-solving to make your game engaging and functional.

---

### **Learning Goals**
1. **Using Data from Files to Instantiate Objects**  
   - Learn how to read external files and use their data to initialize game objects (e.g., player, enemies, and map elements).  
   - Understand file formats (e.g., CSV or plain text) and how to parse them.  
   - Handle exceptions to ensure robust file reading.

2. **Designing Classes**  
   - Practice creating modular and cohesive classes for the game elements, such as `Player`, `Enemy`, `Score`, and `GameMap`.  
   - Define clear responsibilities for each class and implement appropriate methods and fields.  
   - Use object-oriented principles such as encapsulation and abstraction.

3. **Programming Creatively**  
   - Experiment with different ideas to make the game more interactive and fun.  
   - Iterate on your design and test the game to refine its mechanics.  
   - Explore creative ways to handle enemy interactions and scoring.

---

### **Task Requirements**

You will create a simple console-based game that includes the following functionalities:

1. **Player Movement**:  
   - The player can move up, down, left, or right on a grid-based map using keyboard input.  
   - The map layout and the player’s starting position are loaded from a file.

2. **Scoring System**:  
   - The game tracks the player’s score as they interact with objects on the map (e.g., collect items or defeat enemies).  
   - The scoring system should be dynamic and update with each interaction.

3. **Enemy Interactions**:  
   - Enemies are placed on the map using data from a file.  
   - The player loses points or health if they collide with an enemy.  
   - Optional: Enemies can move randomly or follow simple patterns.

---

### **Step-by-Step Instructions**

#### **Step 1: Understand the File Format**
You will load the initial game configuration from a file. The file will specify the size of the map, the player’s starting position, the positions of enemies, and any items on the map.

**Example file format (game_config.txt):**
```
MAP 5 5
PLAYER 2 2
ENEMY 0 4
ENEMY 4 0
ITEM 1 1 10
ITEM 3 3 20
```
- `MAP` specifies the dimensions of the grid (rows, columns).  
- `PLAYER` specifies the starting position of the player (row, column).  
- `ENEMY` specifies the position of an enemy (row, column).  
- `ITEM` specifies the position of an item and its score value (row, column, score).

#### **Step 2: Design the Classes**

Design the following classes for your game. Each class should have clear responsibilities:

1. **`Player` Class**  
   - Fields: `int x`, `int y` (position), `int score` (player’s score).  
   - Methods: `move(String direction)`, `updateScore(int points)`.  

2. **`Enemy` Class**  
   - Fields: `int x`, `int y` (position).  
   - Methods: `moveRandomly()` (optional, for enemy movement).  

3. **`Item` Class**  
   - Fields: `int x`, `int y`, `int scoreValue`.  

4. **`GameMap` Class**  
   - Fields: `int rows`, `int cols`, `List<Enemy> enemies`, `List<Item> items`, `Player player`.  
   - Methods: `loadFromFile(String fileName)`, `renderMap()`.  

#### **Code Scaffolding**

Here’s a basic structure for the `Player` class to get you started:
```java
public class Player {
    private int x;
    private int y;
    private int score;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
        this.score = 0;
    }

    public void move(String direction) {
        switch (direction.toLowerCase()) {
            case "up": 
                this.x--;
                break;
            case "down": 
                this.x++;
                break;
            case "left": 
                this.y--;
                break;
            case "right": 
                this.y++;
                break;
        }
    }

    public void updateScore(int points) {
        this.score += points;
    }

    public int getScore() {
        return this.score;
    }
}
```

#### **Step 3: Load Game Data from File**

Use Java’s `BufferedReader` or `Scanner` to read the game configuration file. Parse the data to create instances of `Player`, `Enemy`, and `Item`.

**Example Code Snippet for File Reading:**
```java
import java.io.*;
import java.util.*;

public class GameMap {
    private int rows;
    private int cols;
    private Player player;
    private List<Enemy> enemies = new ArrayList<>();
    private List<Item> items = new ArrayList<>();

    public void loadFromFile(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                switch (parts[0]) {
                    case "MAP":
                        this.rows = Integer.parseInt(parts[1]);
                        this.cols = Integer.parseInt(parts[2]);
                        break;
                    case "PLAYER":
                        this.player = new Player(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                        break;
                    case "ENEMY":
                        enemies.add(new Enemy(Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
                        break;
                    case "ITEM":
                        items.add(new Item(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3])));
                        break;
                }
            }
        }
    }
}
```

#### **Step 4: Implement the Game Loop**

Create a simple game loop in your `Main` class to handle user input and update the game state. Use `System.in` to capture keyboard input for player movement.

**Example Code Snippet for Game Loop:**
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        GameMap gameMap = new GameMap();
        gameMap.loadFromFile("game_config.txt");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            gameMap.renderMap();
            System.out.println("Enter move (up, down

### **Exercise 1: Understanding File Formats and Data Parsing**

**Objective**: To assess and deepen students' understanding of file formats, parsing techniques, and the role of external data in object instantiation.

---

#### **Scenario**:  
Imagine that you are designing a game where the initial configuration (map size, player position, enemy positions, and item locations) is loaded from a file. The file uses a specific format, such as the following:

```
MAP 5 5
PLAYER 2 2
ENEMY 0 4
ENEMY 4 0
ITEM 1 1 10
ITEM 3 3 20
```

Each line begins with a keyword (`MAP`, `PLAYER`, `ENEMY`, or `ITEM`), followed by specific data fields. Your goal is to extract the data from this file and use it to configure your game.

---

#### **Questions**:

1. **Understanding the File Format**:  
   - What does each line in the above configuration file represent?  
   - Identify the data fields for each line and explain their significance in the game.  
   - Why is it important to use a clear and structured format like this for configuration files?

2. **Parsing Techniques**:  
   - Suppose you are given a line of data such as `PLAYER 2 2`. Explain how you would extract the relevant fields (`2` and `2`) for the player's initial position.  
   - What are some common methods in Java for reading and parsing files? Discuss the differences between `BufferedReader` and `Scanner`.

3. **Challenges in File Reading**:  
   - What potential issues might arise when reading from a configuration file?  
   - How can you ensure that your code handles these issues gracefully (e.g., missing data, incorrectly formatted lines, or file not found)?

4. **Dynamic Object Creation**:  
   - Why is it beneficial to create game objects (e.g., `Player`, `Enemy`, `Item`) dynamically based on file data instead of hardcoding their attributes in the program?  
   - Suggest other scenarios (outside of games) where this approach could be useful in software development.

---

**Expected Outcome**:  
Students should be able to:
- Clearly articulate the purpose and structure of the configuration file.
- Propose strategies to parse data and handle potential errors.
- Understand the advantages of dynamic object creation and its broader applications.

---

---

### **Exercise 2: Designing Game Classes**

**Objective**: To challenge students to think critically about class design, their responsibilities, and the principles of object-oriented programming (OOP).

---

#### **Scenario**:  
You are tasked with designing the core classes for a simple game. The game has the following requirements:
- A `Player` that can move around a grid-based map and collect items.
- `Enemies` that act as obstacles on the map, reducing the player's score or health upon collision.
- `Items` that increase the player's score when collected.
- A `GameMap` that keeps track of the map layout and all the objects on it.

---

#### **Questions**:

1. **Understanding Class Responsibilities**:  
   - What is the primary responsibility of each class (`Player`, `Enemy`, `Item`, and `GameMap`)?  
   - How do these classes interact with each other? Provide an example of how two classes (e.g., `Player` and `GameMap`) might collaborate to implement a game feature.

2. **Fields and Methods**:  
   - For each class, list the fields (attributes) and methods (behaviors) that are essential to fulfill its responsibilities.  
   - For example:  
     - `Player`: Fields: `int x`, `int y`, `int score`. Methods: `move(String direction)`, `updateScore(int points)`.  
     - `Enemy`: Fields: `int x`, `int y`. Methods: (Optional) `moveRandomly()`.  
   - Justify the inclusion of each field and method.

3. **Encapsulation and Abstraction**:  
   - Why is it important to ensure that the fields in a class are private and only accessible through public methods?  
   - How does this principle (encapsulation) improve the maintainability and readability of your code?

4. **Cohesion and Coupling**:  
   - Define the concepts of cohesion and coupling in the context of class design.  
   - Evaluate the following design choice:  
     - The `GameMap` class directly modifies the `Player`'s position when the player moves.  
     - Is this a good design choice? Why or why not? Suggest an alternative if necessary.

5. **Design Patterns and Reusability**:  
   - How could you design the `GameMap` class so that it could potentially be reused for other types of games (e.g., a maze-solving game or a treasure-hunting game)?  
   - Discuss how applying design patterns (e.g., Factory Pattern, Singleton Pattern) could improve the flexibility and scalability of your game.

---

**Expected Outcome**:  
Students should:
- Identify the clear responsibilities of each class and propose reasonable fields and methods for them.
- Demonstrate an understanding of OOP principles such as encapsulation, abstraction, cohesion, and coupling.
- Reflect critically on design decisions and explore how to make classes reusable and scalable.

---

**Note for Instructors**:  
These exercises are designed to prepare students for the coding tasks by ensuring they have a solid understanding of the theoretical foundations. Encourage students to discuss their answers in groups or with the class to explore different perspectives and approaches.

### **Exercise 3: Implementing File Parsing and Object Instantiation**

**Objective**: To transition students from theoretical understanding to practical implementation by writing code that reads data from a file and dynamically instantiates game objects (e.g., `Player`, `Enemy`, `Item`, and `GameMap`). This exercise bridges the gap between Exercises 1 & 2 and the coding-heavy tasks in Exercises 5 & 6.

---

#### **Scenario**:  
You are building the foundation of your game by writing a program that reads a configuration file and creates the necessary game objects dynamically. The file contains information about the map layout, the player's starting position, the positions of enemies, and the locations and values of items. Your goal is to write the code that processes this data and creates the appropriate objects.

---

#### **Instructions**:

1. **Prepare the File**:  
   Create a configuration file named `game_config.txt` in the root of your project. Use the following example content:  
   ```
   MAP 6 6
   PLAYER 2 3
   ENEMY 1 4
   ENEMY 5 0
   ITEM 0 0 15
   ITEM 4 4 25
   ```

2. **Write the `GameMap` Class**:  
   Implement the `GameMap` class with the following responsibilities:  
   - Store the map's dimensions (`rows`, `cols`).  
   - Maintain lists of `Enemy` and `Item` objects.  
   - Store a reference to the `Player` object.  
   - Provide a method `loadFromFile(String fileName)` to read the file and create the necessary objects.

3. **Write the File Parsing Logic**:  
   - Use `BufferedReader` or `Scanner` to read the file line by line.  
   - For each line, split the data into parts using the `split()` method.  
   - Based on the first word (`MAP`, `PLAYER`, `ENEMY`, or `ITEM`), create the corresponding object and store it in the appropriate field or list.

4. **Handle Errors Gracefully**:  
   - Implement exception handling to ensure that your program doesn't crash if the file is missing, the format is incorrect, or other errors occur.  
   - Print meaningful error messages for debugging.

---

#### **Starter Code**:

Below is a partial implementation of the `GameMap` class to help you get started:

```java
import java.io.*;
import java.util.*;

public class GameMap {
    private int rows;
    private int cols;
    private Player player;
    private List<Enemy> enemies = new ArrayList<>();
    private List<Item> items = new ArrayList<>();

    public void loadFromFile(String fileName) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(" ");
                switch (parts[0]) {
                    case "MAP":
                        this.rows = Integer.parseInt(parts[1]);
                        this.cols = Integer.parseInt(parts[2]);
                        break;
                    case "PLAYER":
                        this.player = new Player(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]));
                        break;
                    case "ENEMY":
                        enemies.add(new Enemy(Integer.parseInt(parts[1]), Integer.parseInt(parts[2])));
                        break;
                    case "ITEM":
                        items.add(new Item(Integer.parseInt(parts[1]), Integer.parseInt(parts[2]), Integer.parseInt(parts[3])));
                        break;
                    default:
                        System.out.println("Unknown configuration line: " + line);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Configuration file not found: " + fileName);
        } catch (NumberFormatException e) {
            System.err.println("Invalid number format in configuration file.");
        }
    }

    public void printGameObjects() {
        System.out.println("Map size: " + rows + "x" + cols);
        System.out.println("Player starting position: " + player.getX() + ", " + player.getY());
        enemies.forEach(enemy -> System.out.println("Enemy at: " + enemy.getX() + ", " + enemy.getY()));
        items.forEach(item -> System.out.println("Item at: " + item.getX() + ", " + item.getY() + " (Score: " + item.getScoreValue() + ")"));
    }
}
```

---

#### **Tasks**:

1. Complete the `GameMap` class by adding any missing fields, methods, and logic.  
2. Test your implementation by creating a `Main` class. In the `main` method:  
   - Instantiate a `GameMap` object.  
   - Call `loadFromFile("game_config.txt")`.  
   - Print the loaded objects using the `printGameObjects()` method.  
3. Handle at least two types of errors (e.g., file not found or invalid format).  

---

#### **Expected Outcome**:  
When you run the program, it should print the following output for the example file:
```
Map size: 6x6
Player starting position: 2, 3
Enemy at: 1, 4
Enemy at: 5, 0
Item at: 0, 0 (Score: 15)
Item at: 4, 4 (Score: 25)
```

---

---

### **Exercise 4: Implementing Basic Class Interactions**

**Objective**: To build upon the foundational implementation in Exercise 3 by introducing basic interactions between the game objects and the `GameMap`. This exercise prepares students for the game loop implementation in later exercises.

---

#### **Scenario**:  
You have successfully loaded the game configuration from a file and instantiated the necessary objects. Now, you need to add basic interaction logic to simulate simple gameplay. For this exercise, you will implement player movement and item collection.

---

#### **Instructions**:

1. **Implement Player Movement**:  
   - Add a method `movePlayer(String direction)` to the `GameMap` class.  
   - This method should update the player's position (`x`, `y`) based on the `direction` input (`"up"`, `"down"`, `"left"`, `"right"`).  
   - Ensure the player cannot move outside the bounds of the map.

2. **Item Collection Logic**:  
   - After the player moves, check if their new position matches the position of any item on the map.  
   - If the player collects an item, increase their score by the item's value and remove the item from the map.  
   - Print a message indicating that the item was collected and the player's new score.

3. **Render the Map**:  
   - Add a method `renderMap()` to the `GameMap` class to display the current state of the map in the console.  
   - Use symbols to represent different objects:  
     - `P` for the player.  
     - `E` for enemies.  
     - `I` for items.  
     - `.` for empty spaces.

4. **Test the

### **Exercise 5: Implementing the Game Loop and Enemy Interactions**

**Objective**: To bring the game mechanics to life by incorporating a game loop that allows the player to move around the map, interact with items, and encounter enemies. This exercise focuses on integrating all previously implemented features and introducing dynamic interactions with enemies.

---

#### **Scenario**:  
Your game is almost ready! You’ve designed the classes, loaded the game configuration from a file, and implemented basic player movement and item collection. Now, you need to create a game loop that processes user input and updates the game state in real time. Additionally, you will implement interactions with enemies, where the player loses points or health upon collision.

---

#### **Instructions**:

1. **Enhance the `Player` Class**:  
   - Add an additional field, `int health`, to track the player’s health.  
   - Initialize the player's health to 100 in the constructor.  
   - Add a method `reduceHealth(int amount)` to decrease the player's health when encountering an enemy.  
   - Add a method `isAlive()` that returns `true` if the player's health is greater than 0.

2. **Add Enemy Interactions**:  
   - In the `GameMap` class, add logic to check if the player’s position matches the position of any enemy after a move.  
   - If the player encounters an enemy:  
     - Decrease their health by 20 points using the `reduceHealth(int amount)` method.  
     - Print a message indicating the collision and the player's remaining health.  
   - If the player's health becomes 0 or less, end the game and print a "Game Over" message.

3. **Implement the Game Loop**:  
   - In the `Main` class, implement a game loop that runs until the player either collects all items or their health drops to 0.  
   - Within each iteration of the loop:  
     - Display the current state of the map using the `renderMap()` method.  
     - Prompt the user for input (`"up"`, `"down"`, `"left"`, `"right"`) to move the player.  
     - Call the `movePlayer(String direction)` method to update the player's position.  
     - Check for interactions with items and enemies.  
     - End the game if all items are collected or the player’s health reaches 0.

4. **Add Win Conditions**:  
   - If the player collects all items on the map, display a "You Win!" message along with the final score.  

---

#### **Starter Code**:

Here’s a skeleton for the game loop in the `Main` class:

```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        GameMap gameMap = new GameMap();
        gameMap.loadFromFile("game_config.txt");
        
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            gameMap.renderMap();
            System.out.println("Enter move (up, down, left, right): ");
            String direction = scanner.nextLine();

            gameMap.movePlayer(direction);

            // Check if the game is over
            if (!gameMap.getPlayer().isAlive()) {
                System.out.println("Game Over! You lost all your health.");
                running = false;
            } else if (gameMap.allItemsCollected()) {
                System.out.println("You Win! Final score: " + gameMap.getPlayer().getScore());
                running = false;
            }
        }

        scanner.close();
    }
}
```

5. **Test Your Game**:  
   - Use the example configuration file provided in Exercise 3.  
   - Simulate different scenarios:  
     - The player collects all items and wins.  
     - The player loses all health by encountering enemies.

---

#### **Expected Outcome**:  
When the game runs, the following should happen:
- The player can move around the map using keyboard input.
- Items are collected, and the player's score updates correctly.
- The player loses health upon encountering enemies.
- The game ends with either a "You Win!" or "Game Over!" message.

---

---

### **Exercise 6: Adding Enemy Movement and Polishing the Game**

**Objective**: To add an extra layer of complexity by introducing enemy movement and refining the game’s mechanics and user experience. This exercise consolidates all previous learning while slightly expanding the scope by introducing basic AI for enemies.

---

#### **Scenario**:  
Your game is fully functional, but it can be made more dynamic and engaging by allowing enemies to move on the map. You will implement simple enemy movement logic and refine the game mechanics to create a polished final version.

---

#### **Instructions**:

1. **Enhance the `Enemy` Class**:  
   - Add a method `moveRandomly()` to simulate enemy movement.  
   - Randomly move the enemy up, down, left, or right by one grid space.  
   - Ensure enemies do not move outside the bounds of the map.

   **Example Code**:
   ```java
   public void moveRandomly(int rows, int cols) {
       int direction = (int) (Math.random() * 4); // 0: up, 1: down, 2: left, 3: right
       switch (direction) {
           case 0: // up
               if (x > 0) x--;
               break;
           case 1: // down
               if (x < rows - 1) x++;
               break;
           case 2: // left
               if (y > 0) y--;
               break;
           case 3: // right
               if (y < cols - 1) y++;
               break;
       }
   }
   ```

2. **Integrate Enemy Movement into the Game Loop**:  
   - In the `GameMap` class, add a method `moveEnemies()` that iterates through all enemies and calls their `moveRandomly()` method.  
   - Call this method at the end of each iteration of the game loop in the `Main` class.  

3. **Refine Enemy Interactions**:  
   - Update the collision logic to account for enemy movement.  
   - If an enemy moves into the player’s position, reduce the player’s health and print a message.

4. **Improve the `renderMap()` Method**:  
   - Ensure that the map updates correctly after each player and enemy movement.  
   - Add clear formatting to make the map easier to read.  
   - For example:  
     - Use `P` for the player, `E` for enemies, `I` for items, and `.` for empty spaces.  
     - Print a border around the map for better visualization.

5. **Polish the User Experience**:  
   - Add prompts and messages to guide the player (e.g., "Health: 80 | Score: 30").  
   - Clear the console (e.g., using escape sequences) after each move to simulate a real-time game experience.  

6. **Optional Challenge**:  
   - Implement smarter enemy movement logic where