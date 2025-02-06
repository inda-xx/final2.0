# **Weekly Programming Task: Building a Simple Game in Java 🎮**  

## **Task Overview**  
In this task, you will design and implement a simple 2D text-based game in Java. The game will involve **player movement**, a **scoring system**, **enemy interactions**, and **basic collision detection**. You will also learn to **read data from files to instantiate game objects**, **design well-structured classes**, and **think creatively to implement game logic**.  

By the end of this task, you will have a working game with dynamic object creation, proper class design, and creative gameplay mechanics.  

---

## **Exercise 1: Understanding Game Components 📝**  
Before jumping into coding, take some time to **analyze the different components** required for the game.  
1. **List down the key objects** in the game (e.g., Player, Enemy, GameBoard).  
2. **Identify the responsibilities** of each object and how they will interact.  
3. **Think about what data** needs to be stored in files (e.g., enemy positions, game levels).  

### **Guiding Questions:**  
- What attributes should a `Player` class have?  
- How will enemies behave in the game?  
- What kind of file format can be used to store game level data?  

💡 **Write a short paragraph describing your game idea and how you plan to structure it.**  

---

## **Exercise 2: Designing Game Classes 📦**  
Now that you have a basic idea of the game components, you will **design the core classes** for the game.  

### **Task:**  
1. Define a **Player** class with attributes such as position (`x, y`), score, and movement methods.  
2. Define an **Enemy** class with attributes like position and behavior.  
3. Define a **GameBoard** class that manages the game state.  

💡 **Scaffolding Code:**  
Start by creating a simple class structure:  
```java
public class Player {
    private int x, y; // Player position
    private int score;
    
    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.score = 0;
    }

    public void move(int dx, int dy) {
        x += dx;
        y += dy;
    }

    public int getScore() {
        return score;
    }
}
```  
Modify and expand this structure as needed!  

### **Discussion Questions:**  
- What methods should the `Enemy` class have?  
- How can we structure the `GameBoard` class to track objects dynamically?  

---

## **Exercise 3: Loading Game Data from Files 📂**  
Now, you will **load enemy positions from a file** and instantiate objects based on this data.  

### **Task:**  
1. Create a text file (e.g., `enemies.txt`) with enemy positions formatted as follows:  
   ```
   3,5
   7,2
   4,4
   ```
2. Write a Java method to **read this file** and create `Enemy` objects dynamically.  

💡 **Scaffolding Code:**  
```java
import java.io.*;
import java.util.*;

public class GameLoader {
    public static List<Enemy> loadEnemies(String filename) {
        List<Enemy> enemies = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                enemies.add(new Enemy(x, y));
            }
        } catch (IOException e) {
            System.out.println("Error loading enemies: " + e.getMessage());
        }
        return enemies;
    }
}
```  
Modify this code to integrate it into your game!  

### **Discussion Questions:**  
- How can you handle errors if the file contains invalid data?  
- How can you extend this approach to load different types of game objects?  

---

## **Exercise 4: Implementing Player Movement and Controls ⌨️**  
Now, let's make the player move!  

### **Task:**  
1. Implement a simple **keyboard-based movement system** using Java's Scanner.  
2. Allow the player to enter commands like `w` (up), `s` (down), `a` (left), `d` (right).  
3. Update the player's position based on the input.  

💡 **Scaffolding Code:**  
```java
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Player player = new Player(0, 0);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter move (w/a/s/d): ");
            String move = scanner.nextLine();
            switch (move) {
                case "w": player.move(0, -1); break;
                case "s": player.move(0, 1); break;
                case "a": player.move(-1, 0); break;
                case "d": player.move(1, 0); break;
                default: System.out.println("Invalid move");
            }
            System.out.println("Player position: " + player.getX() + ", " + player.getY());
        }
    }
}
```  
Modify it to fit your game's logic!  

### **Bonus:**  
- Add a way to **quit the game** (e.g., entering `q`).  
- Prevent the player from moving outside the game boundaries.  

---

## **Exercise 5: Implementing Enemy Interactions and Collision Detection ⚔️**  
Enemies should **react** when the player moves!  

### **Task:**  
1. Implement basic **collision detection**: If the player moves to an enemy’s position, print `"Enemy encountered!"`.  
2. Implement a **simple enemy behavior**, such as moving in a random direction.  

💡 **Scaffolding Code:**  
```java
public class GameLogic {
    public static boolean checkCollision(Player player, List<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            if (player.getX() == enemy.getX() && player.getY() == enemy.getY()) {
                return true;
            }
        }
        return false;
    }
}
```  
Modify this to add custom behavior for enemies!  

