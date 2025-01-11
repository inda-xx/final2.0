![Task Image](images/task_image_20250111_162603.png)

### Task: Build a Simple 2D Game Application

**Goal**: In this task, you will create a simple 2D game application in Java that includes **player movement**, a **scoring system**, and **enemy interactions**. The game will load data about game objects (e.g., enemies, obstacles, and scoring items) from a file, use well-designed classes to represent the game entities, and encourage creative features to enhance the gameplay experience.

The task is divided into smaller steps, aligning with the weekly learning goals. You will progressively implement key functionalities, ensuring you gain practical experience in **Using Data from Files to Instantiate Objects**, **Designing Classes**, and **Programming Creatively**.

---

### Game Description

The game is a simple **top-down survival game** where the player moves around the screen, avoiding enemies and collecting coins for points. The player scores by picking up coins while avoiding collisions with enemies. If the player collides with an enemy, the game ends.

---

### Step-by-Step Instructions

---

#### **Step 1: Designing the Classes**  
*Learning Goal: Designing Classes*

Design the core classes for your game. Each class should represent a specific entity or concept in the game. Below are the suggested classes and their responsibilities:  
- **Player**: Represents the player character. Responsible for movement and tracking the player's score.  
- **Enemy**: Represents enemies that move randomly on the screen.  
- **Coin**: Represents collectible items that increase the player's score.  
- **GameWorld**: Manages the game state, including all entities, and ensures interactions between them (e.g., collisions).  

**Exercise**:  
1. Start by creating a UML diagram (on paper or software) for the game. Define the fields and methods for each class.  
   - Example for the `Player` class:
     ```java
     public class Player {
         private int x, y; // Player position
         private int score; // Player's score

         public Player(int startX, int startY) {
             this.x = startX;
             this.y = startY;
             this.score = 0;
         }

         public void move(String direction) {
             // Update x, y based on direction
         }

         public void increaseScore(int points) {
             this.score += points;
         }
         
         public int getScore() {
             return score;
         }
     }
     ```

2. Implement these classes in Java with **fields and methods** based on your design.

---

#### **Step 2: Loading Game Data from a File**  
*Learning Goal: Using Data from Files to Instantiate Objects*

The game should dynamically load game objects (e.g., enemies and coins) from a file. This allows flexibility and demonstrates reading and using data from external sources.  

1. **Create a data file** (`game_data.txt`) with the following format:
   ```
   ENEMY,50,100
   ENEMY,200,300
   COIN,150,250
   COIN,300,400
   ```
   - Each line represents an object. The first value indicates the type (`ENEMY` or `COIN`), followed by the x and y coordinates.

2. **Read the file** in your `GameWorld` class and instantiate objects dynamically:
   - Use `BufferedReader` to read the file line by line.
   - Parse each line and extract the object type and position.
   - Create and store the corresponding objects in a list.

3. **Example Code Snippet**:
   ```java
   import java.io.*;
   import java.util.*;

   public class GameWorld {
       private List<Enemy> enemies = new ArrayList<>();
       private List<Coin> coins = new ArrayList<>();

       public void loadGameData(String fileName) {
           try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
               String line;
               while ((line = br.readLine()) != null) {
                   String[] parts = line.split(",");
                   String type = parts[0];
                   int x = Integer.parseInt(parts[1]);
                   int y = Integer.parseInt(parts[2]);

                   if (type.equals("ENEMY")) {
                       enemies.add(new Enemy(x, y));
                   } else if (type.equals("COIN")) {
                       coins.add(new Coin(x, y));
                   }
               }
           } catch (IOException e) {
               System.out.println("Error reading file: " + e.getMessage());
           }
       }

       public List<Enemy> getEnemies() {
           return enemies;
       }

       public List<Coin> getCoins() {
           return coins;
       }
   }
   ```
4. Test your file loading by printing the objects after loading them.

---

#### **Step 3: Implementing Gameplay**  
*Learning Goal: Programming Creatively*

Add functionality for **player movement**, **collisions**, and a **scoring system**.

1. **Player Movement**:  
   - Allow the player to move up, down, left, and right using keys (e.g., WASD or arrow keys).  
   - Use a simple game loop to poll for user input and update the player's position.  
     Example:  
     ```java
     public void move(String direction) {
         switch (direction) {
             case "UP": y -= 10; break;
             case "DOWN": y += 10; break;
             case "LEFT": x -= 10; break;
             case "RIGHT": x += 10; break;
         }
     }
     ```

