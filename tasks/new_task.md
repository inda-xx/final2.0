## Task: Build a Simple Game Application 🎮

### Overview
Your task this week is to design and implement a simple game application in Java. The game should include the following features:
1. **Player movement**: The player should be able to move around in a 2D grid-based world.
2. **Scoring system**: The player earns points by collecting items or completing tasks.
3. **Enemy interactions**: Enemies will interact with the player, such as reducing the player's score or ending the game.

To complete this task, you'll practice reading data from files to instantiate objects, designing well-structured classes, and applying creative problem-solving techniques. By the end of the week, you will have a functional game and a deeper understanding of Java programming concepts.

---

### Exercise 1: Understanding File I/O Basics 📂
**Objective:** Develop a foundational understanding of reading data from files in Java.

1. Research the basic file I/O classes in Java (`File`, `Scanner`, `BufferedReader`, etc.). Write a short summary of how these classes can be used to read data from a text file.
2. Create a small text file (e.g., `game_data.txt`) with sample data for your game:
   ```
   Player:John,100
   Enemy1:Orc,50
   Enemy2:Troll,75
   ```
3. Write a simple Java program to read this file and print its contents to the console. Here's a scaffold to get you started:
   ```java
   import java.io.*;
   import java.util.*;

   public class FileReadingExample {
       public static void main(String[] args) {
           try {
               File file = new File("game_data.txt");
               Scanner scanner = new Scanner(file);
               while (scanner.hasNextLine()) {
                   String line = scanner.nextLine();
                   System.out.println(line);
               }
               scanner.close();
           } catch (FileNotFoundException e) {
               System.out.println("File not found: " + e.getMessage());
           }
       }
   }
   ```

---

### Exercise 2: Designing Your Game's Classes 🛠️
**Objective:** Plan and design the class structure for your game.

1. Identify the main entities in your game (e.g., `Player`, `Enemy`, `GameWorld`, etc.).
2. For each entity, define its **attributes** (fields) and **behaviors** (methods). For example:
   - `Player`:
     - Attributes: `name`, `score`, `position`
     - Methods: `move()`, `scorePoints()`, `takeDamage()`
   - `Enemy`:
     - Attributes: `type`, `health`, `position`
     - Methods: `move()`, `attackPlayer()`

3. Create a **class diagram** (you can draw this on paper and upload it as an image) that includes the relationships between your classes. For instance, `GameWorld` might contain a list of `Enemy` objects.

4. Write the scaffolding code for your classes, focusing on constructors and field declarations. Example:
   ```java
   public class Player {
       private String name;
       private int score;
       private int position;

       public Player(String name, int position) {
           this.name = name;
           this.score = 0; // Default score
           this.position = position;
       }

       // Getters and setters (optional)
   }
   ```

---

### Exercise 3: Instantiating Game Objects from a File ⚙️
**Objective:** Use data from a file to create and initialize game objects.

1. Modify the text file `game_data.txt` to include player and enemy data in a structured format:
   ```
   Player:John,0
   Enemy:Orc,10
   Enemy:Troll,20
   ```
2. Write a program that reads this file and creates `Player` and `Enemy` objects based on the data. Ensure that:
   - Each `Player` and `Enemy` object is instantiated and stored in an appropriate data structure (e.g., a list).
   - You handle potential exceptions, such as missing or malformed data.

   Example scaffold:
   ```java
   public class GameLoader {
       public static void main(String[] args) {
           List<Enemy> enemies = new ArrayList<>();
           Player player = null;

           try {
               File file = new File("game_data.txt");
               Scanner scanner = new Scanner(file);

               while (scanner.hasNextLine()) {
                   String line = scanner.nextLine();
                   String[] parts = line.split(":");
                   if (parts[0].equals("Player")) {
                       String[] details = parts[1].split(",");
                       player = new Player(details[0], Integer.parseInt(details[1]));
                   } else if (parts[0].equals("Enemy")) {
                       String[] details = parts[1].split(",");
                       enemies.add(new Enemy(details[0], Integer.parseInt(details[1])));
                   }
               }
               scanner.close();
           } catch (FileNotFoundException e) {
               System.out.println("File not found: " + e.getMessage());
           }

           // Print loaded data for debugging
           System.out.println("Player: " + player);
           System.out.println("Enemies: " + enemies);
       }
   }
   ```