### **Bonus:**  
- Implement a **turn-based system** where enemies move after the player moves.  
- Make enemies chase the player if they get too close.  

---

## **Exercise 6: Adding a Scoring System and Game State Management 🏆**  
Now, let's **track scores and manage game states**.  

### **Task:**  
1. Add a **score system** where the player earns points by avoiding or defeating enemies.  
2. Implement a **win condition**, such as reaching a certain score.  
3. Implement a **lose condition**, such as getting caught by an enemy.  

💡 **

# **Exercise 1: Understanding Game Components 📝**  

## **Introduction**  
Before diving into the implementation, it’s important to **understand the structure of the game** and how different components interact. A well-planned design will make the coding process smoother and help you create a more maintainable program.  

## **Task**  
1. **Identify the key objects** in the game. Think about the different entities involved in the game, such as the **Player**, **Enemy**, and **GameBoard**.  
2. **Determine the responsibilities** of each object. For example, what actions should a `Player` be able to perform? How should the `GameBoard` manage game objects?  
3. **Consider how data will be stored and loaded**. Since we will be reading enemy positions from a file, think about the best way to structure this data (e.g., file format, organization).  

## **Guiding Questions**  
- What attributes and methods should the `Player` class have?  
- How should the `Enemy` class behave? Should it move randomly or follow the player?  
- How can the `GameBoard` keep track of all game objects?  
- What file format (e.g., `.txt`, `.csv`) is best for storing enemy positions?  

## **Your Task:**  
Write **a short paragraph** (5-7 sentences) describing your game idea. Outline the **main components**, how they interact, and what kind of **data you plan to store in files**.  

💡 **Example Answer Structure (Do not copy)**:  
*"In my game, the player moves on a 2D grid, avoiding or battling enemies. The `Player` class will track position and score, while the `Enemy` class will store enemy positions and movement logic. The `GameBoard` will manage all elements and check for collisions. Enemy positions will be loaded from a `.txt` file, ensuring dynamic level creation. The player moves using keyboard inputs, and enemies may move randomly or follow the player. The game will end when the player reaches a certain score or is defeated by an enemy."*  

---

# **Exercise 2: Designing Game Classes 📦**  

## **Introduction**  
Now that you have a **conceptual understanding** of the game, it’s time to **design the core classes**. Object-oriented programming (OOP) allows us to break down the game into **manageable components**, making the game easier to develop and extend.  

## **Task**  
1. **Define three main classes**:  
   - `Player`: Represents the player character with attributes like `x, y` position and `score`.  
   - `Enemy`: Represents enemy objects with attributes like `x, y` position and movement behavior.  
   - `GameBoard`: Manages the game state, tracks all objects, and checks for collisions.  
2. **Think about the responsibilities of each class**:  
   - What methods should each class have? (e.g., `move()` for `Player`, `updatePosition()` for `Enemy`)  
   - How will these classes interact?  

## **Guiding Questions**  
- What attributes and methods should the `Player` class have?  
- How should the `Enemy` class behave?  
- How can the `GameBoard` manage all objects efficiently?  

## **Your Task:**  
Sketch a **simple class diagram** (on paper or a drawing tool) showing the relationships between the `Player`, `Enemy`, and `GameBoard` classes.  
Then, **write a brief explanation** (4-5 sentences) describing your class design choices.  

💡 **Example Answer Structure (Do not copy)**:  
*"The `Player` class stores position and score, with methods for movement. The `Enemy` class has a position and may move randomly. The `GameBoard` contains a list of enemies and checks for collisions. The player’s movement will trigger enemy updates, and the game will check if the player collides with an enemy. This structure keeps the game logic modular and easy to expand."*  

These exercises will help solidify your **understanding of object-oriented design** before you start coding in the next exercises! 🚀

# **Exercise 3: Loading and Instantiating Game Objects from a File 📂**  

## **Introduction**  
Now that you have structured your **game components**, it's time to make the game **dynamic** by reading enemy positions from a file and instantiating `Enemy` objects accordingly. This will allow your game to **load different levels** based on file data, making it more flexible and reusable.  

## **Task**  
1. **Create a text file (`enemies.txt`)** that contains enemy positions in a simple format, such as:  
   ```
   2,3
   5,1
   6,4
   ```  
   Each line represents an enemy’s `x, y` position in the game world.  
2. **Write a Java method to read this file** and create `Enemy` objects dynamically.  
3. **Store these objects in a list** inside the `GameBoard` class so they can be used during gameplay.  

