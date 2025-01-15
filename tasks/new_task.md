![Task Image](images/task_image_20250115_012716.png)

### Task: Build a Simple Game Application in Java

**Objective:**  
Your task is to design and implement a simple game application in Java. The game should include three core functionalities:  
1. **Player Movement**: The player should be able to move (e.g., using keyboard inputs).  
2. **Scoring System**: The game should track and display the player's score based on their performance.  
3. **Enemy Interactions**: Enemies should be instantiated dynamically from a file and interact with the player (e.g., reduce score or end the game when the player collides with an enemy).

This task integrates three key programming concepts:  
- Using data from files to instantiate objects.  
- Designing cohesive and reusable classes.  
- Applying creative problem-solving techniques to design and implement game mechanics.

The game should be **text-based** or **console-based** to keep the focus on programming concepts rather than graphics.

---

### **Task Breakdown and Requirements**

#### **1. Using Data from Files to Instantiate Objects**
You will use a file to define enemy properties (e.g., position, speed, and type). The program should read this file, parse its contents, and create enemy objects dynamically.

- **File Format:** Use a simple `.txt` file to store enemy data. For example:
  ```
  enemy1,20,5,speedy
  enemy2,35,3,strong
  ```
  Here:  
  - The first value is the enemy name.  
  - The second value is the starting position.  
  - The third value is the speed or movement rate.  
  - The fourth value is the type of enemy (e.g., "speedy" might move faster than "strong").

- **Steps to implement this:**  
  1. Create a `readEnemiesFromFile(String filename)` method to read and parse the file.  
  2. Use the parsed data to instantiate enemy objects.

**Code Scaffolding (File Reading Example):**
```java
import java.io.*;
import java.util.*;

public class EnemyLoader {
    public static List<Enemy> readEnemiesFromFile(String filename) {
        List<Enemy> enemies = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                int position = Integer.parseInt(parts[1]);
                int speed = Integer.parseInt(parts[2]);
                String type = parts[3];
                enemies.add(new Enemy(name, position, speed, type));
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return enemies;
    }
}
```

---

#### **2. Designing Classes**
You must design a set of classes to represent the game elements (e.g., Player, Enemy, Game). Follow object-oriented principles to ensure the classes are well-structured and maintainable.

- **Class Responsibilities:**  
  1. **Player Class:** Represents the player. Includes fields for position and score, and methods for movement (`moveLeft`, `moveRight`) and scoring (`incrementScore`, `decrementScore`).  
  2. **Enemy Class:** Represents an enemy. Includes fields for position, speed, and type, and a method for movement (`move`).  
  3. **Game Class:** Manages the game loop, interactions between player and enemies, and the overall game state (e.g., score, collisions, and game over).

- **Steps to implement this:**
  1. Start by designing the `Player` and `Enemy` classes with appropriate fields and methods.  
  2. Implement the `Game` class to manage the objects and interactions.  

**Code Scaffolding (Class Design Example):**
```java
// Player.java
public class Player {
    private int position;
    private int score;

    public Player(int startPosition) {
        this.position = startPosition;
        this.score = 0;
    }

    public void moveLeft() {
        position--;
    }

    public void moveRight() {
        position++;
    }

    public void incrementScore(int points) {
        score += points;
    }

    public void decrementScore(int points) {
        score -= points;
    }

    public int getPosition() {
        return position;
    }

    public int getScore() {
        return score;
    }
}

// Enemy.java
public class Enemy {
    private String name;
    private int position;
    private int speed;
    private String type;

    public Enemy(String name, int position, int speed, String type) {
        this.name = name;
        this.position = position;
        this.speed = speed;
        this.type = type;
    }

    public void move() {
        position -= speed; // Enemies move towards the player
    }

    public int getPosition() {
        return position;
    }

    public String getType() {
        return type;
    }
}
```

---

#### **3. Programming Creatively**
This is your chance to get creative and make your game engaging! Use your creativity to:  
- Define how the player interacts with enemies (e.g., scoring, game over conditions).  
- Add special behaviors for different enemy types (e.g., "speedy" moves faster, "strong" requires multiple interactions to defeat).  
- Experiment with additional gameplay mechanics, such as power-ups or random events.

