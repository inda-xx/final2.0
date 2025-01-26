![Task Image](images/task_image_20250126_205044.png)

### 🎮 **Task: Create a Simple Game Application**  
**Theme**: Build a simple game application that includes player movement, a scoring system, and enemy interactions. This task will help you integrate key programming concepts such as **Using Data from Files to Instantiate Objects**, **Designing Classes**, and **Programming Creatively**.  

---

### 📚 **Exercise 1: Understanding Game Data and File Formats**  
**Objective**: Learn how to read and parse data from files to initialize game objects.  

1. **Description**:  
   In this exercise, you will explore how to read data from a file (e.g., a `.txt` or `.csv` file) and use it to create game objects like players, enemies, and items. The file will contain attributes such as player name, starting position, enemy type, and score thresholds.  

2. **Tasks**:  
   - Study the provided file format (e.g., `game_data.txt`) and identify the data fields.  
   - Write pseudocode to parse the file and extract the necessary data.  
   - Discuss how you would handle exceptions (e.g., missing or corrupted data).  

3. **Scaffolding**:  
   ```java
   // Example file format (game_data.txt)
   // Player:Name,X,Y,Score
   // Enemy:Type,X,Y,Speed
   // Item:Type,X,Y,Value

   // Pseudocode for reading the file
   // 1. Open the file using a FileReader or BufferedReader.
   // 2. Read each line and split it into tokens.
   // 3. Check the first token to determine the object type (Player, Enemy, Item).
   // 4. Extract the remaining tokens as attributes.
   ```

---

### 🛠️ **Exercise 2: Designing Classes for the Game**  
**Objective**: Design well-structured classes for the game application.  

1. **Description**:  
   In this exercise, you will design classes for the game entities (e.g., `Player`, `Enemy`, `Item`) and define their responsibilities. Focus on creating cohesive classes with clear interfaces and appropriate fields/methods.  

2. **Tasks**:  
   - Identify the responsibilities of each class (e.g., `Player` handles movement, `Enemy` handles interactions).  
   - Define the fields and methods for each class.  
   - Discuss how you would use design patterns (e.g., Singleton for the game manager) to enhance your design.  

3. **Scaffolding**:  
   ```java
   // Example class structure
   class Player {
       String name;
       int x, y;
       int score;

       void move(int deltaX, int deltaY) {
           // Update player position
       }
   }

   class Enemy {
       String type;
       int x, y;
       int speed;

       void interact(Player player) {
           // Handle enemy-player interaction
       }
   }
   ```

---

### 🧩 **Exercise 3: Implementing Basic Player Movement**  
**Objective**: Implement player movement using keyboard input.  

1. **Description**:  
   In this exercise, you will implement basic player movement using arrow keys. The player should move within a defined boundary (e.g., a 10x10 grid).  

2. **Tasks**:  
   - Use a loop to continuously check for keyboard input.  
   - Update the player's position based on the input.  
   - Ensure the player does not move outside the grid boundaries.  

3. **Scaffolding**:  
   ```java
   // Example code for reading keyboard input
   Scanner scanner = new Scanner(System.in);
   String input = scanner.nextLine();

   // Example movement logic
   if (input.equals("up")) {
       player.move(0, -1);
   } else if (input.equals("down")) {
       player.move(0, 1);
   }
   ```

---

### 🎯 **Exercise 4: Adding a Scoring System**  
**Objective**: Implement a scoring system that updates based on player actions.  

1. **Description**:  
   In this exercise, you will add a scoring system to the game. The score should increase when the player collects items or defeats enemies.  

2. **Tasks**:  
   - Define a method to update the player's score.  
   - Trigger score updates when the player interacts with items or enemies.  
   - Display the score on the screen.  

3. **Scaffolding**:  
   ```java
   // Example score update logic
   void collectItem(Item item) {
       player.score += item.value;
   }

   void defeatEnemy(Enemy enemy) {
       player.score += 10; // Example score increment
   }
   ```

---

### 🧠 **Exercise 5: Implementing Enemy Interactions**  
**Objective**: Add enemy interactions to the game.  