## **Scaffolding Code**  
This snippet provides a basic framework for reading enemy positions from a file:  
```java
import java.io.*;
import java.util.*;

public class GameLoader {
    public static List<Enemy> loadEnemies(String filename) {
        List<Enemy> enemies = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                enemies.add(new Enemy(x, y)); // Instantiate Enemy object
            }
        } catch (IOException e) {
            System.out.println("Error loading enemies: " + e.getMessage());
        }
        return enemies;
    }
}
```  

Modify and integrate this into your `GameBoard` class!  

## **Guiding Questions**  
- How can you ensure the file format is **parsed correctly**?  
- What happens if the file contains **invalid data** (e.g., missing numbers, non-numeric values)?  
- How can we extend this to load **other game objects** dynamically?  

## **Bonus Challenge**  
- Implement **error handling** to detect and **skip invalid lines** in the file.  
- Allow the game to load **multiple levels** by using different files like `level1.txt`, `level2.txt`.  

---

# **Exercise 4: Integrating Player Movement and Game State Management ⌨️**  

## **Introduction**  
Now that we can **load enemies from a file**, it's time to make the game interactive by implementing **player movement** and **game state management**. The player should be able to move around the game board using keyboard input, and the game should **track the player's current state**.  

## **Task**  
1. **Implement a keyboard-based movement system** using Java’s `Scanner` class.  
2. **Track the player’s position** and update it based on user input (`w` for up, `s` for down, `a` for left, `d` for right).  
3. **Detect collisions** between the player and enemies. If the player moves into an enemy’s position, print `"Enemy encountered!"`.  
4. **Ensure the player stays within the game boundaries** (e.g., grid size of `10x10`).  

## **Scaffolding Code**  
This snippet provides a basic movement system for the player:  
```java
import java.util.List;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        Player player = new Player(0, 0);
        List<Enemy> enemies = GameLoader.loadEnemies("enemies.txt");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter move (w/a/s/d): ");
            String move = scanner.nextLine();

            switch (move) {
                case "w": player.move(0, -1); break;
                case "s": player.move(0, 1); break;
                case "a": player.move(-1, 0); break;
                case "d": player.move(1, 0); break;
                default: System.out.println("Invalid move");
            }

            System.out.println("Player position: " + player.getX() + ", " + player.getY());

            // Check for collisions
            if (checkCollision(player, enemies)) {
                System.out.println("Enemy encountered!");
                break; // End game on collision
            }
        }
        scanner.close();
    }

    public static boolean checkCollision(Player player, List<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            if (player.getX() == enemy.getX() && player.getY() == enemy.getY()) {
                return true;
            }
        }
        return false;
    }
}
```  

Modify and expand this code to handle **game boundaries**, **enemy behaviors**, and **more complex interactions**!  

## **Guiding Questions**  
- How can you **prevent the player from moving outside** the game grid?  
- What should happen **when an enemy is encountered**?  
- How can you extend this system to **allow enemies to move** as well?  

## **Bonus Challenge**  
- Add a **quit option** (e.g., enter `q` to exit).  
- Implement a **turn-based system** where enemies move **after the player moves**.  
- Introduce **power-ups or rewards** the player can collect.  

---

### **Summary of Exercises 3 & 4**  
- **Exercise 3:** Focused on **loading game data from files** and instantiating objects dynamically.  
- **Exercise 4:** Integrated **player movement, game state management, and basic enemy interactions**.  

These exercises prepare you for the **final coding challenges** in Exercises 5 & 6, where you’ll implement **collision detection, scoring, and advanced gameplay mechanics**! 🚀

# **Exercise 5: Implementing Enemy Interactions and Collision Detection ⚔️**  

## **Introduction**  
Now that the player can move and enemies are loaded from a file, it’s time to introduce **enemy interactions** and **collision detection**. This will add a challenge to the game and make movement meaningful. If the player collides with an enemy, a specific event should occur (e.g., game over, losing points, or defeating the enemy).  

This exercise will also introduce a **turn-based system**, where enemies move **after** the player moves. This will make the game more dynamic.  

---

## **Task Breakdown**  
1. **Implement basic collision detection**: If the player moves to an enemy’s position, print `"Enemy encountered!"` and decide on a consequence (e.g., losing points, removing the enemy, or ending the game).  
2. **Introduce enemy movement**: After the player moves, all enemies should move in a random direction (left, right, up, or down).  
3. **Ensure game boundaries**: Both the player and enemies should be restricted to a defined grid (e.g., `10x10`).  
4. **Modify the game loop**: After each player move, update enemy positions and check for collisions again.  

