![Task Image](images/task_image_20250115_022454.png)

# Task Description: Build a Simple Game Application in Java

### **Overview**
In this task, you will design and implement a simple game application in Java. The game will include basic functionalities such as player movement, a scoring system, and enemy interactions. The goal of this task is to integrate key programming concepts, including reading data from files, designing well-structured classes, and applying creative programming techniques.

You will use **data from files** to create and initialize game objects, **design classes** to model the game’s components, and **program creatively** to make the game engaging and functional. This project will help you practice object-oriented programming and improve your problem-solving skills.

---

### **Task Requirements**
Your game application should have the following features:
1. **Player Movement**: The player should be able to move around the game world.
2. **Scoring System**: The game should track and display the player’s score.
3. **Enemy Interactions**: Enemies should appear on the game screen, and interacting with them should affect the game (e.g., reducing the score or ending the game).
4. **Dynamic Object Creation from File**: Game objects (e.g., enemies, obstacles) should be instantiated dynamically by reading data from a file.

---

### **Step-by-Step Guidance**

#### **1. Plan and Design the Game**
Before diving into coding, think about how you want the game to work. Answer the following questions:
- What actions can the player perform? (e.g., move up, down, left, right)
- How will you represent the game world? (e.g., grid-based, 2D plane)
- How will enemies behave? (e.g., static or moving)
- What will the scoring system look like? (e.g., increase score when avoiding enemies, decrease score on collision)

Create a basic sketch or flowchart of your game to visualize the relationships between different components (e.g., Player, Enemy, GameController).

---

#### **2. Design the Classes**
Design Java classes for the key components of your game. Follow these principles:

- **Player Class**:
    - Fields: `x` and `y` for position, `score` for tracking the player’s score.
    - Methods: `move(direction)`, `updateScore(points)`, `toString()`.

- **Enemy Class**:
    - Fields: `x`, `y` for position, and any other attributes you want (e.g., type, speed).
    - Methods: `move()`, `toString()`.

- **GameController Class**:
    - Fields: A list of enemies, the player object, and the game status.
    - Methods: `loadGameObjectsFromFile()`, `updateGame()`, `detectCollisions()`.

- **File Data Representation**: 
    - Use a simple file format (e.g., CSV or text) to define game objects. For example:
      ```
      enemy,5,10
      enemy,15,20
      player,0,0
      ```

---

#### **3. Read Data from a File**
Use Java’s file I/O classes to read game object data and instantiate objects dynamically. Here's a starting point for reading a file:

```java
import java.io.*;
import java.util.*;

public class FileReaderExample {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("game_objects.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0];
                int x = Integer.parseInt(parts[1]);
                int y = Integer.parseInt(parts[2]);
                
                if (type.equals("enemy")) {
                    Enemy enemy = new Enemy(x, y);
                    System.out.println("Created enemy at: " + enemy);
                } else if (type.equals("player")) {
                    Player player = new Player(x, y);
                    System.out.println("Created player at: " + player);
                }
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}
```
**Your Task**: Modify this code to integrate it into your `GameController` class. Handle exceptions to ensure data integrity (e.g., skip invalid lines).

---

#### **4. Implement Player Movement**
Allow the player to move around the game world. You can use a simple console-based input method for this:

```java
import java.util.Scanner;

public class Player {
    private int x, y;

    public Player(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(String direction) {
        switch (direction) {
            case "up": y--; break;
            case "down": y++; break;
            case "left": x--; break;
            case "right": x++; break;
            default: System.out.println("Invalid direction!");
        }
    }

    @Override
    public String toString() {
        return "Player position: (" + x + ", " + y + ")";
    }
    
    public static void main(String[] args) {
        Player player = new Player(0, 0);
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            System.out.println(player);
            System.out.print("Enter direction (up, down, left, right): ");
            String direction = scanner.nextLine();
            player.move(direction);
        }
    }
}
```
**Your Task**: Integrate this functionality into your game and allow the player to interact with enemies.

---

#### **5. Add a Scoring System**
- Update the player's score based on actions (e.g., increase score when avoiding enemies, decrease score on collision).
- Display the score after each move.

