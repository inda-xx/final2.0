# Task: Build a Simple Game Application 🎮

Welcome to your weekly challenge! This week, you’ll be building a **simple 2D game application** with three core functionalities: **player movement**, a **scoring system**, and **enemy interactions**. Along the way, you’ll explore how to design clean and reusable classes, use data from files to dynamically create game objects, and bring your creativity to life through programming. The exercises are structured to guide you step-by-step, gradually increasing in complexity.

---

### 🗂 Exercise 1: Understanding Data from Files  
**Goal:** In this exercise, you will explore the basics of file formats and how they can be used to store game data.  

1. **Task Description:**  
   - Research different file formats that can store game-related data, such as `.txt`, `.csv`, or `.json`.
   - Imagine that your game requires storing information about enemies (e.g., their name, health, and position) in a file. Write a short sample of what this file might look like in **CSV format**.  
     
     Example:  
     ```
     Name,Health,PositionX,PositionY
     Slime,50,3,5
     Goblin,100,6,8
     ```

2. **Deliverable:**  
   Submit a simple `.csv` file that models how you would store enemy data for your game. Also, briefly explain why you chose this format and how it can be parsed.

---

### 🏗 Exercise 2: Designing Game Classes  
**Goal:** Learn how to design classes that represent the entities in your game.  

1. **Task Description:**  
   - Create a simple class diagram or written description for three main entities in your game: **Player**, **Enemy**, and **GameWorld**.
   - For each class, define:  
     - **Attributes:** What data does this class need?  
     - **Methods:** What actions or behaviors does this class need to implement?  
   - Ensure your classes follow principles of **cohesion** and **responsibility**.

2. **Scaffolding:** Use the example below as a starting point for your **Player** class:  
   ```java
   public class Player {
       private String name;       // Player's name
       private int score;         // Player's current score
       private int positionX;     // X-coordinate of the player
       private int positionY;     // Y-coordinate of the player

       // Constructor
       public Player(String name, int positionX, int positionY) {
           this.name = name;
           this.positionX = positionX;
           this.positionY = positionY;
           this.score = 0; // Score starts at zero
       }

       // Method to move the player
       public void move(int x, int y) {
           this.positionX += x;
           this.positionY += y;
       }

       // Method to update the score
       public void updateScore(int points) {
           this.score += points;
       }
   }
   ```

3. **Deliverable:** Submit a short description or diagram for your three classes, along with an explanation of your design choices.

---

### 🛠 Exercise 3: Reading Enemy Data from a File  
**Goal:** Learn how to use data from a file to dynamically instantiate objects in your game.  

1. **Task Description:**  
   - Using the `Enemy` class from **Exercise 2**, write a program that reads enemy data from a `.csv` file and creates an array or list of `Enemy` objects.  
   - For example, given the following file:  
     ```
     Name,Health,PositionX,PositionY
     Slime,50,3,5
     Goblin,100,6,8
     ```

   Your program should create two `Enemy` objects with the appropriate attributes.  

2. **Scaffolding:** Use the following snippet as a starting point:  
   ```java
   import java.io.BufferedReader;
   import java.io.FileReader;
   import java.util.ArrayList;

   public class Game {
       public static void main(String[] args) {
           ArrayList<Enemy> enemies = new ArrayList<>();
           try (BufferedReader br = new BufferedReader(new FileReader("enemies.csv"))) {
               String line;
               br.readLine(); // Skip header line
               while ((line = br.readLine()) != null) {
                   String[] data = line.split(",");
                   String name = data[0];
                   int health = Integer.parseInt(data[1]);
                   int positionX = Integer.parseInt(data[2]);
                   int positionY = Integer.parseInt(data[3]);
                   enemies.add(new Enemy(name, health, positionX, positionY));
               }
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
   }
   ```

   **Note:** You’ll need to implement the `Enemy` class based on your design from Exercise 2.  

3. **Deliverable:** Submit your Java program and the `.csv` file. Ensure your program runs without errors.