2. **Scoring System**:  
   - Check for collisions between the player and coins. If a coin is collected, remove it from the game and increase the player's score.  
   Example:  
   ```java
   public void checkCoinCollection(Player player) {
       Iterator<Coin> iterator = coins.iterator();
       while (iterator.hasNext()) {
           Coin coin = iterator.next();
           if (player.getX() == coin.getX() && player.getY() == coin.getY()) {
               player.increaseScore(10);
               iterator.remove();
           }
       }
   }
   ```

3. **Enemy Interactions**:  
   - Check for collisions between the player and enemies. If they collide, end the game.  
   Example:  
   ```java
   public boolean checkEnemyCollision(Player player) {
       for (Enemy enemy : enemies) {
           if (player.getX() == enemy.getX() && player.getY() == enemy.getY()) {
               return true; // Game over
           }
       }
       return false;
   }
   ```

4. **Game Loop**:  
   - Create a simple game loop to continuously update and render the game state.  
   - Example:  
     ```java
     while (!gameOver) {
         player.move(inputDirection); // Get input direction from user
         gameWorld.checkCoinCollection(player);
         gameOver = gameWorld.checkEnemyCollision(player);
         render(); // Update the game display
     }
     ```

---

#### **Step 4: Adding Creative Features**  
*Learning Goal: Programming Creatively*

Enhance your game by adding creative and unique features. Here are some ideas:
-

### Exercise 1: **Theoretical Foundations of File I/O and Object Instantiation**  
**Objective**: Understand the concepts of reading data from files and using it to create objects in object-oriented programming.

1. **File I/O Basics (Short Answer Questions)**  
    - What is the purpose of using external files (e.g., `.txt`, `.csv`, or `.json`) in programming? Provide at least two examples of real-world applications that use external data files.  
    - Explain the difference between `FileReader` and `BufferedReader` in Java. Why is `BufferedReader` generally preferred for reading text files?  
    - In the context of game development, why might it be useful to load game objects like enemies and coins from a file instead of hardcoding them in the program?

2. **Data Parsing and Object Instantiation (Scenario-Based Questions)**  
    - Suppose you have a file containing the following data:  
      ```
      ENEMY,100,200
      COIN,300,400
      ENEMY,500,600
      ```
      - How would you parse this file to determine the type of each object and its position?  
      - What key steps are necessary to ensure that the data parsed from the file is valid (e.g., handling incorrect data formats or missing values)?  
    - Imagine you are writing a program to read this file and create `Enemy` and `Coin` objects dynamically. Describe the process step by step, focusing on how you would handle errors like missing files, incorrect data formats, or unexpected object types.

3. **Exception Handling in File I/O (Code Analysis)**  
    Below is a snippet of code for reading a file and instantiating objects:
    ```java
    public void loadGameData(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0];
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);

                if (type.equals("ENEMY")) {
                    // Instantiate Enemy
                } else if (type.equals("COIN")) {
                    // Instantiate Coin
                }
            }
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Data format error: " + e.getMessage());
        }
    }
    ```
    - Identify the purpose of each `try-catch` block in the code.  
    - How does the `try-with-resources` statement ensure better resource management compared to a traditional `try` block?  
    - Propose at least one improvement to this code to handle additional potential errors during file I/O.

---

### Exercise 2: **Principles of Class Design in Game Development**  
**Objective**: Develop a strong understanding of designing object-oriented classes for a game application.

1. **Understanding Class Responsibilities (Short Answer Questions)**  
    - Why is it important to identify clear responsibilities for each class in a program?  
    - For the following entities in the game (`Player`, `Enemy`, `Coin`, `GameWorld`), describe their general responsibilities in one or two sentences.  
    - What is the significance of encapsulation in class design? How does it help in creating maintainable and scalable programs?  

2. **Cohesion and Coupling (Conceptual Questions)**  
    - Define **cohesion** and **coupling** in the context of software design. Provide examples of high cohesion and low coupling in the context of the game being developed.  
    - Suppose the `GameWorld` class directly accesses and modifies the `x` and `y` fields of the `Player` class without using getter or setter methods. How does this design choice affect cohesion and coupling? Suggest an alternative approach to improve the design.

