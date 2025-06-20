import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Book[] books = {
            new Book(101, "The Alchemist", "Paulo Coelho"),
            new Book(102, "1984", "George Orwell"),
            new Book(103, "Clean Code", "Robert Martin"),
            new Book(104, "The Pragmatic Programmer", "Andy Hunt")
        };

        System.out.println(" Linear Search for '1984':");
        Book found1 = linearSearch(books, "1984");
        if (found1 != null) found1.displayBook();
        else System.out.println("Book not found.");

        System.out.println("\nSorting books by title for binary search...");
        sortBooksByTitle(books);

        System.out.println("Binary Search for 'Clean Code':");
        Book found2 = binarySearch(books, "Clean Code");
        if (found2 != null) found2.displayBook();
        else System.out.println("Book not found.");
    }

    // Linear search
    public static Book linearSearch(Book[] books, String title) {
        for (Book book : books) {
            if (book.title.equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }

    // Binary search
    public static Book binarySearch(Book[] books, String title) {
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);
            if (cmp == 0) return books[mid];
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return null;
    }

    // Sort books by title
    public static void sortBooksByTitle(Book[] books) {
        Arrays.sort(books, (b1, b2) -> b1.title.compareToIgnoreCase(b2.title));
    }
}
