### **Programming Task: Build a Simple Game Application 🎮**

In this task, you will design and implement a simple 2D game application in Java. The game will include player movement, a scoring system, and interactions with enemies. Additionally, you will leverage file-based data to dynamically generate objects (e.g., enemies or game levels), design well-structured and cohesive classes, and apply your creativity to make the game enjoyable and functional. This project integrates key programming concepts, helping you practice object-oriented programming, file I/O, and creative problem-solving.

---

### **Learning Goals**
1. **Using Data from Files to Instantiate Objects**
   - Understand file formats and parsing techniques to load game data.
   - Use Java’s file I/O classes to extract data and initialize objects in the game (e.g., enemies, levels, or obstacles).
   - Handle exceptions gracefully to ensure the game runs smoothly even with imperfect data inputs.

2. **Designing Classes**
   - Design well-structured classes for the game components (e.g., `Player`, `Enemy`, `Game`).
   - Identify clear responsibilities for each class and build cohesive methods.
   - Use appropriate Object-Oriented Programming (OOP) principles such as encapsulation and modularity.

3. **Programming Creatively**
   - Brainstorm and implement creative gameplay mechanics and interactions.
   - Experiment with algorithm design to create engaging features (e.g., scoring system or enemy behavior).
   - Test and refine your game based on your own feedback or input from peers.

---

### **Task Breakdown**

#### **Part 1: Designing the Game Classes 🧩**
Start by planning the core components of your game. You will need at least three main classes:
   - **`Player`**: Represents the player character and handles movement and scoring.
   - **`Enemy`**: Represents an enemy object with attributes such as position and behavior.
   - **`Game`**: Manages the game loop, player-enemy interactions, and overall game logic.

##### **Steps:**
1. Create a UML diagram or a simple sketch of how the classes will interact. Think about the attributes and methods each class should have.
   - For example:
     ```text
     Player:
       - Attributes: positionX, positionY, score
       - Methods: move(), increaseScore()

     Enemy:
       - Attributes: positionX, positionY, speed
       - Methods: move(), interactWithPlayer()

     Game:
       - Attributes: player, enemies (ArrayList), isRunning
       - Methods: startGame(), updateGame(), endGame()
     ```

2. Implement the basic skeletons of these classes. For example:
   ```java
   public class Player {
       private int positionX;
       private int positionY;
       private int score;

       public Player(int positionX, int positionY) {
           this.positionX = positionX;
           this.positionY = positionY;
           this.score = 0;
       }

       public void move(int deltaX, int deltaY) {
           positionX += deltaX;
           positionY += deltaY;
       }

       public void increaseScore(int points) {
           score += points;
       }

       // Getters and other methods...
   }
   ```

---

#### **Part 2: Using Data from Files to Instantiate Objects 📂**
Enemies in your game will be dynamically created using data stored in a file. The file will specify attributes such as the enemy's position and speed. For example, the file `enemies.txt` might look like this:
   ```
   100,200,3
   150,250,2
   200,100,5
   ```

##### **Steps:**
1. Write code to read the file and parse the data. Use the `BufferedReader` or `Scanner` class.
   - Example scaffolding:
     ```java
     import java.io.*;
     import java.util.ArrayList;

     public class EnemyLoader {
         public static ArrayList<Enemy> loadEnemies(String filePath) {
             ArrayList<Enemy> enemies = new ArrayList<>();
             try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
                 String line;
                 while ((line = br.readLine()) != null) {
                     String[] data = line.split(",");
                     int x = Integer.parseInt(data[0]);
                     int y = Integer.parseInt(data[1]);
                     int speed = Integer.parseInt(data[2]);
                     enemies.add(new Enemy(x, y, speed));
                 }
             } catch (IOException | NumberFormatException e) {
                 System.out.println("Error loading enemies: " + e.getMessage());
             }
             return enemies;
         }
     }
     ```

2. Use the `loadEnemies` method to populate a list of enemies in your game class.

3. Ensure robust error handling. For example, handle cases where the file is missing or contains invalid data.

---

