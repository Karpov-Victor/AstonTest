import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    private int newInt;
    private int newInt2;

    private final List<Student> studentList = new ArrayList<>();

    public static void main(String[] args) {
        Book book1 = new Book("Война и мир", 1984, 432);
        Book book2 = new Book("Фараон", 1991, 267);
        Book book3 = new Book("Граф Монте-Кристо", 2006, 398);
        Book book4 = new Book("Незнайка на Луне", 1982, 146);
        Book book5 = new Book("Тёмный лес", 2023, 301);
        Book book6 = new Book("Матанализ для непосвященных", 2008, 325);
        Book book7 = new Book("Заводной апельсин", 1974, 85);
        Book book8 = new Book("Я - Легенда", 2003, 76);
        Book book9 = new Book("Квантовая механника для детей", 2024, 607);
        Book book10 = new Book("Вий", 1998, 113);
        Book book11 = new Book("Занимательная физика", 1980, 145);
        Book book12 = new Book("История Беларуси", 2024, 109);
        Book book13 = new Book("Психиатрия", 2007, 308);
        Book book14 = new Book("Аэропорт", 1979, 354);
        Book book15 = new Book("Война миров", 1984, 155);
//        Book book16 = book15;
        List<Book> library1 = new ArrayList<>(); library1.add(book1);library1.add(book2);library1.add(book3);library1.add(book4);library1.add(book5);
        List<Book> library2 = new ArrayList<>(); library2.add(book6);library2.add(book7);library2.add(book8);library2.add(book9);library2.add(book10);
        List<Book> library3 = new ArrayList<>(); library3.add(book11);library3.add(book12);library3.add(book13);library3.add(book14);library3.add(book15);

        Student student1 = new Student("Ферми", library1);
        Student student2 = new Student("Ампер", library2);
        Student student3 = new Student("Фрейд", library3);

        Main main = new Main();


        main.studentList.add(student1); main.studentList.add(student2); main.studentList.add(student3);

        main.studentList.stream()
                .peek(System.out::println)
                .flatMap(student -> student.getBooksList().stream())
//                .sorted(new Comparator<Book>() {
//                    @Override
//                    public int compare(Book o1, Book o2) {
//                        return Integer.compare(o2.getPages(), o1.getPages());
//                    }
//                })
                .sorted((b1, b2) -> Integer.compare(b2.getPages(), b1.getPages()))
                .distinct()
                .filter(book -> book.getYear() > 2000)
                .limit(3)
                .collect(Collectors.toList()).stream()
//                .toList().stream()
                .peek(book -> System.out.println(book.getYear()))
                .findAny()
                .ifPresentOrElse(
                        number -> {},
                        () -> System.out.println("Никакие книги не найдены")
                );
    }
}