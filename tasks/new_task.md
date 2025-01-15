![Task Image](images/task_image_20250115_020242.png)

### Task: Create a Simple Game Application in Java

In this project, you will create a simple **2D console-based game** in Java that includes key functionalities such as **player movement**, **a scoring system**, and **enemy interactions**. This project will challenge you to apply your Java programming skills while integrating the weekly learning goals: **Using Data from Files to Instantiate Objects**, **Designing Classes**, and **Programming Creatively**.

The game concept is simple: the player navigates a grid to collect points while avoiding enemies. The positions of the player, enemies, and collectible items will be dynamically loaded from a configuration file. You will design the game by dividing it into well-structured classes and use your creativity to make the gameplay engaging.

---

## Learning Goals

1. **Using Data from Files to Instantiate Objects**  
   - Learn how to read a configuration file to initialize the game world.
   - Understand how to parse file data and use it to create objects (e.g., player, enemies, items).
   - Handle exceptions gracefully to ensure robust file loading.

2. **Designing Classes**  
   - Identify responsibilities for different classes (e.g., `Player`, `Enemy`, `Game`).
   - Use proper naming conventions, fields, and methods to create cohesive class structures.
   - Apply object-oriented programming principles to organize game functionality.

3. **Programming Creatively**  
   - Experiment with gameplay mechanics and refine your design.
   - Enhance the game by introducing new features, such as special items or unique enemy behavior.
   - Test your game thoroughly and use feedback to improve the user experience.

---

## Task Requirements

### 1. **Game Setup**
   - The game world consists of a **10x10 grid**, where each cell can either be empty or contain:
     - The player (`P`).
     - An enemy (`E`).
     - A collectible item (`C`).
   - The grid layout, including the initial positions of the player, enemies, and items, must be loaded from a **text file** (e.g., `game_config.txt`). Below is an example of the file format:

     ```
     PLAYER: 1,1
     ENEMY: 3,4
     ENEMY: 7,2
     ITEM: 2,5
     ITEM: 8,8
     ```

   - You will read this file, parse the data, and use the extracted information to instantiate the corresponding objects in your game.

---

### 2. **Designing Classes**
   - Divide your game into the following **classes**:
     1. **`Player`**: Represents the player. Includes fields for position, score, and methods for movement.
     2. **`Enemy`**: Represents an enemy. Includes fields for position and methods for basic movement (e.g., random movement).
     3. **`Item`**: Represents a

### Exercise 1: Understanding File I/O and Object Instantiation

**Objective:**  
To help students understand how to read data from a file, parse it, and use the extracted information to instantiate objects dynamically. This exercise focuses on the theoretical aspects of file handling, parsing techniques, and object creation in Java.

---

#### Instructions:

1. **File Handling Basics:**
   - Explain the role of file I/O in applications. Why is it important to load data dynamically from files instead of hardcoding it in programs?
   - Research and describe the purpose of the following Java classes and interfaces:
     - `File`
     - `Scanner`
     - `BufferedReader`
     - `IOException`

2. **File Formats and Parsing:**
   - Given the following configuration file format, explain how the data can be parsed to extract meaningful information:
     ```
     PLAYER: 1,1
     ENEMY: 3,4
     ITEM: 2,5
     ```
     - What are the key components of each line that need to be extracted?
     - Discuss how you would handle parsing errors, such as missing or malformed data (e.g., "PLAYER: ,").

3. **Object Instantiation:**
   - Imagine you have three Java classes: `Player`, `Enemy`, and `Item`. Each class has a constructor that accepts two integers for the x and y positions (e.g., `Player(int x, int y)`).
   - Explain the process of:
     1. Reading the file line by line.
     2. Identifying the type of object to create based on the prefix (`PLAYER`, `ENEMY`, or `ITEM`).
     3. Extracting the x and y coordinates from the line and instantiating the correct object.

4. **Error Handling:**
   - Discuss how you would ensure data integrity during object instantiation. For example:
     - What happens if the file contains invalid coordinates (e.g., "PLAYER: -1,12")?
     - How would you handle exceptions, such as the file not being found or having corrupted content?