---

### 🏃‍♂️ Exercise 4: Implementing Player Movement  
**Goal:** Add functionality to move the player around a simple grid-based game world.  

1. **Task Description:**  
   - Implement the `move` method in your `Player` class to update the player’s position based on user input.  
   - Use the Java `Scanner` class to allow the user to input movement commands (e.g., `up`, `down`, `left`, `right`).  
   - Ensure that the player does not move outside the bounds of the grid (e.g., a 10x10 grid).  

2. **Scaffolding:**  
   ```java
   import java.util.Scanner;

   public class Game {
       public static void main(String[] args) {
           Player player = new Player("Hero", 0, 0);
           Scanner scanner = new Scanner(System.in);

           while (true) {
               System.out.println("Enter move (up, down, left, right): ");
               String command = scanner.nextLine();

               switch (command) {
                   case "up": player.move(0, -1); break;
                   case "down": player.move(0, 1); break;
                   case "left": player.move(-1, 0); break;
                   case "right": player.move(1, 0); break;
                   default: System.out.println("Invalid command");
               }

               System.out.println("Player position: " + player.getPositionX() + ", " + player.getPositionY());
           }
       }
   }
   ```

3. **Deliverable:** Submit your program with working player movement logic.

---

### 🎯 Exercise 5: Adding a Scoring System  
**Goal:** Implement a scoring system where the player earns points for collecting items or interacting with enemies.  

1. **Task Description:**  
   - Add an **Item** class to your game. Each item should have attributes such as `name`, `points`, and `position`.  
   - Spawn items randomly on the grid and allow the player to collect them by moving to their position.  
   -

### Exercise 1: Exploring Data Storage for Game Objects  
**Goal:** Deepen your understanding of file formats and how they can be used to store and retrieve game-related data.  

---

1. **Task Description:**  
Imagine a scenario where your game needs to store information about game enemies in a file. This external data will later be used to dynamically create enemy objects. You’ll research file formats that are commonly used for storing structured data and determine how they can be applied to your game.  

   - Research and compare the following file formats: `.txt`, `.csv`, and `.json`. For each format, provide:  
     - A brief description of its structure and use case.  
     - An example of how you would represent enemy data in the format.  
   - Choose one of the file formats (e.g., `.csv`) and create a small sample file to store enemy data. For example:  

     **CSV Example:**  
     ```
     Name,Health,PositionX,PositionY  
     Slime,30,4,2  
     Orc,80,7,5  
     ```

2. **Conceptual Questions:**  
   - Why do you think structured file formats like `.csv` or `.json` are commonly used in game design?  
   - What considerations must be made when reading data from external files to ensure data integrity (e.g., handling missing or incorrect data)?  

3. **Deliverable:**  
   Submit your research findings, including a brief comparison of the file formats, and your chosen sample file (e.g., `enemies.csv`). Include a short explanation of why you selected this format for your game.  

---

### Exercise 2: Designing Classes for Game Entities  
**Goal:** Lay the foundation for object-oriented programming by designing key game classes.  

---

1. **Task Description:**  
Games rely on well-structured classes to manage their entities and interactions. In this exercise, you will design three core classes for your game: **Player**, **Enemy**, and **GameWorld**. This will prepare you for implementing these classes in future exercises.  

   - For each class, define:  
     - **Attributes** (What data does the class need to store?)  
     - **Methods** (What actions or behaviors does the class need to perform?)  

   **Example for Player Class:**  
   - **Attributes:** `name`, `score`, `positionX`, `positionY`  
   - **Methods:** `move(x, y)`, `updateScore(points)`  

   - Consider how these classes will interact. For example:  
     - The `GameWorld` class might manage a grid where the player and enemies are positioned.  
     - The `Enemy` class could have attributes like `health` and `damage` and methods like `takeDamage(int amount)`.  
     - The `Player` class could interact with enemies or collect items on the grid.  

