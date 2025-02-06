# 🎮 Game Development Challenge: Build a Simple Game with Player, Enemies, and Scoring

## Task Overview  
In this project, you will design and implement a simple game application in Java. The game should include **player movement**, a **scoring system**, and **enemy interactions**. You will also use **data from files** to instantiate game objects dynamically. By completing this task, you will strengthen your understanding of **class design**, **handling file input**, and **creative problem-solving**.

---

## 📝 **Exercise 1: Understanding File-Based Object Instantiation**  
Before diving into writing code, let’s explore **why** and **how** we use files to instantiate objects.  

### **Task:**  
1. Research different file formats (**CSV, JSON, TXT**) and discuss their advantages for storing game data.  
2. Explain how a game might load enemy positions, player stats, or level configurations from a file.  
3. Write a short paragraph on how **parsing techniques** (e.g., `Scanner`, `BufferedReader`) allow dynamic object creation.  

💡 **Hint:** Think about how games load levels without hardcoding objects in Java.

---

## 🎭 **Exercise 2: Designing the Game Classes**  
A well-structured game requires properly defined classes. In this step, you will **design the class structure** for your game.  

### **Task:**  
1. Identify and define the responsibilities of the following classes:  
   - `Player`  
   - `Enemy`  
   - `Game`  
   - `ScoreManager`  
2. Draw a **UML diagram** (or write a text-based class blueprint) showing relationships between these classes.  
3. Write a short description of how **inheritance** or **interfaces** might improve the design.  

💡 **Hint:** Consider using an **abstract class or interface** for game entities like `Character`.

---

## 🏃 **Exercise 3: Implementing the Player Class**  
Now that we have our design, let's implement the **Player class** with movement functionality.  

### **Task:**  
1. Implement a `Player` class with:  
   - Attributes for the player’s **position (x, y)** and **score**.  
   - Methods to **move up, down, left, and right**.  

💡 **Hint:** Use simple integer values for coordinates (`x, y`) and update them based on movement commands.

🔹 **Scaffolding Code:**  
```java
public class Player {
    private int x, y;
    private int score;

    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.score = 0;
    }

    public void moveUp() { /* Implement movement logic */ }
    public void moveDown() { /* Implement movement logic */ }
    
    // Add methods for left and right movement

    public void increaseScore(int points) {
        this.score += points;
    }
}
```

---

## 👾 **Exercise 4: Loading Enemy Data from a File**  
Enemies should be **dynamically loaded from a file** instead of being hardcoded.  

### **Task:**  
1. Create a text file (`enemies.txt`) with enemy positions (**x, y**):  
   ```
   5,10
   15,20
   25,30
   ```
2. Implement an `Enemy` class that:  
   - Stores an **(x, y) position**.  
   - Can be loaded from a file.  
3. Write a method in `Game` to **read enemy data from the file and create Enemy objects**.  

💡 **Hint:** Use `BufferedReader` or `Scanner` to read the file line by line.

🔹 **Scaffolding Code:**  
```java
import java.io.*;
import java.util.*;

public class Game {
    private List<Enemy> enemies = new ArrayList<>();

    public void loadEnemiesFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                enemies.add(new Enemy(x, y));
            }
        } catch (IOException e) {
            System.out.println("Error reading enemy file: " + e.getMessage());
        }
    }
}
```

---

## 🏆 **Exercise 5: Implementing the Scoring System**  
The game should track and update the **player’s score** when interacting with enemies.  

### **Task:**  
1. Modify the `Player` class so that:  
   - The player **gains points** when reaching an enemy’s position.  
2. Implement a `ScoreManager` class that:  
   - Stores the score.  
   - Saves the **highest score** in `highscore.txt`.  
3. Ensure that when the game ends, it writes the **highest score** to the file.  

💡 **Hint:** Use `FileWriter` to save the high score.

🔹 **Scaffolding Code:**  
```java
import java.io.*;

public class ScoreManager {
    private int highScore;

    public void saveHighScore(int score) {
        try (FileWriter writer = new FileWriter("highscore.txt")) {
            writer.write(String.valueOf(score));
        } catch (IOException e) {
            System.out.println("Error saving high score.");
        }
    }
}
```

---

## 🎨 **Exercise 6: Adding Creative Features**  
Now that the core mechanics are in place, let’s **enhance** the game with creative elements!  

### **Task:**  
1. Add new **enemy types** with different behaviors.  
2. Introduce a **power-up system** (e.g., speed boost, temporary invincibility).  
3. Implement a **simple graphical representation** using `ASCII` characters or a basic GUI.  