---

#### Deliverables:
- Write a short essay (300-500 words) answering the above questions.
- Provide pseudocode for reading the example file and instantiating the objects.

---

### Exercise 2: Principles of Class Design

**Objective:**  
To help students understand the principles of designing classes in Java, focusing on responsibilities, cohesion, and the relationship between classes. This exercise builds a foundation for implementing the game structure in subsequent coding tasks.

---

#### Instructions:

1. **Class Responsibilities:**
   - Define the main responsibilities of the following classes in the context of the game:
     - `Player`
     - `Enemy`
     - `Item`
     - `Game` (a class that manages the overall game logic, such as updating the grid, detecting collisions, and checking win/loss conditions).
   - For each

### Exercise 3: Implementing File I/O and Object Instantiation in Java

**Objective:**  
To bridge the theoretical understanding from Exercise 1 into practical coding. Students will write Java code to read a configuration file, parse it, and dynamically instantiate objects for the game (`Player`, `Enemy`, `Item`) based on the data.

---

#### Instructions:

1. **Preparing the Configuration File:**
   - Create a sample configuration file (`game_config.txt`) with the following content:
     ```
     PLAYER: 1,1
     ENEMY: 3,4
     ENEMY: 7,2
     ITEM: 2,5
     ITEM: 8,8
     ```
   - Save it in the root of your Java project directory.

2. **Reading the File:**
   - Write a Java program that performs the following:
     1. Reads the `game_config.txt` file line by line using classes like `BufferedReader` or `Scanner`.
     2. Identifies the type of object to create based on the prefix (`PLAYER`, `ENEMY`, or `ITEM`).
     3. Extracts the x and y coordinates from each line and handles parsing errors gracefully.

3. **Creating Classes:**
   - Implement the following Java classes with the given fields and methods:
     - **`Player`**:
       - Fields: `int x`, `int y`, `int score`.
       - Constructor: `Player(int x, int y)`.
       - Method: `toString()` to return the player's position and score as a string.
     - **`Enemy`**:
       - Fields: `int x`, `int y`.
       - Constructor: `Enemy(int x, int y)`.
       - Method: `toString()` to return the enemy's position as a string.
     - **`Item`**:
       - Fields: `int x`, `int y`.
       - Constructor: `Item(int x, int y)`.
       - Method: `toString()` to return the item's position as a string.

4. **Instantiating Objects:**
   - Use the data from the file to create objects of `Player`, `Enemy`, and `Item` and store them in separate lists (e.g., `List<Player>` for players, `List<Enemy>` for enemies, and `List<Item>` for items).

5. **Error Handling:**
   - Ensure the program handles the following cases:
     - File not found: Print an appropriate error message and exit gracefully.
     - Malformed line in the file: Skip the line and print a warning message (e.g., "Skipping invalid line: ENEMY: , ").
     - Invalid coordinates (e.g., negative values or values outside the 10x10 grid): Print a warning and skip the line.

6. **Testing:**
   - Test your program with the provided `game_config.txt` file and verify that it correctly instantiates the objects.
   - Deliberately introduce errors in the file (e.g., malformed lines, invalid coordinates) to test your error-handling logic.

---

#### Deliverables:
- Java code for reading the file, parsing it, and instantiating the objects.
- A sample output that lists all instantiated objects and any error messages (if applicable).

---

### Example Output (Sample Run):
Given the provided `game_config.txt`:
```
PLAYER: 1,1
ENEMY: 3,4
ENEMY: 7,2
ITEM: 2,5
ITEM: 8,8
```

Expected Console Output:
```
Player created at position (1, 1).
Enemy created at position (3, 4).
Enemy created at position (7, 2).
Item created at position (2, 5).
Item created at position (8, 8).
```

With errors introduced (e.g., "ENEMY: ,"):
```
Player created at position (1, 1).
Error: Skipping invalid line: ENEMY: ,
Enemy created at position (7, 2).
Item created at position (2, 5).
Item created at position (8, 8).
```

---

