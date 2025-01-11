### Task: Build a Simple Game Application in Java

For this week's assignment, you will design and implement a **simple 2D game application** in Java. The game will allow a player to move around a grid, collect points, and avoid enemies. This task integrates the following key concepts:

- **Using data from files to instantiate game elements (e.g., player, enemies, and game level)**.
- **Designing classes to represent the structure and functionality of the game**.
- **Programming creatively to make the game engaging and functional**.

---

### **Objective**
Your goal is to create a game that has the following core functionalities:
1. **Player Movement**: The player can move up, down, left, or right on a grid using keyboard input.
2. **Scoring System**: The player gains points by collecting items on the grid.
3. **Enemy Interactions**: If the player encounters an enemy, the game ends.
4. **Dynamic Game Configuration**: Game elements such as enemy positions, item locations, and player starting position should be loaded dynamically from an external file.

---

### **Requirements**

1. **Using Data from Files to Instantiate Objects**
   - Design a text-based configuration file (e.g., `gameConfig.txt`) to store the initial positions of the player, enemies, and items in the game grid.
   - Implement file I/O logic to **read and parse the configuration file**, creating objects (e.g., `Player`, `Enemy`, `Item`) based on the data.
   - Handle errors such as missing or corrupted data in the file.

   Example configuration file:
   ```
   Player: 0,0
   Enemy: 3,3
   Enemy: 1,4
   Item: 2,2
   Item: 4,0
   GridSize: 5,5
   ```

   Example snippet to load data:
   ```java
   BufferedReader reader = new BufferedReader(new FileReader("gameConfig.txt"));
   String line;
   while ((line = reader.readLine()) != null) {
       String[] parts = line.split(": ");
       if (parts[0].equals("Player")) {
           String[] coordinates = parts[1].split(",");
           int x = Integer.parseInt(coordinates[0]);
           int y = Integer.parseInt(coordinates[1]);
           Player player = new Player(x, y); // Instantiate player at given position
       }
       // Handle other game elements (Enemy, Item, etc.)
   }
   reader.close();
   ```