💡 **Hint:** Experiment with `JFrame` or `ASCII art` for visualization.  

🔹 **Example ASCII Grid Representation:**  
```
P  .  .  .  E  
.  .  .  .  .  
.  E  .  .  .  
```

---

## 🎯 **Submission Guidelines**  
- Submit your **Java source files** with comments explaining your logic.  
- Include a **README.md** explaining how to run your game.  
- Optional: Submit a short **screen recording** of gameplay.  

---

## 🚀 **Bonus Challenge**  
- Implement **enemy movement** to make the game more dynamic.  
- Load **level configurations** from a file instead of hardcoding them.  

---

## 🎉 **Conclusion**  
By completing this task, you have learned how to:  
✅ **Use file data** to create game objects dynamically.  
✅ **Design and implement** well-structured Java classes.  
✅ **Think creatively** to make gameplay engaging.  

Now, bring your game to life and have fun coding! 🚀🎮

# **Exercise 1: Understanding File-Based Object Instantiation**  

## **Objective**  
Before writing code, it is crucial to understand how **file-based data** enables dynamic object instantiation. This exercise explores different file formats, parsing techniques, and their application in game development.  

### **Task 1: Research File Formats**  
Research and briefly describe the following file formats in **game data storage**:  
- **CSV (Comma-Separated Values)**  
- **JSON (JavaScript Object Notation)**  
- **TXT (Plain Text)**  

For each format, explain:  
1. How the data is structured.  
2. Advantages and disadvantages of using it for storing game data (e.g., enemy positions, player stats).  

### **Task 2: Explain Dynamic Object Creation**  
Consider how a game might load **enemy positions, player stats, or level configurations** from a file instead of hardcoding them. Write a short explanation (4-5 sentences) on:  
- Why file-based instantiation is useful in game development.  
- How it improves flexibility and scalability.  

### **Task 3: Parsing Techniques in Java**  
Java provides multiple ways to read and process file data. Research and compare the following:  
- `Scanner`  
- `BufferedReader`  

Write a short paragraph on:  
- How these classes work and their differences.  
- When you would use each in a game.  

💡 **Hint:** Think about **efficiency** when handling large files!  

---

# **Exercise 2: Designing the Game Classes**  

## **Objective**  
A well-structured game requires properly designed **classes**. This exercise focuses on identifying class responsibilities and designing a **blueprint** for the game's architecture.  

### **Task 1: Identify Class Responsibilities**  
Define the responsibilities of the following classes:  
- **`Player`**: Tracks position and movement, updates score.  
- **`Enemy`**: Stores location, interacts with the player.  
- **`Game`**: Manages game logic, loads data from files.  
- **`ScoreManager`**: Tracks and saves high scores.  

For each class, write **a short 2-3 sentence description** of its **role and key methods**.  

### **Task 2: Draw a UML Diagram**  
Create a **simple UML diagram** (or a text-based class blueprint) to illustrate the relationships between these classes. If you are unfamiliar with UML, use the following format:  

```
Class: Player  
- int x, y  
- int score  
+ moveUp()  
+ moveDown()  
+ increaseScore(int points)  
```  

### **Task 3: Using Inheritance or Interfaces**  
To improve the design, we can use **inheritance** or **interfaces**. Write a short paragraph explaining:  
- How polymorphism could be applied (e.g., making `Enemy` an abstract class with multiple enemy types).  
- How using an interface like `Movable` could improve flexibility.  

💡 **Hint:** Think about **code reuse** and **extensibility** when designing a game.  

---

These exercises will prepare you for implementing the game logic in the next steps! 🚀

# **🚀 Exercises 3 & 4: Implementing Core Game Mechanics**
Now that you've designed the class structure in Exercises 1 & 2, it's time to **bring the game to life** by implementing the `Player` class and dynamically loading `Enemy` objects from a file.

These exercises will **bridge the gap between theory and implementation**, preparing you for the more complex coding tasks in Exercises 5 & 6.

---

# **🏃 Exercise 3: Implementing the Player Class**  

## **Objective**  
The `Player` class will handle **movement** and **scoring**. You will implement methods that allow the player to move and interact with other game objects.

### **Task 1: Implement the `Player` Class**  
1. Define the `Player` class with the following attributes:
   - `x, y` → Representing the **player's position**.
   - `score` → The player's **current score**.
2. Implement methods for **player movement**:
   - `moveUp()`, `moveDown()`, `moveLeft()`, `moveRight()`
   - Ensure movement updates the `x, y` coordinates correctly.