3. **Designing the `Player` Class (Open-Ended Design Question)**  
    - The `Player` class needs to handle movement, scoring, and position tracking. Below are three potential fields for the class:  
      ```
      private int x, y;
      private int score;
      private String direction;
      ```
      - Propose a set of methods for this class that align with its responsibilities. Clearly define their purpose and any parameters they take.  
      - Why is it important to separate the logic for updating the player's position and the logic for handling collisions into different methods? How does this improve the design of the `Player` class?  

4. **Collaborative Class Design (Scenario-Based Questions)**  
    - Your game will have multiple `Enemy` and `Coin` objects, which interact with the `Player`.  
      - How would you structure the `GameWorld` class to ensure it can efficiently handle interactions between these objects (e.g., detecting collisions or updating positions)?  
      - Describe how you would organize the relationships between the `Player`, `Enemy`, and `Coin` classes to ensure high cohesion and low coupling.

5. **UML Diagram Exercise**  
    - Create a UML diagram for the `Player`, `Enemy`, `Coin`, and `GameWorld` classes. Include the following:  
      - Fields and methods for each class.  
      - Relationships between the classes (e.g., aggregation, composition, or association).  
    - Reflect on your diagram:  
      - Are there any potential violations of encapsulation or principles of class design?  
      - How might you improve the relationships between classes to make the system more modular and extensible?

---

### Deliverables for Exercises 1 & 2:
1. Written responses to all short answer and conceptual questions.  
2. A UML diagram for the game classes, either hand-drawn and scanned or created using software tools like Lucidchart, draw.io, or StarUML.  
3. Reflection notes on how the principles learned in these exercises will guide your implementation in the coding tasks ahead.  

---

These exercises will help students build the theoretical foundation necessary for implementing the game application while also fostering critical thinking about class design and file I/O principles.

### Exercise 3: **Implementing Basic Game Logic and File Integration**

**Objective**: Transition from theoretical understanding to practical coding by implementing key game elements: class instantiation, file reading, and basic interactions.

---

#### **Part 1: Implementing File-Driven Object Instantiation**
In this exercise, you will implement the functionality for reading game data from a file and creating objects dynamically, as outlined in Exercise 2. You will also validate your code by printing out the loaded objects.

**Instructions**:
1. **Set Up Your Project Environment**:
   - Create a Java project with the `Player`, `Enemy`, `Coin`, and `GameWorld` classes.
   - Include the `game_data.txt` file in the root directory of your project or a designated `resources` folder.

2. **Enhance the `GameWorld` Class**:
   - Implement the `loadGameData(String fileName)` method to read the data from `game_data.txt` and instantiate `Enemy` and `Coin` objects dynamically.
   - Use exception handling to manage potential errors, such as missing files or invalid data formats.
   - Store the instantiated objects in `ArrayList`s for `enemies` and `coins`.

3. **Exercise Requirements**:
   - Validate the data after reading it to ensure all required fields (type, x, y) are present and correctly formatted.
   - Print out the list of `Enemy` and `Coin` objects after loading them to confirm the data has been read successfully.

**Example File Format** (`game_data.txt`):
```
ENEMY,50,100
COIN,150,250
ENEMY,300,400
COIN,400,500
```

**Testing**:
- Write a `main` method in a test class to initialize a `GameWorld` object, call the `loadGameData` method, and print loaded objects to verify correctness.

---

#### **Part 2: Basic Interactions Between Classes**
Now that you have loaded game objects, implement basic functionality for the `Player` class and integrate it with `GameWorld`.

**Player Implementation**:
1. Add the following methods to the `Player` class:
   - `move(String direction)`: Updates the player’s position based on movement (e.g., up, down, left, right).
   - `increaseScore(int points)`: Increases the player’s score when a coin is collected.
   - `getPosition()`: Returns the player’s current position as an `(x, y)` coordinate pair.

2. Update the `GameWorld` class to track the `Player` object:
   - Add a `Player` field to the `GameWorld` class.
   - Create a method to initialize the player at a starting position (e.g., `(0, 0)`).
   - Write a `printPlayerStatus()` method to display the player’s position and score.

**Testing**:
- In your `main` method, initialize a `Player` object and call the `move` method with different directions.
- Print the player's position after each move to ensure it updates correctly.

**Output Example**:
```
Player starts at (0, 0)
Player moves UP: (0, -10)
Player moves RIGHT: (10, -10)
```

---

### Exercise 4: **Simulating Game Mechanics**

**Objective**: Build upon Exercise 3 by implementing real-time game mechanics, such as player movement, coin collection, and enemy interactions.

---

