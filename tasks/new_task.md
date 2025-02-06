![Task Image](images/task_image_20250206_002336.png)

# **Task: Library Management System 📚**  

### **Task Overview**  
In this task, you will design and implement a **Library Management System** that reads book data from a file and creates book objects dynamically. You will also explore object-oriented principles, such as designing well-structured classes, handling file input, and implementing creative enhancements.  

By the end of this task, you will:  
✅ Understand how to read data from a file and instantiate objects dynamically.  
✅ Apply object-oriented design principles to structure a program effectively.  
✅ Experiment with creative programming ideas to enhance functionality.  

---

## **Exercise 1: Understanding File Formats for Data Extraction 📄**  

Before we start programming, let’s analyze how data is structured in files. A library system might store book records in a text file like this:  

```
978-3-16-148410-0, The Great Gatsby, F. Scott Fitzgerald, Fiction, 1925  
978-0-14-044913-6, Crime and Punishment, Fyodor Dostoevsky, Classic, 1866  
978-1-56619-909-4, Introduction to Algorithms, Thomas H. Cormen, Education, 2009  
```

Each book has attributes separated by commas:  
- **ISBN**  
- **Title**  
- **Author**  
- **Genre**  
- **Year of Publication**  

### **Your Task:**  
1. Describe how you would **extract** this data from a file in Java.  
2. **What challenges** might arise when parsing such data?  
3. How would you **handle missing or incorrect data** when reading the file?  

💡 **Hint**: Think about using `BufferedReader` and `String.split(",")` to process each line in Java.

---

## **Exercise 2: Designing the Book Class 📖**  

Now that you understand file data, let's design a `Book` class to represent books in our library system.  

### **Your Task:**  
1. Identify the **responsibilities** of the `Book` class.  
2. Define **fields** for book attributes.  
3. Implement a **constructor** and appropriate **getter methods**.  

💡 **Hint:** Your `Book` class might look like this:  

```java
public class Book {
    private String isbn;
    private String title;
    private String author;
    private String genre;
    private int year;

    // Constructor
    public Book(String isbn, String title, String author, String genre, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
    }

    // Getters
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getGenre() { return genre; }
    public int getYear() { return year; }
}
```

Would you add any **extra methods**? If so, why?  

---

## **Exercise 3: Reading Book Data from a File 📂**  

Now that we have a `Book` class, it's time to read book data from a file and create `Book` objects dynamically.  

### **Your Task:**  
1. Implement a method `readBooksFromFile(String filename)` that:  
   - Reads the file line by line.  
   - Parses each line into a `Book` object.  
   - Stores the objects in a `List<Book>`.  
2. Handle **exceptions** properly (e.g., missing files, incorrect formats).  

💡 **Hint:** You might use a method like this:  

```java
public static List<Book> readBooksFromFile(String filename) {
    List<Book> books = new ArrayList<>();
    try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length == 5) {
                books.add(new Book(data[0], data[1], data[2], data[3], Integer.parseInt(data[4])));
            }
        }
    } catch (IOException e) {
        System.err.println("Error reading file: " + e.getMessage());
    }
    return books;
}
```

Test this method with a sample file and print the books to verify correct parsing.

---

## **Exercise 4: Implementing a Library System 📚**  

Now that we can read books from a file, let’s build a simple **Library System** to store and retrieve books by genre.  

### **Your Task:**  
1. Create a `Library` class that:  
   - Stores a **collection of books**.  
   - Has a method `addBook(Book book)`.  
   - Has a method `getBooksByGenre(String genre)` that returns books matching the given genre.  
2. Read book data from a file and add books to the library.  
3. Allow users to **search for books by genre** and display results.  

💡 **Hint:** Your `Library` class might look like this:  

```java
public class Library {
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooksByGenre(String genre) {
        return books.stream()
                    .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                    .collect(Collectors.toList());
    }
}
```

Test your system by searching for books in a specific genre!

---

## **Exercise 5: Enhancing the Library System with Sorting & Searching 🔍**  

Let’s improve the **Library System** by adding sorting and searching functionality.  

### **Your Task:**  
1. Implement a method `getBooksSortedByTitle()` that returns books sorted **alphabetically** by title.  
2. Implement a method `searchBooksByTitle(String keyword)` that returns books **containing the keyword** (case insensitive).  
3. Modify `getBooksByGenre(String genre)` to return results **sorted by year** (newest first).  

💡 **Hint:** Use **Comparator** and **Streams** for sorting:  

```java
public List<Book> getBooksSortedByTitle() {
    return books.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .collect(Collectors.toList());
}
```

Test your methods by:  
✅ Searching for books with a keyword.  
✅ Sorting books alphabetically.  
✅ Filtering by genre and checking if results are correctly sorted.

---

