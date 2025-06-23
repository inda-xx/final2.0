# 🕹️ Weekly Programming Challenge: Build Your Own Mini-Game Engine!

Welcome to your weekly programming challenge! This week, you’ll combine your creativity and growing programming skills to design and implement a **simple 2D game application** in Java. The game will simulate a basic environment where a player moves around, interacts with enemies, accumulates points, and can win or lose based on gameplay events.

This project will span six structured exercises to help you gradually build your game from scratch, while mastering key programming concepts such as **class design**, **object instantiation from files**, and **creative problem-solving**.

---

## 🎯 Learning Goals

Throughout this task, you will:

- Learn to **design classes** with clear responsibilities.
- Use **file input** to load game entities.
- Practice **object-oriented thinking** and **game logic implementation**.
- Apply **creative thinking** to build unique game mechanics and features.

---

## 🧠 Exercise 1: Game World Planning & Class Responsibilities ✍️

**Objective**: Define the key elements of your game and assign responsibilities to different classes.

**Instructions**:

1. Think about the general structure of your game. What are the key components? (e.g., `Player`, `Enemy`, `Game`, `Scoreboard`, `GameState`, etc.)
2. For each component, describe:
   - Its **purpose**
   - What **data** it holds
   - What **behaviors** (methods) it should support

📄 **Deliverable**: A document outlining your planned classes using this format:

```plaintext
Class: Player
- Fields: positionX, positionY, health, score
- Methods: move(), takeDamage(), increaseScore()
```

🔍 **Focus Concepts**:
- Designing Classes: Identifying responsibilities and interfaces.
- Programming Creatively: Choosing what kind of game experience you want to deliver.

---

## 🗃️ Exercise 2: Define and Load Game Entities from a File 📂

**Objective**: Practice using file I/O to read data and create objects dynamically.

**Instructions**:

1. Create a **text file** called `enemies.txt` with enemy data:

```
Goblin,50,100,5
Orc,250,300,10
Dragon,500,200,25
```

2. Define an `Enemy` class in Java. Use the file to instantiate a list of `Enemy` objects.

📄 **Scaffold Code Snippet**:

```java
public class Enemy {
    private String type;
    private int x, y, damage;

    public Enemy(String type, int x, int y, int damage) {
        this.type = type;
        this.x = x;
        this.y = y;
        this.damage = damage;
    }

    // Add getters and any needed methods
}
```

🔍 **Focus Concepts**:
- Using Data from Files to Instantiate Objects
- Handling exceptions using `try-catch`
- Parsing CSV-like data

---

## 🧱 Exercise 3: Implement Player Movement and Controls 🎮

**Objective**: Create a `Player` class with basic movement functionality.

**Instructions**:

1. Define a `Player` class with position fields and a `move(String direction)` method.
2. Allow the player to move using simple console input (e.g., "up", "down", "left", "right").
3. Print the player's position after each move.

📄 **Scaffold Code Snippet**:

```java
public class Player {
    private int x, y;

    public void move(String direction) {
        if (direction.equals("up")) y--;
        else if (direction.equals("down")) y++;
        // Add left/right movement
    }

    public void printPosition() {
        System.out.println("Player is at (" + x + ", " + y + ")");
    }
}
```

🔍 **Focus Concepts**:
- Designing cohesive class behavior
- Console-based user interaction
- Programming Creatively: Add your own ideas for movement boosts or constraints

---

## 🧮 Exercise 4: Add a Scoring System and Track Progress ⭐

**Objective**: Implement a simple scoring system that updates based on player actions.

**Instructions**:

1. Add a score field to the `Player` class.
2. Create an `increaseScore(int points)` method.
3. Simulate gaining points by defeating enemies or collecting items (you can hardcode this or simulate it).

📄 **Scaffold Code Snippet**:

```java
public void increaseScore(int points) {
    this.score += points;
    System.out.println("Score: " + this.score);
}
```

🔍 **Focus Concepts**:
- State management within objects
- Simple event-driven programming (e.g., simulate a win condition at 100 points)

