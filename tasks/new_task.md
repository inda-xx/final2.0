### 🎮 Weekly Programming Task: "Dungeon Quest" Text-Based Adventure Game  
**Theme**: Create a console-based game where a player navigates a dungeon, collects treasures, avoids enemies, and earns points.  

---

#### 📚 **Exercise 1: Designing Classes (Theoretical)**  
**Goal**: Identify the classes needed for the game and define their responsibilities.  
**Tasks**:  
1. Sketch a UML diagram or write descriptions for classes like `Player`, `Enemy`, `GameMap`, and `ScoreManager`.  
2. Define their attributes (e.g., `Player` has `positionX`, `positionY`, `health`) and methods (e.g., `move()`, `attack()`).  
**Scaffolding**:  
```java  
// Example class outline (DO NOT IMPLEMENT YET!)  
public class Player {  
    private int x, y;  
    public void move(String direction) { /* ... */ }  
}  
```  
**Reflection Question**: How can the `Enemy` class interact with the `Player` without directly accessing its fields?  

---

#### 📂 **Exercise 2: File I/O for Object Initialization (Theoretical → Practical)**  
**Goal**: Load enemy data (name, strength, speed) from a file to create `Enemy` objects.  
**Tasks**:  
1. Design a CSV file `enemies.csv` with columns: `type,strength,speed`.  
2. Plan how to parse this data using `BufferedReader` and split strings.  
**Scaffolding**:  
```java  
// Partial example for file reading  
try (BufferedReader br = new BufferedReader(new FileReader("enemies.csv"))) {  
    String line;  
    while ((line = br.readLine()) != null) {  
        // Split line into parts and create Enemy objects  
    }  
}  
```  
**Reflection Question**: How would you handle a corrupted line in the file (e.g., missing data)?  

---

#### 🕹️ **Exercise 3: Implementing Player Movement (Programming)**  
**Goal**: Allow the player to move using WASD keys in a 2D grid.  
**Tasks**:  
1. Use a loop to read user input (e.g., `Scanner`).  
2. Update the player’s coordinates based on input.  
**Scaffolding**:  
```java  
// Input handling snippet  
Scanner scanner = new Scanner(System.in);  
String input = scanner.nextLine().toLowerCase();  
switch(input) {  
    case "w": player.moveUp(); break;  
    // Add cases for other directions  
}  
```  

---

#### ⚖️ **Exercise 4: Scoring System (Programming)**  
**Goal**: Track points when the player collects treasures or defeats enemies.  
**Tasks**:  
1. Create a `ScoreManager` class with methods like `addPoints(int points)`.  
2. Trigger scoring events (e.g., +10 for treasure, +50 for defeating an enemy).  
**Scaffolding**:  
```java  
// Example method in ScoreManager  
public void addPoints(int points) {  
    totalScore += points;  
    System.out.println("Score: " + totalScore);  
}  
```  

---

#### 🧟 **Exercise 5: Enemy Interactions (Advanced Programming)**  
**Goal**: Implement enemy behavior (e.g., chase the player) using data from `enemies.csv`.  
**Tasks**:  
1. Load enemy stats from the file and initialize `Enemy` objects.  
2. Implement a method `updateEnemyPosition(Player player)` to move enemies toward the player.  
**Scaffolding**:  
```java  
// Example Enemy constructor  
public Enemy(String type, int strength, int speed) {  
    this.type = type;  
    // Initialize other attributes  
}  
```  

---

#### 🌟 **Exercise 6: Creative Feature Integration (Open-Ended)**  
**Goal**: Add a unique feature (e.g., power-ups, traps, or a boss battle).  
**Tasks**:  
1. Design a new class (e.g., `PowerUp`) and define its interaction rules.  
2. Test your feature with peers and refine based on feedback.  
**Scaffolding**:  
```java  
// Example PowerUp class stub  
public class PowerUp {  
    public void applyEffect(Player player) { /* ... */ }  
}  
```  

**Submission**: Submit your Java project + a short video demoing your creative feature!  

---  
**Learning Goals Achieved**:  
- Class design for maintainability 🏗️  
- Dynamic object creation from files 📄  
- Creative problem-solving 🌈