---

### Exercise 4: Adding Player Movement 🚶‍♂️
**Objective:** Implement basic player movement in a 2D grid world.

1. Define a simple 2D grid (e.g., 5x5) where the player and enemies can move. Represent this grid as a 2D array or a list of lists.
2. Add a `move()` method to the `Player` class that allows the player to move up, down, left, or right.
3. Write a simple program that allows the player to input movement commands (e.g., "up", "down") and updates their position on the grid.

---

### Exercise 5: Implementing the Scoring System 🏆
**Objective:** Add a scoring mechanism to your game.

1. Place collectible items (e.g., coins) on the grid. When the player moves to a cell containing a coin, they earn points, and the coin is removed.
2. Update the player's score when they collect an item. Display the updated score after every move.

---

### Exercise 6: Enemy Interactions and Game Logic 👾
**Objective:** Add enemy interactions and implement the game logic.

1. Add functionality for enemies to move randomly on the grid.
2. If an enemy moves to the same position as the player, reduce the player's score or end the game.
3. Add win/lose conditions:
   - The player wins if they collect all coins.
   - The player loses if their score falls below zero or if they're caught by an enemy.

---

### Bonus Challenge: Enhancing the Game 🌟
1. Add multiple levels with increasing difficulty.
2. Implement a simple graphical interface using Java Swing or JavaFX.

---

### Deliverables
1. Source code for all classes and the main program.
2. A README file with instructions on how to run your game.
3. A short reflection (1-2 paragraphs) on what you learned while

### Exercise 1: Understanding File I/O Basics 📂

#### Objective:
Gain a foundational understanding of file input/output (I/O) in Java and its importance in reading dynamic data for a program.

#### Instructions:
1. **Research File I/O Classes in Java**  
   Conduct a brief study of the Java file I/O classes (`File`, `Scanner`, `BufferedReader`, etc.). In your own words, write a **short summary (3–5 sentences)** explaining:
   - What these classes are used for.
   - How they differ in terms of functionality (e.g., when to use `Scanner` vs. `BufferedReader`).
   - Why exception handling is important when working with file I/O.

2. **Practical Task: Create a Sample File**  
   Create a text file named `game_data.txt` in your project directory. Add the following sample data to the file:
   ```
   Player:John,100
   Enemy1:Orc,50
   Enemy2:Troll,75
   ```
   This file represents the initial state of a simple game, including a player and two enemies.

3. **Conceptual Question:**  
   Why is reading data from a file more flexible than hardcoding the data directly in your program? Write a 2–3 sentence response.

---

### Exercise 2: Designing Your Game's Classes 🛠️

#### Objective:
Understand the principles of good class design and practice creating a class structure for your game.

#### Instructions:
1. **Analyze the Problem**  
   Identify the main entities in the game. For each entity, answer the following:
   - What attributes (states) does this entity need?  
     Example: A `Player` might have `name`, `score`, and `position`.
   - What behaviors (methods) should this entity have?  
     Example: A `Player` might need methods like `move()`, `scorePoints()`, and `takeDamage()`.

2. **Practice Designing Classes**  
   For each entity, write a **brief description** of its roles and responsibilities in the game. For example:
   - `Player`: Represents the user. Responsible for moving around the game world, collecting items, and interacting with enemies.
   - `Enemy`: Represents an obstacle. Responsible for moving independently and interacting with the player.

3. **Plan Class Relationships**  
   Describe how your classes will interact. For example:
   - The `GameWorld` class will manage the grid and contain a list of `Enemy` objects.
   - The `Player` and `Enemy` classes will share a common attribute, `position`, which will determine their interactions on the grid.