2. **Conceptual Questions:**  
   - How does encapsulation help in designing reusable and maintainable classes?  
   - Why is it important to clearly define the responsibilities of each class in your game?  

3. **Deliverable:**  
   Submit a short written description or diagram of your class designs. Explain how you applied principles of cohesion and responsibility to your designs.  

--- 

These two exercises ensure theoretical preparation for the coding challenges that follow. Exercise 1 introduces students to structured data storage, a foundational skill for working with external data. Exercise 2 focuses on object-oriented design principles, enabling students to create robust and reusable game entities. Both exercises emphasize understanding and planning, key skills for successful programming.

### 🛠 Exercise 3: Reading and Instantiating Enemy Objects from a File  
**Goal:** Apply file I/O concepts to dynamically create game objects based on external data.  

---

1. **Task Description:**  
Now that you’ve designed the `Enemy` class and created a sample data file, it’s time to write a program that reads the enemy data from the file and uses it to instantiate `Enemy` objects dynamically.  

   - **Step 1:** Implement the `Enemy` class based on your design from **Exercise 2**.  
     - Include attributes such as `name`, `health`, `positionX`, and `positionY`.  
     - Provide a constructor to initialize these attributes and methods to retrieve or modify the data (e.g., getters, `takeDamage`).  

   - **Step 2:** Write a program that reads the enemy data from a `.csv` file (e.g., `enemies.csv`) and creates a list of `Enemy` objects.  
     - Use Java’s `BufferedReader` and `FileReader` classes as shown in the scaffolding below.  
     - Handle missing or malformed data gracefully using exception handling. (E.g., skip invalid lines and log a warning.)  

   - **Step 3:** After reading the data, print out the details of each enemy to verify that the objects were created correctly.  

2. **Scaffolding:**  
   ```java
   import java.io.BufferedReader;
   import java.io.FileReader;
   import java.util.ArrayList;

   public class Game {
       public static void main(String[] args) {
           ArrayList<Enemy> enemies = new ArrayList<>();
           try (BufferedReader br = new BufferedReader(new FileReader("enemies.csv"))) {
               String line;
               br.readLine(); // Skip header line
               while ((line = br.readLine()) != null) {
                   String[] data = line.split(",");
                   if (data.length == 4) { // Ensure the line has all required fields
                       try {
                           String name = data[0];
                           int health = Integer.parseInt(data[1]);
                           int positionX = Integer.parseInt(data[2]);
                           int positionY = Integer.parseInt(data[3]);
                           enemies.add(new Enemy(name, health, positionX, positionY));
                       } catch (NumberFormatException e) {
                           System.out.println("Warning: Invalid data format in line: " + line);
                       }
                   } else {
                       System.out.println("Warning: Incomplete data in line: " + line);
                   }
               }
           } catch (Exception e) {
               e.printStackTrace();
           }

           // Print all enemies to verify
           for (Enemy enemy : enemies) {
               System.out.println(enemy);
           }
       }
   }
   ```

   **Note:** You’ll need to implement the `Enemy` class with a `toString` method to format the enemy details for printing.  

3. **Conceptual Questions:**  
   - How can you handle errors in the file (e.g., missing fields, invalid numbers) to ensure your program doesn’t crash?  
   - Why is it useful to store game data in external files rather than hardcoding it into the program?  

4. **Deliverable:**  
   Submit your Java program, the `Enemy` class implementation, and the `.csv` file. Ensure that your program runs without errors and outputs the correct enemy details.  

---

### 🏃‍♂️ Exercise 4: Moving the Player in a Grid-Based Game World  
**Goal:** Implement player movement logic and boundary constraints within a grid-based game world.  

---

