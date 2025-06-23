**🎮 Weekly Programming Project: Build Your Own 2D Adventure Game!**

Welcome to your creative challenge of the week! You will build a **simple 2D text-based or graphical game** (your choice!) that implements player movement, enemy interaction, a scoring system, and manages game state transitions like "game over" or "you win". This project will help solidify your understanding of **object-oriented programming**, **file I/O**, and **creative problem solving**.

Your final game should:
- Allow the player to move using simple controls (e.g., WASD).
- Include enemies that interact with the player.
- Track a score that increases as the player collects items or defeats enemies.
- Detect collisions (e.g., when a player touches an enemy or an item).
- Load game levels, enemies, or items from a file dynamically.
- Manage different game states (e.g., running, paused, game over).

---

## 📘 Exercise 1: Designing a Game World – Concepts in Class Design

**Goal:** Understand how to break down a game into classes and define their responsibilities.

**Instructions:**
- Think about what objects exist in a game: `Player`, `Enemy`, `Item`, `GameMap`, `GameEngine`, etc.
- For each object, define:
  - Its responsibilities
  - Its key fields (e.g., `x`, `y` positions, `health`, `name`)
  - Its key methods (e.g., `move()`, `attack()`, `interact()`)

**Deliverable:**
- A short document (1-2 pages) or UML diagram that outlines your class design.

**Tip:** Use this template to help you organize your thinking:

```java
public class Player {
    private int x;
    private int y;
    private int health;
    private int score;

    public void move(char direction) {
        // Move based on WASD keys
    }

    public void collect(Item item) {
        // Increase score based on item value
    }
}
```

---

## 🗃️ Exercise 2: Loading a Game Map from a File

**Goal:** Learn how to parse a file and use its contents to create game objects.

**Instructions:**
- Design a simple file format to describe your game world. For example:

```
P,1,3   // Player starts at (1,3)
E,2,1   // Enemy at (2,1)
I,0,4,10 // Item at (0,4) worth 10 points
```

- Write a class `GameLoader` that reads this file and instantiates objects accordingly.

**Deliverable:**
- A `GameLoader.java` class with a method like:

```java
public class GameLoader {
    public static List<GameObject> loadGame(String filename) {
        // Read file and return list of game objects
    }
}
```

**Tip:** Think about using `BufferedReader` and `String.split(",")` to parse lines.

---

## 🧱 Exercise 3: Implementing Player Movement

**Goal:** Implement movement logic for the player using keyboard inputs.

**Instructions:**
- Allow the player to move in four directions using WASD.
- Prevent the player from moving outside the game boundaries.

**Deliverable:**
- A method `move(char direction)` in your `Player` class.
- A simple game loop that accepts input and updates the player position.

**Scaffolding:**

```java
Scanner scanner = new Scanner(System.in);
char input = scanner.next().charAt(0);
player.move(input);
```

**Challenge:** Print a basic map showing player and enemy positions after each move.

---

## 💥 Exercise 4: Adding Enemies and Basic Collision Detection

**Goal:** Introduce enemies and handle simple collision between player and enemies.

**Instructions:**
- Add an `Enemy` class with a position.
- Check if the player’s position matches any enemy’s position.
- If so, reduce player health or end the game.

**Deliverable:**
- Collision logic that determines when the player collides with an enemy.
- A `checkCollisions()` method in your game engine or main loop.

**Scaffolding:**

```java
for (Enemy enemy : enemies) {
    if (player.getX() == enemy.getX() && player.getY() == enemy.getY()) {
        // Handle collision
    }
}
```

---

## 🧠 Exercise 5: Managing Game State and Scoring System

**Goal:** Add a scoring system and manage different game states (running, paused, game over).

**Instructions:**
- Create a `GameEngine` class to manage game logic.
- Define an enum `GameState { RUNNING, PAUSED, GAME_OVER }`.
- Track player’s score and print it after each move.

**Deliverable:**
- A fully working game loop that:
  - Updates score when items are collected.
  - Ends the game if the player dies or wins.

**Scaffolding:**

```java
enum GameState {
    RUNNING, PAUSED, GAME_OVER
}
```

**Challenge:** Pause the game and resume based on user input.

---

## 🧑‍🎨 Exercise 6: Creative Enhancements and Level Design from File

**Goal:** Use your creativity to enhance the game and load levels from different files.

**Instructions:**
- Add new features like:
  - Multiple levels
  - Different enemy behaviors (e.g., random movement)
  - Power-ups or traps
- Store each level in a separate `.txt` file and load them dynamically.

**Deliverable:**
- A polished version of your game with at least two levels loaded from files.
- A README describing your game features and how to play.

**Scaffolding:**

```java
// Example of loading multiple levels
for (int i = 1; i <= 2; i++) {
    String levelFile = "level" + i + ".txt";
    List<GameObject> levelObjects = GameLoader.loadGame(levelFile);
    // Play level
}
```

**Tip:** Use exception handling to gracefully handle missing or malformed files.

---

## ✅ Submission Checklist

- [ ] UML or design document (Exercise 1)
- [ ] `GameLoader.java` with file parsing (Exercise 2)
- [ ] Working player movement and keyboard input (Exercise 3)
- [ ] Collision detection with enemies (Exercise 4)
- [ ] Game loop and state management (Exercise 5)
- [ ] Enhanced features and level loading (Exercise 6)
- [ ] README file with instructions and reflections

---

## 💡 Final Thoughts

This project is your chance to combine everything you’ve learned so far: **object-oriented design**, **file handling**, and **creative programming**. Don’t be afraid to explore new ideas and add your personal touch. The goal is not just to make a game—but to **think like a developer**.

Happy coding! 👾

Sure! Below are the revised **Exercises 1 & 2** with a focus on theoretical and conceptual understanding, each within the 300–400 word range. These exercises are designed to prepare students for the implementation tasks in later parts of the project by reinforcing foundational ideas about class design and file-based object creation.

---

## 🧠 Exercise 1: Designing a Game World – Concepts in Class Design

**Learning Goal:** Understand how to model a game system using object-oriented design principles.

Before writing any code, it's important to plan how your game will be structured. In object-oriented programming (OOP), we break complex systems into interacting objects, each with its own state (fields) and behavior (methods). This exercise helps you explore how to do that effectively.

### Instructions:

1. **Identify the main objects** in your game. These could include:
   - `Player`: represents the user-controlled character.
   - `Enemy`: represents non-player characters that challenge the player.
   - `Item`: collectible or usable objects that affect gameplay.
   - `GameMap`: holds the layout and object positions.
   - `GameEngine`: controls game logic and state transitions.

2. For each object, define:
   - **Responsibilities**: What is this object supposed to do?
   - **Fields**: What information does it store?
   - **Methods**: What can it do, or what operations can be performed on it?

3. Discuss how objects interact. For example:
   - How does `Player` interact with `Item`?
   - When does the `GameEngine` update the `GameMap`?

4. Optional: Draw a UML diagram showing the relationships between classes.

### Deliverable:

Submit a 1–2 page design document or a class diagram describing your proposed class structure. Use bullet points or tables to describe fields and methods for clarity.

### Reflection Questions:

- Why is it useful to separate responsibilities into different classes?
- How does OOP help make your game easier to extend (e.g., adding new enemies or levels)?
- What challenges can arise when designing too many or too few classes?

🧩 Think of your design as a blueprint—it doesn’t need to be perfect, but it should be clear and adaptable.

---

## 📄 Exercise 2: From Text to Game – Thinking About File-Based Object Creation

**Learning Goal:** Learn how to represent and load objects from a file to create a dynamic game world.

Games often load data from external files to define levels, enemies, items, and more. This allows flexibility—you can change the game setup without modifying the code. In this exercise, you’ll explore how to format and interpret such a file using Java file I/O concepts.

### Instructions:

1. Design a **simple text format** to represent your game world. For example:

```
P,1,3        // P = Player at (1,3)
E,2,1        // E = Enemy at (2,1)
I,0,4,10     // I = Item at (0,4) worth 10 points
```

2. Consider:
   - What symbols or characters will represent different types of objects?
   - How will you structure lines to store object data (type, position, attributes)?
   - How do you ensure the file remains readable and easy to edit?

3. Reflect on how you might **parse each line**:
   - Use `String.split(",")` to break the line into components.
   - Use `Integer.parseInt()` to convert strings into numbers.

4. Think about error handling:
   - What if the file is missing or malformed?
   - How can you ensure only valid objects are created?

### Deliverable:

Submit a brief description (about 1 page) of your file format and how each line will be interpreted. List the object types and the expected format for their data.

### Reflection Questions:

- Why is loading data from a file more flexible than hardcoding values?
- What are the risks of relying on external files?
- How can well-structured file formats help simplify code?

🔍 You’re not writing code yet—but by planning your format now, you’ll make the coding part much easier in the next exercise.

---

These exercises position students to think critically about system structure and data-driven programming before diving into implementation.

Absolutely! Below are detailed and pedagogically balanced descriptions for **Exercise 3** and **Exercise 4**, which serve as a practical bridge between the conceptual design work of Exercises 1 & 2 and the more advanced coding tasks in Exercises 5 & 6. These tasks emphasize object-oriented thinking, reinforce key file-handling skills, and introduce interactive programming in a manageable way for first-year students.

---

## 🎮 Exercise 3: Bringing the Player to Life – Movement and Input

**Learning Goal:** Implement basic user interaction and player movement using keyboard input, while reinforcing object-oriented design.

Now that you've designed your classes and defined how your game is built from file-based data, it’s time to introduce interactivity. In this exercise, you’ll focus on one of the most central components of any game: the player character.

You will write the logic that allows your player to move around the game map in response to keyboard inputs (WASD), while ensuring the player stays within the boundaries of the game world.

### Instructions:

1. Implement the `move(char direction)` method in your `Player` class:
   - `'W'` should move the player up (decrease y).
   - `'S'` should move the player down (increase y).
   - `'A'` should move the player left (decrease x).
   - `'D'` should move the player right (increase x).
   - Don’t allow the player to move outside the map’s bounds (e.g., x and y must stay within 0 and map width/height).

2. Create a basic game loop in a `Main.java` or `GameEngine.java` class:
   - Use a `Scanner` to read user input from the console.
   - After each move, print the player’s current position.
   - Include a simple `while` loop to continue accepting input until the user enters `'Q'` to quit.

3. (Optional) Render a simple text-based grid after each move:
   - Use characters like `P` for Player, `E` for Enemy, `.` for empty space.
   - This helps students visualize the game state.

### Deliverable:

- A working `Player` class with a `move(char direction)` method.
- A main loop that accepts user input and updates the player’s position.
- Map boundary checking to prevent invalid movement.

### Reflection Questions:

- How does separating the movement logic into the `Player` class make your game easier to manage?
- What challenges did you face with input handling or map boundaries?
- How could this system be extended to allow for multiple players or larger maps?

💡 Tip: Make sure your `Player` class doesn’t know about the entire map—it should only care about its own position. Let the game engine handle map boundaries!

---

## 🧱 Exercise 4: Enemies and Encounters – Collision Detection and Interaction

**Learning Goal:** Implement enemy entities and detect collisions between the player and enemies using object-oriented principles and simple control logic.

In most games, the player isn’t alone. This exercise introduces enemy objects and collision detection, marking your first use of interaction logic between game objects. You’ll apply your class design from Exercise 1 and use the game world data from Exercise 2 to make these objects come alive.

### Instructions:

1. Implement an `Enemy` class:
   - Include fields for position (`x`, `y`) and optionally a name or type.
   - Override the `toString()` or create a `display()` method for debugging.

2. Extend your `GameLoader` to read and instantiate `Enemy` objects from the level file.

3. In your game loop (from Exercise 3):
   - After each move, check if the player’s position matches any enemy’s position.
   - If a collision is detected, display a message like “You’ve been caught by an enemy!” and end the game or reduce player health.

4. Add a `checkCollisions()` method in your `GameEngine` or main loop to handle this logic cleanly.

5. (Optional) Represent enemies on the map using a different character (e.g., `E`) when printing the game state.

### Deliverable:

- A complete `Enemy` class.
- Collision detection logic that compares player and enemy positions.
- Updated game loop that ends the game or updates the state when a collision occurs.

### Reflection Questions:

- How did using separate classes for `Player` and `Enemy` help structure your game logic?
- How would you scale this to multiple enemies or dynamic enemy movement?
- What techniques could help make the collision detection more efficient in larger game worlds?

🧩 Extension Idea: Add a health system. When the player collides with an enemy, reduce health instead of ending the game immediately. Display the health after every move.

---

## Summary of Key Concepts Reinforced

These two exercises serve as a vital transition by:

- Applying object-oriented design from Exercise 1.
- Using file-based data to create real game objects (from Exercise 2).
- Introducing interactive loops and real-time feedback.
- Implementing foundational game logic like movement and collisions.

By the end of Exercise 4, students will have a functioning interactive prototype with real-time input and object interaction, ready to be expanded with scoring, game states, and creative features in Exercises 5 and 6.

Absolutely! Below are the final two exercises — **Exercise 5: Managing Game State and Scoring**, and **Exercise 6: Creative Features and Level Loading** — designed to bring together all previous exercises into a complete and functional game. These exercises emphasize synthesis of knowledge and encourage creative, independent thinking within a structured framework.

They are carefully scaffolded for CS1 students: complex enough to be meaningful, but broken down into manageable, guided steps that build confidence and reinforce OOP, file I/O, and game logic.

---

## ✅ Exercise 5: Game Loop, State Management, and Scoring System

🎯 **Learning Goal:** Implement a controllable game loop that manages different game states, supports player actions, and updates the player’s score based on interactions with the world.

Now that your player moves and interacts with enemies, it’s time to manage the overall flow of the game. This includes keeping score, detecting win/lose conditions, and organizing the game’s current state (e.g., running, paused, game over). You'll also formalize your game loop and logic into a `GameEngine` class.

---

### 🧩 Step-by-Step Instructions

1. ✅ **Create a `GameEngine` class**:
   - This class should run the main game loop.
   - It should manage the `Player`, list of `Enemy` and `Item` objects, and the game state.

2. 🧱 **Define a `GameState` enum**:
   ```java
   public enum GameState {
       RUNNING, PAUSED, GAME_OVER
   }
   ```

3. ▶️ **Implement the main game loop**:
   - While in `RUNNING` state:
     - Accept player input (WASD or Q to quit, P to pause).
     - Move the player.
     - Check for collisions with enemies.
     - Check for collisions with items. If collected, remove the item and increase the player’s score.
     - Print the game map after each move and display score/health.
   - If the player’s health reaches 0, switch to `GAME_OVER` and exit the loop.
   - If all items are collected or a win condition is met, display a "You Win" message and end the game.

4. 🧠 **Implement a scoring system**:
   - Each `Item` has a point value (already established in Exercise 2).
   - When the player collects an item, add its value to the player’s score.
   - Display the score after every move.

5. 💤 **Add pause functionality**:
   - If the user inputs `P`, switch to `PAUSED` state.
   - In `PAUSED`, ignore movement and print “Game paused. Press R to resume.”
   - When the user inputs `R`, switch back to `RUNNING`.

---

### 📝 Deliverable

- A working `GameEngine` class with a complete game loop.
- Game states (`RUNNING`, `PAUSED`, `GAME_OVER`) managed using an enum.
- Score increases when items are collected, displayed on screen.
- Game ends with win/lose message based on conditions.

---

### 💬 Reflection Questions

- How does using `GameState` enum simplify your game loop?
- Why is separating the game loop logic into a `GameEngine` class good design?
- How would you save the player's score to a file for a high-score system?

---

### 🔧 Scaffolding Snippet

```java
switch (state) {
    case RUNNING:
        player.move(input);
        checkCollisions();
        break;
    case PAUSED:
        System.out.println("Game paused. Press R to resume.");
        break;
    case GAME_OVER:
        System.out.println("Game Over!");
        break;
}
```

---

## 🎨 Exercise 6: Creative Enhancements and Multi-Level Game Loading

🎯 **Learning Goal:** Extend your game with creative features and load multiple levels from external files, applying everything you’ve learned in a flexible and modular way.

This final exercise challenges you to enhance your game with new features and design multiple levels, each defined in its own file. You’ll learn how to reuse your `GameLoader` to dynamically load levels and manage transitions between them. You’ll also be encouraged to get creative with features like enemy behavior, power-ups, and traps.

---

### 🧩 Step-by-Step Instructions

1. 📂 **Create at least 2 level files** (e.g., `level1.txt`, `level2.txt`):
   - Use the format from Exercise 2 (e.g., P,x,y, E,x,y, I,x,y,value).
   - Level 1 could be simple; Level 2 can have more enemies or items.

2. 📥 **Enhance your `GameLoader`** to load any level file:
   - Add a method `loadLevel(String filename)` that returns all game objects.
   - Reset the player, enemies, and items for each level.

3. 🔄 **Add level progression logic**:
   - When the player collects all items or reaches a special “goal” tile (`G,x,y`), move to the next level.
   - If all levels are completed, display a “You Win the Game!” message.

4. 🧠 **Optional Enhancements (choose 1–2):**
   - Add a `PowerUp` item that boosts health or provides temporary invincibility.
   - Introduce a `Trap` tile that reduces score or health.
   - Make enemies move randomly or chase the player (if you’re feeling adventurous!).
   - Add a high-score system saved in a file (stretch goal).

---

### 📝 Deliverable

- A working game with multiple levels loaded from `.txt` files.
- At least one creative enhancement (power-up, trap, enemy AI, etc.).
- A README file that:
  - Describes your game rules and features.
  - Explains how to run the game and switch between levels.
  - Reflects on what you learned and what you would improve.

---

### 💬 Reflection Questions

- What challenges did you face when loading multiple levels?
- How did you structure your game to make it easy to reset between levels?
- What parts of your design were easiest/hardest to change as you added features?

---

### 🔧 Scaffolding Snippet

```java
for (int level = 1; level <= 2; level++) {
    String filename = "level" + level + ".txt";
    List<GameObject> objects = GameLoader.loadLevel(filename);
    gameEngine.loadObjects(objects);
    gameEngine.run(); // plays one level
}
System.out.println("Congratulations! You finished all levels.");
```

---

### 🏁 Final Thoughts

With this final exercise, you are now the architect of your own game. You’ve designed classes, used file input to create objects, implemented player interaction, and structured your game’s flow using object-oriented techniques.

You’ve also had the chance to creatively extend your game beyond the core requirements — a key part of thinking like a programmer.

---

## ✅ Week 6 Submission Checklist

- [ ] GameEngine class with state management
- [ ] Enum managing game states
- [ ] Scoring system and item collection