4. **Conceptual Question:**  
   Why is it useful to separate responsibilities into distinct classes rather than combining everything into one class? Write a 2–3 sentence response.

---

### Expected Outcomes:
- **Exercise 1:** Students will understand the basics of file I/O and why files provide flexibility for dynamic program data.
- **Exercise 2:** Students will gain a high-level understanding of class design, relationships, and responsibilities, preparing them for implementation in later exercises.

### Exercise 3: Instantiating Game Objects from a File ⚙️

#### Objective:
Learn how to read data from a file and use it to create and initialize objects in Java. This exercise will focus on combining file I/O techniques with object-oriented programming concepts.

---

#### Instructions:
1. **Modify the Data File**  
   Update `game_data.txt` to include the following data:
   ```
   Player:John,0
   Enemy:Orc,10
   Enemy:Troll,20
   ```
   - Each line represents an object in the game.
   - The `Player` line includes the player's name and starting position on the grid.
   - Each `Enemy` line includes the enemy type and its starting position.

2. **Create Classes**  
   Based on the class design from **Exercise 2**, implement scaffolding for the `Player` and `Enemy` classes. Each class should have:
   - **Attributes** (fields) to store the data read from the file (e.g., `name`, `position`).
   - **Constructors** that accept arguments for initialization.
   - A `toString()` method for debugging purposes.

   Example scaffolding:
   ```java
   public class Player {
       private String name;
       private int position;

       public Player(String name, int position) {
           this.name = name;
           this.position = position;
       }

       @Override
       public String toString() {
           return "Player{name='" + name + "', position=" + position + "}";
       }
   }

   public class Enemy {
       private String type;
       private int position;

       public Enemy(String type, int position) {
           this.type = type;
           this.position = position;
       }

       @Override
       public String toString() {
           return "Enemy{type='" + type + "', position=" + position + "}";
       }
   }
   ```

3. **Read File and Create Objects**  
   Write a program that:
   - Reads the data from `game_data.txt`.
   - For each line, determines whether to create a `Player` or an `Enemy` object based on the prefix (`Player:` or `Enemy:`).
   - Uses the constructor of the appropriate class to instantiate the object.
   - Stores the objects in appropriate data structures (`Player` as a single object, and `Enemy` objects in a `List<Enemy>`).

   Example scaffold:
   ```java
   import java.io.*;
   import java.util.*;

   public class GameLoader {
       public static void main(String[] args) {
           List<Enemy> enemies = new ArrayList<>();
           Player player = null;

           try {
               File file = new File("game_data.txt");
               Scanner scanner = new Scanner(file);

               while (scanner.hasNextLine()) {
                   String line = scanner.nextLine();
                   String[] parts = line.split(":");
                   if (parts[0].equals("Player")) {
                       String[] details = parts[1].split(",");
                       player = new Player(details[0], Integer.parseInt(details[1]));
                   } else if (parts[0].equals("Enemy")) {
                       String[] details = parts[1].split(",");
                       enemies.add(new Enemy(details[0], Integer.parseInt(details[1])));
                   }
               }
               scanner.close();
           } catch (FileNotFoundException e) {
               System.out.println("File not found: " + e.getMessage());
           }

           // Debugging output
           System.out.println("Player: " + player);
           System.out.println("Enemies: " + enemies);
       }
   }
   ```

4. **Reflect and Debug**  
   - Run the program and verify that the `Player` and `Enemy` objects are correctly created and stored.
   - Print the contents of the `Player` object and the `List<Enemy>` for debugging.
   - **Optional Challenge:** What would you do if the file contained malformed data (e.g., missing or invalid fields)? Write a brief explanation.

---

#### Expected Outcome:
- Students will successfully read data from a file and initialize objects dynamically.
- Students will understand how to use constructors and data structures (e.g., `List`) to store objects.

---