---

## **Scaffolding Code**  
This code provides a basic framework for **checking collisions** and **moving enemies randomly**.  

```java
import java.util.List;
import java.util.Random;

public class GameLogic {

    // Checks if the player collides with an enemy
    public static boolean checkCollision(Player player, List<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            if (player.getX() == enemy.getX() && player.getY() == enemy.getY()) {
                return true; // Collision detected
            }
        }
        return false;
    }

    // Moves enemies randomly after the player moves
    public static void moveEnemies(List<Enemy> enemies, int gridSize) {
        Random random = new Random();
        for (Enemy enemy : enemies) {
            int direction = random.nextInt(4); // 0 = up, 1 = down, 2 = left, 3 = right
            switch (direction) {
                case 0: enemy.move(0, -1, gridSize); break; // Move up
                case 1: enemy.move(0, 1, gridSize); break;  // Move down
                case 2: enemy.move(-1, 0, gridSize); break; // Move left
                case 3: enemy.move(1, 0, gridSize); break;  // Move right
            }
        }
    }
}
```  

---

## **Guiding Questions**  
- How can we prevent **enemies from moving outside the grid**?  
- What should happen when the **player collides with an enemy**?  
  - Should the game end?  
  - Should the player lose points?  
  - Should the enemy be removed?  
- How can enemy movement be improved (e.g., making them **chase the player**) instead of moving randomly?  

---

## **Your Task**  
1. **Integrate the provided logic into your game loop**:  
   - After each player move, call `moveEnemies()` and then check for collisions.  
2. **Decide on a consequence for a collision** and implement it.  
3. **Ensure enemies and players stay within the grid boundaries**.  

---

## **Bonus Challenges**  
💡 Want an extra challenge? Try these:  
- Modify enemy behavior so that **they chase the player** if nearby instead of moving randomly.  
- Add a **"safe zone"** where the player can move without being attacked.  
- Introduce different **enemy types** with different movement patterns.  

---

## **Expected Outcome**  
By the end of this exercise, enemies should move **each turn**, and the game should **detect and handle collisions** between the player and enemies.  

---

# **Exercise 6: Adding a Scoring System and Game State Management 🏆**  

## **Introduction**  
Now that enemies move and interact with the player, let's introduce **a scoring system, win/lose conditions, and better game state management**.  

The player should be able to **earn points** by surviving, collecting items, or defeating enemies. The game should also have a **clear ending condition**, such as:  
- Winning by reaching a score limit.  
- Losing by colliding with an enemy.  

This will add **a sense of progression** and make the game more engaging.  

---

## **Task Breakdown**  
1. **Implement a scoring system**:  
   - The player earns points for avoiding enemies or collecting items.  
   - The score should be displayed after each move.  
2. **Define win and lose conditions**:  
   - The game ends when the player reaches a score of `10` (win).  
   - The game ends if the player collides with an enemy (lose).  
3. **Enhance the game loop to track the game state**:  
   - Display a message when the player **wins or loses**, and **end the game gracefully**.  
4. **Introduce collectable items (optional)**:  
   - Randomly place items on the grid that increase the player's score when collected.  

---

## **Scaffolding Code**  
This snippet provides a basic **game loop** with scoring and win/lose conditions:  

```java
import java.util.*;

public class Game {
    public static void main(String[] args) {
        Player player = new Player(0, 0);
        List<Enemy> enemies = GameLoader.loadEnemies("enemies.txt");
        int gridSize = 10; // Define grid boundaries
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Score: " + player.getScore());
            System.out.print("Enter move (w/a/s/d or 'q' to quit): ");
            String move = scanner.nextLine();

            // Handle player movement
            switch (move) {
                case "w": player.move(0, -1, gridSize); break;
                case "s": player.move(0, 1, gridSize); break;
                case "a": player.move(-1, 0, gridSize); break;
                case "d": player.move(1, 0, gridSize); break;
                case "q": System.out.println("Game Over!"); return;
                default: System.out.println("Invalid move");
            }

            // Move enemies
            GameLogic.moveEnemies(enemies, gridSize);

            // Check for collisions
            if (GameLogic.checkCollision(player, enemies)) {
                System.out.println("You were caught by an enemy! Game Over!");
                break;
            }

            // Check win condition
            if (player.getScore() >= 10) {
                System.out.println("Congratulations! You win!");
                break;
            }
        }
        scanner.close();
    }
}
```  

---

## **Guiding Questions**  
- How can you **increase difficulty** as the game