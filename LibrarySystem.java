import java.util.*;

class Book {
    String title;
    String author;
    boolean isIssued;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public void issue() {
        if (!isIssued) {
            isIssued = true;
            System.out.println(" Book issued: " + title);
        } else {
            System.out.println(" Book already issued!");
        }
    }

    public void returnBook() {
        if (isIssued) {
            isIssued = false;
            System.out.println(" Book returned: " + title);
        } else {
            System.out.println(" Book was not issued!");
        }
    }

    public void display() {
        String status = isIssued ? "Issued" : "Available";
        System.out.println(title + " by " + author + " | Status: " + status);
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Book> books = new ArrayList<>();

        // Adding some books
        books.add(new Book("Harry Potter", "J.K. Rowling"));
        books.add(new Book("The Alchemist", "Paulo Coelho"));
        books.add(new Book("Atomic Habits", "James Clear"));

        int choice;
        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Display Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.println("\n Book List:");
                    for (Book b : books) {
                        b.display();
                    }
                    break;
                case 2:
                    System.out.print("Enter book title to issue: ");
                    String issueTitle = sc.nextLine();
                    boolean foundIssue = false;
                    for (Book b : books) {
                        if (b.title.equalsIgnoreCase(issueTitle)) {
                            b.issue();
                            foundIssue = true;
                            break;
                        }
                    }
                    if (!foundIssue) System.out.println(" Book not found!");
                    break;
                case 3:
                    System.out.print("Enter book title to return: ");
                    String returnTitle = sc.nextLine();
                    boolean foundReturn = false;
                    for (Book b : books) {
                        if (b.title.equalsIgnoreCase(returnTitle)) {
                            b.returnBook();
                            foundReturn = true;
                            break;
                        }
                    }
                    if (!foundReturn) System.out.println(" Book not found!");
                    break;
                case 4:
                    System.out.println(" Exiting Library System");
                    break;
                default:
                    System.out.println(" Invalid choice!");
            }
        } while (choice != 4);

        sc.close();
    }
}