#### **Part 1: Simulating Player-Coin Interactions**
Add functionality for detecting and handling collisions between the player and coins.

**Instructions**:
1. Add a `checkCoinCollision()` method in the `GameWorld` class:
   - Iterate through the `coins` list.
   - If the player's position matches a coin's position, remove the coin from the list and increase the player's score by 10 points.

2. Enhance the `GameWorld` class to display the state of the game:
   - Add a `printGameState()` method to display the player's score and the number of remaining coins.

3. Test the functionality:
   - Simulate the player moving to a position where a coin is located.
   - Verify that the coin is removed from the list and the player's score is updated.

**Example Workflow**:
1. Player starts at `(0, 0)` with 0 points.
2. Player moves to `(150, 250)` and collects a coin.
3. Output:
   ```
   Coin collected at (150, 250)!
   Player Score: 10
   Remaining Coins: 3
   ```

---

#### **Part 2: Simulating Player-Enemy Interactions**
Extend the game logic to handle collisions between the player and enemies.

**Instructions**:
1. Add a `checkEnemyCollision()` method in the `GameWorld` class:
   - Iterate through the `enemies` list.
   - If the player's position matches an enemy's position, end the game.

2. Modify the `GameWorld` game loop:
   - Continuously check for player-enemy collisions.
   - If a collision occurs, print a "Game Over" message and exit the loop.

3. Test the functionality:
   - Simulate the player moving to a position where an enemy is located.
   - Verify that the game ends and displays the appropriate message.

**Example Workflow**:
1. Player starts at `(0, 0)` with 0 points.
2. Player moves to `(50, 100)` and collides with an enemy.
3. Output:
   ```
   Game Over! The player collided with an enemy at (50, 100).
   ```

---

#### **Part 3: Building a Simple Game Loop**
Implement a basic game loop to simulate real-time gameplay.

**Instructions**:
1. Create a `startGame()` method in the `GameWorld` class:
   - Continuously prompt the user for input to move the player (`UP`, `DOWN`, `LEFT`, `RIGHT`).
   - After each move:
     - Check for coin collection.
     - Check for enemy collision.
     - Print the current game state.

2. Use a `Scanner` to read player input and update their position:
   ```java
   Scanner scanner = new Scanner(System.in);
   while (!gameOver) {
       System.out.print("Enter move (UP/DOWN/LEFT/RIGHT): ");
       String direction = scanner.nextLine().toUpperCase();
       player.move(direction);
       checkCoinCollision();
       if (checkEnemyCollision()) {
           gameOver = true;
           System.out.println("Game Over!");
       }
       printGameState();
   }
   ```

3. Test the game loop:
   - Use the `game_data.txt` file to load initial objects.
   - Simulate gameplay by entering movement commands.

---

#### **Deliverables for Exercises 3 & 4**:
1. **Code for Exercise 3**:
   - `Player` and `GameWorld` classes with implemented methods for file reading, object instantiation, and basic interactions.
2. **Code for Exercise 4**:
   - Extended functionality for coin collection, enemy collisions, and the game loop.
3. **Test Cases**:
   - Include

### Exercise 5: **Enhancing the Game with Advanced Features**

**Objective**: Expand your game by implementing advanced features such as enemy movement, boundary detection, and pausing/resuming the game. These features will require integrating concepts from previous exercises while introducing slightly more complexity in logic and interaction.

---

#### **Part 1: Adding Enemy Movement**
Currently, enemies remain stationary. In this part, you will implement random movement for enemies, making the game more dynamic and challenging.

**Instructions**:
1. Modify the `Enemy` class to include a `move()` method:
   - Randomly adjust the enemy's `x` and `y` positions within a defined range (e.g., -10 to 10 units per move).
   - Ensure that enemies do not move outside the game boundary (e.g., screen size of 500x500).

   Example:
   ```java
   public void move() {
       Random random = new Random();
       int dx = random.nextInt(21) - 10; // Random movement between -10 and 10
       int dy = random.nextInt(21) - 10;

       x = Math.max(0, Math.min(500, x + dx)); // Ensure x stays within 0 to 500
       y = Math.max(0, Math.min(500, y + dy)); // Ensure y stays within 0 to 500
   }
   ```

2. Update the `GameWorld` class:
   - Add a method `moveEnemies()` that iterates through all enemies and calls their `move()` method.
   - Integrate `moveEnemies()` into the game loop so that enemies move after each player action.

3. Test the functionality:
   - Run the game and observe enemy movements after each player action.
   - Verify that enemies stay within the defined boundaries.

