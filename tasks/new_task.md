![Task Image](images/task_image_20250206_003007.png)

# **Programming Task: Library Book Management System 📚**

## **Task Overview**
In this task, you will design and implement a simple **Library Book Management System**. You will practice reading data from files, designing well-structured classes, and applying creative programming techniques to build a functional system. Your program will read book data from a file, instantiate `Book` objects, and allow users to interact with the system to search for books, display book details, and borrow books. 

By the end of this task, you will have strengthened your **object-oriented programming skills**, **file handling techniques**, and **problem-solving abilities**.

---

## **Exercise 1: Understanding File Formats and Object Instantiation 📄**
Before writing code, it's crucial to understand how data is structured in files and how it maps to objects in Java. 

1. **Given the following book data stored in a file (`books.txt`):**
   ```
   1, The Great Gatsby, F. Scott Fitzgerald, 1925
   2, To Kill a Mockingbird, Harper Lee, 1960
   3, 1984, George Orwell, 1949
   ```
   - What format is being used to store the data?
   - How would you extract each individual piece of information (ID, title, author, year) in Java?
   - What potential problems might arise when reading data from a file?

📌 **Task:** Write a short explanation (5-6 sentences) on how you would parse this data and handle any potential errors (e.g., missing fields, incorrect formatting).

---

## **Exercise 2: Designing the Book Class 🏗️**
Now that you understand the file format, it's time to **design the `Book` class**.

📌 **Task:** Define a `Book` class that contains:
- Fields for **book ID, title, author, and publication year**.
- A **constructor** to initialize these fields.
- A **toString() method** that returns a well-formatted string representation of the book.

🔹 **Example Structure (Scaffolding):**
```java
public class Book {
    private int id;
    private String title;
    private String author;
    private int publicationYear;

    public Book(int id, String title, String author, int publicationYear) {
        // Initialize fields
    }

    @Override
    public String toString() {
        // Return a formatted string representation
    }
}
```
✅ **Question for Reflection:** Why is it important to encapsulate fields in a class? How does this improve code maintainability?

---

## **Exercise 3: Reading Books from a File 📂**
Now, let's implement **file reading functionality** to create `Book` objects dynamically.

📌 **Task:** Write a method in a new class `Library` that:
- Reads book data from `books.txt`.
- Creates and stores `Book` objects in an `ArrayList<Book>`.
- Prints out all books after reading.

🔹 **Example Scaffolding:**
```java
import java.io.*;
import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void loadBooksFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line by commas and create a Book object
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```
✅ **Enhancement:** What happens if the file is missing or contains incorrect data? How would you handle such cases?

---

## **Exercise 4: Implementing a Simple Search Feature 🔍**
A library system must allow users to search for books by title.

📌 **Task:** Implement a method `searchBookByTitle(String title)` in the `Library` class that:
- Takes a title as input.
- Searches for books that match (case-insensitive).
- Returns a list of matching books.

🔹 **Example Call:**
```java
Library library = new Library();
library.loadBooksFromFile("books.txt");
List<Book> results = library.searchBookByTitle("1984");
System.out.println(results);
```
✅ **Enhancement:** How would you modify the search to allow partial matches instead of exact ones?

---

## **Exercise 5: Implementing a Borrowing System 📖**
Let's extend the functionality by allowing users to **borrow books**.

📌 **Task:** Modify the `Book` class to include:
- A **boolean field** `isBorrowed`.
- A method `borrowBook()` that marks a book as borrowed if available.

Modify the `Library` class to:
- Implement a method `borrowBook(int bookId)` that **checks if a book is available and marks it as borrowed**.

🔹 **Example Scaffolding:**
```java
public class Book {
    private boolean isBorrowed;

    public void borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println("Book borrowed successfully!");
        } else {
            System.out.println("Book is already borrowed.");
        }
    }
}
```
✅ **Challenge:** How would you implement a **returnBook()** method that allows books to be returned?

---