2. **Designing Classes**
   - Use **object-oriented design principles** to create well-structured classes for the game.
   - Define at least the following classes:
     - **`Player`**: Represents the player with attributes like position and score.
     - **`Enemy`**: Represents enemies with attributes like position.
     - **`Item`**: Represents collectible items with attributes like position and points.
     - **`Game`**: Manages the game state, grid, and interactions between objects.

   Example class outline:
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
           if (direction.equals("UP")) this.y--;
           else if (direction.equals("DOWN")) this.y++;
           else if (direction.equals("LEFT")) this.x--;
           else if (direction.equals("RIGHT")) this.x++;
       }

       public void addScore(int points) {
           this.score += points;
       }

       // Getters and setters...
   }
   ```

   - Use methods in each class to handle specific behaviors, such as movement, scoring, and detecting collisions.
   - Ensure your classes are **cohesive** and have a clear division of responsibilities.

3. **Programming Creatively**
   - Add **creative elements** to make the game more engaging. For example:
     - Implement a **timer** that counts down and ends the game if the player takes too long.
     - Allow the player to **restart the game** if they lose.
     - Add **different types of enemies or items** with unique behaviors (e.g., moving enemies, bonus items).
   - Experiment with different algorithms to handle game logic, such as collision detection or grid boundary checks.

   Example idea: **Moving Enemies**
   ```java
   public class Enemy {
       private int x;
       private int y;

       public Enemy(int x, int y) {
           this.x = x;
           this.y = y;
       }

       public void moveRandomly(int gridWidth, int gridHeight) {
           int dx = (int)(Math.random() * 3) - 1; // -1, 0, or 1
           int dy = (int)(Math.random() * 3) - 1;
           this.x = Math.max(0, Math.min(gridWidth - 1, this.x + dx));
           this.y = Math.max(0, Math.min(gridHeight - 1, this.y + dy));
       }
   }
   ```

4. **User Input and Feedback**
   - Allow the player to control their movement using keyboard input (e.g., W, A, S, D for up, left, down, right).
   - Display the game grid in the console after each move, showing the player's position, enemy positions, and item locations.
   - Provide feedback when the player collects an item, scores points, or collides with an enemy.

   Example grid display:
   ```
   P . . . .
   . . . E .
   . . I . .
   . . . . .
   . I . . .
   ```

---

### **Scaffolding and Development Plan**

1. **Step 1: Parse Configuration File**
   - Create a sample `gameConfig.txt` file and write code to parse it.
   - Test by printing the loaded objects and their attributes.

2. **Step 2: Design and Implement Classes**
   - Create the `Player`, `Enemy`, `Item`, and `Game` classes.
   - Add basic functionality such as movement, scoring, and collision detection.

3. **Step 3: Implement Game Logic**
   - Write a loop to run the game, processing user input and updating the game state after each move.
   - Display the game grid and provide feedback to the player.

4. **Step 4: Add Creative Features**
   - Experiment with additional features, such as moving enemies, a timer, or bonus items.
   - Refine the game based on your own ideas and testing.

---

### **Submission**
Submit the following by the end of the week:
1. Your well-documented Java code.
2. A sample `gameConfig.txt` file.
3. A short README file explaining how to run the game and what features you implemented.

---

### **Evaluation Criteria**
- **Code Functionality**: Does the game meet the basic requirements (player movement, scoring, enemy interactions)?
- **Class Design**: Are the classes well-designed, cohesive, and

### Exercise 1: Understanding File I/O and Data Parsing for Object Instantiation

#### Objective:
To ensure students understand how to use file I/O to read and parse data from external files, and how this data can be used to dynamically create objects in Java.

---

#### **Theoretical Questions**

1. **File Formats and Parsing:**
   - What are the advantages of using a text-based configuration file to initialize game elements dynamically?
   - Explain the structure of the following configuration file:
     ```
     Player: 1,2
     Enemy: 3,4
     Item: 2,2
     GridSize: 5,5
     ```
     What information does each line convey? How could this file be parsed in Java?

2. **File I/O Classes in Java:**
   - Describe the purpose of the following Java classes used in file handling:
     - `FileReader`
     - `BufferedReader`
   - What is the difference between reading files line by line using `BufferedReader` and reading the entire file at once?

3. **Dynamic Object Creation:**
   - Imagine you want to create an `Enemy` object given the line `Enemy: 3,4` from the configuration file. What steps would you take to:
     1. Extract the `x` and `y` coordinates from the line?
     2. Instantiate the `Enemy` object with these coordinates?

4. **Error Handling:**
   - What types of errors might occur when reading data from a configuration file? Provide examples of how you could handle the following cases in Java:
     - The file does not exist.
     - A line in the file is missing or corrupted (e.g., `Enemy: 3` instead of `Enemy: 3,4`).
     - A line contains invalid data (e.g., `Player: x,y` instead of `Player: 1,2`).

---

#### **Activity**
- Write pseudocode or an algorithm (in plain English or Java-like syntax) for a method that:
  - Reads a configuration file line by line.
  - Parses each line to identify the type of game element (e.g., Player, Enemy, Item).
  - Dynamically creates and stores the corresponding objects in a `List`.

---

#### Expected Outcome:
Students should demonstrate an understanding of:
1. How text-based configuration files can be structured and parsed.
2. The role of Java's file handling classes in reading data.
3. The process of converting parsed data into dynamically instantiated objects.
4. Strategies for handling errors and ensuring the integrity of data during object creation.

---

### Exercise 2: Principles of Class Design in Object-Oriented Programming

#### Objective:
To prepare students for designing the classes (`Player`, `Enemy`, `Item`, `Game`) required for the game by exploring the principles of class design, including identifying responsibilities, defining interfaces, and ensuring cohesion.

---

#### **Theoretical Questions**

1. **Class Responsibilities:**
   - Why is it important to identify the responsibilities of a class during the design phase?
   - For the following game elements, identify the key responsibilities of each and suggest attributes and methods they might have:
     - `Player` (e.g., attributes: position, score; methods: move, addScore).
     - `Enemy` (e.g., attributes: position; methods: moveRandomly).
     - `Item` (e.g., attributes: position, points; methods: [optional]).

2. **Encapsulation and Cohesion:**
   - What is encapsulation, and how does it help in designing maintainable classes?
   - How does cohesion contribute to good class design? Can you identify potential cohesion issues in a class that handles both player movement and enemy spawning?

3. **Class Relationships:**
   - What is the difference between "has-a" relationships and "is-a" relationships in class design? Provide examples from the context of the game (e.g., a `Game` class "has-a" `Player`, but a `Player` "is-a" `GameElement`).

4. **Interfaces and Abstraction:**
   - Why might it be useful to define a common interface or abstract class (e.g., `GameElement`) for all game elements (`Player`, `Enemy`, `Item`)? Suggest some methods that could be included in such an interface.

5. **Design Patterns:**
   - The "Factory Method" pattern is often used for creating objects. How might this pattern be applied to dynamically create game elements based on the configuration file?

---

#### **Activity**
- Given the following partial class skeleton for a `Player` class, identify and explain:
  - Which attributes and methods are essential for the `Player` class to fulfill its responsibilities.
  - Any additional methods or attributes that might improve the design.

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
          // Move logic here
      }

      public void addScore(int points) {
          // Add score logic here
      }

      // Getters and setters...
  }
  ```