3. Add a method to **increase the score** when the player reaches an enemy position.

💡 **Hint:** Movement should simply adjust the `(x, y)` coordinates.  
Example: Moving **left** decreases `x`, moving **up** decreases `y`.

### **Scaffolding Code:**  
```java
public class Player {
    private int x, y;
    private int score;

    public Player(int startX, int startY) {
        this.x = startX;
        this.y = startY;
        this.score = 0;
    }

    public void moveUp() { 
        // Implement movement logic
    }

    public void moveDown() { 
        // Implement movement logic
    }

    public void moveLeft() { 
        // Implement movement logic
    }

    public void moveRight() { 
        // Implement movement logic
    }

    public void increaseScore(int points) {
        // Implement scoring logic
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getScore() { return score; }
}
```

---

### **Task 2: Testing Player Movement**
To ensure that movement works, write a **test program** that:
1. **Creates a Player object** at an initial position (e.g., `0,0`).
2. Moves the player in different directions.
3. Prints the updated `(x, y)` position after each movement.

💡 **Hint:** Use `System.out.println(player.getX() + ", " + player.getY());` to check position changes.

---

# **👾 Exercise 4: Loading Enemies from a File**  

## **Objective**  
Enemies should be **dynamically loaded from a file** instead of being hardcoded. This will allow the game to have multiple levels and configurations.  

### **Task 1: Create the `Enemy` Class**  
1. Define an `Enemy` class with:
   - `x, y` → Representing the **enemy’s position**.
2. Implement a constructor that **initializes enemy positions**.
3. Add `getX()` and `getY()` methods to retrieve enemy coordinates.

💡 **Hint:** Enemies don’t need movement yet—just their positions.

### **Scaffolding Code:**  
```java
public class Enemy {
    private int x, y;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }
}
```

---

### **Task 2: Load Enemies from a File**  
1. Create a **text file (`enemies.txt`)** with enemy positions:  
   ```
   5,10
   15,20
   25,30
   ```
2. Implement a method in `Game` to **read this file** and create `Enemy` objects.
3. Store these objects in a `List<Enemy>`.

💡 **Hint:** Use `BufferedReader` or `Scanner` to read the file line by line.

### **Scaffolding Code:**  
```java
import java.io.*;
import java.util.*;

public class Game {
    private List<Enemy> enemies = new ArrayList<>();

    public void loadEnemiesFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                int x = Integer.parseInt(parts[0]);
                int y = Integer.parseInt(parts[1]);
                enemies.add(new Enemy(x, y));
            }
        } catch (IOException e) {
            System.out.println("Error reading enemy file: " + e.getMessage());
        }
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }
}
```

---

### **Task 3: Test Enemy Loading**
Write a **test program** that:
1. Calls `loadEnemiesFromFile("enemies.txt")`.
2. Prints out all enemy positions to ensure they are **loaded correctly**.

💡 **Hint:** Use a loop to print each enemy’s coordinates.

---

## **🔗 Connecting Exercises 3 & 4**
Now that you can **move the player** and **load enemies dynamically**, consider:
- How player movement could **interact with enemies**.
- How you might **check for collisions** between the player and enemies.

---

## **🎯 Submission Guidelines**
- Submit your **Java source files** with comments explaining your logic.
- Include a **text file (`enemies.txt`)** with sample enemy positions.
- Submit a **README.md** explaining how to test your code.

---

## **🚀 What’s Next?**
In **Exercise 5**, you’ll implement **scoring** and detect when the player reaches an enemy. Stay tuned! 🎮

# 🚀 Exercises 5 & 6: Implementing Scoring and Creative Enhancements

Now that you have implemented **player movement** and dynamically **loaded enemies from a file**, it's time to **finalize the core mechanics** of the game!  

In **Exercise 5**, you will implement the **scoring system**, detect when the player reaches an enemy, and save the **high score** to a file.  

In **Exercise 6**, you will **enhance** the game by adding **different types of enemies, power-ups, and a simple visual representation**.

By completing these exercises, you will **tie all previous steps together** and create a functional, engaging game. 🎮🚀  

---

# **🏆 Exercise 5: Implementing the Scoring System**  

## **Objective**  
The game should track and update the **player’s score** when interacting with enemies. Additionally, the **high score** should be saved to a file so that it persists between game sessions.  

### **Task 1: Detect Player-Enemy Collisions**  
1. Modify the `Game` class to check if the **player's position matches an enemy's position**.
2. If a collision is detected:
   - The player **gains points** (e.g., `+10` points per enemy).
   - The enemy is **removed** from the game.  