- **Example Gameplay:**  
  The player starts at position `0` and moves left or right using keyboard inputs (`a` for left, `d` for right). Enemies move towards the player. If an enemy reaches the same position as the player, the player loses points or the game ends.

**Code Scaffolding (Game Loop Example):**
```java
import java.util.*;

public class Game {
    private Player player;
    private List<Enemy> enemies;

    public Game(Player player, List<Enemy> enemies) {
        this.player = player;
        this.enemies = enemies;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean isRunning = true;

        while (isRunning) {
            // Display game state
            System.out.println("Player Position: " + player.getPosition() + ", Score: " + player.getScore());
            for (Enemy enemy : enemies) {
                System.out.println("Enemy " + enemy.getType() + " at position " + enemy.getPosition());
            }

            // Player input
            System.out.print("Move (a: left, d: right, q: quit): ");
            String input = scanner.nextLine();
            if (input.equals("a")) {
                player.moveLeft();
            } else if (input.equals("d")) {
                player.moveRight();
            } else if (input.equals("q")) {
                isRunning = false;
            }

            // Update enemies
            for (Enemy enemy : enemies) {
                enemy.move();
                if (enemy.getPosition() == player.getPosition()) {
                    System.out.println("Collision! Enemy " + enemy.getType() + " hit the player!");
                    player.decrementScore(10);
                }


### **Exercise 1: Understanding File I/O and Object Instantiation**

**Objective:**  
To ensure the students grasp the theoretical concepts behind using data from files to instantiate objects.

---

#### **Instructions:**
1. **File I/O Basics:**  
   Research how Java handles file input and output (I/O). Answer the following questions:  
   - What are the main classes in the `java.io` package used for reading files?  
   - What is the difference between `FileReader` and `BufferedReader` in Java?  
   - Why is it important to close file streams after reading or writing data?  

2. **File Parsing Techniques:**  
   Imagine you are working with a file containing the following data:  
   ```
   player1,10,100
   player2,20,150
   ```
   - Describe how you would parse this file to extract the player's name, position, and score into separate variables.  
   - What challenges might arise if the file contains a syntax error or unexpected data format?  

3. **Object Instantiation from File Data:**  
   Consider the following class definition:  
   ```java
   public class GameCharacter {
       private String name;
       private int position;
       private int score;

       public GameCharacter(String name, int position, int score) {
           this.name = name;
           this.position = position;
           this.score = score;
       }

       @Override
       public String toString() {
           return "Name: " + name + ", Position: " + position + ", Score: " + score;
       }
   }
   ```
   - Explain how you would use the file data to create a `GameCharacter` object for each line in the file.  
   - Provide pseudocode or a conceptual outline of the steps involved (no need to write actual Java code).  

4. **Error Handling:**  
   - Why is exception handling important when working with file I/O?  
   - Explain the difference between `IOException` and `FileNotFoundException`.  
   - If a file being read does not exist, what exception would be thrown, and how can the program recover gracefully?

---

#### **Expected Outcome:**  
Students should demonstrate an understanding of file I/O basics, parsing techniques, and the rationale behind using external data to instantiate objects. They should also be familiar with common pitfalls and the importance of exception handling.

---

### **Exercise 2: Principles of Class Design**

**Objective:**  
To help students think critically about designing well-structured classes and understand their responsibilities in an object-oriented program.

---

#### **Instructions:**
1. **Class Responsibilities:**  
   - What is the Single Responsibility Principle (SRP) in object-oriented design?  
   - For the following classes that will be a part of the game application (`Player`, `Enemy`, `Game`), outline their primary responsibilities.  
     - **Player:** What fields and methods should the `Player` class contain? Why?  
     - **Enemy:** What fields and methods should the `Enemy` class contain? Why?  
     - **Game:** What is the role of the `Game` class in managing the overall game?  

2. **Encapsulation and Data Hiding:**  
   - What is encapsulation, and why is it important in class design?  
   - For the `Player` class, identify which fields should be private and which (if any) should be public. Justify your choices.  
   - How would you use getters and setters to control access to the player's score? Provide an example.  

3. **Inheritance and Polymorphism:**  
   - Assume you want to extend the functionality of the `Enemy` class by creating two specific types of enemies: `SpeedyEnemy` and `StrongEnemy`.  
     - What common attributes and behaviors would these subclasses inherit from the `Enemy` class?  
     - What unique attributes or behaviors might each subclass have?  
   - How does polymorphism allow the game to treat all enemies uniformly, regardless of their specific type?  

4. **Design Patterns:**  
   - Research the "Factory Method" design pattern. How could this pattern be used to create `Enemy` objects dynamically based on data read from a file?  
   - Provide a high-level description (no coding required) of how you might implement a factory to generate `Enemy` objects of different types (`SpeedyEnemy`, `StrongEnemy`) based on the `type` field in the file.  

---

#### **Expected Outcome:**  
Students should be able to clearly articulate the principles of class design, including SRP, encapsulation, inheritance, and polymorphism. They should also begin to understand how design patterns like the Factory Method can simplify object creation and improve code maintainability.

---

### **Purpose of Exercises 1 & 2:**
These exercises are designed to build a strong theoretical foundation for the task. Exercise 1 focuses on the file I/O and object instantiation concepts, while Exercise 2 helps students critically analyze and plan their class designs. Both exercises prepare the students for the subsequent coding activities by ensuring they understand the underlying principles before diving into implementation.

### **Exercise 3: File I/O and Object Instantiation (Practical Implementation)**

**Objective:**  
To transition from theory to practice by implementing file reading, parsing, and object instantiation in Java. This exercise will help students understand how to work with files and use their data to dynamically create objects.

---

#### **Instructions:**

1. **Setup Enemy File:**  
   - Create a file named `enemies.txt` in your project directory with the following content:
     ```
     enemy1,25,2,speedy
     enemy2,40,1,strong
     enemy3,15,3,speedy
     ```

2. **Implement the `Enemy` Class:**  
   Copy the `Enemy` class structure provided earlier in Exercise 2. Add a `toString()` method to print the enemy's attributes for debugging purposes:
   ```java
   @Override
   public String toString() {
       return "Enemy{name='" + name + "', position=" + position + ", speed=" + speed + ", type='" + type + "'}";
   }
   ```

3. **Write the `EnemyLoader` Class:**  
   Implement the `EnemyLoader` class with the `readEnemiesFromFile(String filename)` method to:
   - Read the `enemies.txt` file line by line.
   - Parse each line into attributes (`name`, `position`, `speed`, `type`).
   - Create an `Enemy` object for each line and add it to a list.

   **Example Code Skeleton:**
   ```java
   import java.io.*;
   import java.util.*;

   public class EnemyLoader {
       public static List<Enemy> readEnemiesFromFile(String filename) {
           List<Enemy> enemies = new ArrayList<>();
           try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
               String line;
               while ((line = br.readLine()) != null) {
                   String[] parts = line.split(",");
                   String name = parts[0];
                   int position = Integer.parseInt(parts[1]);
                   int speed = Integer.parseInt(parts[2]);
                   String type = parts[3];
                   enemies.add(new Enemy(name, position, speed, type));
               }
           } catch (IOException e) {
               System.out.println("Error reading file: " + e.getMessage());
           }
           return enemies;
       }
   }
   ```

4. **Test File Loading:**  
   - Create a `Main` class with a `main` method to test file loading:
     ```java
     public class Main {
         public static void main(String[] args) {
             List<Enemy> enemies = EnemyLoader.readEnemiesFromFile("enemies.txt");
             for (Enemy enemy : enemies) {
                 System.out.println(enemy);
             }
         }
     }
     ```
   - Run the program to ensure the enemies are correctly loaded and displayed on the console.

5. **Exception Handling:**  
   - Modify the `EnemyLoader` class to handle potential errors gracefully:
     - Print a user-friendly error message if the file is not found.
     - Skip malformed lines in the file and print a warning message.

   **Example:**
   If the file contains the line `enemy4,invalid,2,speedy`, your program should:
   - Skip the line.
   - Display a warning: `Warning: Skipping malformed line: enemy4,invalid,2,speedy`.

---

#### **Expected Outcome:**
- Students will successfully read a file, parse its content, and dynamically create objects using the data.
- They will demonstrate basic error handling and understand the importance of data validation when working with external files.

---

---

### **Exercise 4: Game Class Design and Interaction**

**Objective:**  
To design and implement the `Game` class and integrate the `Player` and `Enemy` classes into a functional game loop. This exercise will help students practice combining multiple classes and handling interactions.

---

#### **Instructions:**

1. **Enhance the `Player` Class:**
   - Add a method to check if the player is at the same position as an enemy:
     ```java
     public boolean isColliding(int enemyPosition) {
         return this.position == enemyPosition;
     }
     ```

2. **Design the `Game` Class:**
   - Implement a basic structure for the `Game` class to:
     - Initialize the player and enemies.
     - Manage the game loop (e.g., process player input, update enemy positions, and check for collisions).
     - End the game when a specific condition is met (e.g., the player's score drops below 0).

   **Code Skeleton:**
   ```java
   import java.util.*;

   public class Game {
       private Player player;
       private List<Enemy> enemies;

       public Game(Player player, List<Enemy> enemies) {
           this.player = player;
           this.enemies = enemies;
       }

       public void start() {
           Scanner scanner = new Scanner(System.in);
           boolean isRunning = true;

           while (isRunning) {
               // Display game state
               System.out.println("Player Position: " + player.getPosition() + ", Score: " + player.getScore());
               for (Enemy enemy : enemies) {
                   System.out.println(enemy);
               }

               // Player input
               System.out.print("Move (a: left, d: right, q: quit): ");
               String input = scanner.nextLine();
               if (input.equals("a")) {
                   player.moveLeft();
               } else if (input.equals("d")) {
                   player.moveRight();
               } else if (input.equals("q")) {
                   isRunning = false;
               }

               // Update enemies
               for (Enemy enemy : enemies) {
                   enemy.move();
                   if (player.isColliding(enemy.getPosition())) {
                       System.out.println("Collision with " + enemy.getType() + "!");
                       player.decrementScore(10);
                   }
               }

               // End game if score drops below 0
               if (player.getScore() < 0) {
                   System.out.println("Game Over! Your score is below 0.");
                   isRunning = false;
               }
           }
           scanner.close();
       }
   }
   ```

3. **Test the Game:**
   - In the `Main` class, initialize a `Player` and load enemies using `EnemyLoader`.
   - Create a `Game` object and call its `start` method to begin the game loop.

   **Example Code in `Main`:**
   ```java
   public class Main {
       public static void main(String[] args) {
           Player player = new Player(0); // Start player at position 0
           List<Enemy> enemies = EnemyLoader.readEnemiesFromFile("enemies.txt");
           Game game = new Game(player, enemies);
           game.start();
       }
   }
   ```

4. **Enhance Gameplay:**
   - Add a scoring system:
     - Player gains 5 points for moving right.
     - Player loses 10 points for colliding with an enemy.
   - Add a "win condition":
     - The player wins if their score reaches 50 points.

5. **Optional Challenge:**  
   - Design a special behavior for

### **Exercise 5: Enhancing the Game with Advanced Features**

**Objective:**  
To build upon the previously implemented game by adding advanced gameplay mechanics and refining the program structure. This will consolidate the students' understanding of object-oriented principles, file I/O, and creative problem-solving.

---

#### **Instructions:**

1. **Enhance the Enemy Class with Behavior:**
   - Add a method to handle interactions when the player collides with an enemy. Depending on the enemy type (`speedy` or `strong`), the interaction should have different effects:
     - **SpeedyEnemy:** The player loses 10 points and the enemy moves to a new random position.
     - **StrongEnemy:** The player loses 20 points, and the enemy remains in the current position.

   **Code Example:**
   ```java
   import java.util.Random;

   public class Enemy {
       private String name;
       private int position;
       private int speed;
       private String type;

       // Existing methods...

       public void handleCollision(Player player) {
           if (type.equals("speedy")) {
               player.decrementScore(10);
               Random random = new Random();
               position = random.nextInt(50); // Move enemy to a new random position
           } else if (type.equals("strong")) {
               player.decrementScore(20);
           }
       }
   }
   ```

2. **Add Power-Ups:**
   - Introduce a new gameplay mechanic: **Power-Ups**.
   - Create a `PowerUp` class with fields for position and type (`"scoreBoost"` or `"shield"`).
     - **ScoreBoost:** Increases the player's score by 15 points.
     - **Shield:** Protects the player from losing points on the next collision.

   **Code Skeleton:**
   ```java
   public class PowerUp {
       private int position;
       private String type;

       public PowerUp(int position, String type) {
           this.position = position;
           this.type = type;
       }

       public int getPosition() {
           return position;
       }

       public String getType() {
           return type;
       }

       public void applyEffect(Player player) {
           if (type.equals("scoreBoost")) {
               player.incrementScore(15);
           } else if (type.equals("shield")) {
               player.activateShield();
           }
       }
   }
   ```

3. **Enhance the Player Class to Support Power-Ups:**
   - Add a `boolean shieldActive` field to the `Player` class. If `shieldActive` is `true`, the player does not lose points on collision. After a single collision, the shield should deactivate.

   **Code Example:**
   ```java
   public class Player {
       private int position;
       private int score;
       private boolean shieldActive;

       public Player(int startPosition) {
           this.position = startPosition;
           this.score = 0;
           this.shieldActive = false;
       }

       public void activateShield() {
           this.shieldActive = true;
       }

       public void decrementScore(int points) {
           if (shieldActive) {
               System.out.println("Shield protected the player from losing points!");
               shieldActive = false;
           } else {
               score -= points;
           }
       }

       // Existing methods...
   }
   ```

4. **Integrate Power-Ups into the Game:**
   - Add a list of `PowerUp` objects to the `Game` class.
   - Randomly generate power-ups on the game board (e.g., at positions 5, 15, 25, etc.).
   - When the player reaches the position of a power-up, it should be removed from the game, and its effect applied to the player.

   **Code Example:**
   ```java
   public class Game {
       private Player player;
       private List<Enemy> enemies;
       private List<PowerUp> powerUps;

       public Game(Player player, List<Enemy> enemies, List<PowerUp> powerUps) {
           this.player = player;
           this.enemies = enemies;
           this.powerUps = powerUps;
       }

       public void checkPowerUpCollision() {
           Iterator<PowerUp> iterator = powerUps.iterator();
           while (iterator.hasNext()) {
               PowerUp powerUp = iterator.next();
               if (player.getPosition() == powerUp.getPosition()) {
                   System.out.println("Power-Up collected: " + powerUp.getType());
                   powerUp.applyEffect(player);
                   iterator.remove(); // Remove the power-up after use
               }
           }
       }

       // Update the game loop to include a call to checkPowerUpCollision
       public void start() {
           // Existing game loop logic...

           checkPowerUpCollision();

           // Continue existing game loop logic...
       }
   }
   ```

5. **Test the Enhanced Game:**
   - Update the `Main` class to create and initialize power-ups. For example:
     ```java
     List<PowerUp> powerUps = Arrays.asList(
         new PowerUp(5, "scoreBoost"),
         new PowerUp(15, "shield"),
         new PowerUp(25, "scoreBoost")
     );
     Game game = new Game(player, enemies, powerUps);
     game.start();
     ```

---

#### **Expected Outcome:**
Students will integrate advanced gameplay mechanics into their game, such as power-ups and enhanced enemy interactions. They will also demonstrate an understanding of how to design and work with new classes in a modular way.

---

---

### **Exercise 6: Game Completion and Refinement**

**Objective:**  
To finalize the game by adding polish, refining gameplay mechanics, and incorporating all learned concepts. This exercise will challenge students to think critically about code structure, user experience, and program robustness.

---

#### **Instructions:**

1. **Add a Game Timer:**
   - Introduce a timer to the game. The game should end after 60 seconds, and the player's final score should be displayed.
   - Use `System.currentTimeMillis()` to track the start and elapsed time.

   **Code Example:**
   ```java
   public void start() {
       long startTime = System.currentTimeMillis();
       long gameDuration = 60000; // 60 seconds
       boolean isRunning = true;

       while (isRunning) {
           long elapsedTime = System.currentTimeMillis() - startTime;
           if (elapsedTime > gameDuration) {
               System.out.println("Time's up! Final Score: " + player.getScore());
               isRunning = false;
               break;
           }

           // Existing game loop logic...

           System.out.println("Time Remaining: " + (gameDuration - elapsedTime) / 1000 + " seconds");
       }
   }
   ```

2. **Enhance Enemy Movement with Randomization:**
   - Modify the `Enemy` class so that enemies occasionally change their speed or direction. For example, every 5 moves, an enemy could randomly increase or decrease its speed by 1.

   **Hint:** Use a counter in the `move()` method to track the number of moves and apply random speed changes periodically.

3. **Add a Leaderboard System:**
   - At