---

#### Expected Outcome:
Students should demonstrate an understanding of:
1. How to identify and assign responsibilities to classes.
2. The importance of encapsulation, cohesion, and abstraction in class design.
3. The relationships between classes and how they interact in an object-oriented system.
4. How to critically analyze and improve a class design.

---

### Summary of Exercises 1 and 2:
- **Exercise 1** focuses on the foundational concept of using file data to dynamically instantiate objects, ensuring students understand file I/O and data parsing.
- **Exercise 2** introduces the principles of class design, helping students think critically about how to structure their code for clarity, maintainability, and scalability.

These exercises will prepare students for the coding tasks in subsequent exercises by building their theoretical understanding of the core programming concepts.

### Exercise 3: Implementing File Parsing and Object Instantiation

#### **Objective**
To transition from theoretical understanding to practical application by implementing file I/O operations to instantiate game elements dynamically. Students will write Java code to read a configuration file, parse its contents, and create corresponding objects.

---

#### **Instructions**

1. **Write a Configuration File Parser**
   - Create a sample configuration file (`gameConfig.txt`) to define the game elements as follows:
     ```
     Player: 0,0
     Enemy: 3,3
     Enemy: 1,4
     Item: 2,2
     Item: 4,0
     GridSize: 5,5
     ```
   - Write a Java program to:
     - Open and read the file line by line.
     - Parse each line to extract the type of game element and its attributes (e.g., coordinates for Player, Enemy, and Item).
     - Dynamically instantiate objects (`Player`, `Enemy`, `Item`) using the extracted data.
     - Store these objects in appropriate data structures (e.g., `List<Player>`, `List<Enemy>`, `List<Item>`).

2. **Implement Error Handling**
   - Add safeguards to handle the following scenarios:
     - The configuration file does not exist.
     - Lines in the file are missing required data (e.g., `Enemy: 3` instead of `Enemy: 3,3`).
     - Lines contain invalid data types (e.g., `Player: x,y` instead of `Player: 0,0`).
   - Print meaningful error messages to the console and terminate the program gracefully if errors are encountered.

3. **Test the Parser**
   - Test your program with both valid and invalid configuration files.
   - Print the parsed objects and their attributes to the console to verify correctness.

---

#### **Scaffolding**
- Use the following method signature as a starting point:
  ```java
  public static void loadGameConfig(String filePath) throws IOException {
      // File reading and parsing logic here
  }
  ```
- Example for parsing a single line:
  ```java
  String[] parts = line.split(": ");
  if (parts[0].equals("Player")) {
      String[] coordinates = parts[1].split(",");
      int x = Integer.parseInt(coordinates[0]);
      int y = Integer.parseInt(coordinates[1]);
      Player player = new Player(x, y);
      players.add(player); // Add to a list of players
  }
  ```

---

#### **Expected Outcome**
By the end of this exercise, students should have:
- A functioning Java method to parse a configuration file and instantiate game elements dynamically.
- Error handling mechanisms to ensure robust file parsing.
- A basic understanding of how file data can drive object creation in a program.

---

### Exercise 4: Designing and Implementing Core Game Classes

#### **Objective**
To build the core classes (`Player`, `Enemy`, `Item`, and `Game`) for the game application. Students will implement the functionality of these classes and integrate them with the file parser from Exercise 3.

---

#### **Instructions**