---

## 💥 Exercise 5: Detect Collisions with Enemies and Handle Interactions ⚔️

**Objective**: Detect when the player "collides" with an enemy and respond appropriately.

**Instructions**:

1. Check if any enemy occupies the same position as the player.
2. If a collision is detected, reduce the player’s health and remove the enemy from the game.
3. Print a message showing the interaction.

📄 **Scaffold Code Snippet**:

```java
for (Enemy enemy : enemies) {
    if (enemy.getX() == player.getX() && enemy.getY() == player.getY()) {
        System.out.println("Collided with " + enemy.getType());
        player.takeDamage(enemy.getDamage());
        // Remove enemy from list
    }
}
```

🔍 **Focus Concepts**:
- Collision detection logic
- Game state updates
- Exception handling (e.g., modifying a list while iterating)

---

## 🎯 Exercise 6: Manage Game States (Start, Playing, Game Over, Win) 🕰️

**Objective**: Implement a game loop that tracks and transitions between different states.

**Instructions**:

1. Create a `GameState` enum with values like `START`, `PLAYING`, `GAME_OVER`, `WIN`.
2. Use a loop to drive the game until an end condition is met.
3. Display messages and allow game restart or exit.

📄 **Scaffold Code Snippet**:

```java
enum GameState {
    START, PLAYING, GAME_OVER, WIN
}

GameState currentState = GameState.START;

while (currentState != GameState.GAME_OVER) {
    // Handle input, update game objects, check win/lose
}
```

🔍 **Focus Concepts**:
- Game loop design
- Creative thinking for game-ending conditions
- Clean class design and state transitions

---

## 🧠 Bonus Challenge: Add Custom Features! 🎨

If you're ahead of schedule or want to challenge yourself further, consider:
- Adding different enemy types with unique behaviors
- Creating a map or level system (loaded from a file!)
- Implementing a simple GUI using a library like JavaFX

---

## ✅ Submission Checklist

Before submitting, make sure you have:
- ✅ A class design document (Exercise 1)
- ✅ A working game that loads enemies from file
- ✅ Player movement and scoring mechanics
- ✅

Sure! Below are the revised and finalized versions of Exercises 1 and 2, designed to be conceptually rich but concise (~300–400 words each). These focus on theoretical understanding and planning, setting the groundwork for the more involved coding tasks to follow.

---

## 🧠 Exercise 1: Game World Planning & Class Responsibilities ✍️

**Objective**: Understand how to design classes by identifying key responsibilities and relationships in your game architecture.

**Overview**:  
Before you dive into coding, it’s essential to think like a software designer. A well-structured game relies on clearly defined classes that each serve a specific purpose. In this exercise, you will analyze your game idea and break it down into a set of collaborating classes. This will lay the foundation for your entire project.

**Instructions**:

1. Reflect on what kind of simple 2D game you want to build. Will it involve a character collecting items? Fighting enemies? Reaching a goal?
2. Identify the main components (e.g., `Player`, `Enemy`, `Game`, `Item`, `Scoreboard`, `GameState`).
3. For each component, define:
   - Its role or purpose in the game.
   - The data it should store (fields).
   - The actions it can perform (methods).

**Deliverable**:  
Create a design document (plain text or PDF) listing your proposed classes in this format:

```plaintext
Class: Enemy
- Fields: type, x, y, damage
- Methods: getPosition(), attack(Player), takeDamage()
```

**Reflection Questions** (Answer briefly in your document):

- What makes a class “well-designed”?
- How can separating responsibilities between classes help you write better code?
- Can any of your classes be reused in other games or programs?

**Key Concepts**:
- Designing Classes: Focus on cohesion, responsibility, and clear interfaces.
- Programming Creatively: Think about what makes your game unique and how your design supports that.

---

## 🗃️ Exercise 2: Define and Load Game Entities from a File 📂

**Objective**: Explore how to represent game data externally and use Java to load it into your program by creating objects dynamically.

