import java.util.List;
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

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
                continue;
            }

            switch (choice) {
                case 1:
                    library.loadBooksFromFile("books.txt");
                    break;
                case 2:
                    library.displayBooks();
                    break;
                case 3:
                    System.out.print("Enter book title to search: ");
                    String title = scanner.nextLine();
                    List<Book> results = library.searchBookByTitle(title);
                    break;
                case 4:
                    System.out.print("Enter book ID to borrow: ");
                    int borrowId = Integer.parseInt(scanner.nextLine());
                    library.borrowBook(borrowId);
                    break;
                case 5:
                    System.out.print("Enter book ID to return: ");
                    int returnId = Integer.parseInt(scanner.nextLine());
                    library.returnBook(returnId);
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}