## **Exercise 6: Enhancing User Interaction with a Menu System 🖥️**
Now, let's make the system interactive by implementing a **menu-driven program**.

📌 **Task:** Create a `LibraryApp` class that:
- Displays a **menu** with options: 
  1. Load books from file
  2. Search for a book
  3. Borrow a book
  4. Exit
- Uses a `Scanner` to take user input and call appropriate methods.

🔹 **Example Scaffolding:**
```java
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Load books");
            System.out.println("2. Search for a book");
            System.out.println("3. Borrow a book");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    library.loadBooksFromFile("books.txt");
                    break;
                // Implement cases for search and borrow
                case 4:
                    System.out.println("Exiting...");
                    return;
            }
        }
    }
}
```
✅ **Challenge:** How would you modify the system to allow multiple users to borrow and return books?

---

## **Summary of Learning Outcomes 🎯**
By completing this task, you will have:
✅ Used **file I/O** to read data and instantiate objects.  
✅ Designed well-structured **classes** with appropriate responsibilities.  
✅ Implemented **search and borrowing functionality** creatively.  
✅ Built an interactive **menu-driven program** for user interaction.  

Feel free to experiment and extend the system further! 🚀

# **Exercise 1: Understanding File Formats and Object Instantiation 📄**  

Before writing code, it's important to analyze how data is structured in a file and how it can be processed into objects in Java. You will work with a **comma-separated values (CSV)** format, where book details are stored as:  

```
1, The Great Gatsby, F. Scott Fitzgerald, 1925  
2, To Kill a Mockingbird, Harper Lee, 1960  
3, 1984, George Orwell, 1949  
```

Each line represents a book with four attributes:  
- **Book ID (integer)**  
- **Title (string)**  
- **Author (string)**  
- **Publication Year (integer)**  

### 📌 Task:  
Write a short explanation (5-6 sentences) addressing:  
1. What format is being used to store the data?  
2. How would you extract each piece of information in Java?  
3. What potential issues might arise when reading data from a file?  

**Hints:**  
- Consider using `split(",")` to separate values in a line.  
- Think about handling missing values, incorrect formats, or extra spaces.  
- How can exception handling (`try-catch`) help ensure smooth reading?  

**Reflection:** Understanding file reading and parsing is crucial in real-world applications. How does this knowledge apply beyond this task?  

---  

# **Exercise 2: Designing the Book Class 🏗️**  

Now that you understand how book data is structured, it’s time to design a **Book** class. Well-structured classes improve maintainability and scalability.  

### 📌 Task:  
Define a `Book` class that includes:  
- **Fields** for `id`, `title`, `author`, and `publicationYear`.  
- A **constructor** to initialize these fields.  
- A **toString() method** that returns a well-formatted string representation of the book.  

🔹 **Example Scaffolding:**  
```java
public class Book {
    private int id;
    private String title;
    private String author;
    private int publicationYear;

    public Book(int id, String title, String author, int publicationYear) {
        // Initialize fields
    }

    @Override
    public String toString() {
        // Return a formatted string
    }
}
```

### ✅ Question for Reflection:  
- **Why is encapsulation important?**  
- **How does designing a clear class structure help in larger programs?**  

**Hint:** Consider how getters and setters might be useful. Think about **code reusability** – how can this class be extended later?  

By completing these exercises, you will be prepared to implement **file reading and object creation** in the next steps! 🚀

# **Exercise 3: Reading Books from a File 📂**

Now that you've designed the `Book` class, it's time to **read book data from a file** and instantiate `Book` objects dynamically. In this exercise, you will implement **file reading functionality** and store books in a collection.

### **📌 Task: Implement File Reading and Object Creation**
1. **Create a `Library` class** that manages a collection of books.
2. **Implement a method `loadBooksFromFile(String filename)`** that:
   - Reads book data from a text file (`books.txt`).
   - Parses each line into `Book` attributes.
   - Creates and stores `Book` objects in an `ArrayList<Book>`.