1. **Design and Implement the Classes**
   - Create the following classes with the specified attributes and methods:

     **`Player` Class**
     - Attributes: `x`, `y`, `score`
     - Methods:
       - `move(String direction)`: Updates the player's position based on input (e.g., "UP", "DOWN", "LEFT", "RIGHT").
       - `addScore(int points)`: Increases the player's score.
       - Getters and setters for attributes.

     **`Enemy` Class**
     - Attributes: `x`, `y`
     - Methods:
       - `moveRandomly(int gridWidth, int gridHeight)`: Moves the enemy randomly within the grid boundaries.
       - Getters and setters for attributes.

     **`Item` Class**
     - Attributes: `x`, `y`, `points`
     - Methods:
       - Constructor to initialize position and point value.
       - Getters and setters for attributes.

     **`Game` Class**
     - Attributes:
       - `List<Player>`
       - `List<Enemy>`
       - `List<Item>`
       - `int gridWidth`, `int gridHeight`
     - Methods:
       - `initializeGame(String filePath)`: Calls the file parser (from Exercise 3) to load the game configuration and instantiate objects.
       - `printGrid()`: Displays the current state of the game grid in the console, marking the positions of the player(s), enemies, and items.
       - `updateGameState(String playerMove)`: Updates the positions of the player and enemies and checks for collisions or item collection.

2. **Integrate with File Parsing**
   - Modify the `loadGameConfig` method from Exercise 3 to instantiate the objects into the respective lists in the `Game` class.

3. **Test the Classes**
   - Write a simple `main` method to:
     - Create a `Game` object.
     - Initialize the game using a configuration file.
     - Print the game grid.
     - Allow the player to input a move (e.g., "UP", "DOWN", "LEFT", "RIGHT") and update the game state.
     - Verify that the player can move, items can be collected, and collisions with enemies are detected.

---

#### **Scaffolding**
- Example for `Game.printGrid()`:
  ```java
  public void printGrid() {
      for (int i = 0; i < gridHeight; i++) {
          for (int j = 0; j < gridWidth; j++) {
              boolean printed = false;

              // Check for player
              for (Player player : players) {
                  if (player.getX() == j && player.getY() == i) {
                      System.out.print("P ");
                      printed = true;
                      break;
                  }
              }

              // Check for enemy
              if (!printed) {
                  for (Enemy enemy : enemies) {
                      if (enemy.getX() == j && enemy.getY() == i) {
                          System.out.print("E ");
                          printed = true;
                          break;
                      }
                  }
              }

              // Check for item
              if (!printed) {
                  for (Item item : items) {
                      if (item.getX() == j && item.getY() == i) {
                          System.out.print("I ");
                          printed = true;
                          break;
                      }
                  }
              }

              // Empty space
              if (!printed) {
                  System.out.print(". ");
              }
          }
          System.out.println();
      }
  }
  ```

---

#### **Expected Outcome**
By the end of this exercise, students should have:
- Fully implemented and tested the core classes for the game.
- A working `Game` class that integrates with the file parser from Exercise 3 to initialize the game state dynamically.
- A basic console-based game that displays the grid and allows the player to move.

---

### Bridging the Gap Between Theory and Practice
- **Exercise 3** focuses on implementing file parsing, transitioning from the theoretical foundation in Exercise 1.
- **Exercise 4** focuses on

### Exercise 5: Adding Dynamic Gameplay Features and Refining the Game Logic

#### **Objective**
To enhance the functionality of the game by adding dynamic gameplay elements such as moving enemies, item collection logic, and a scoring system. This exercise challenges students to integrate more advanced features into their game while reinforcing object-oriented principles.

---

#### **Instructions**

1. **Enhance Player Movement**
   - Modify the `Player.move(String direction)` method to include **boundary checks**, ensuring the player cannot move off the grid.
   - If the player attempts to move out of bounds, display a message (e.g., "You can't move outside the grid!") and do not update their position.

2. **Implement Item Collection Logic**
   - Update the `Game.updateGameState(String playerMove)` method to check if the player's new position matches the position of any `Item` object.
   - If an item is collected:
     - Remove the item from the grid.
     - Add the item's point value to the player's score.
     - Display a message (e.g., "You collected an item! Your score is now 10.").

3. **Introduce Moving Enemies**
   - Add a `moveRandomly(int gridWidth, int gridHeight)` method to the `Enemy` class, allowing enemies to move one step in a random direction after each player move.
   - Implement collision detection in `Game.updateGameState`:
     - If the player's position matches an enemy's position, the game ends, and a message is displayed (e.g., "Game Over! You were caught by an enemy.").
   - Ensure enemies cannot move off the grid or overlap with other enemies.

4. **Game Over Conditions**
   - Modify the game loop in the `main` method to end the game if:
     - The player collides with an enemy.
     - All items are collected (display a congratulatory message, e.g., "You won! Your final score is 20.").