---

#### **6. Handle Enemy Interactions**
- Add logic to detect collisions between the player and enemies.
- If a collision occurs, implement an appropriate response (e.g., reduce the score or end the game).

---

#### **7. Test and Iterate**
- Test your game frequently to ensure all features work correctly.
- Experiment with different enemy behaviors, scoring rules, or file formats to make the game more interesting.

---

### **Bonus Challenges (Optional)**
1. Add a **timer** to track how long the player survives.
2. Make enemies move randomly or follow the player.
3. Add obstacles or power-ups to enhance gameplay.

---

### **Deliverables**
1. A zipped folder containing your Java project files.
2. A `README` file explaining how to run your game and the features included.
3. A sample input file (`game_objects.txt`) with data for initializing game objects.

---

### **Grading Criteria**
- **File I/O (30%)**: Correctly read data from a file and instantiate objects.
- **Class Design (30%)**: Proper use of classes, fields, methods, and object-oriented principles.
- **Game Functionality (30%)**: Implementation of player movement, scoring system, and enemy interactions.
- **Creativity (10%)**: Innovative features or enhancements added to the game.

Good luck, and have fun programming your game

### **Exercise 1: Understanding File I/O and Object Instantiation**

#### **Objective:**
This exercise will help you understand the theoretical aspects of using file I/O to dynamically instantiate objects. By exploring file formats, parsing techniques, and exception handling, you will build a strong foundation for integrating file data into your Java programs.

---

#### **Task: Answer the following questions**

1. **File Formats and Parsing:**
   - What is a CSV file, and why is it commonly used for storing structured data? Provide an example of a CSV file that could be used to initialize game objects in a grid-based game.
   - Explain how the `split()` method in Java can be used to parse a line of text from a file. What are some potential challenges when parsing data, and how can you address them?

2. **File I/O in Java:**
   - Describe the purpose of the following Java classes used for file handling:
     - `FileReader`
     - `BufferedReader`
   - Discuss the importance of closing file streams after reading a file. What could happen if you forget to close the stream?

3. **Object Instantiation from File Data:**
   - Consider the following line from a file: `enemy,5,10`. How would you dynamically create an `Enemy` object from this data in Java? Describe the steps involved.
   - What might happen if the file contains invalid or corrupted data (e.g., `enemy,5,abc`)? How would you handle such cases in your code?

4. **Exception Handling:**
   - Why is exception handling important when working with file I/O? Provide an example of how you would handle an `IOException` when reading a file.
   - What is the difference between `checked` and `unchecked` exceptions in Java? Which category does `IOException` fall into?

---

#### **Deliverables:**
Write your answers to the questions in a text or Word document, providing clear explanations and examples where necessary. Focus on demonstrating your understanding of the concepts rather than writing code.

---

### **Exercise 2: Principles of Class Design**

#### **Objective:**
This exercise will guide you through the essential principles of designing well-structured Java classes. By analyzing class responsibilities, cohesion, and design patterns, you will prepare for implementing the game components in the next steps of the project.

---

#### **Task: Answer the following conceptual questions**

1. **Understanding Class Responsibilities:**
   - What does it mean for a class to have a single responsibility? Why is this important in object-oriented programming?
   - For the game application, identify the key responsibilities of the following classes:
     - `Player`
     - `Enemy`
     - `GameController`

2. **Class Cohesion and Interfaces:**
   - Define the concept of cohesion in the context of class design. How can you ensure that a class is cohesive?
   - Imagine you are designing the `Player` class. List the fields and methods you think are necessary to make the class cohesive. Justify your choices.

3. **Relationships Between Classes:**
   - Describe the relationship between the `Player` and `Enemy` classes in the game. Should these classes directly interact with each other? Why or why not?
   - How does the `GameController` class act as a mediator between different game components? What are the advantages of using a controller class in this scenario?

4. **Role of Design Patterns:**
   - What are design patterns, and why are they useful in class design?
   - The game application could benefit from using the **Factory Pattern** when creating game objects from file data. Describe how this pattern works and why it might be a good choice for this project.