**Overview**:  
Games often rely on external data files to define levels, characters, or configurations. In this exercise, you’ll prepare to load "enemy" characters from a file into your game. This introduces the powerful concept of using files to drive object creation at runtime — a key step in making flexible, data-driven applications.

**Instructions**:

1. Study the following sample data in a text file named `enemies.txt`:

```
Goblin,50,100,5
Orc,250,300,10
Dragon,500,200,25
```

Each line represents an enemy, with values for type, x-position, y-position, and damage.

2. Without coding yet, answer the following questions in a short write-up (half a page):

- What Java data types would you use for each of the values in the file?
- How could you split each line to extract this data?
- What should happen if a line is missing a value or contains invalid data?
- What fields and constructor should your `Enemy` class have to support this data?

3. Consider the advantages of storing this information in a file rather than hardcoding it in your program. How does this improve maintainability or flexibility?

**Deliverable**:  
Submit a brief write-up (max 1 page) explaining how you would load and represent these enemy objects from a file, including:
- A proposed constructor signature for the `Enemy` class
- Your answers to the questions above

**Key Concepts**:
- Using Data from Files to Instantiate Objects
- File I/O and basic parsing
- Defensive programming and error handling

---

These two exercises build the conceptual framework necessary for students to confidently proceed with code implementation in Exercises 3–6.

Certainly! Below are the next two exercises — Exercise 3 and Exercise 4 — crafted to serve as a transition from conceptual design (Exercises 1 & 2) to full implementation and logic-heavy tasks (Exercises 5 & 6). These exercises emphasize applying object-oriented design in practice, integrating file-based data into gameplay, and establishing interactive behavior through code.

---

## 🎮 Exercise 3: Implement the Player Class and Basic Movement 🚶‍♂️

**Objective**: Translate your class design into working code by implementing a `Player` class with movement functionality and basic console interaction.

**Overview**:  
Now that you've planned your class structure and thought through how entities like `Player` should behave, it's time to bring your ideas to life in code. This exercise introduces user input, object state changes, and real-time feedback — core ideas in any interactive application.

**Instructions**:

1. Create a class named `Player` with the following:
   - Fields: `x`, `y` (starting position), `health`, and `score`.
   - Constructor to initialize the player’s starting values.
   - A method `move(String direction)` that changes the player's `x` and `y` based on movement:
     - `"up"` decreases `y`
     - `"down"` increases `y`
     - `"left"` decreases `x`
     - `"right"` increases `x`
   - A method `printPosition()` that prints the player’s current coordinates.

2. Implement a simple command-line loop in your `main()` method that:
   - Prompts the user for movement commands.
   - Updates the player's position using `move()`.
   - Prints the player’s new position after each move.
   - Ends the game if the user types `"exit"`.

3. Think creatively — add a temporary feature such as:
   - A movement boundary (e.g., player can’t move outside a 10x10 grid).
   - A "boost" command that moves the player two steps instead of one.

**Scaffold Snippet**:

```java
Scanner scanner = new Scanner(System.in);
Player player = new Player();

while (true) {
    System.out.print("Enter move (up/down/left/right/exit): ");
    String input = scanner.nextLine();
    if (input.equals("exit")) break;
    player.move(input);
    player.printPosition();
}
```

**Deliverable**:
- Java class file: `Player.java`
- A `main()` method in a separate file (`Game.java` or similar) that demonstrates movement
- A brief README (5–6 lines) explaining your creative enhancements

**Key Concepts**:
- Class implementation from a design document
- Real-time user interaction via console input
- Programming Creatively: Allowing for unique behavior or constraints

---

## ⭐ Exercise 4: Add a Scoring System and Simulate Interactions ✨

**Objective**: Extend the `Player` class with score tracking and simulate basic game interactions that impact the score.

**Overview**:  
Scoring adds purpose to gameplay and allows for win/loss conditions. In this exercise, you'll simulate interactions between the player and game elements (e.g., enemies, items) that increase or decrease the player's score. This prepares you for implementing real gameplay logic in future exercises.