### Exercise 4: Adding Player Movement 🚶‍♂️

#### Objective:
Implement basic player movement in a 2D grid-based game world. This exercise combines object-oriented programming with simple logic and user input handling.

---

#### Instructions:
1. **Set Up the Game World**  
   Define a simple 2D grid to represent the game world. Use a 2D array or a list of lists to model a 5x5 grid. Example:
   ```java
   public class GameWorld {
       private char[][] grid;

       public GameWorld() {
           grid = new char[5][5];
           for (int i = 0; i < grid.length; i++) {
               for (int j = 0; j < grid[i].length; j++) {
                   grid[i][j] = '-'; // Empty cell
               }
           }
       }

       public void displayGrid() {
           for (char[] row : grid) {
               for (char cell : row) {
                   System.out.print(cell + " ");
               }
               System.out.println();
           }
       }

       // Additional methods for updating and displaying the grid will be added later
   }
   ```

2. **Update the `Player` Class**  
   Add a `move(String direction)` method to the `Player` class. This method should:
   - Accept a direction ("up", "down", "left", "right").
   - Update the player's position accordingly.
   - Ensure the player does not move out of bounds.

   Example:
   ```java
   public void move(String direction) {
       switch (direction.toLowerCase()) {
           case "up":
               if (position > 0) position -= 1;
               break;
           case "down":
               if (position < 4) position += 1;
               break;
           case "left":
               // Implement left movement
               break;
           case "right":
               // Implement right movement
               break;
           default:
               System.out.println("Invalid direction!");
       }
   }
   ```