1. **Description**:  
   In this exercise, you will implement enemy interactions. Enemies should move randomly and interact with the player (e.g., reduce the player's score or health).  

2. **Tasks**:  
   - Implement random movement for enemies.  
   - Define interaction logic (e.g., player loses points when colliding with an enemy).  
   - Handle edge cases (e.g., enemies moving outside the grid).  

3. **Scaffolding**:  
   ```java
   // Example random movement logic
   void moveRandomly() {
       int deltaX = (int) (Math.random() * 3) - 1; // Random value between -1 and 1
       int deltaY = (int) (Math.random() * 3) - 1;
       enemy.move(deltaX, deltaY);
   }

   // Example interaction logic
   void checkCollision(Player player, Enemy enemy) {
       if (player.x == enemy.x && player.y == enemy.y) {
           player.score -= 5; // Example penalty
       }
   }
   ```

---

### 🚀 **Exercise 6: Creative Enhancements and Testing**  
**Objective**: Add creative features and test the game.  

1. **Description**:  
   In this exercise, you will add creative enhancements to the game (e.g., power-ups, multiple levels) and test the game for usability and functionality.  

2. **Tasks**:  
   - Add at least one creative feature (e.g., power-ups, traps, or multiple levels).  
   - Test the game with peers and gather feedback.  
   - Iterate on your design based on feedback.  

3. **Scaffolding**:  
   ```java
   // Example creative feature: Power-up
   class PowerUp {
       String type;
       int x, y;

       void applyEffect(Player player) {
           if (type.equals("speed")) {
               player.speed += 2;
           }
       }
   }

   // Example testing feedback loop
   // 1. Play the game yourself.
   // 2. Ask a friend to play and observe their experience.
   // 3. Note any issues or suggestions for improvement.
   ```

---

### 📝 **Submission Guidelines**:  
- Submit all code files and a brief report explaining your design decisions

### 🎮 **Task: Create a Simple Game Application**  
**Theme**: Build a simple game application that includes player movement, a scoring system, and enemy interactions. This task will help you integrate key programming concepts such as **Using Data from Files to Instantiate Objects**, **Designing Classes**, and **Programming Creatively**.  

---

### 📚 **Exercise 1: Understanding Game Data and File Formats**  
**Objective**: Learn how to read and parse data from files to initialize game objects.  

1. **Description**:  
   In this exercise, you will explore how to read data from a file (e.g., a `.txt` or `.csv` file) and use it to create game objects like players, enemies, and items. The file will contain attributes such as player name, starting position, enemy type, and score thresholds.  

2. **Tasks**:  
   - Study the provided file format (e.g., `game_data.txt`) and identify the data fields.  
   - Write pseudocode to parse the file and extract the necessary data.  
   - Discuss how you would handle exceptions (e.g., missing or corrupted data).  

3. **Scaffolding**:  
   ```java
   // Example file format (game_data.txt)
   // Player:Name,X,Y,Score
   // Enemy:Type,X,Y,Speed
   // Item:Type,X,Y,Value

   // Pseudocode for reading the file
   // 1. Open the file using a FileReader or BufferedReader.
   // 2. Read each line and split it into tokens.
   // 3. Check the first token to determine the object type (Player, Enemy, Item).
   // 4. Extract the remaining tokens as attributes.
   ```

---

### 🛠️ **Exercise 2: Designing Classes for the Game**  
**Objective**: Design well-structured classes for the game application.  

1. **Description**:  
   In this exercise, you will design classes for the game entities (e.g., `Player`, `Enemy`, `Item`) and define their responsibilities. Focus on creating cohesive classes with clear interfaces and appropriate fields/methods.  

2. **Tasks**:  
   - Identify the responsibilities of each class (e.g., `Player` handles movement, `Enemy` handles interactions).  
   - Define the fields and methods for each class.  
   - Discuss how you would use design patterns (e.g., Singleton for the game manager) to enhance your design.  

3. **Scaffolding**:  
   ```java
   // Example class structure
   class Player {
       String name;
       int x, y;
       int score;

       void move(int deltaX, int deltaY) {
           // Update player position
       }
   }

   class Enemy {
       String type;
       int x, y;
       int speed;

       void interact(Player player) {
           // Handle enemy-player interaction
       }
   }
   ```

---

### 📝 **Submission Guidelines**:  
- Submit all code files and a brief report explaining your design decisions

---

### 📚 **Exercise 1: Understanding Game Data and File Formats**  
**Objective**: Learn how to read and parse data from files to initialize game objects.  

1. **Description**:  
   In this exercise, you will explore how to read data from a file (e.g., a `.txt` or `.csv` file) and use it to create game objects like players, enemies, and items. The file will contain attributes such as player name, starting position, enemy type, and score thresholds.  

2. **Tasks**:  
   - Study the provided file format (e.g., `game_data.txt`) and identify the data fields.  
   - Write pseudocode to parse the file and extract the necessary data.  
   - Discuss how you would handle exceptions (e.g., missing or corrupted data).  

3. **Scaffolding**:  
   ```java
   // Example file format (game_data.txt)
   // Player:Name,X,Y,Score
   // Enemy:Type,X,Y,Speed
   // Item:Type,X,Y,Value

   // Pseudocode for reading the file
   // 1. Open the file using a FileReader or BufferedReader.
   // 2. Read each line and split it into tokens.
   // 3. Check

### 🧩 **Exercise 3: Implementing Basic Player Movement**  
**Objective**: Implement player movement using keyboard input.  

1. **Description**:  
   In this exercise, you will implement basic player movement using arrow keys. The player should move within a defined boundary (e.g., a 10x10 grid). This exercise will help you transition from theoretical design to practical implementation by integrating the `Player` class with user input.  

2. **Tasks**:  
   - Use a loop to continuously check for keyboard input.  
   - Update the player's position based on the input.  
   - Ensure the player does not move outside the grid boundaries.  
   - Display the player's updated position after each move.  

3. **Scaffolding**:  
   ```java
   // Example code for reading keyboard input
   Scanner scanner = new Scanner(System.in);
   String input = scanner.nextLine();

   // Example movement logic
   if (input.equals("up")) {
       player.move(0, -1);
   } else if (input.equals("down")) {
       player.move(0, 1);
   } else if (input.equals("left")) {
       player.move(-1, 0);
   } else if (input.equals("right")) {
       player.move(1, 0);
   }

   // Example boundary check
   if (player.x < 0) player.x = 0;
   if (player.x > 9) player.x = 9;
   if (player.y < 0) player.y = 0;
   if (player.y > 9) player.y = 9;

   // Display updated position
   System.out.println("Player position: (" + player.x + ", " + player.y + ")");
   ```

4. **Deliverables**:  
   - A working implementation of player movement within a 10x10 grid.  
   - A brief explanation of how you handled boundary checks and user input.  

---

### 🎯 **Exercise 4: Adding a Scoring System**  
**Objective**: Implement a scoring system that updates based on player actions.  

1. **Description**:  
   In this exercise, you will add a scoring system to the game. The score should increase when the player collects items or defeats enemies. This exercise builds on the `Player` and `Item` classes designed earlier and integrates them with the game logic.  

2. **Tasks**:  
   - Define a method to update the player's score.  
   - Trigger score updates when the player interacts with items or enemies.  
   - Display the score on the screen after each interaction.  
   - Ensure the score cannot go below zero.  

3. **Scaffolding**:  
   ```java
   // Example score update logic
   void collectItem(Item item) {
       player.score += item.value;
       System.out.println("Collected " + item.type + "! Score: " + player.score);
   }

   void defeatEnemy(Enemy enemy) {
       player.score += 10; // Example score increment
       System.out.println("Defeated " + enemy.type + "! Score: " + player.score);
   }

   // Example score validation
   if (player.score < 0) {
       player.score = 0;
   }
   ```

4. **Deliverables**:  
   - A working scoring system that updates based on player interactions.  
   - A brief explanation of how you implemented score updates and validation.  

---

### 📝 **Submission Guidelines**:  
- Submit all code files and a brief report explaining your design decisions.  
- Ensure your code is well-commented and follows good coding practices.  

---

### 🧠 **Transition to Exercises 5 & 6**:  
These exercises (3 & 4) act as a bridge between the theoretical groundwork (Exercises 1 & 2) and the more advanced coding tasks (Exercises 5 & 6). By completing these exercises, you will have a functional game with player movement and a scoring system, setting the stage for adding enemy interactions and creative enhancements in the next exercises.

### 🧠 **Exercise 5: Implementing Enemy Interactions**  
**Objective**: Add enemy interactions to the game.  

1. **Description**:  
   In this exercise, you will implement enemy interactions. Enemies should move randomly and interact with the player (e.g., reduce the player's score or health). This exercise builds on the `Enemy` class and integrates it with the game logic.  

2. **Tasks**:  
   - Implement random movement for enemies.  
   - Define interaction logic (e.g., player loses points when colliding with an enemy).  
   - Handle edge cases (e.g., enemies moving outside the grid).  
   - Display the player's updated score after each interaction.  

3. **Scaffolding**:  
   ```java
   // Example random movement logic
   void moveRandomly(Enemy enemy) {
       int deltaX = (int) (Math.random() * 3) - 1; // Random value between -1 and 1
       int deltaY = (int) (Math.random() * 3) - 1;
       enemy.move(deltaX, deltaY);

       // Boundary check for enemies
       if (enemy.x < 0) enemy.x = 0;
       if (enemy.x > 9) enemy.x = 9;
       if (enemy.y < 0) enemy.y = 0;
       if (enemy.y > 9) enemy.y = 9;
   }

   // Example interaction logic
   void checkCollision(Player player, Enemy enemy) {
       if (player.x == enemy.x && player.y == enemy.y) {
           player.score -= 5; // Example penalty
           System.out.println("Collided with " + enemy.type + "! Score: " + player.score);
       }
   }
   ```

4. **Deliverables**:  
   - A working implementation of enemy movement and interactions.  
   - A brief explanation of how you handled random movement and collision detection.  

---

### 🚀 **Exercise 6: Creative Enhancements and Testing**  
**Objective**: Add creative features and test the game.  

1. **Description**:  
   In this exercise, you will add creative enhancements to the game (e.g., power-ups, traps, or multiple levels) and test the game for usability and functionality. This exercise encourages you to think creatively and apply your programming skills to improve the game.  

2. **Tasks**:  
   - Add at least one creative feature (e.g., power-ups, traps, or multiple levels).  
   - Test the game with peers and gather feedback.  
   - Iterate on your design based on feedback.  
   - Ensure the game is functional and free of major bugs.  

3. **Scaffolding**:  
   ```java
   // Example creative feature: Power-up
   class PowerUp {
       String type;
       int x, y;

       void applyEffect(Player player) {
           if (type.equals("speed")) {
               player.speed += 2;
               System.out.println("Speed increased! New speed: " + player.speed);
           } else if (type.equals("shield")) {
               player.score += 20; // Example bonus
               System.out.println("Shield collected! Score: " + player.score);
           }
       }
   }

   // Example testing feedback loop
   // 1. Play the game yourself and note any issues.
   // 2. Ask a friend to play and observe their experience.
   // 3. Note any issues or suggestions for improvement.
   // 4. Iterate on your design to address feedback.
   ```

4. **Deliverables**:  
   - A working game with at least one creative feature.  
   - A brief report summarizing the creative feature, testing process, and feedback received.  
   - Updated code files reflecting the final version of the game.  

---

### 📝 **Submission Guidelines**:  
- Submit all code files and a brief report explaining your design decisions.  
- Ensure your code is well-commented and follows good coding practices.  
- Include a README file with instructions on how to run the game.  

---

### 🎯 **Learning Outcomes**:  
By completing these exercises, you will:  
1. Gain hands-on experience in reading data from files and using it to instantiate objects.  
2. Develop skills in designing cohesive and well-structured classes.  
3. Apply creative problem-solving techniques to enhance the functionality and user experience of your game.  
4. Learn how to test and iterate on your code based on feedback.  

These exercises consolidate all previous steps into a cohesive outcome, providing a comprehensive learning journey for first-year computer science students.