### 🎮 Weekly Programming Task: "Dungeon Quest" Text-Based Adventure Game  
**Theme**: Create a console-based game where a player navigates a dungeon, collects treasures, avoids enemies, and earns points.  

---

#### 📚 **Exercise 1: Designing Classes (Theoretical)**  
**Goal**: Identify core classes and their responsibilities to establish a robust object-oriented foundation.  

**Tasks**:  
1. **Class Identification**: Propose 4-5 essential classes (e.g., `Player`, `Enemy`, `Treasure`, `GameMap`). For each, write a 1-sentence purpose (e.g., "`Player` tracks position, health, and movement").  
2. **Attributes and Methods**: Define 2-3 critical attributes and 1-2 key methods per class. Avoid implementation details (e.g., `Player` has `positionX`, `positionY`, and a `move(direction)` method).  
3. **Interaction Design**: Explain how the `Enemy` class could *indirectly* affect the `Player` (e.g., reducing health via a `dealDamage()` method rather than direct field access).  

**Scaffolding**:  
```java  
// Example conceptual outline  
public class GameMap {  
    private int[][] grid;  // 2D grid for dungeon layout  
    public boolean isPositionValid(int x, int y) { /* ... */ }  
}  
```  

**Reflection Questions**:  
- Why should classes avoid directly modifying each other’s fields?  
- How does encapsulation improve code maintainability in this game?  

---

#### 📂 **Exercise 2: File I/O Strategy Design (Theoretical)**  
**Goal**: Plan how to load external data (enemy stats) into the game using file I/O.  

**Tasks**:  
1. **File Format Design**: Design a structured file (e.g., CSV, JSON) to store enemy data. List required fields (e.g., `type`, `strength`, `speed`).  
2. **Parsing Logic**: Outline steps to read the file line-by-line, split data, and validate entries (e.g., checking for missing values).  
3. **Error Handling**: Propose strategies to handle corrupted data (e.g., invalid numbers, missing lines).  

**Scaffolding**:  
```java  
// Conceptual exception-handling snippet  
try {  
    // Read file  
} catch (IOException e) {  
    System.out.println("Error: File not found!");  
}  
```  

**Reflection Questions**:  
- What are the risks of not validating data during file parsing?  
- How could you ensure the game still runs if the `enemies.csv` file is missing?  

---

**Learning Goals Introduced**:  
- Class design principles (encapsulation, cohesion) 🏗️  
- File I/O strategies for dynamic object creation 📄  

These exercises set the stage for implementing the game’s core systems in later tasks. Focus on clear, modular design and error-resistant data handling!

---

#### 🗺️ **Exercise 3: Map Initialization from File (Programming)**  
**Goal**: Implement a `GameMap` class that loads dungeon layouts from a file and validates movement.  

**Tasks**:  
1. Create `dungeon.txt` with a grid layout using symbols (e.g., `#` = wall, `.` = path).  
2. Read the file to initialize a 2D array in `GameMap`, handling `FileNotFoundException`.  
3. Implement `isPositionValid(int x, int y)` to check boundaries and walkable terrain.  

**Scaffolding**:  
```java  
// Partial GameMap implementation  
public class GameMap {  
    private char[][] grid;  
    
    public GameMap(String filename) {  
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {  
            // Build grid from file lines  
        } catch (IOException e) {  
            // Initialize default map  
        }  
    }  
    
    public boolean isPositionValid(int x, int y) {  
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length  
               && grid[x][y] != '#';  
    }  
}  
```  

**Reflection Questions**:  
- Why is it beneficial to separate map data into an external file?  
- How does providing a default map improve error resilience?  

---

#### 🧭 **Exercise 4: Player Class Implementation (Programming)**  
**Goal**: Create a `Player` class that interacts with `GameMap` through encapsulated methods.  

**Tasks**:  
1. Implement `Player` with `x`, `y`, and `health` attributes.  
2. Add `move(direction)` method that updates coordinates ONLY if `GameMap.isPositionValid()`.  
3. Add `getPosition()` method returning coordinates as an array (preserves encapsulation).  