### Exercise 4: Designing and Connecting Classes for Game Logic

**Objective:**  
To help students transition from coding individual components to integrating them into a cohesive game system. Students will design the overall game structure and implement basic interactions and grid visualization.

---

#### Instructions:

1. **Game Class Design:**
   - Implement a `Game` class that manages the overall game logic. Include the following:
     - Fields:
       - `List<Player>`: A list to store the player(s) (for now, assume only one player).
       - `List<Enemy>`: A list to store the enemies.
       - `List<Item>`: A list to store the collectible items.
       - `int[][] grid`: A 10x10 array representing the game world.
     - Methods:
       - `initializeGame()`: Reads the configuration file, instantiates objects, and populates the grid.
       - `displayGrid()`: Prints the current state of the grid to the console (e.g., `P` for player, `E` for enemy, `C` for item, `.` for empty cells).
       - `updateGame()`: A placeholder method for future updates (e.g., player movement, enemy movement).

2. **Grid Visualization:**
   - Implement the `displayGrid()` method to visualize the 10x10 grid. For example:
     ```
     P . . . . . . . . .
     . . . . . C . . . .
     . . . . E . . . . .
     . . . . . . . E . .
     . . . . . . . . . .
     . . . . . . . . C .
     ```
   - Ensure that the player's position (`P`), enemies (`E`), and items (`C`) are correctly displayed on the grid.

3. **Integration of Classes:**
   - In the `Game` class, use the `Player`, `Enemy`, and `Item` classes to populate the grid during initialization.
   - Ensure the grid accurately reflects the positions of all game objects.

4. **Testing the Game Initialization:**
   - Test the `Game` class by calling `initializeGame()` and `displayGrid()`.
   - Verify that the grid is displayed correctly based on the configuration file.

5. **Creative Extensions (Optional):**
   - Allow students to experiment with creative ideas, such as:
     - Allowing the player to "move" on the grid by entering commands (e.g., "UP", "DOWN").
     - Adding simple logic for enemies to move randomly on the grid.

---

#### Deliverables:
- Java code for the `Game` class, including the `initializeGame()` and `displayGrid()` methods.
- A sample output that displays the game grid after initialization.

---

### Example Output (Sample Run):
Given the provided `game_config.txt`:
```
PLAYER: 1,1
ENEMY: 3,4
ENEMY: 7,2
ITEM: 2,5
ITEM: 8,8
```

Expected

### Exercise 5: Adding Movement and Interactions in the Game

**Objective:**  
To implement **player movement**, basic **collision detection**, and interactions between the player and other game elements (e.g., items and enemies). This exercise focuses on bringing dynamic behavior to the game using previously designed classes and logic.

---

#### Instructions:

1. **Player Movement:**
   - Add a method `movePlayer(String direction)` to the `Game` class that allows the player to move in one of the four cardinal directions (`UP`, `DOWN`, `LEFT`, `RIGHT`).
   - Movement rules:
     - The player can only move within the bounds of the 10x10 grid (e.g., moving left from position `(0,0)` has no effect).
     - If the player attempts an invalid move (e.g., moving off the grid), display an appropriate message like: `"Invalid move. Try again."`

2. **Collision with Items:**
   - Update the `movePlayer` method to check whether the player has collided with a collectible item:
     - If the player moves to a cell containing an item, increment the player's score by 1, remove the item from the grid, and display a message like: `"Item collected! Current score: 1."`

3. **Collision with Enemies:**
   - Update the `movePlayer` method to check whether the player has collided with an enemy:
     - If the player moves to a cell containing an enemy, display a game-over message like: `"Game Over! You collided with an enemy."` and terminate the game.

4. **Updating the Grid:**
   - After each move, update the grid to reflect the player's new position and the removal of any collected items.
   - Use the `displayGrid()` method to show the updated grid after every move.

5. **Testing the Movement:**
   - Allow the player to enter movement commands (`UP`, `DOWN`, `LEFT`, `RIGHT`) in a loop until:
     - The player collects all items (winning condition) or collides with an enemy (losing condition).
   - After each move, display the grid and the player's current score.