---

#### **Part 2: Implementing Game Boundaries**
Ensure that the player cannot move outside the game boundary.

**Instructions**:
1. Modify the `Player` class:
   - Update the `move()` method to prevent the player from moving outside the defined game area (e.g., 500x500).

   Example:
   ```java
   public void move(String direction) {
       switch (direction) {
           case "UP": y = Math.max(0, y - 10); break;
           case "DOWN": y = Math.min(500, y + 10); break;
           case "LEFT": x = Math.max(0, x - 10); break;
           case "RIGHT": x = Math.min(500, x + 10); break;
       }
   }
   ```

2. Test the functionality:
   - Attempt to move the player beyond the boundary and verify that their position is constrained.

---

#### **Part 3: Adding Pause and Resume Functionality**
Allow the player to pause and resume the game at any time.

**Instructions**:
1. Update the game loop in the `GameWorld` class:
   - Add a `paused` flag to track whether the game is currently paused.
   - Allow the player to enter a special command (e.g., `PAUSE`) to toggle the `paused` state.

   Example:
   ```java
   while (!gameOver) {
       System.out.print("Enter move (UP/DOWN/LEFT/RIGHT/PAUSE): ");
       String input = scanner.nextLine().toUpperCase();

       if (input.equals("PAUSE")) {
           paused = !paused;
           System.out.println(paused ? "Game Paused" : "Game Resumed");
           continue;
       }

       if (!paused) {
           player.move(input);
           moveEnemies();
           checkCoinCollision();
           if (checkEnemyCollision()) {
               gameOver = true;
               System.out.println("Game Over!");
           }
           printGameState();
       }
   }
   ```

2. Test the functionality:
   - Pause the game during gameplay and verify that no objects move or interact while paused.
   - Resume the game and ensure that gameplay continues as expected.

---

#### Deliverables for Exercise 5:
1. Updated `Enemy` and `Player` classes with movement constraints.
2. Updated `GameWorld` class with `moveEnemies()` and pause/resume functionality.
3. Test cases demonstrating enemy movement, boundary enforcement, and pause/resume behavior.

---

### Exercise 6: **Polishing and Expanding the Game with Creative Features**

**Objective**: Finalize the game by implementing additional gameplay mechanics and polishing the user experience. This exercise encourages creative thinking and problem-solving while consolidating all previously learned concepts.

---

#### **Part 1: Adding Power-Ups**
Introduce a new collectible type, "Power-Up," that temporarily enhances the player's abilities (e.g., invincibility, faster movement).

**Instructions**:
1. Create a new `PowerUp` class:
   - Add fields for the type of power-up (e.g., "INVINCIBILITY", "SPEED").
   - Include fields for position (`x`, `y`) and duration (e.g., 5 seconds).

   Example:
   ```java
   public class PowerUp {
       private String type;
       private int x, y;
       private int duration;

       public PowerUp(String type, int x, int y, int duration) {
           this.type = type;
           this.x = x;
           this.y = y;
           this.duration = duration;
       }

       public String getType() {
           return type;
       }

       public int getX() {
           return x;
       }

       public int getY() {
           return y;
       }

       public int getDuration() {
           return duration;
       }
   }
   ```

2. Update the `game_data.txt` file:
   - Add entries for power-ups, e.g.:
     ```
     POWER_UP,250,250,INVINCIBILITY,5
     ```

3. Modify the `GameWorld` class:
   - Add a new list to store `PowerUp` objects.
   - Update the `loadGameData()` method to parse and instantiate `PowerUp` objects.

4. Implement power-up effects:
   - If the player collects an "INVINCIBILITY" power-up, make them immune to enemy collisions for the specified duration.
   - If the player collects a "SPEED" power-up, double their movement speed for the specified duration.

5. Test the functionality:
   - Ensure that power-ups are instantiated correctly and their effects are applied when collected.

---

#### **Part 2: Adding a Timer and Win Condition**
Introduce a timer and a win condition to give the game a clear goal.

**Instructions**:
1. Add a timer to the `GameWorld` class:
   - Use a `long` field to track the start time of the game.
   - Calculate the elapsed time during each iteration of the game loop.

   Example:
   ```java
   long startTime = System.currentTimeMillis();
   while (!gameOver) {
       long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
       System.out.println("Time Elapsed: " + elapsedTime + " seconds");
   }
   ```

2. Define a win condition:
   - The player wins if