import java.util.List;

public class Student {
    private final String surname;
    private List<Book> booksList;

    public List<Book> getBooksList() {
        return booksList;
    }

    public Student(String surname, List<Book> booksList) {
        this.surname = surname;
        this.booksList = booksList;
    }

    @Override
    public String toString() {
        return surname;
    }
}