#### **Part 3: Adding Gameplay Features 🎮**
Now it's time to make the game interactive and fun! Focus on:
1. **Player Movement**:
   - Allow the player to move using keyboard inputs (e.g., WASD keys or arrow keys). Use a library like `java.awt` or `javafx` for handling input.
   - Example scaffolding for movement:
     ```java
     public void handleInput(String input) {
         switch (input) {
             case "W": move(0, -1); break;  // Move up
             case "A": move(-1, 0); break; // Move left
             case "S": move(0, 1); break;  // Move down
             case "D": move(1, 0); break;  // Move right
         }
     }
     ```

2. **Scoring System**:
   - Award points when the player successfully avoids an enemy or collects an item.
   - Update the player's score and display it on the screen.

3. **Enemy Interactions**:
   - Enemies move towards the player or follow a predefined path.
   - If the player collides with an enemy, the game ends. Implement collision detection:
     ```java
     public boolean checkCollision(Player player, Enemy enemy) {
         return player.getPositionX() == enemy.getPositionX() &&
                player.getPositionY() == enemy.getPositionY();
     }
     ```

---

#### **Part 4: Enhancing the Game with Creativity 🌟**
Use your imagination to make the game unique:
1. Add a **difficulty level**: Increase enemy speed or number as the game progresses.
2. Create different **enemy types**: Some enemies might move faster or behave differently.
3. Introduce **power-ups**: Add objects the player can collect to gain bonus points or temporary invincibility.
4. Add a **visual interface**: Use basic graphics from `java.awt` or `javax.swing` to display the game grid and objects.

---

### **Submission Requirements**
- Submit your project as a `.zip` file containing:
  - All `.java` files for your program.
  - The `enemies.txt` file or any additional data files created.
  - A `README.md` file explaining how to run your program and describing your

### **Exercise 1: Understanding File I/O and Object Instantiation**  
**Learning Goal:** Using Data from Files to Instantiate Objects  

Before designing and coding the game, it's crucial to understand how to use data from files to dynamically create objects. This exercise will help you explore file I/O concepts and how they connect to object instantiation.  

---

#### **Task:**  
Study the provided scenario and answer the following questions.  

Imagine you are developing a program where enemy objects are generated based on data stored in a text file named `enemies.txt`. Each line in the file contains the x-coordinate, y-coordinate, and speed of an enemy. For example:  
```
100,200,3  
150,250,2  
200,100,5  
```  
The goal is to read this data and dynamically create `Enemy` objects in your program.  

1. **File Formats and Parsing:**  
   - Explain why the format of a data file (e.g., `.txt`, `.csv`, `.json`) is important for parsing the data.  
   - Given the sample file `enemies.txt`, discuss how you would split each line of data into the attributes needed for an `Enemy` object. Include the role of delimiters (e.g., commas) in this process.  

2. **Object Instantiation from File Data:**  
   - Describe the process of using the parsed file data to dynamically create objects in Java. Specifically, how would you convert the x-coordinate, y-coordinate, and speed from the file into attributes for an `Enemy` object?  
   - Why is it important to handle exceptions (e.g., `IOException`, `NumberFormatException`) when working with file data? How could improper handling affect the program?  

3. **Data Integrity:**  
   - Imagine one line in the file is corrupted (e.g., `100,abc,3`). Discuss how you would handle such cases in your program to ensure the game still runs smoothly.  

---

**Deliverable:** Write your answers to these questions in a document. Be clear and concise, using examples where appropriate. Avoid writing code at this stage; focus on explaining the concepts.  

---

### **Exercise 2: Principles of Class Design**  
**Learning Goal:** Designing Classes  

Effective class design is the foundation of well-structured programs. In this exercise, you will explore how to design classes with clear responsibilities and cohesive methods.  

---

#### **Task:**  
Analyze the following scenario and answer the questions below:  

You are tasked with designing three classes for a simple game:  
1. **`Player`**: Represents the playable character and manages attributes like position and score.  
2. **`Enemy`**: Represents enemies in the game with attributes like position and speed.  
3. **`Game`**: Manages the overall game logic, including player-enemy interactions and the game loop.  

