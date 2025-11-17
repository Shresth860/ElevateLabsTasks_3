import java.util.*;

// ================= BOOK CLASS =================
class Book {
    private String id;
    private String title;
    private String author;
    private boolean isIssued;

    public Book(String id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public String getId() { return id; }

    public boolean isIssued() { return isIssued; }

    public void issueBook() { isIssued = true; }

    public void returnBook() { isIssued = false; }

    @Override
    public String toString() {
        return id + " | " + title + " | " + author + " | " + (isIssued ? "Issued" : "Available");
    }
}

// ================ LIBRARY CLASS =================
class Library {
    private List<Book> books = new ArrayList<>();

    // Add book manually
    public void addBook(Book b) {
        books.add(b);
        System.out.println("✔ Book added successfully!");
    }

    // Show all books
    public void showBooks() {
        if (books.isEmpty()) {
            System.out.println("❌ No books available!");
            return;
        }
        System.out.println("\n📚 List of Books:");
        for (Book b : books) System.out.println(b);
    }

    // Borrow book manually
    public void borrowBook(String bookId) {
        for (Book b : books) {
            if (b.getId().equals(bookId)) {
                if (b.isIssued()) {
                    System.out.println("❌ Book already issued!");
                    return;
                }
                b.issueBook();
                System.out.println("✔ You borrowed: " + b.getId());
                return;
            }
        }
        System.out.println("❌ Book not found!");
    }

    // Return book manually
    public void returnBook(String bookId) {
        for (Book b : books) {
            if (b.getId().equals(bookId)) {
                if (!b.isIssued()) {
                    System.out.println("❌ This book was never issued!");
                    return;
                }
                b.returnBook();
                System.out.println("✔ Book returned successfully!");
                return;
            }
        }
        System.out.println("❌ Book not found!");
    }
}

// ================ MAIN (MENU DRIVEN) =================
class LibraryManegementSystemUsingOOPs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library lib = new Library();

        while (true) {
            System.out.println("\n=========================");
            System.out.println("📘 LIBRARY MANAGEMENT SYSTEM");
            System.out.println("=========================");
            System.out.println("1️⃣  Add Book");
            System.out.println("2️⃣  View Books");
            System.out.println("3️⃣  Borrow Book");
            System.out.println("4️⃣  Return Book");
            System.out.println("5️⃣  Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter Book ID: ");
                    String id = sc.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter Book Author: ");
                    String author = sc.nextLine();
                    lib.addBook(new Book(id, title, author));
                    break;

                case 2:
                    lib.showBooks();
                    break;

                case 3:
                    System.out.print("Enter Book ID to Borrow: ");
                    String borrowId = sc.nextLine();
                    lib.borrowBook(borrowId);
                    break;

                case 4:
                    System.out.print("Enter Book ID to Return: ");
                    String returnId = sc.nextLine();
                    lib.returnBook(returnId);
                    break;

                case 5:
                    System.out.println("👋 Exiting Library System...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("❌ Invalid option! Try again.");
            }
        }
    }
}