3. **Integrate Player Movement with the Game World**  
   - Update the `GameWorld` class to place the player on the grid. For example, the player's position might be represented by a `P` character.
   - Write a program that:
     - Instantiates a `GameWorld` and a `Player` object.
     - Displays the grid.
     - Allows the user to input movement commands (e.g., "up", "down") to move the player.
     - Updates and redisplays the grid after each move.

   Example scaffold:
   ```java
   import java.util.Scanner;

   public class Game {
       public static void main(String[] args) {
           GameWorld world = new GameWorld();
           Player player = new Player("John", 0);

           Scanner scanner = new Scanner(System.in);
           String command;

           while (true) {
               world.displayGrid();
               System.out.print("Enter a move (up, down, left,

### Exercise 5: Implementing the Scoring System 🏆

#### Objective:
Add a scoring mechanism to your game by introducing collectible items on the grid. The player should earn points by collecting these items, and the game should display the updated score after every move.

---

#### Instructions:

1. **Add Collectible Items to the Grid**  
   - Update the `GameWorld` class to include collectible items (e.g., coins) represented by a specific character (`C`).
   - Randomly place a few collectible items on the grid when the game starts. Example:
     ```java
     public void placeCollectibles(int numCollectibles) {
         Random random = new Random();
         for (int i = 0; i < numCollectibles; i++) {
             int x, y;
             do {
                 x = random.nextInt(grid.length);
                 y = random.nextInt(grid[0].length);
             } while (grid[x][y] != '-'); // Ensure the cell is empty
             grid[x][y] = 'C'; // Place a collectible
         }
     }
     ```

2. **Update the Player's Position**  
   - Modify the `GameWorld` class to update the grid when the player moves. If the player moves to a cell containing a collectible, the collectible should be removed, and the player's score should increase. Example:
     ```java
     public void updatePlayerPosition(int oldX, int oldY, int newX, int newY, Player player) {
         if (grid[newX][newY] == 'C') {
             player.increaseScore(10); // Example: 10 points per collectible
             System.out.println("You collected a coin! Score: " + player.getScore());
         }
         grid[oldX][oldY] = '-'; // Clear old position
         grid[newX][newY] = 'P'; // Update to new position
     }
     ```

3. **Enhance the `Player` Class**  
   - Add a `score` attribute to the `Player` class.
   - Provide methods `increaseScore(int points)` and `getScore()` to manage the player's score. Example:
     ```java
     public class Player {
         private int score;

         public void increaseScore(int points) {
             this.score += points;
         }

         public int getScore() {
             return score;
         }
     }
     ```

4. **Integrate Scoring with Player Movement**  
   - Update the game loop to check for collectibles after each move and display the player's updated score.

   Example scaffold:
   ```java
   public class Game {
       public static void main(String[] args) {
           GameWorld world = new GameWorld();
           Player player = new Player("John", 0);
           world.placeCollectibles(5); // Place 5 collectibles

           Scanner scanner = new Scanner(System.in);
           String command;

           while (true) {
               world.displayGrid();
               System.out.println("Score: " + player.getScore());
               System.out.print("Enter a move (up, down, left, right): ");
               command = scanner.nextLine();

               int oldX = player.getX();
               int oldY = player.getY();
               player.move(command);
               int newX = player.getX();
               int newY = player.getY();

               world.updatePlayerPosition(oldX, oldY, newX, newY, player);
           }
       }
   }
   ```

5. **Reflect and Debug**  
   - Test the program to ensure collectibles are removed when collected, the score updates correctly, and the grid reflects the changes.
   - Optional: Add a message when all collectibles have been collected (e.g., "Congratulations! You collected all items!").

---

#### Expected Outcome:
- Students will implement a scoring mechanism and understand how to modify game state dynamically.
- Students will practice integrating multiple classes and concepts, such as file I/O, grid management, and player movement.

---

### Exercise 6: Enemy Interactions and Game Logic 👾

#### Objective:
Introduce enemies that interact with the player. Enemies will move randomly on the grid, and the game will include win/lose conditions based on interactions with enemies and collectibles.

---

#### Instructions:

1. **Add Enemy Movement**  
   - Update the `Enemy` class to include a `move()` method that allows enemies to move randomly on the grid.
   - Modify the `GameWorld` class to update the grid when enemies move. Ensure enemies do not move out of bounds or overlap with other entities (e.g., player, other enemies, collectibles). Example:
     ```java
     public void moveEnemy(Enemy enemy) {
         Random random = new Random();
         int newX, newY;
         do {
             int direction = random.nextInt(4); // 0: up, 1: down, 2: left, 3: right
             newX = enemy.getX();
             newY = enemy.getY();

             switch (direction) {
                 case 0: newX--; break; // Up
                 case 1: newX++; break; // Down
                 case 2: newY--; break; // Left
                 case 3: newY++; break; // Right
             }
         } while (isOutOfBounds(newX, newY) || grid[newX][newY] != '-');

         grid[enemy.getX()][enemy.getY()] = '-'; // Clear old position
         grid[newX][newY] = 'E'; // Update to new position
         enemy.setPosition(newX, newY);
     }
     ```

2. **Player-Enemy Interaction**  
   - Detect when the player and an enemy occupy the same position. If this happens:
     - Reduce the player's score (e.g., by 20 points).
     - Optionally end the game if the player's score drops below zero. Example:
       ```java
       if (player.getX() == enemy.getX() && player.getY() == enemy.getY()) {
           player.increaseScore(-20); // Subtract points
           System.out.println("An enemy hit you! Score: " + player.getScore());
           if (player.getScore() < 0) {
               System.out.println("Game Over! You lost.");
               System.exit(0); // End the game
           }
       }
       ```

3. **Win/Lose Conditions**  
   - The player wins if they collect all the collectibles on the grid.
   - The player loses if their score drops below zero or if they are caught by an enemy.

4. **Enhance the Game Loop**  
   - Add a turn-based system where the player moves first, followed by all enemies. Example:
     ```java
     while (true) {
         // Player's turn
         world.displayGrid();
         System.out.println("Score: " + player.getScore());
         System.out.print("Enter a move (up, down, left, right): ");
         command = scanner.nextLine();

         int oldX = player.getX();
         int oldY = player.getY();
         player.move(command);
         int newX = player.getX();
