

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagement {

    static Scanner sc = new Scanner(System.in);

    static ArrayList<String> books = new ArrayList<>();
    static ArrayList<String> issuedBooks = new ArrayList<>();

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n================================");
            System.out.println("   LIBRARY MANAGEMENT SYSTEM");
            System.out.println("================================");

            System.out.println("1. Add Book");
            System.out.println("2. Display Books");
            System.out.println("3. Search Book");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Delete Book");
            System.out.println("7. Exit");

            System.out.print("\nEnter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    displayBooks();
                    break;

                case 3:
                    searchBook();
                    break;

                case 4:
                    issueBook();
                    break;

                case 5:
                    returnBook();
                    break;

                case 6:
                    deleteBook();
                    break;

                case 7:
                    System.out.println("Thank You!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 7);

        sc.close();
    }

    // ADD BOOK
    static void addBook() {

        System.out.print("Enter Book Name: ");
        String book = sc.nextLine();

        books.add(book);

        System.out.println("Book Added Successfully!");
    }

    // DISPLAY BOOKS
    static void displayBooks() {

        System.out.println("\n----- BOOK LIST -----");

        if (books.isEmpty()) {
            System.out.println("No Books Available!");
            return;
        }

        for (int i = 0; i < books.size(); i++) {

            String status = issuedBooks.contains(books.get(i))
                    ? "Issued" : "Available";

            System.out.println((i + 1) + ". "
                    + books.get(i) + " - " + status);
        }
    }

    // SEARCH BOOK
    static void searchBook() {

        System.out.print("Enter Book Name: ");
        String search = sc.nextLine();

        boolean found = false;

        for (String book : books) {

            if (book.equalsIgnoreCase(search)) {

                System.out.println("Book Found: " + book);

                if (issuedBooks.contains(book)) {
                    System.out.println("Status: Issued");
                } else {
                    System.out.println("Status: Available");
                }

                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Book Not Found!");
        }
    }

    // ISSUE BOOK
    static void issueBook() {

        System.out.print("Enter Book Name to Issue: ");
        String name = sc.nextLine();

        for (String book : books) {

            if (book.equalsIgnoreCase(name)) {

                if (issuedBooks.contains(book)) {
                    System.out.println("Book Already Issued!");
                } else {
                    issuedBooks.add(book);
                    System.out.println("Book Issued Successfully!");
                }

                return;
            }
        }

        System.out.println("Book Not Found!");
    }

    // RETURN BOOK
    static void returnBook() {

        System.out.print("Enter Book Name to Return: ");
        String name = sc.nextLine();

        for (String book : books) {

            if (book.equalsIgnoreCase(name)) {

                if (issuedBooks.remove(book)) {
                    System.out.println("Book Returned Successfully!");
                } else {
                    System.out.println("Book Was Not Issued!");
                }

                return;
            }
        }

        System.out.println("Book Not Found!");
    }

    // DELETE BOOK
    static void deleteBook() {

        System.out.print("Enter Book Name to Delete: ");
        String name = sc.nextLine();

        for (String book : books) {

            if (book.equalsIgnoreCase(name)) {

                if (issuedBooks.contains(book)) {
                    System.out.println("Cannot Delete! Book is Issued.");
                } else {
                    books.remove(book);
                    System.out.println("Book Deleted Successfully!");
                }

                return;
            }
        }

        System.out.println("Book Not Found!");
    }
}