**Instructions**:

1. Extend your `Player` class:
   - Add a `score` field (if not already present).
   - Add a method `increaseScore(int points)` and optionally `decreaseScore(int points)`.

2. Simulate interactions:
   - Create a list of “items” (can be represented by a simple `Item` class or hardcoded locations).
   - If the player moves to a location that matches an item’s position, increase the score and print a message.
   - Optionally simulate enemy encounters that reduce score or health.

3. Use a conditional in your game loop to check if the player has reached a score threshold (e.g., 100 points) and print a win message.

4. Add basic feedback:
   - After every move, print the updated score.
   - Notify the player when they collect items or reach the win condition.

**Optional**:  
Instead of hardcoding item positions, try loading them from a simple file like you did for enemies (e.g., `items.txt` with position and point value).

**Scaffold Snippet**:

```java
if (player.getX() == item.getX() && player.getY() == item.getY()) {
    System.out.println("Collected item! +10 points");
    player.increaseScore(10);
}
```

**Deliverable**:
- Updated `Player.java` with score logic
- An `Item` class if used (optional)
- Updated `main()` game loop that integrates movement and score tracking
- A short paragraph (3–4 sentences) explaining how you simulated interaction

**Key Concepts**:
- State management using object fields
- Simulated gameplay logic (interaction → consequence → feedback)
- Laying groundwork for future collision and event handling

---

## 🔗 Transition to Next Steps

These exercises require you to take your design ideas and implement them as functioning code. You’ll be managing object state, taking user input, and simulating basic interactions — all key foundations before you tackle more dynamic elements like enemy collisions and full game state transitions.

In the next exercises, you will:
- Detect real-time collisions between player and enemies
- Manage enemy removal and player health
- Implement a structured game loop with win/lose conditions

Keep your code modular and readable — it will make the next steps much easier!

---

Let me know if you'd like solutions, rubrics, or tools for automated testing to go with these exercises.

Absolutely! Below are well-structured, final-stage Exercises 5 and 6 for your programming challenge. These exercises are deliberately comprehensive, guiding students through meaningful, hands-on experiences in game logic, object interaction, and state management, while reinforcing the week’s learning objectives.

---

## ⚔️ Exercise 5: Detect Collisions with Enemies and Handle Interactions

**Objective**: Implement collision detection between the `Player` and `Enemy` objects, and simulate consequences such as taking damage or defeating enemies.

---

### 🔍 Summary

Your game is interactive — but can your player survive? In this exercise, you’ll add **collision detection** and **interaction logic** so that when the player’s position matches an enemy’s, a battle occurs! This will involve scanning through your list of enemies, checking for matches, and updating game state accordingly.

---

### 🧩 Instructions

1. ✅ **Enhance the Player Class**  
   Add the following to your `Player` class if not already present:
   - A `health` field initialized in the constructor (e.g., 100).
   - A method `takeDamage(int amount)` that subtracts health and prints a status message.
   - A method `isAlive()` that returns `true` if health > 0.

2. ✅ **Enhance the Enemy Class**
   Ensure your `Enemy` class has:
   - A `getX()`, `getY()` method.
   - A `getDamage()` method.
   - A `getType()` method (for printing/logging).
   - Additional optional method: `isDefeated()` if you want to incorporate enemy health.

3. ✅ **Collision Detection Logic**
   In your game loop:
   - After the player moves, check if their current position matches any enemy’s position.
   - If a match is found:
     - Print a collision message (e.g., "You bumped into a Goblin!").
     - Call `player.takeDamage(enemy.getDamage())`.
     - Remove the enemy from the game (from the `List<Enemy>`).
     - Optionally, increase the player’s score after a successful encounter.

4. ✅ **Handle List Removal Safely**
   Use an iterator or a secondary list to avoid `ConcurrentModificationException`. Example scaffold:

   ```java
   Iterator<Enemy> iter = enemies.iterator();
   while (iter.hasNext()) {
       Enemy enemy = iter.next();
       if (enemy.getX() == player.getX() && enemy.getY() == player.getY()) {
           System.out.println("Collided with " + enemy.getType());
           player.takeDamage(enemy.getDamage());
           iter.remove(); // Safely remove enemy
       }
   }
   ```

5. ✅ **Print Player Status After Each Move**
   After each turn, print:
   - Player's current health
   - Player's score
   - Remaining number of enemies

6. ✅ **Win / Lose Conditions**
   - If `player.isAlive()` returns `false`, end the game with a "Game Over" message.
   - If all enemies are defeated, print a "You Win!" message.

---

### 📄 Deliverables

- Updated `Player.java` and `Enemy.java` files
- A working `main()` loop that handles:
  - Movement
  - Collision detection
  - Player health
  - Enemy removal
- A brief comment in your code (2–3 lines) explaining how you avoided list modification errors

---

### 🔑 Key Concepts

- Collision detection logic
- Object comparison and interaction
- Defensive programming & error avoidance
- Game state updates (health, score, entity removal)

---

### 💡 Creative Extensions (Optional)

- Give enemies health and allow two-way combat (player can also attack).
- Add a "combat log" to print detailed messages per interaction.
- Introduce different enemy types with unique behaviors (e.g., fast-moving or ranged enemies).

---

## 🕰️ Exercise 6: Implement a Game Loop and Manage Game States

**Objective**: Build a full game loop with structured state transitions using an enum-based state machine. Finalize your game’s logic and user flow from start to win/lose.

---

### 🔍 Summary

You’ve implemented most of your game’s logic. Now let’s structure it using **game states**. This will help you control game flow cleanly — from the welcome screen to playing, and finally to win/loss conditions and restarting.

---

### 🧩 Instructions

1. ✅ **Create a GameState Enum**
   Define an enum in a file called `GameState.java`:

   ```java
   public enum GameState {
       START,
       PLAYING,
       GAME_OVER,
       WIN
   }
   ```

2. ✅ **Initialize the Game Loop**
   Create a `Game` class with a `main()` method that:
   - Uses a `GameState currentState` variable
   - Starts in the `START` state

3. ✅ **Handle State Transitions**
   Use a `while` loop to manage transitions:

   ```java
   GameState currentState = GameState.START;

   while (true) {
       switch (currentState) {
           case START:
               // Show welcome message
               // Wait for user input to start
               currentState = GameState.PLAYING;
               break;

           case PLAYING:
               // Run main game loop (movement, collision, score updates)
               // If player dies: currentState = GAME_OVER;
               // If player defeats all enemies: currentState = WIN;
               break;

           case GAME_OVER:
               // Print game over message
               // Prompt to restart or exit
               break;

           case WIN:
               // Print win message
               // Prompt to restart or exit
               break;
       }
   }
   ```

4. ✅ **Restart or Exit**
   After win/loss, prompt the player:
   - `"Restart"` → reset all game data (player, enemies, score, etc.)
   - `"Exit"` → break the loop and end the program

5. ✅ **Organize Your Code**
   - Move the game logic (movement, collisions, score checks) into helper methods for readability.
   - Keep class responsibilities clean: `Player` handles health/score, `Game` handles flow.

---

### 📄 Deliverables

- A `Game.java` file with a working main loop and game state transitions
- A `GameState.java` enum file
- Updated versions of `Player.java`, `Enemy.java`
- Brief inline comments (or a separate README) explaining how your game transitions between states

---

### 🔑 Key Concepts

- Enum usage for state machines
- Structured control flow using `switch` statements
- Modular game loop design
- Creative problem-solving: wrapping gameplay in a user-friendly loop

---

### 📚 CS1 Concepts Reinforced

- Control structures (`while`, `switch`)
- Enums and constants
- Modular method decomposition
- Program reusability and replayability

---

### 💡 Optional Creative Enhancements

- Add a pause state or menu
- Implement a “level-up” system where enemies get tougher after each round
- Add a timer or turn limit to increase difficulty

---

## ✅ Final Submission Checklist