3. **Print out all books** after reading to verify successful loading.

### **🔹 Example Scaffolding:**
```java
import java.io.*;
import java.util.*;

public class Library {
    private List<Book> books = new ArrayList<>();

    public void loadBooksFromFile(String filename) {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split the line by commas and create a Book object
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
```

### **✅ Questions for Reflection:**
1. **What happens if the file does not exist?** How can you handle this gracefully?
2. **What if a line in the file has missing or extra data?** How can you validate input?
3. **How would you modify the method to handle large files efficiently?** Would `BufferedReader` still be suitable?

### **💡 Hints:**
- Use `split(",")` to extract book attributes from a line.
- Trim spaces using `.trim()` to avoid formatting issues.
- Implement **exception handling** to catch errors like missing files or incorrect data formats.

---

# **Exercise 4: Implementing a Search Feature 🔍**

A key functionality of a library system is allowing users to **search for books** by title. In this exercise, you will implement a **search feature** that allows users to find books easily.

### **📌 Task: Implement a Search Method**
1. **In the `Library` class, implement `searchBookByTitle(String title)`.**
2. The method should:
   - Take a **title** as input.
   - Search for books with a **matching (case-insensitive) title**.
   - Return and print a **list of matching books**.

### **🔹 Example Scaffolding:**
```java
public List<Book> searchBookByTitle(String title) {
    List<Book> results = new ArrayList<>();
    for (Book book : books) {
        // Compare book title (case-insensitive)
    }
    return results;
}
```

### **🔹 Example Usage:**
```java
Library library = new Library();
library.loadBooksFromFile("books.txt");

List<Book> results = library.searchBookByTitle("1984");
System.out.println(results);
```

### **✅ Enhancement:**
- Modify the search to allow **partial matches** instead of requiring an exact match.  
  _(Hint: Use `String.contains()` or `toLowerCase()` to make the search more flexible.)_

### **✅ Questions for Reflection:**
1. **What challenges arise when searching text data?**
2. **How could you improve search efficiency for a large collection of books?**
3. **How would you modify the method to allow searching by author as well?**

### **💡 Hints:**
- Convert both the input title and book titles to lowercase before comparing.
- Use a loop to iterate through the book list and check for a match.
- Print a message if no books are found.

---

# **Summary of Learning Outcomes 🎯**
By completing these exercises, you will have:
✅ **Read data from files** and used it to instantiate objects dynamically.  
✅ **Handled potential file reading errors** and ensured data integrity.  
✅ **Designed an efficient search feature** that allows users to find books.  
✅ **Practiced writing modular, reusable methods** for better maintainability.  

These exercises bridge the gap between theoretical concepts and practical coding. In the next exercises, you will extend the system with **borrowing functionality and interactive user menus**! 🚀

# **Exercise 5: Implementing a Borrowing System 📖**  

Now that we can **load books from a file and search for them**, let's extend the system by allowing users to **borrow books**. This will simulate a common feature in a real-world library system.

---

### **📌 Task: Modify the `Book` and `Library` Classes to Support Borrowing**
1. **Modify the `Book` class** to include:
   - A **boolean field** `isBorrowed` to track whether the book is borrowed.
   - A method `borrowBook()` that marks the book as borrowed **only if it's available**.

2. **Modify the `Library` class** to:
   - Implement a method `borrowBook(int bookId)` that:
     - Finds the book by its **ID**.
     - Checks if it is already borrowed.
     - If available, marks it as borrowed; otherwise, prints a message indicating it is unavailable.

---

### **🔹 Example Scaffolding for the `Book` Class**
```java
public class Book {
    private int id;
    private String title;
    private String author;
    private int publicationYear;
    private boolean isBorrowed;

    public Book(int id, String title, String author, int publicationYear) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.publicationYear = publicationYear;
        this.isBorrowed = false; // By default, books are available
    }

    public boolean isBorrowed() {
        return isBorrowed;
    }

    public void borrowBook() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println(title + " has been borrowed!");
        } else {
            System.out.println(title + " is already borrowed.");
        }
    }

    @Override
    public String toString() {
        return id + ": " + title + " by " + author + " (" + publicationYear + ") " 
               + (isBorrowed ? "[Borrowed]" : "[Available]");
    }
}
```