5. **Refactor Code for Maintainability**
   - Refactor the `Game.updateGameState` method to improve readability and modularity:
     - Extract collision detection into a separate method (e.g., `checkCollisions()`).
     - Extract item collection logic into a separate method (e.g., `collectItems()`).

6. **Testing and Debugging**
   - Test the game thoroughly with different configurations to ensure:
     - The player cannot move out of bounds.
     - Items are correctly removed and scored upon collection.
     - Enemies move randomly without overlapping or leaving the grid.
     - The game ends correctly under all conditions.

---

#### **Scaffolding**
- Example for item collection logic:
  ```java
  public void collectItems(Player player) {
      Iterator<Item> iterator = items.iterator();
      while (iterator.hasNext()) {
          Item item = iterator.next();
          if (item.getX() == player.getX() && item.getY() == player.getY()) {
              player.addScore(item.getPoints());
              System.out.println("You collected an item! Your score is now " + player.getScore());
              iterator.remove();
          }
      }
  }
  ```

- Example for moving enemies:
  ```java
  public void moveEnemies() {
      for (Enemy enemy : enemies) {
          enemy.moveRandomly(gridWidth, gridHeight);
      }
  }
  ```

---

#### **Expected Outcome**
By the end of this exercise, students should have:
1. A more dynamic and engaging game where the player collects items, avoids moving enemies, and works toward a win condition.
2. A deeper understanding of modular programming and how to refactor methods for readability and maintainability.
3. A fully functional game loop that integrates player movement, enemy movement, item collection, and collision detection.

---

### Exercise 6: Adding Advanced Features and Finalizing the Game

#### **Objective**
To finalize the game by adding advanced features such as a timer, restart functionality, and bonus items. This exercise challenges students to think creatively and integrate all the concepts they’ve learned in the course.

---

#### **Instructions**

1. **Add a Timer**
   - Implement a countdown timer in the `Game` class. The timer should:
     - Start at a configurable value (e.g., 60 seconds).
     - Decrease by 1 second after each player move.
     - End the game if the timer reaches 0, displaying a message (e.g., "Time's up! Game Over.").
   - Use Java's `System.currentTimeMillis()` or a similar approach to measure time, ensuring the game loop accounts for timer updates.

   Example:
   ```java
   private long startTime;
   private int timeLimit; // In seconds

   public void startTimer() {
       this.startTime = System.currentTimeMillis();
   }

   public boolean isTimeUp() {
       long elapsedTime = (System.currentTimeMillis() - startTime) / 1000;
       return elapsedTime >= timeLimit;
   }
   ```

2. **Restart Functionality**
   - Modify the game loop to allow the player to restart the game after losing or running out of time.
   - Display a message prompting the player for input (e.g., "Do you want to restart? (yes/no):").
   - If the player chooses to restart:
     - Reload the game configuration file.
     - Reset the game state (player position, score, enemy positions, etc.).

3. **Add Bonus Items**
   - Introduce a new type of item (`BonusItem`) that gives the player extra time or points when collected.
   - Implement the `BonusItem` class as a subclass of `Item`, adding attributes for bonus effects (e.g., `extraTime`, `extraPoints`).
   - Modify the `Game.updateGameState` method to handle bonus item collection.

   Example:
   ```java
   public class BonusItem extends Item {
       private int extraTime;

       public BonusItem(int x, int y, int points, int extraTime) {
           super(x, y, points);
           this.extraTime = extraTime;
       }

       public int getExtraTime() {
           return extraTime;
       }
   }
   ```

4. **Polish the Game**
   - Improve the console output to make the game more user-friendly:
     - Display the timer and score after each move.
     - Highlight the remaining number of items on the grid.
   - Optionally, use ASCII art or symbols to represent different game elements (e.g., `P` for player, `E` for enemy, `I` for item, `B` for bonus item).

   Example grid display:
   ```
   Time: 30s | Score: 10 | Items Remaining: 2
   P . . . .
   . . . E .
   . . I . .
   . . . . B
   . I . . .
   ```

5. **Testing and Debugging**
   - Test the game with different configurations and scenarios:
     - Ensure the timer works correctly and ends the game when time runs out.
     - Verify that bonus items provide the correct effects (e.g., adding time or points).
     - Test the restart functionality to ensure the game resets properly.

---

#### **Scaffolding