## **Exercise 6: Creative Features & Error Handling 💡**  

To make our system more **robust and interesting**, let’s introduce additional features!  

### **Your Task:**  
1. **Handle missing fields gracefully:** Modify `readBooksFromFile()` to skip **malformed** lines but log a warning instead of crashing.  
2. **Add a borrowing system:**  
   - Introduce a `boolean isBorrowed` field in `Book`.  
   - Implement `borrowBook(String isbn)` to mark a book as borrowed.  
   - Implement `returnBook(String

# **Exercise 1: Understanding File Formats for Data Extraction 📄**  

Before implementing our **Library Management System**, it's essential to understand how book data is stored in files and how we can extract meaningful information from it in Java.  

### **Analyzing the File Format**  
A library system might store book records in a structured text file like this:  

```
978-3-16-148410-0, The Great Gatsby, F. Scott Fitzgerald, Fiction, 1925  
978-0-14-044913-6, Crime and Punishment, Fyodor Dostoevsky, Classic, 1866  
978-1-56619-909-4, Introduction to Algorithms, Thomas H. Cormen, Education, 2009  
```

Each line represents a **book record**, with attributes separated by commas:  
- **ISBN** (Unique identifier)  
- **Title**  
- **Author**  
- **Genre**  
- **Year of Publication**  

### **Your Task:**  
1. **Explain how you would extract this data from a file in Java.**  
   - What Java classes would you use for reading the file?  
   - How would you split and process the data efficiently?  

2. **Identify potential challenges in parsing this data.**  
   - What happens if the file contains missing or improperly formatted data?  
   - How would you handle cases where a book entry is incomplete or has extra spaces?  

3. **Suggest ways to handle errors when reading the file.**  
   - How can you ensure the program doesn't crash due to unexpected input?  
   - What techniques would you use to validate the extracted data?  

💡 **Hint:** Think about using `BufferedReader` for reading files and `String.split(",")` for parsing. Consider exception handling techniques such as `try-catch` blocks to manage errors gracefully.  

---

# **Exercise 2: Designing the Book Class 📖**  

Now that we understand how book data is structured, let's design a **`Book` class** to represent individual books in our library system.  

### **Understanding Class Responsibilities**  
A `Book` class should:  
✅ Store information about a book (ISBN, title, author, genre, and year).  
✅ Provide methods to access this information.  
✅ Ensure data integrity by restricting direct modification of attributes.  

### **Your Task:**  
1. **Define the attributes of a `Book`.**  
   - What fields should be private?  
   - Why should we use getter methods instead of public fields?  

2. **Write a constructor for the `Book` class.**  
   - What parameters should it take to initialize a book object?  
   - How can we ensure valid data is assigned to attributes?  

3. **Consider additional methods.**  
   - Would it be useful to include a method like `displayBookInfo()` to print book details?  
   - How could we enhance the class with methods related to book availability (e.g., borrowed status)?  

💡 **Hint:** Your `Book` class should follow **encapsulation principles** by keeping fields private and providing only necessary methods to interact with the data.  

### **Discussion:**  
- What advantages does designing a well-structured class bring to a project?  
- How would you modify the `Book` class if new attributes (e.g., book edition or publisher) were added later?  

After completing this exercise, you will be ready to implement the `Book` class and proceed to file handling in the next steps! 🚀

# **Exercise 3: Reading Book Data from a File 📂**  

Now that we have designed the `Book` class, it’s time to **read book data from a file** and dynamically create `Book` objects. This exercise will help you practice **file handling, data extraction, and object instantiation** in Java.  

---

## **Step 1: Implementing File Reading**  

Your task is to implement a method `readBooksFromFile(String filename)` that:  
✅ Reads a file line by line.  
✅ Splits each line into meaningful **book attributes**.  
✅ Creates a `Book` object for each valid entry.  
✅ Stores all `Book` objects in a `List<Book>`.  

💡 **Hints:**  
- Use `BufferedReader` to read the file efficiently.  
- Use `String.split(",")` to extract values from each line.  
- Be **careful with data integrity**—not all files are perfectly formatted!  

### **Your Task:**  
1. **Write the `readBooksFromFile` method** that follows the above specifications.  
2. **Handle exceptions properly:**  
   - What happens if the file is missing?  
   - What if a line is incorrectly formatted?  
3. **Test your method** using a sample file and print the books to verify correct parsing.  

---

### **Step 2: Handling Errors and Edge Cases**  

When reading from a file, errors and inconsistencies can arise. Consider the following cases:  

❌ **Missing fields:**  
```
978-3-16-148410-0, The Great Gatsby, F. Scott Fitzgerald, Fiction  // Year is missing!
```
✅ **Solution:** Skip such lines and log a warning.  

❌ **Extra spaces or incorrect formatting:**  
```
978-0-14-044913-6 , Crime and Punishment , Fyodor Dostoevsky , Classic , 1866  
```
✅ **Solution:** Trim spaces to ensure clean data.  

---

### **Code Scaffolding**
Use the following **starting point** to structure your method:

```java
import java.io.*;
import java.util.*;