💡 **Hint:** Use a loop to check if the player's `(x, y)` position matches any enemy's `(x, y)`.  

### **Scaffolding Code:**  
```java
public void checkForCollisions(Player player) {
    Iterator<Enemy> iterator = enemies.iterator();
    while (iterator.hasNext()) {
        Enemy enemy = iterator.next();
        if (player.getX() == enemy.getX() && player.getY() == enemy.getY()) {
            player.increaseScore(10); // Award points
            iterator.remove(); // Remove enemy from the list
        }
    }
}
```

---

### **Task 2: Implement the `ScoreManager` Class**  
To keep track of scores, create a `ScoreManager` class that:
1. Stores the **current score** and **high score**.
2. Saves the **highest score** to a file (`highscore.txt`).
3. Loads the previous **high score** when the game starts.

💡 **Hint:** Use `FileWriter` to write the high score to a file.

### **Scaffolding Code:**  
```java
import java.io.*;

public class ScoreManager {
    private int highScore = 0;

    public ScoreManager() {
        loadHighScore();
    }

    public void saveHighScore(int score) {
        if (score > highScore) {
            highScore = score;
            try (FileWriter writer = new FileWriter("highscore.txt")) {
                writer.write(String.valueOf(highScore));
            } catch (IOException e) {
                System.out.println("Error saving high score.");
            }
        }
    }

    public void loadHighScore() {
        try (BufferedReader reader = new BufferedReader(new FileReader("highscore.txt"))) {
            highScore = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println("No previous high score found.");
        }
    }

    public int getHighScore() { return highScore; }
}
```

---

### **Task 3: Test the Scoring System**  
1. Modify the **game loop** to:  
   - Continuously check for **collisions** between player and enemies.  
   - Update and **display the player’s score** after each move.  
   - Save the **high score** when the game ends.  

2. Run a simulation where the **player moves to an enemy's position** and gains points.  

💡 **Hint:** Print the score after every move to ensure it updates correctly.  

---

### **Task 4: Handling Game Over**  
1. Define **game over conditions** (e.g., when all enemies are defeated).  
2. Display the **final score and high score**.  
3. Save the **high score** before exiting.  

💡 **Hint:** You can check if `enemies.isEmpty()` to detect when the game ends.  

---

## **🔗 Connecting Exercise 5 to the Game**
At this point, you have:  
✅ **Player movement**  
✅ **Dynamic enemy loading**  
✅ **Scoring system with high scores**  

Now, it's time to **make the game more interactive and fun!** 🎮   

---

# **🎨 Exercise 6: Adding Creative Features**  

## **Objective**  
Now that the core game is functional, let’s **enhance** it with creative elements! In this step, you will introduce **different enemy types, power-ups, and a simple visual representation**.

---

### **Task 1: Introduce Different Enemy Types**  
1. Modify the `Enemy` class to support **different enemy types**:
   - **BasicEnemy** (default behavior)
   - **FastEnemy** (moves randomly)
   - **StrongEnemy** (requires **two hits** to defeat)  

2. Use **inheritance** to create a base `Enemy` class and extend it for different behaviors.

💡 **Hint:** You can use an **abstract class** for `Enemy` and override methods in subclasses.

### **Scaffolding Code:**  
```java
public abstract class Enemy {
    protected int x, y;

    public Enemy(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public abstract void interact(Player player);
}
```

```java
public class BasicEnemy extends Enemy {
    public BasicEnemy(int x, int y) {
        super(x, y);
    }

    @Override
    public void interact(Player player) {
        player.increaseScore(10);
    }
}
```

```java
public class StrongEnemy extends Enemy {
    private int health = 2;

    public StrongEnemy(int x, int y) {
        super(x, y);
    }

    @Override
    public void interact(Player player) {
        health--;
        if (health == 0) {
            player.increaseScore(20); // Strong enemy gives more points
        }
    }
}
```

---

### **Task 2: Implement Power-Ups**  
1. Create a `PowerUp` class that appears at random locations.
2. When the player collects a power-up:
   - **Speed Boost** → Allows **two moves per turn** for 5 turns.
   - **Shield** → Prevents **enemy interactions** for 3 turns.

💡 **Hint:** Store an `activeTurns` counter to track power-up effects.

### **Scaffolding Code:**  
```java
public class PowerUp {
    private int x, y;
    private String type;

    public PowerUp(int x, int y, String type) {
        this.x = x;
        this.y = y;
        this.type = type;
    }

    public boolean is