1. **Identifying Responsibilities:**  
   - For each class (`Player`, `Enemy`, and `Game`), list at least two responsibilities. For example, what should the `Player` class be responsible for? What should the `Game` class manage?  
   - Why is it important to limit each class to a specific set of responsibilities? What problems might arise if a class takes on too many roles?  

2. **Encapsulation and Modularity:**  
   - Define encapsulation and explain how it applies to the attributes of the `Player` and `Enemy` classes. For example, should attributes like `positionX` and `positionY` be public or private? Why?  
   - Discuss how modular class design makes programs easier to maintain and scale. Use the example of adding a new feature, such as power-ups, to the game.  

3. **Method Design:**  
   - For the `Player` class, propose two methods (e.g., `move()`, `increaseScore()`). Describe their purpose and how they interact with the class’s attributes.  
   - For the `Enemy` class, propose a method (e.g., `move()`) and explain how it would behave based on the enemy's attributes (e.g., `speed`).  

---

**Deliverable:** Write your answers to these questions in a document. Focus on describing class design principles and avoid writing code in this exercise. Use clear examples to support your reasoning.  



### **Exercise 3: Implementing File I/O and Object Instantiation in Practice**  
**Learning Goal:** Using Data from Files to Instantiate Objects  

Now that you understand the theoretical aspects of file I/O and object instantiation, it’s time to apply those concepts in a practical scenario. This exercise focuses on writing Java code to dynamically create `Enemy` objects by reading data from a file.  

---

#### **Task:**  
Write code to implement the following functionality:  

1. **Setup the Enemy Class**  
   - Define the `Enemy` class with the following attributes:
     - `positionX` (int): The x-coordinate of the enemy.
     - `positionY` (int): The y-coordinate of the enemy.
     - `speed` (int): The speed of the enemy.  
   - Add a constructor to initialize these attributes.  
   - Implement a `toString()` method to format the enemy's details for debugging purposes.  
     ```java
     @Override
     public String toString() {
         return "Enemy at (" + positionX + ", " + positionY + "), Speed: " + speed;
     }
     ```

2. **Loading Enemies from a File**  
   - Write a class called `EnemyLoader` with a static method `loadEnemies(String filePath)` that:
     - Reads the file line by line.
     - Parses each line into the attributes (`positionX`, `positionY`, `speed`).
     - Creates an `Enemy` object for each line and adds it to an `ArrayList<Enemy>`.  
   - Handle potential exceptions:
     - If the file does not exist, print an error message and return an empty list.
     - If a line contains invalid data (e.g., non-integer values), skip that line and continue processing the rest of the file.  

3. **Testing the File Loading**  
   - Write a `Main` class with a `main` method to test the functionality.  
   - Create a sample file (e.g., `enemies.txt`) with the following content:  
     ```
     100,200,3
     150,250,2
     200,100,5
     300,abc,4  // This line should be skipped due to invalid data.
     400,500,6
     ```
   - Use the `loadEnemies` method to load the enemies from the file and print their details using the `toString()` method.

---

##### **Example Output:**  
If the file contains the example data above, the output might look like this:  
```
Enemy at (100, 200), Speed: 3  
Enemy at (150, 250), Speed: 2  
Enemy at (200, 100), Speed: 5  
Skipping invalid line: 300,abc,4  
Enemy at (400, 500), Speed: 6  
```

---

#### **Submission Requirements:**  
- Submit the `Enemy` and `EnemyLoader` classes as `.java` files.  
- Include the test file `enemies.txt` with your submission.  
- Ensure your code is well-documented with comments explaining each step.  

---

### **Exercise 4: Designing and Combining Classes for Core Game Functionality**  
**Learning Goal:** Designing Classes and Combining Concepts  

In this exercise, you will extend the concepts from Exercise 3 to design a basic game system. You will create multiple classes (`Player`, `Enemy`, `Game`) and connect them to form the foundation of a simple game.  

---

#### **Task:**  
Write code to define and combine the `Player`, `Enemy`, and `Game` classes according to the following specifications:  

1. **Player Class**  
   - Define a `Player` class with the following attributes:
     - `positionX` and `positionY` (int): The player’s position.
     - `score` (int): The player’s current score.  
   - Add methods:
     - `move(int deltaX, int deltaY)`: Updates the player’s position.
     - `increaseScore(int points)`: Updates the player’s score by adding the specified points.
     - `toString()`: Returns a string representation of the player’s position and score.  

2. **Game Class**  
   - Define a `Game` class with the following attributes:
     - `player` (Player): The player object.
     - `enemies` (ArrayList<Enemy>): A list of enemies in the game.  
   - Add methods:
     - `initializeGame(String enemyFilePath)`: Loads enemies from a file and initializes the player at position (0, 0) with a score of 0.
     - `printGameState()`: Prints the current state of the player and all enemies.
     - `updateGame(String playerInput)`: Updates the player’s position based on input (`W`, `A`, `S`, `D` for movement) and checks if the player collides with any enemy. If a collision occurs, print a message and end the game.  

3. **Collision Detection**  
   - Implement a method `checkCollision(Player player, Enemy enemy)` in the `Game` class to detect if the player’s position matches an enemy’s position. If so, print:  
     ```
     Game Over! The player collided with an enemy at (X, Y).
     ```

4. **Testing the Game**  
   - In your `Main` class, write code to:
     - Initialize the game using a file (e.g., `enemies.txt`).
     - Print the initial game state.
     - Accept user input (e.g., `W`, `A`, `S`, `D`) to move the player and update the game state.
     - End the game if a collision occurs.  

---

##### **Example Workflow:**  
1. **Initial Setup:**  
   The file `enemies.txt` contains:  
   ```
   100,200,3  
   150,250,2  
   200,100,5  
   ```  
   Output:  
   ```
   Player at (0, 0), Score: 0  
   Enemy at (100, 200), Speed: 3  
   Enemy at (150, 250), Speed: 2  
   Enemy at (200, 100), Speed: 5  
   ```  

2. **Player Movement and Collision Detection:**  
   - Input: `W` (Move up)  
   - Output:  
     ```
     Player moved to (0, -1).  
     ```  
   - Input: `D` (Move right until collision occurs)  
   - Output:  
     ```
     Player moved to (100, 200).  
     Game Over! The player collided with an enemy at (100, 200).  
     ```

---

#### **Submission Requirements:**  
- Submit the `Player`, `Enemy`, and `Game` classes as `.java` files.  
- Include the test file `enemies.txt` used for the game.  
- Ensure the game is functional and handles edge cases like invalid inputs (e.g., `X`, `5`).  
- Add comments to explain

### **Exercise 5: Adding Advanced Gameplay Mechanics and Enhancing the Game System**  
**Learning Goal:** Programming Creatively and Consolidating Class Design  

In this exercise, you will enhance your game by adding new gameplay mechanics, refining your class design, and integrating feedback mechanisms to make the game more interactive and engaging. You will build upon the `Player`, `Enemy`, and `Game` classes developed earlier, incorporating more advanced features and improving the game's structure.

---

#### **Task:**  
Expand your game by implementing the following features:

---

### **1. Adding Power-Ups to the Game**
Introduce a new type of object called `PowerUp`. These objects appear randomly on the game grid and grant bonuses to the player when collected.  

1. **Define the `PowerUp` Class**  
   - Attributes:
     - `positionX` and `positionY` (int): The coordinates of the power-up.
     - `type` (String): The type of power-up (e.g., `"scoreBoost"`, `"invincibility"`).  
   - Methods:
     - Constructor to initialize the attributes.
     - `toString()`: Returns a string representation of the power-up's position and type.  

   ```java
   public class PowerUp {
       private int positionX;
       private int positionY;
       private String type;

       public PowerUp(int positionX, int positionY, String type) {
           this.positionX = positionX;
           this.positionY = positionY;
           this.type = type;
       }

       @Override
       public String toString() {
           return "PowerUp (" + type + ") at (" + positionX + ", " + positionY + ")";
       }
   }
   ```

2. **Add Power-Ups to the Game**  
   - In the `Game` class, add an `ArrayList<PowerUp>` to track active power-ups.
   - Generate power-ups randomly on the grid during game initialization and periodically during gameplay.  
     - Example: Create a new power-up every 5 player moves.
     - Types of power-ups:
       - `"scoreBoost"`: Increases the player's score by 50 points.
       - `"invincibility"`: Grants temporary immunity to collisions for 5 moves.  

3. **Player-PowerUp Interaction**  
   - Update the game logic to check if the player collects a power-up (i.e., the player's position matches a power-up's position).
   - If a power-up is collected:
     - Apply its effect to the player.
     - Remove the power-up from the game.  
   - Example:
     ```java
     public void checkPowerUpCollection(Player player) {
         PowerUp collectedPowerUp = null;
         for (PowerUp powerUp : powerUps) {
             if (player.getPositionX() == powerUp.positionX &&
                 player.getPositionY() == powerUp.positionY) {
                 collectedPowerUp = powerUp;
                 break;
             }
         }
         if (collectedPowerUp != null) {
             applyPowerUpEffect(player, collectedPowerUp);
             powerUps.remove(collectedPowerUp);
         }
     }
     ```

---

### **2. Dynamic Enemy Behaviors**
Enhance the `Enemy` class to include dynamic behaviors that make gameplay more challenging.  

1. **Enemy Movement Patterns**  
   - Add a `behaviorType` attribute to the `Enemy` class to define its movement pattern:
     - `"chase"`: The enemy moves toward the player's position.
     - `"patrol"`: The enemy moves back and forth between two points.  

   - Implement the movement logic for each behavior type in the `Enemy` class.  
     - Example of chase behavior:
       ```java
       public void moveTowardsPlayer(Player player) {
           if (positionX < player.getPositionX()) positionX++;
           else if (positionX > player.getPositionX()) positionX--;
           if (positionY < player.getPositionY()) positionY++;
           else if (positionY > player.getPositionY()) positionY--;
       }
       ```

2. **Integrate Enemy Behaviors into the Game**  
   - Assign a behavior type to each enemy when it is instantiated.
   - Update the game loop to execute the appropriate movement logic for each enemy during each turn.

---

### **3. Win and Lose Conditions**
Define clear conditions for winning or losing the game:  

1. **Win Condition**  
   - The player wins if they collect a certain number of power-ups (e.g., 5).  
   - Display a victory message and end the game.  

2. **Lose Condition**  
   - The player loses if they collide with an enemy (unless invincibility is active).  
   - Display a "Game Over" message and end the game.  

3. **Game Status Display**  
   - Enhance the `printGameState` method in the `Game` class to display:
     - The player's current score.
     - Active power-ups and their positions.
     - The number of power-ups collected so far.

---

#### **Example Workflow:**  
1. **Initial Game State**  
   ```
   Player at (0, 0), Score: 0  
   Enemies:  
   - Enemy (chase) at (100, 200), Speed: 3  
   - Enemy (patrol) at (150, 250), Speed: 2  
   PowerUps:  
   - PowerUp (scoreBoost) at (50, 50)  
   ```

2. **Player Movement and Power-Up Collection**  
   - Input: `D` (Move right)  
   - Output:  
     ```
     Player moved to (1, 0).  
     Active PowerUps:  
     - PowerUp (scoreBoost) at (50, 50)  
     ```

3. **Collision Detection and Game Over**  
   - Input: Player collides with an enemy.  
   - Output:  
     ```
     Game Over! The player collided with an enemy at (100, 200).  
     ```

---

#### **Submission Requirements:**  
- Submit the `PowerUp`, `Player`, `Enemy`, and `Game` classes as `.java` files.  
- Include the `enemies.txt` and any new data files (e.g., for power-up positions).  
- Ensure your code is well-documented with comments explaining the new features.

---

### **Exercise 6: Adding Graphics with `javax.swing` and Finalizing the Game**  
**Learning Goal:** Programming Creatively and Expanding Knowledge of Basic Graphics  

In this final exercise, you will replace the text-based game interface with a simple graphical interface using the `javax.swing` library. This will allow you to visually represent the player, enemies, and power-ups on a 2D grid.

---

#### **Task:**  
Create a graphical version of your game using `javax.swing`. You will need to draw the game grid and objects on a `JPanel`, handle player input graphically, and update the game state visually.

---

### **1. Setting Up the Game Window**
1. Create a `GameWindow` class to represent the main game window.  
   - Use a