public class LibraryFileReader {
    public static List<Book> readBooksFromFile(String filename) {
        List<Book> books = new ArrayList<>();
        
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 5) { // Ensuring correct format
                    String isbn = data[0].trim();
                    String title = data[1].trim();
                    String author = data[2].trim();
                    String genre = data[3].trim();
                    
                    try {
                        int year = Integer.parseInt(data[4].trim());
                        books.add(new Book(isbn, title, author, genre, year));
                    } catch (NumberFormatException e) {
                        System.err.println("Invalid year format for book: " + title);
                    }
                } else {
                    System.err.println("Skipping invalid entry: " + line);
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        return books;
    }
}
```

🔎 **Your Task:** Complete this method, test it with a sample file, and print the books to verify correct extraction!  

---

## **Exercise 4: Implementing a Library System 📚**  

Now that we can **read books from a file**, let’s build a **Library System** that stores and retrieves books dynamically.  

### **Step 1: Designing the Library Class**  

A `Library` class should:  
✅ Store a **collection of books**.  
✅ Provide methods to **add books** and **search books by genre**.  

💡 **Hint:** Think about **data structures**—which one is most efficient for storing and searching books?  

---

### **Step 2: Implementing Core Functionality**  

Your `Library` class should have the following **functionalities**:  

1️⃣ **Adding Books**  
   - Implement a method `addBook(Book book)` to add books to the collection.  

2️⃣ **Retrieving Books by Genre**  
   - Implement `getBooksByGenre(String genre)` to return books of a specific genre.

3️⃣ **Loading Books from File**  
   - Modify `Library` to **automatically load books from a file** when initialized.  

---

### **Code Scaffolding**
Here’s a **starting structure** for your `Library` class:

```java
import java.util.*;
import java.util.stream.Collectors;

public class Library {
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public List<Book> getBooksByGenre(String genre) {
        return books.stream()
                    .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                    .collect(Collectors.toList());
    }

    public void loadBooksFromFile(String filename) {
        books.addAll(LibraryFileReader.readBooksFromFile(filename)); // Reuse previous method
    }
}
```

---

### **Step 3: Testing the Library System**  

🔹 **Write a test program to:**  
✅ Create a `Library` object.  
✅ Load books from a file.  
✅ Search for books by genre and print the results.  

💡 **Example Test Code:**
```java
public class LibraryTest {
    public static void main(String[] args) {
        Library library = new Library();
        library.loadBooksFromFile("books.txt");

        System.out.println("Fiction Books:");
        for (Book book : library.getBooksByGenre("Fiction")) {
            System.out.println(book.getTitle() + " by " + book.getAuthor());
        }
    }
}
```

---

### **Step 4: Discussion Points**
1. **How could you optimize data retrieval?**  
   - Would a different data structure (e.g., `Map<String, List<Book>>` instead of `List<Book>`) improve performance?  

2. **What happens if you try to search for a genre that doesn’t exist?**  
   - How should the system handle an empty result?  

3. **What additional features could enhance the `Library` class?**  
   - Could we allow users to search for books by **title or author**?  
   - How might we add a **borrowing system** later?  

---

## **Summary of Exercises 3 & 4**
✅ **Exercise 3:** You learned how to **read book data from a file** and handle errors gracefully.  
✅ **Exercise 4:** You **implemented a Library System** that stores books and allows **genre-based searches**.  

🚀 **Next Steps:**  
In the next exercises, you’ll **enhance the system** with sorting, searching, and borrowing features! 🎉

# **Exercise 5: Enhancing the Library System with Sorting & Searching 🔍**

Now that we have a functional **Library System**, let’s **enhance it** by adding sorting and searching capabilities. This will allow users to find books more efficiently and improve the overall usability of the system.  

---

## **Step 1: Implement Sorting by Title**  

Your task is to implement a **method** that returns a list of books **sorted alphabetically** by title.  

### **Your Task**  
1. Implement a method `getBooksSortedByTitle()` that:  
   - Returns books sorted alphabetically by title.  
   - Uses **Streams** and **Comparator** for sorting.  

💡 **Hint:** Use `Comparator.comparing(Book::getTitle)`.  

```java
public List<Book> getBooksSortedByTitle() {
    return books.stream()
                .sorted(Comparator.comparing(Book::getTitle))
                .collect(Collectors.toList());
}
```

### **Test the Sorting Function**  
Write a small test to verify that books are displayed in **alphabetical order**.  

```java
Library library = new Library();
library.loadBooksFromFile("books.txt");