---

#### **Deliverables:**
Write your responses to the questions in a document, ensuring you provide clear and concise explanations. Use examples or diagrams where appropriate to support your answers.

---

### **Purpose of These Exercises:**
- **Exercise 1** focuses on the first learning goal: **Using Data from Files to Instantiate Objects**. It ensures you understand the theoretical aspects of file handling and object creation before diving into implementation.
- **Exercise 2** focuses on the second learning goal: **Designing Classes**. It prepares you to think critically about class structure and relationships, which are essential for building a maintainable and scalable game application.

These exercises will provide the foundational knowledge needed to tackle the coding challenges in

### **Exercise 3: Implementing File I/O and Object Instantiation**

#### **Objective:**
This exercise bridges the gap between theory and practical implementation by requiring you to write Java code that reads data from a file, parses it, and dynamically creates objects. You will practice file I/O, exception handling, and object instantiation, which are critical for building the game application.

---

#### **Task: Write a Java Program**

1. **File Parsing and Object Creation:**
   - Create a Java program that reads a file named `game_objects.txt`. The file contains data about game entities in the following format:
     ```
     enemy,5,10
     player,0,0
     obstacle,3,8
     ```
   - Write code to parse each line, identify the type of entity (e.g., `enemy`, `player`, `obstacle`), and create the corresponding object dynamically.

2. **Define Classes:**
   - Implement the following classes:
     - `Player`:
       - Fields: `x`, `y` (position).
       - Constructor: Initialize position based on file input.
       - Methods: `toString()` to print the player’s position.
     - `Enemy`:
       - Fields: `x`, `y` (position).
       - Constructor: Initialize position based on file input.
       - Methods: `toString()` to print the enemy’s position.
     - `Obstacle`:
       - Fields: `x`, `y` (position).
       - Constructor: Initialize position based on file input.
       - Methods: `toString()` to print the obstacle’s position.

3. **File I/O Logic:**
   - Implement a `FileHandler` class with the following method:
     ```java
     public static List<Object> loadGameObjects(String fileName)
     ```
     - This method should:
       - Read the file line by line.
       - Parse each line and create the appropriate object (`Player`, `Enemy`, or `Obstacle`).
       - Return a list of all game objects.

4. **Error Handling:**
   - Handle potential issues such as:
     - File not found: Print an error message and terminate the program gracefully.
     - Invalid data format (e.g., `enemy,5,abc`): Skip the invalid line and continue processing.
   - Use appropriate exceptions (e.g., `IOException`, `NumberFormatException`) and ensure the program does not crash unexpectedly.

5. **Test Your Program:**
   - Create a sample `game_objects.txt` file with a mix of valid and invalid data.
   - Run your program and ensure it correctly handles all cases:
     - Valid lines should result in object creation.
     - Invalid lines should be skipped with a warning.

---

#### **Deliverables:**
Submit the following:
1. The source code for your program.
2. A sample `game_objects.txt` file used for testing.
3. A screenshot or output log demonstrating the program’s behavior with valid and invalid input.

---

### **Exercise 4: Building the Game Framework**

#### **Objective:**
This exercise focuses on integrating basic game mechanics and introducing dynamic interactions between game components. You will write code to simulate player movement and interactions with dynamically created game objects.

---

#### **Task: Create a Basic Game Framework**

1. **GameController Class:**
   - Implement a `GameController` class to manage the game. It should:
     - Load game objects using the `FileHandler` class from Exercise 3.
     - Maintain a list of all game objects (e.g., `Player`, `Enemy`, `Obstacle`).
     - Handle player movement and interactions.

2. **Player Movement:**
   - Add functionality to let the player move around the game world. Use a simple console-based input system where the user can enter commands such as `up`, `down`, `left`, or `right`.
   - Update the player’s position based on the input and display the new position.

3. **Collision Detection:**
   - Implement collision detection between the player and other game objects (e.g., enemies, obstacles).
     - If the player collides with an `Enemy`, print a message (e.g., "Collision with enemy! Game over.") and stop the game.
     - If the player collides with an `Obstacle`, print a message (e.g., "Collision with obstacle! Movement blocked.") and prevent the player from moving into the obstacle.

4. **Game Loop:**
   - Create a simple game loop in the `GameController` class:
     - Display the player’s position and score.
     - Prompt the user for a movement direction.
     - Update the game state based on the player’s input.
     - Detect collisions and handle them appropriately.
     - Exit the loop if the game is over (e.g., player collides with an enemy).

5. **Test Your Game:**
   - Use the `game_objects.txt` file from Exercise 3 to initialize the game world.
   - Test different scenarios:
     - Moving the player around the world.
     - Colliding with an enemy.
     - Colliding with an obstacle.

---

#### **Sample Console Output:**
Here’s an example of what the game might look like in the console:

```
Game Started!
Player position: (0, 0)
Score: 0

Enter direction (up, down, left, right): right
Player position: (1, 0)
Score: 0

Enter direction (up, down, left, right): up
Player position: (1, -1)
Score: 0

Enter direction (up, down, left, right): right
Collision with enemy! Game over.
```

---

#### **Hints and Tips:**
- Use a `List<Object>` to store all game objects, but remember to cast objects (e.g., `if (obj instanceof Enemy)`) when checking for collisions or interactions.
- To simplify collision detection, assume all objects occupy a single grid cell and compare their `x` and `y` coordinates to detect overlaps.
- Start with a small, fixed grid (e.g., 10x10) for the game world to make testing easier.

---

#### **Deliverables:**
Submit the following:
1. The source code for your `GameController` class and any supporting classes.
2. A screenshot or output log demonstrating the game in action (e.g., player movement, collisions, and game over scenarios).
3. A brief explanation of how your game handles collisions and updates the game state.

---

### **Purpose of These Exercises:**
- **Exercise 3** focuses on applying file I/O concepts from Exercise 1 and transitioning them into practical coding with object instantiation.
- **Exercise 4** integrates class design principles from Exercise 2 and introduces dynamic interactions between game components, preparing students for more advanced coding in subsequent exercises.

By the end of these exercises, you will have a working framework for your game, with foundational mechanics in place and the ability to dynamically load game objects from a file. This sets the stage for more advanced coding challenges in Exercises 5 and 6.

### **Exercise 5: Adding a Scoring System and Enhancing Gameplay**

#### **Objective:**
This exercise focuses on integrating a scoring system into your game and enhancing gameplay by introducing dynamic enemy behavior and additional game mechanics. You will practice combining previously learned concepts of object-oriented design, file I/O, and creative programming.

---

### **Task: Enhance Your Game with Scoring and Enemy Behavior**

1. **Scoring System**:
   - Add a scoring system to track the player’s performance during the game.
     - Increase the score by 10 points for each valid move the player makes (not blocked by an obstacle or enemy).
     - Decrease the score by 20 points if the player collides with an obstacle.
     - End the game with a message if the player’s score falls below zero (e.g., "Game over: Your score reached zero!").
   - Display the updated score after each move.

2. **Dynamic Enemy Behavior**:
   - Modify the `Enemy` class to introduce simple dynamic behavior:
     - Enemies should move randomly within the game world after each player move.
     - Ensure enemies remain within the bounds of the game grid (e.g., 10x10).
     - Use a random number generator to determine the enemy’s movement direction (`up`, `down`, `left`, `right`).
   - Update the `GameController` class to handle enemy movement during the game loop.

3. **Collision Detection Enhancements**:
   - Refine collision detection to handle moving enemies:
     - If the player collides with an enemy, print a game-over message (e.g., "Game over: You collided with an enemy!") and terminate the game.
     - Prevent enemies from overlapping with obstacles or other enemies.

4. **Game World Boundaries**:
   - Ensure the player and enemies cannot move outside the bounds of the game grid.
   - Print a warning message if the player attempts an invalid move (e.g., "You can't move outside the game world!") and maintain their current position.

5. **Game Loop Enhancements**:
   - Update the game loop in the `GameController` class to:
     - Display the player's position, score, and the positions of all enemies after each move.
     - Allow the player to enter a new move direction.
     - Update the positions of all enemies after the player’s move.
     - Check for collisions and update the game state accordingly.

6. **Testing**:
   - Create a test `game_objects.txt` file with a mix of player, enemies, and obstacles. For example:
     ```
     player,0,0
     enemy,5,5
     enemy,2,3
     obstacle,4,4
     obstacle,1,1
     ```
   - Test the following scenarios:
     - Player moves toward an obstacle.
     - Player collides with an enemy.
     - Player moves while avoiding obstacles and enemies.
     - Enemies move randomly and avoid obstacles.

---

#### **Hints and Tips:**
- **Random Movement for Enemies**:
  Use `java.util.Random` to generate random numbers for the enemy’s movement direction:
  ```java
  Random random = new Random();
  int direction = random.nextInt(4); // 0 for up, 1 for down, 2 for left, 3 for right
  ```

- **Game Grid Boundaries**:
  Use `if` conditions to ensure that the player and enemies stay within the grid. For example:
  ```java
  if (x < 0 || x >= gridWidth || y < 0 || y >= gridHeight) {
      System.out.println("Invalid move: Out of bounds!");
      return;
  }
  ```

- **Collision Detection**:
  Use the `instanceof` operator and object casting to differentiate between game objects during collision checks.

---

#### **Deliverables**:
1. The updated Java source code for your game, including the scoring system and enemy behavior.
2. A screenshot or output log demonstrating the gameplay, scoring system, and dynamic enemy behavior.
3. A brief explanation of how you implemented the scoring system and handled enemy movement.

---

### **Exercise 6: Introducing Advanced Game Features and Finalizing the Game**

#### **Objective:**
This final exercise challenges you to consolidate all the concepts learned in this task by introducing advanced game features such as a timer, power-ups, and a win condition. You will also refine your game to ensure it is polished, functional, and engaging.

---

### **Task: Finalize and Extend Your Game**

1. **Add a Timer**:
   - Introduce a timer to track how long the player survives in the game.
   - Use Java’s `System.currentTimeMillis()` to capture the start and end times of the game. Display the total survival time when the game ends.

2. **Power-Ups**:
   - Add a new `PowerUp` class to the game:
     - Fields: `x`, `y` (position), and `type` (e.g., "score_boost", "extra_life").
     - Constructor: Initialize position and type.
     - Methods: `toString()` to display the power-up’s details.
   - Modify the `game_objects.txt` file to include power-ups. For example:
     ```
     powerup,7,7,score_boost
     powerup,3,6,extra_life
     ```
   - Implement logic in the `GameController` class to handle power-ups:
     - If the player collects a power-up, apply its effect:
       - `score_boost`: Increase the player’s score by 50 points.
       - `extra_life`: Allow the player to survive one collision with an enemy.
     - Remove the power-up from the game world after it is collected.

3. **Win Condition**:
   - Define a win condition for the game:
     - The player wins if they survive for a certain time (e.g., 2 minutes) or achieve a certain score (e.g., 500 points).
   - Display a congratulatory message when the player wins (e.g., "Congratulations! You survived and won the game!").

4. **Game Over Enhancements**:
   - Refine the game-over logic to include detailed feedback:
     - Display the player’s final score and survival time.
     - If the player loses due to a collision, indicate the type of collision (e.g., "Game over: Collided with enemy.").
     - If the player’s score falls below zero, display a message (e.g., "Game over: Score reached zero.").

5. **Polish the User Interface**:
   - Improve the console-based user interface to make it more readable:
     - Use clear headings (e.g., "=== GAME STATUS ===").
     - Organize the display of game objects, the player's position, and score.
     - Add spacing and formatting for better readability.

6. **Testing and Debugging**:
   - Test the game thoroughly with different scenarios:
     - Player collects power-ups.
     - Player achieves the win condition.
     - Player loses due to various reasons (e.g., collision, score reaching zero).
   - Debug any issues to ensure the game runs smoothly and handles edge