**Scaffolding**:  
```java  
public class Player {  
    private int x, y, health = 100;  
    
    public void move(String direction, GameMap map) {  
        int newX = x, newY = y;  
        switch(direction.toLowerCase()) {  
            case "w": newX--; break;  
            // Add other directions  
        }  
        if (map.isPositionValid(newX, newY)) {  
            x = newX;  
            y = newY;  
        }  
    }  
    
    public int[] getPosition() { return new int[]{x, y}; }  
}  
```  

**Reflection Questions**:  
- Why should `Player` coordinates be private rather than public?  
- How does returning a copy of the position via `getPosition()` maintain encapsulation?  

---

**Learning Goals Reinforced**:  
- **File-to-Object Mapping**: Dynamically building game environments from external data 📂→🗺️  
- **Encapsulation Practice**: Controlling access to class internals through methods 🔒  
- **Class Collaboration**: Establishing clear communication between `Player` and `GameMap` 🤝  

These exercises bridge theory and implementation, setting up core systems for enemy interactions and scoring in later tasks. Focus on clean class interfaces and defensive programming!

#### 🧟 **Exercise 5: Enemy System Implementation (Programming)**  
**Goal**: Create dynamic enemy behaviors using file-loaded data and implement combat mechanics.  

**Tasks**:  
1. **Enemy Initialization**:  
   - Load `enemies.csv` (created in Exercise 2) using `BufferedReader`  
   - Handle corrupted data: Skip lines with missing/invalid values, log warnings  
   - Instantiate `Enemy` objects with parsed `type`, `strength`, and `speed`  

2. **Chase Algorithm**:  
   - Implement `enemy.updatePosition(Player player)` where enemies move toward the player  
   - Use `speed` value to determine how many tiles an enemy can move per turn  
   - Validate movements with `GameMap.isPositionValid()`  

3. **Combat System**:  
   - Add `Player.takeDamage(int amount)` and `Enemy.attack(Player target)` methods  
   - Trigger combat when player/enemy positions collide  

**Scaffolding**:  
```java  
// Partial Enemy implementation  
public class Enemy {  
    private int speed;  
    public void updatePosition(Player player, GameMap map) {  
        int[] playerPos = player.getPosition();  
        // Calculate movement toward player using speed  
        // Update position only if map.isPositionValid()  
    }  
}  
```  

**Reflection Questions**:  
- How does separating movement logic into `updatePosition()` improve code maintainability?  
- Why is it critical to validate both numerical data in the CSV and movement positions?  

---

#### 🌟 **Exercise 6: Dynamic Event System (Creative Programming)**  
**Goal**: Design and implement an expandable event system using file-driven object creation.  

**Tasks**:  
1. **Event Class Design**:  
   - Create `GameEvent` class with `type` (TRAP/POWERUP), `effect`, and `position`  
   - Load events from `events.csv` (e.g., "HEAL,15,3|4" = restore 15 HP at (3,4))  

2. **Event Triggers**:  
   - Check for event position matches during player movement  
   - Apply effects (modify health/score) and remove consumed events  

3. **Creative Expansion**:  
   - Add at least one custom event type (e.g., TELEPORT, TIMED_BUFF)  
   - Implement visual feedback using console messages  

**Scaffolding**:  
```java  
// Event handling concept  
public class GameEvent {  
    public void trigger(Player player, ScoreManager score) {  
        if (type.equals("HEAL")) player.heal(effectValue);  
        // Add custom event handling  
    }  
}  
```  

**Reflection Questions**:  
- How does using a file-based event system make the game easily expandable?  
- What trade-offs exist between hardcoding events vs. using external files?  

---

**Learning Goals Achieved**:  
- **File-Driven Object Orchestration**: Seamlessly integrate multiple file sources (enemies + events) 📂→⚙️  
- **Behavior Encapsulation**: Keep enemy AI and event logic contained within their classes 🧠  
- **Creative Systems Design**: Build flexible systems allowing endless gameplay variations 🎨  

**Final Challenge**: In your demo video, showcase how all systems interact when a player encounters a custom event type!  

---  
These exercises solidify core OOP concepts while encouraging inventive solutions. By week's end, students will have a fully functional game with file-driven content and expandable architecture!