6. **Error Handling:**
   - If the player enters an invalid command (e.g., `JUMP`), display an appropriate message like: `"Invalid command. Please enter UP, DOWN, LEFT, or RIGHT."`

---

#### Deliverables:
- Java code implementing the `movePlayer()` method in the `Game` class.
- Updated `Game` class that integrates player movement, item collection, and enemy collision.
- A sample output demonstrating the player moving on the grid, collecting items, and handling invalid moves.

---

### Example Output (Sample Run):
Given the grid initialized as follows:
```
P . . . . . . . . .
. . . . . C . . . .
. . . . E . . . . .
. . . . . . . E . .
. . . . . . . . . .
. . . . . . . . C .
```

Expected Console Interaction:
```
Enter your move (UP, DOWN, LEFT, RIGHT): DOWN
P . . . . . . . . .
. . . . . C . . . .
. . . . E . . . . .
. . . . . . . E . .
. . . . . . . . . .
. . . . . . . . C .
Item collected! Current score: 1.

Enter your move (UP, DOWN, LEFT, RIGHT): RIGHT
. . . . . . . . . .
P . . . . . C . . .
. . . . E . . . . .
. . . . . . . E . .
. . . . . . . . . .
. . . . . . . . C .
```

---

### Exercise 6: Introducing Enemy Movement and Enhanced Gameplay

**Objective:**  
To add **enemy movement**, refine game mechanics (e.g., winning and losing conditions), and encourage creative gameplay extensions. This exercise consolidates all previous concepts while introducing a small additional challenge.

---

#### Instructions:

1. **Enemy Movement:**
   - Add a method `moveEnemies()` to the `Game` class that moves all enemies on the grid:
     - Each enemy moves one step in a random direction (`UP`, `DOWN`, `LEFT`, `RIGHT`).
     - Enemies cannot move off the grid. If a random direction moves the enemy out of bounds, choose a new direction.
     - Enemies cannot move into a cell already occupied by another enemy.
   - Update the grid after moving all enemies.

2. **Player-Enemy Collision Check:**
   - After all enemies have moved, check if any enemy occupies the same position as the player:
     - If a collision occurs, display `"Game Over! You were caught by an enemy."` and terminate the game.

3. **Winning Condition:**
   - Update the game loop to check if all items have been collected:
     - If all items are collected, display `"Congratulations! You collected all items and won the game!"` and terminate the game.

4. **Enhanced Grid Display:**
   - Modify the `displayGrid()` method to make it visually clearer:
     - Use `P` for the player, `E` for enemies, `C` for items, and `.` for empty cells.
     - Include a border around the grid for better visualization. For example:
       ```
       +--------------------+
       | P . . . . . . . . |
       | . . . . . C . . . |
       | . . . . E . . . . |
       | . . . . . . . E . |
       | . . . . . . . . . |
       | . . . . . . . . C |
       +--------------------+
       ```

5. **Game Loop Integration:**
   - Combine player movement (`movePlayer()`), enemy movement (`moveEnemies()`), and collision detection into a single game loop:
     - After every player move, update the grid, move the enemies, and check for collisions.
     - Continue the loop until the player wins (collects all items) or loses (collides with an enemy).

6. **Creative Gameplay Enhancements (Optional):**
   - Allow students to add creative extensions to the game, such as:
     - **Special Items:** Add a new type of item (`S`) that gives the player a temporary shield to survive one enemy collision.
     - **Enemy Behavior:** Allow enemies to "chase" the player by moving closer to the player's position instead of moving randomly.
     - **Scoring System:** Add bonus points for collecting items quickly or avoiding enemies for a certain number of moves.

---

#### Deliverables:
- Java code implementing `moveEnemies()` and integrating it into the game loop.
- Updated `Game` class that includes all game features: player movement, enemy movement, item collection, collision detection, and win/lose conditions.
- A sample output demonstrating an entire game session.

---

### Example Output (Sample Run):
Given the grid initialized as follows:
```
P . . . . . . . . .
. . . . . C . . .