---

### **🔹 Example Scaffolding for the `Library` Class**
```java
public class Library {
    private List<Book> books = new ArrayList<>();

    public void borrowBook(int bookId) {
        for (Book book : books) {
            if (book.getId() == bookId) {
                book.borrowBook();
                return;
            }
        }
        System.out.println("Book with ID " + bookId + " not found.");
    }
}
```

---

### **🔹 Example Usage:**
```java
Library library = new Library();
library.loadBooksFromFile("books.txt");

library.borrowBook(1); // Borrow "The Great Gatsby"
library.borrowBook(1); // Attempt to borrow it again (should show already borrowed)
```

---

### **✅ Challenge: Implement a `returnBook()` Method**
- Add a method `returnBook(int bookId)` in the `Library` class that allows users to return a borrowed book.
- Modify the `Book` class to include a method `returnBook()` that marks the book as available again.

**Hint:** The logic is similar to `borrowBook()`, but in reverse!

---

### **✅ Questions for Reflection:**
1. **What happens if a user tries to borrow an already borrowed book?**
2. **How can we ensure that only valid book IDs are processed?**
3. **How would you modify the system to track which user borrowed a book?**

---

# **Exercise 6: Enhancing User Interaction with a Menu System 🖥️**

Now, let's make the system **interactive** by implementing a **menu-driven program** where users can **load books, search for them, and borrow books using console input**.

---

### **📌 Task: Create an Interactive `LibraryApp` Class**
1. **Display a menu** with options:
   ```
   1. Load books from file
   2. Display all books
   3. Search for a book by title
   4. Borrow a book
   5. Return a book
   6. Exit
   ```
2. **Take user input** using `Scanner` and call the appropriate methods.
3. Ensure **error handling** for invalid inputs.

---

### **🔹 Example Scaffolding for `LibraryApp`**
```java
import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Load books from file");
            System.out.println("2. Display all books");
            System.out.println("3. Search for a book by title");
            System.out.println("4. Borrow a book");
            System.out.println("5. Return a book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    library.loadBooksFromFile("books.txt");
                    System.out.println("Books loaded successfully.");
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    System.out.print("Enter book title to search: ");
                    String title = scanner.nextLine();
                    List<Book> results = library.searchBookByTitle(title);
                    if (results.isEmpty()) {
                        System.out.println("No books found.");
                    } else {
                        for (Book book : results) {
                            System.out.println(book);
                        }
                    }
                    break;
                case 4:
                    System.out.print("Enter book ID to borrow: ");
                    int bookId = scanner.nextInt();
                    library.borrowBook(bookId);
                    break;
                case 5:
                    System.out.print("Enter book ID to return: ");
                    int returnBookId = scanner.nextInt();
                    library.returnBook(returnBookId);
                    break;
                case 6:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
```

---

### **✅ Challenge: Improve the User Experience**
- **Enhance error handling**: What if the user enters a non-numeric input?
- **Add a confirmation step** before borrowing or returning a book.
- **Allow users to list only available books** before borrowing.
- **Expand functionality**: How would you allow multiple users to borrow different books?

---

### **✅ Questions for Reflection:**
1. **How does a menu-driven system improve user experience?**
2. **What are some ways to handle invalid user input gracefully?**
3. **If the library had hundreds of books, how would you optimize searching and borrowing?**

---

# **Final Learning Outcomes 🎯**
By completing **Exercise 5 & 6**, you have:
✅ **Implemented a borrowing system** that tracks book availability.  
✅ **Used object-oriented design** to modify class behavior dynamically.  
✅ **Created a menu-driven interactive application** that allows users to interact with the