System.out.println("Books sorted by title:");
for (Book book : library.getBooksSortedByTitle()) {
    System.out.println(book.getTitle() + " by " + book.getAuthor());
}
```

---

## **Step 2: Implement Searching by Title**  

Users should be able to **search for books using keywords**.  

### **Your Task**  
1. Implement `searchBooksByTitle(String keyword)`, which:  
   - Returns books containing the **keyword** (case insensitive).  
   - Uses **Streams** and `contains()` for filtering.  

💡 **Hint:** Use `.toLowerCase().contains(keyword.toLowerCase())` for case-insensitive search.  

```java
public List<Book> searchBooksByTitle(String keyword) {
    return books.stream()
                .filter(book -> book.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .collect(Collectors.toList());
}
```

### **Test the Search Function**  
```java
System.out.println("Searching for 'Great':");
for (Book book : library.searchBooksByTitle("Great")) {
    System.out.println(book.getTitle() + " by " + book.getAuthor());
}
```

---

## **Step 3: Sorting Books by Year (Newest First) in Genre Search**  

Currently, `getBooksByGenre(String genre)` returns books **unsorted**. Let’s modify it to return books **sorted by year (newest first)**.  

### **Your Task**  
1. Modify `getBooksByGenre(String genre)` to:  
   - Sort books **by year in descending order**.  
   - Use `Comparator.comparingInt(Book::getYear).reversed()`.  

```java
public List<Book> getBooksByGenre(String genre) {
    return books.stream()
                .filter(book -> book.getGenre().equalsIgnoreCase(genre))
                .sorted(Comparator.comparingInt(Book::getYear).reversed())
                .collect(Collectors.toList());
}
```

### **Test the Enhanced Genre Search**  
```java
System.out.println("Fiction Books (sorted by year):");
for (Book book : library.getBooksByGenre("Fiction")) {
    System.out.println(book.getTitle() + " - " + book.getYear());
}
```

---

### **Discussion Questions**  
1. **Why is sorting important in a library system?**  
2. **How does case-insensitive searching improve usability?**  
3. **What are the performance implications of sorting and searching?**  

✅ **In this exercise, you added sorting and searching functionality, making the system more user-friendly.**  
🚀 **Next, let’s introduce a borrowing system and improve error handling!**  

---

# **Exercise 6: Implementing a Borrowing System & Robust Error Handling 📚**  

Thus far, our Library System allows users to **store, search, and sort books**, but we haven't added **borrowing functionality**. In this exercise, you will:  
✅ Add a **borrowing system** to track book availability.  
✅ Implement **robust error handling** to deal with missing or malformed data.  

---

## **Step 1: Implementing a Borrowing System**  

### **Your Task**  
1. Modify the `Book` class to include a **`boolean isBorrowed`** field.  
2. Implement methods to **borrow and return books**:  
   - `borrowBook(String isbn)`: Marks a book as borrowed.  
   - `returnBook(String isbn)`: Marks a book as available again.  

### **Modify the `Book` Class**  
```java
public class Book {
    private String isbn;
    private String title;
    private String author;
    private String genre;
    private int year;
    private boolean isBorrowed;

    public Book(String isbn, String title, String author, String genre, int year) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.year = year;
        this.isBorrowed = false; // Default: Not borrowed
    }

    public boolean isBorrowed() { return isBorrowed; }

    public void borrow() {
        if (!isBorrowed) {
            isBorrowed = true;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is already borrowed.");
        }
    }

    public void returnBook() {
        if (isBorrowed) {
            isBorrowed = false;
            System.out.println(title + " has been returned.");
        } else {
            System.out.println(title + " was not borrowed.");
        }
    }
}
```

---

## **Step 2: Implementing Borrowing Functionality in Library**  

### **Your Task:**  
1. Add methods in `Library` to **borrow and return books using their ISBN**.  

```java
public boolean borrowBook(String isbn) {
    for (Book book : books) {
        if (book.getIsbn().equals(isbn)) {
            if (!book.isBorrowed()) {
                book.borrow();
                return true;
            } else {
                System.out.println("Book is already borrowed.");
                return false;
            }
        }
    }
    System.out.println("Book not found.");
    return false;
}
```

```java
public boolean returnBook(String isbn) {
    for (Book book : books) {
        if (book.getIsbn().equals(isbn)) {
            if (book.isBorrowed()) {
                book.returnBook();
                return true;
            } else {
                System.out.println("Book was not borrowed.");
                return false;
            }
        }
    }
    System.out.println("Book not found.");
    return false;
}
```

---

## **Step 3: Handling Errors Gracefully**  

When reading from a file, errors can occur due to **missing fields, invalid numbers, or incorrect formatting**.  

### **Your Task**  
1. Modify `readBooksFromFile()` to: