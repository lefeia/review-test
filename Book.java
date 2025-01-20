import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

// 定义一个图书接口
interface Book {
    String getTitle();
    void setTitle(String title);
}

// 图书类实现了图书接口
class BookImpl implements Book {
    private String title;
    
    public BookImpl(String title) {
        this.title = title;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }
}

// 管理图书的类
class BookManager {
    private List<Book> books = new ArrayList<>();

    // 添加一本书
    public void addBook(Book book) {
        books.add(book);
    }

    // 删除一本书
    public boolean removeBook(String title) {
        return books.removeIf(book -> book.getTitle().equalsIgnoreCase(title));
    }

    // 列出所有书
    public void listBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the system.");
        } else {
            for (Book book : books) {
                System.out.println(book.getTitle());
            }
        }
    }

    // 保存图书列表到文件
    public void saveToFile(String filePath) throws IOException {
        try (FileWriter writer = new FileWriter(filePath)) {
            for (Book book : books) {
                writer.write(book.getTitle() + "\n");
            }
        }
    }

    // 从文件加载图书列表
    public void loadFromFile(String filePath) throws IOException {
        File file = new File(filePath);
        if (!file.exists()) {
            throw new IOException("File not found: " + filePath);
        }
        
        Scanner scanner = new Scanner(file, "UTF-8");
        while (scanner.hasNextLine()) {
            String title = scanner.nextLine();
            books.add(new BookImpl(title));
        }
        scanner.close();
    }
}

// 主程序入口
public class LibraryApp {

    private static final String FILE_PATH = "library_books.txt";

    public static void main(String[] args) {
        BookManager manager = new BookManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        try {
            manager.loadFromFile(FILE_PATH);
        } catch (IOException e) {
            System.out.println("Error loading books from file: " + e.getMessage());
        }

        do {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Add a book");
            System.out.println("2. Remove a book");
            System.out.println("3. List all books");
            System.out.println("4. Save and Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter book title: ");
                    String title = scanner.nextLine();
                    manager.addBook(new BookImpl(title));
                    break;
                case 2:
                    System.out.print("Enter book title to remove: ");
                    String removeTitle = scanner.nextLine();
                    if (manager.removeBook(removeTitle)) {
                        System.out.println("Book removed.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 3:
                    manager.listBooks();
                    break;
                case 4:
                    try {
                        manager.saveToFile(FILE_PATH);
                        System.out.println("Books saved. Exiting...");
                    } catch (IOException e) {
                        System.out.println("Error saving books to file: " + e.getMessage());
                    }
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}