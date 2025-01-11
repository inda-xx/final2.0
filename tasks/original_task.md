# Adventure awaits!

For this week's assignment, you will be creating a fully playable text-based game based on some code provided
for you. As opposed to earlier tasks, you will be given greater freedom to use your creativity and will be able to
showcase what you have learned so far in this course.

### 💀 Deadline

This work should be completed before the exercise on **Friday 8 November**.

**Important note** Due to this deadline, please think twice before creating your own game. It easily becomes very difficult to finish what you set out to do, so it might be better to start small so that you have something ready to hand in if you run out of time. If you do multiple commits during your development cycle you can later go back to a previous commit if you are not done by the deadline. 

### 👩‍🏫 Instructions

For instructions on how to do and submit the assignment, please see the
[assignments section of the course instructions](https://gits-15.sys.kth.se/inda-24/course-instructions#assignments).

### 📝 Preparation

- Review the [lecture slides on Reading and Writing](https://docs.google.com/presentation/d/15GxyDVs5BjzQ7IAB73NL4g-GOhIyCULG4hPJuMejbXU/edit#slide=id.p)
- Review the [lecture slides on Design](https://docs.google.com/presentation/d/1Oqplsow5BUxu3-43WriFONmYzr_wxtmRwHsqDJzefPg/edit#slide=id.p)
- Read and answer all questions in Module 8: [Class Design](https://qbl.sys.kth.se/sections/dd1337_programming/lesson/designing_classes)

### ✅ Learning Goals

This week's learning goals include:

- Using data from files to instantiate objects
- Designing classes
- Programming creatively

### 🚨 Troubleshooting Guide

If you have any questions or problems, follow this procedure: <br/>

1. Look at this week's [posted issues](https://gits-15.sys.kth.se/inda-24/help/issues). Are other students asking about your problem?
2. If not, post a question yourself by creating a [New Issue](https://gits-15.sys.kth.se/inda-24/help/issues/new). Add a descriptive title, beginning with "Task *x*: *summary of problem here*"
3. Ask a TA in person during the [weekly lab](https://queue.csc.kth.se/Queue/INDA). Check your schedule to see when the next lab is.

We encourage you to discuss with your course friends, **but do not share answers!** Similarily, use of any AI services 🤖 are great to help explain things, **but please do not submit AI-generated solutions** - you must be both responsible for your own solutions and must be able to explain them under examination.

### 🏛 Assignment

In the earlier days of computing, [text-based adventure games](https://en.wikipedia.org/wiki/Interactive_fiction)
were a popular form of entertainment, and captured the imagination of many budding programmers. In the [src](src) folder
you can find some code for a very rudimentary game, and you should begin by playing and exploring this game.
You can play the game by going to the [src](src) folder in your terminal and typing:

```bash
javac Game.java
java Game
```

> **Assistant's note:** If you have a version of Java less than 14 then you will get a compile error linked to the Switch 
> statement in `CommandParser.java` (see below). Ric did when he tested this code. The solution is to goto https://www.oracle.com/java/technologies/downloads/
>  and update your runtime. You can always check your version of Java in the terminal by typing `$ java --version`

Once you have played the game and explored what you can do (which is not a lot) take a look at the source code 
and try to understand how the game works. You don't need to understand everything, but the comments in the code should
hopefully explain the most important parts. In the `parse` method of the `CommandParser` class, you will also find
a `switch` expression, which is a more compact way of writing branching code. You can find a summary of `switch` 
expressions below.

<details>
<summary> 📚 Java switch expressions </summary>

Writing a long chain of `if/else` statements can lead to code that is hard to read, and for this a
switch expression is often a better choice. Instead of using a series of `if` statements such as 
```java
if (number == 1) {
    System.out.println("Uno");
} else if (number == 2) {
    System.out.println("Dos");
} else if (number == 3) {
    System.out.println("Tres");
} else {
    System.out.println("Muchos");
}
```

you can use a `switch` expression of the form:

```java
switch (number) {
    case 1 -> System.out.println("Uno"); // If number is one, print "uno" to the terminal
    case 2 -> System.out.println("Dos");
    case 3 -> System.out.println("Tres");
    default -> System.out.println("Muchos"); // The default case will cover all other numbers
}
```

The program will compare the value of `number` to each case, and if there is a match, the code to the right of `->`
will be executed. In the code above, it is just a single method call, but it is possible to also include several lines 
of code within `{}`, such as 

```java
case 1 -> {
    System.out.println("Uno");
    numberIsAPrime = false;
}
case 2 -> {
    System.out.println("Dos");
    numberIsAPrime = true;
}
// etc.
```

However, there are certain limitations to `switch` expressions compared to `if/else` statements. 
The value on which to switch (`number` in the example above) must evaluate to a primitive type (such as `int`), 
a `String` or an [enum type](https://docs.oracle.com/javase/tutorial/java/javaOO/enum.html). Furthermore, 
the value after `case` must be a _constant_ such as `1` or `"hello"`, so it's not possible to add a case such as

```java
case (number < 1) -> System.out.println("Nada");
```

Finally, the cases must be _exhaustive_. A switch expression such as 

```java
switch (number) {
    case 1 -> System.out.println("Uno");
    case 2 -> System.out.println("Dos");
}
```

will give rise to a compiler error, since there are cases not covered by the `switch` expression. To cover every case
it is therefore common to include a `default` case at the end which will always be executed if no other `case` applies.

Java is a language that is constantly evolving and adding new features, so you might sometimes see older and slightly different
`switch` code. The details of all different kinds of switches are beyond the scope of this course, but if you are
interested you can also read about the older [switch statement](https://docs.oracle.com/javase/tutorial/java/nutsandbolts/switch.html).
</details>

#### Exercise 6.0 -- Loading a World Model from File  

In the initial version of the [`Game.java`](src/Game.java) code, there is a method called `generateRooms` that creates
the rooms that the player can move through. This works all right for a simple game, but it's not very convenient, since
you will need to make changes to the code and recompile the whole game if you want to change the description 
of a room.

Having completed the IO exercises in previous tasks, you should be able to see the
potential for storing the rooms for the game as a text file and creating Room objects from these descriptions. 
In the `Game` class, create a new method with the header

```java
private void generateRoomsFromFile(String filename) 
```

This method should read information from a text file, and set up the game according to this information.

One complication we must deal with is the order of creating rooms and then
linking their exits. While it is possible to include the room information and
exits on a single line, it creates a parsing problem, where we create a `Room`
object, but the adjacent `Room`s that you can go to have not yet been created. The original
`generateRooms()` can act as a guide for a simple solution, where we create the rooms
first, then assign the exits. To solve this we can prefix lines in our file and
test with a conditional as we read them. 

1. First, add all rooms. These should be listed in the file as `TYPE;ROOM_NAME;DESCRIPTION`
2. Second, add the exits to the rooms. These should be listed in the file as: `TYPE;FROM;DIRECTION;TO`

For example:

```java
// TYPE; ROOM_NAME; DESCRIPTION
Room,Name1,Description1
Room,Name2,Description2
// TYPE; FROM; DIRECTION; TO
Exit,Name1,East,Name2
Exit,Name2,West,Name1
```

As long as you first define all rooms, and then all the exits, you can build and link the world model of the game. 
Below you can see an outline of how the method could be written.

<details>
    <summary> 🛠 Method outline </summary>

```java
private void generateRoomsFromFile(String filename) {
    // create a HashMap<String, Room> worldModel to store the game world as it is read from file
        
    // Open the file with the room data  
    // While there are more lines in the file, read the next line
    // If the line starts with "Room" then extract the Name and Description 
    // Create a Room with this information and add it to the HashMap, using Name as the key
    
    // Else if the line starts with "Exit" assume the necessary rooms exist in the HashMap and
    // use the addExit() method of the Room class to link Rooms together
    // Hint: this requires us to acces the HashMap twice like:
    // worldModel.get("subway").addExit("north", worldmodel.get("borggarden"));
    
    // Remember to set the currentRoom of the GameState class to the starting room as the final step
    // You can either give the starting room the name "start"
    // or modify the logic above to assume the first room is the starting point
}
```

</details>

We have provided you with a [text file](/src/rooms.txt) which matches the rooms set up in the `generateRooms` method.
Use this file to make sure that your code works correctly and that the game is still playable.

> **Assistant's note:** If you wonder where to begin, have a look at how you read a file line by line in task-7. 
> The only difference should be that the "delimiter" in this case should be a semicolon (`;`) as opposed to a blank space.

#### Exercise 6.1 -- Game design

Now it's time to redesign the existing game to something a bit more fun. Start by creating your own game scenario. 
Do this away from the computer. Don't worry about implementation, classes, or even programming in general, 
just think about inventing an interesting game that you'd like to play. The game can be anything that has as its core 
concept a player moving through different locations. Here are some examples:

<details>
<summary> 🛠 Ideas for game concepts </summary>

- You are trying to find your way to an exam. The doors are closing soon, but you are lost in the M building.
- You are at campus at midnight and must run to the subway while a monster is chasing you.
- You are lost in a shopping mall and must find the exit.
- You are on a field trip and must find a bathroom. 
- You are lost in a hypercube and must teleport your way out.
- You are from the bomb squad and must find and defuse a bomb before it goes off.
- You are an adventurer who searches through a dungeon full of monsters and other characters.
- You are a cat, lost and alone in a cyber city, and must find your cat's family.
</details>

You are completely free to design any text-based game you want. However, in order for this to be a good programming 
task we also have some practical requirements that you need to take into consideration, you can read these below 
in _Exercise 6.2_. 

You do not need to submit anything for this exercise, but it's a good idea to write down what you have planned and
draw a map of the game world using pen and paper or your favorite drawing program before you start writing code.

#### Exercise 6.2 -- Implementing your design

Once you have settled on a game you want to create, it's time to implement this in Java.
You should work based on the existing game code in the [src](src) folder but are free to modify this code in any way you 
like. You may find that your initial game concept is too ambitious or difficult, so keep iterating on your design as you work.

Your game _must_ fulfill these basic requirements:

1. You are not allowed to reuse any of the rooms from the first version of the game (you are allowed to design a game
   that takes place at KTH, but you need to create your own rooms and layout).
2. The rooms must be read from a file using the `generateRoomsFromFile` method you created in _Exercise 6.0_. 
3. It must be possible to win and lose the game by taking (or failing to take) specific game actions. Once the game
   is over the game loop should end and a different message should be printed depending on if the player won or lost.
4. You must create at least one new class and use this class in your game. This class could for instance be
   used to model items that the player can pick up, keys required for certain doors, monsters that the player can fight,
   or any other thing you can think of.
5. The game world should have a minimum of 5 rooms.
6. In order to make it easier for your TA to test your game, you must add a map of your game world in the
   [docs](docs) directory. This can be in the form of a photo or scan of a hand-drawn map, or created using software
   such as [diagrams.net](https://app.diagrams.net/).
7. You must add the following information to the [docs/README.md](docs/README.md) file:
    - A description of the theme of your game.
    - How to win/lose.
    - What class or classes you chose to create and how this is used in the game.

If you get stuck at any point or would like help solving a particular problem, remember to follow the steps of the
🚨 Troubleshooting Guide.

> **Assistant's note:** It's quite easy to get carried away and want to create a huge and complex game,
> but we would recommend that you try to keep it somewhat simple. It's better to create a smaller, well-designed
> game instead of a huge game that is full of bugs. However, if you have the time there is no limit to what features
> you can add to this project.

#### Exercise 6.3 -- Creating documentation

You should already have read the documentation for the classes and methods in the original game classes,
and it should hopefully be evident to you how useful documentation can be for understanding code.
Now it's time to add your own class and method documentation comments. 

Using Javadoc, write the class documentation for all the `public` classes and methods that you have created or modified.
First, briefly review the **Format of a Doc Comment** and **Example of Doc Comments** sections from the
[official documentation](http://www.oracle.com/technetwork/java/javase/documentation/index-137868.html)
on Javadoc from Oracle. Then go through your classes and add Javadoc according to the requirements below:

<details>
<summary> 📚 What to add to a class Javadoc comment </summary>

**The documentation of a class should at least include:**
* A comment describing the overall purpose and characteristics of the class.
* The author’s name, prefixed with the `@author` tag. If there are several authors, you should give each a separate 
line. If you have modified a file that already has an author, make sure to add your own name as well.
</details>

<details>
<summary> 📚 What to add to a method Javadoc comment </summary>

**The documentation of a method or constructor should at least include:**
* A description of the purpose and function of the method.
* Name and description of each parameter (use the `@param` tag). The types of parameters and return values should 
**not** be written in the Javadoc, as these are already in the method/constructor header!
* A description of the value returned (use the `@return` tag). Note that this is not applicable to constructors and `void` methods.
* If the method throws an exception, it should be explained what will cause the method to do this (use the `@throws` tag).

Getters and setters are in general trivial, but the field they correspond to may not be. It is reasonable to describe 
the purpose of the field, rather han what the method does (it should in most cases be obvious that a setter updates a 
value).

In general, methods/constructors that are not `public` (such as ones with access modifier `protected`, `private` or
`package private`) are usually only given Javadoc comments if they are complex and require an explanation 
or part of some larger machinery that is not obvious.
</details>

For examples of good Javadoc, see the files you have been provided in the [src](src) directory. Good Javadoc will 
become a **minimum requirement** in all future assignments in this and subsequent courses, whenever you have created or modified a class.
You may be asked to **resubmit work if the documentation is of a poor standard**. It can be a good habit to 
always double-check so that all your code is properly documented before you create a git commit.

### ❎ Checklist 

- [ ] Update to Java 14 or higher.
- [ ] Checkout the game and source code.
- [ ] Create rooms and exits as text files which can then be imported into the game using `private void generateRoomsFromFile(String filename)`.
- [ ] Come up with an own game idea that utilizes the already existing code. 
- [ ] Code your game and follow these instructions:
  - [ ] You have not reused any of the rooms from the first version of the game (but the game can still take place at KTH!).
  - [ ] The rooms must be read from a file using the `generateRoomsFromFile` method you created in _Exercise 6.0_. 
  - [ ] It is possible to win and lose the game by taking (or failing to take) specific game actions. 
  - [ ] The game loop should ends on game over with a different message depending on if the player win or lose.
  - [ ] You have created at least one new class and used it in your game.
  - [ ] The game world have at least 5 rooms.
  - [ ] Add a map of your game world in the [docs](docs) directory. This can be in the form of a photo or scan of a hand-drawn map, or created using software such as [diagrams.net](https://app.diagrams.net/).
  - [ ] Add the following information to the [docs/README.md](docs/README.md) file:
    - A description of the theme of your game.
    - How to win/lose.
    - What class or classes you chose to create and how this is used in the game.
- [ ] Add Javadoc documentation to your files containing:
  - [ ] A comment describing the overall purpose and characteristics of the class.
  - [ ] The author’s name, prefixed with the `@author` tag. If there are several authors, you should give each a separate line. If you have modified a file that already has an author, make sure to add your own name as well.
- [ ] Add Javadoc documentation to your methods and constructors containing:
  - [ ] A description of the purpose and function of the method.
  - [ ] Name and description of each parameter (use the `@param` tag). The types of parameters and return values should **not** be written in the Javadoc, as these are already in the method/constructor header!
  - [ ] A description of the value returned (use the `@return` tag). Note that this is not applicable to constructors and `void` methods.
  - [ ] If the method throws an exception, it should be explained what will cause the method to do this (use the `@throws` tag).
    
> **Assistant's Note:** We've set up a checklist for you. Use it for a last look at your work before handing it in. You don't have to, but if you want to check off tasks, just put an "x" in the brackets in the README.md file.

### 🐞 Bugs and errors?

If you find any inconsistencies (spelling errors, grammatically incorrect sentences etc) or errors in this exercise, please open a [New Issue](https://gits-15.sys.kth.se/inda-24/help/issues/new) with the title "Task *x* Error: *summary of error here*". Found bugs will be rewarded by mentions in the acknowledgment section.

### 🙏 Acknowledgments

This task was designed by                <br>
[Linus Östlund](mailto:linusost@kth.se)  <br>
[Sofia Bobadilla](mailto:sofbob@kth.se)  <br>
[Gabriel Skoglund](mailto:gabsko@kth.se) <br>
[Arvid Siberov](mailto:asiberov@kth.se)  <br>
[Alexander Runebou](mailto:alerun@kth.se)<br>
    
Proofreading & Bug fixes by <br>
[Jesper Lindeberg ]()   <br>