1. **Task Description:**  
Building on your `Player` class from **Exercise 2**, implement functionality to move the player around a simple 10x10 grid. The player’s position must update based on user input, and they should not be allowed to move outside the bounds of the grid.  

   - **Step 1:** Update the `Player` class to include a method `move(int deltaX, int deltaY)` that adjusts the player’s position.  
     - Ensure the player’s position does not exceed the grid boundaries (e.g., 0 ≤ `positionX` < 10, 0 ≤ `positionY` < 10).  
     - If a move would place the player out of bounds, ignore the move and display a warning message.  

   - **Step 2:** Create a simple game loop in the `Game` class where the program continuously asks the user for input to move the player.  
     - Use the `Scanner` class to read user input (`up`, `down`, `left`, `right`).  
     - Translate the input into movement (e.g., `up` decreases `positionY`, `right` increases `positionX`).  
     - Print the player’s updated position after each move.  

   - **Step 3:** Add a basic grid visualization (optional but encouraged). For example, print a 10x10 grid with the player’s position marked as `P`.  

2. **Scaffolding:**  
   ```java
   import java.util.Scanner;

   public class Game {
       public static void main(String[] args) {
           Player player = new Player("Hero", 0, 0);
           Scanner scanner = new Scanner(System.in);

           while (true) {
               System.out.println("Enter move (up, down, left, right): ");
               String command = scanner.nextLine();

               switch (command) {
                   case "up":
                       player.move(0, -1);
                       break;
                   case "down":
                       player.move(0, 1);
                       break;
                   case "left":
                       player.move(-1, 0);
                       break;
                   case "right":
                       player.move(1, 0);
                       break;
                   default:
                       System.out.println("Invalid command");
               }

               System.out.println("Player position: " + player.getPositionX() + ", " + player.getPositionY());
           }
       }
   }
   ```

   **Note:** You’ll need to implement the `Player` class with attributes and methods to support this functionality.  

3. **Conceptual Questions:**  
   - How can you ensure that your grid-based movement logic remains flexible for grids of different sizes (e.g., 10x10 vs. 20x20)?  
   - Why is it important to validate user input (e.g., check for invalid commands or boundary violations) in interactive programs?  

4. **Deliverable:**  
   Submit your Java program with the implemented player movement logic. If you added a grid visualization, include a screenshot or description of how it works.  

---

### Transition to Exercises 5 & 6  
These exercises bridge the theoretical design from Exercises 1 & 2 with the more complex coding tasks in Exercises 5 & 6. By working with file I/O and interactive player movement, students will develop practical coding skills while reinforcing core object-oriented principles. They’ll also be prepared to integrate additional functionality, like scoring and enemy interactions, in upcoming challenges.

### 🏆 Exercise 5: Adding a Scoring System and Collectible Items  
**Goal:** Implement a scoring system that rewards players for collecting items on the grid.  

---

#### 1. **Task Description:**  
Expand your game to include **items** that the player can collect for points. The player earns points when they move to a grid cell containing an item. The game should randomly spawn items on the grid and track the player’s score as they collect them.  

   - **Step 1:** Design and Implement the `Item` Class.  
     - Define attributes such as `name`, `points`, `positionX`, and `positionY`.  
     - Include a constructor to initialize these attributes and a `toString` method for debugging purposes.  

     **Example:**  
     ```java
     public class Item {
         private String name;
         private int points;
         private int positionX;
         private int positionY;

         public Item(String name, int points, int positionX, int positionY) {
             this.name = name;
             this.points = points;
             this.positionX = positionX;
             this.positionY = positionY;
         }

         public int getPositionX() {
             return positionX;
         }

         public int getPositionY() {
             return positionY;
         }

         public int getPoints() {
             return points;
         }

         @Override
         public String toString() {
             return name + " (" + points + " points)";
         }
     }
     ```

   - **Step 2:** Spawn Items on the Grid.  
     - Randomly generate 5-10 items with random positions on the grid.  
     - Ensure that no two items spawn at the same position.  
     - Store these items in a list for tracking.  

     **Hint:** Use a method to check if a position is already occupied before spawning an item there.

   - **Step 3:** Detect and Handle Item Collection.  
     - In the game loop, check if the player’s current position matches the position of any item.  
     - If it does, update the player’s score, remove the item from the grid, and notify the player.  

     **Example Output:**  
     ```
     You collected a Gold Coin! (+10 points)
     ```

   - **Step 4:** Display the Player’s Score.  
     - Update the game loop to print the player’s score after each move.  

#### 2. **Scaffolding:**  
Update the game loop to include item spawning and collection logic.  
```java
import java.util.ArrayList;
import java.util.Random;

public class Game {
    public static void main(String[] args) {
        Player player = new Player("Hero", 0, 0);
        ArrayList<Item> items = new ArrayList<>();
        Random random = new Random();

        // Spawn 5 items randomly on the grid
        for (int i = 0; i < 5; i++) {
            int x, y;
            do {
                x = random.nextInt(10);
                y = random.nextInt(10);
            } while (isPositionOccupied(items, x, y)); // Ensure no duplicate positions
            items.add(new Item("Gold Coin", 10, x, y));
        }

        // Game loop
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter move (up, down, left, right): ");
            String command = scanner.nextLine();

            switch (command) {
                case "up": player.move(0, -1); break;
                case "down": player.move(0, 1); break;
                case "left": player.move(-1, 0); break;
                case "right": player.move(1, 0); break;
                default: System.out.println("Invalid command");
            }

            // Check for item collection
            for (int i = 0; i < items.size(); i++) {
                Item item = items.get(i);
                if (player.getPositionX() == item.getPositionX() && player.getPositionY() == item.getPositionY()) {
                    player.updateScore(item.getPoints());
                    System.out.println("You collected a " + item + "!");
                    items.remove(i);
                    break;
                }
            }

            System.out.println("Player position: " + player.getPositionX() + ", " + player.getPositionY());
            System.out.println("Player score: " + player.getScore());
        }
    }

    private static boolean isPositionOccupied(ArrayList<Item> items, int x, int y) {
        for (Item item : items) {
            if (item.getPositionX() == x && item.getPositionY() == y) {
                return true;
            }
        }
        return false;
    }
}
```

#### 3. **Conceptual Questions:**  
   - How can you ensure that items are spawned fairly across the grid?  
   - What modifications would you need to make to track multiple types of items (e.g., coins, potions, keys)?  

#### 4. **Deliverable:**  
   Submit your Java program with the implemented scoring system and item collection logic. Include screenshots or console output showing items being collected and the score updating correctly.

---

### 🎮 Exercise 6: Adding Enemy Interactions and a Game Over Condition  
**Goal:** Implement enemy interactions and introduce a "Game Over" condition to your game.  

---

#### 1. **Task Description:**  
Expand your game to include basic interactions with enemies. The player should lose health when they move to a grid cell occupied by an enemy. If the player’s health reaches zero, the game ends.  

   - **Step 1:** Update the `Player` Class.  
     - Add an attribute `health` to the `Player` class (e.g., starting at 100).  
     - Add a method `takeDamage(int amount)` to reduce the player’s health.  

   - **Step 2:** Detect and Handle Enemy Interactions.  
     - In the game loop, check if the player’s position matches the position of any enemy.  
     - If it does, reduce the player’s health, display a warning message, and end the game if the player’s health reaches zero.  

     **Example Output:**  
     ```
     You encountered a Goblin! (-20 health)
     Player health: 80
     ```

   - **Step 3:** Display the Player’s Health.  
     - Update the game loop to print the player’s health after each move.  

   - **Step 4:** End the Game.  
     - If the player’s health reaches zero, print a "Game Over" message and exit the game loop.  

#### 2. **Scaffolding:**  
Update the game loop to include enemy interactions and a game over condition.  
```java
public class Game {
    public static void main(String[] args) {
        Player player = new Player("Hero", 0, 0);
        ArrayList<Enemy> enemies = new ArrayList<>();
        enemies.add(new Enemy("Goblin", 100, 5, 5));
        enemies.add(new Enemy("