package bookList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        List<Book> bookList = new ArrayList<>(10);
        bookList.add(new Book("A", 100, "A-author", 1938));
        bookList.add(new Book("B", 123, "B-author", 1939));
        bookList.add(new Book("C", 124, "C-author", 2000));
        bookList.add(new Book("D", 34, "D-author", 2010));
        bookList.add(new Book("E", 27, "E-author", 2021));
        bookList.add(new Book("F", 4546, "F-author", 2023));
        bookList.add(new Book("G", 234, "G-author", 2024));
        bookList.add(new Book("H", 12, "H-author", 1923));
        bookList.add(new Book("I", 765, "I-author", 1999));
        bookList.add(new Book("J", 234, "J-author", 1998));

        Map<String, String> bookAuthorMap = new HashMap<>();
        bookList.forEach(book -> bookAuthorMap.put(book.getBookName(), book.getAuthorName()));

        System.out.println("Books - Authors Map");
        System.out.println("----------------------");
        bookAuthorMap.forEach(
                (book, author) -> System.out.println("Book: " + book + " Author: " + author)
        );

        System.out.println("----------------------");
        System.out.println("Book Names - Page Greater Than 100");

        ArrayList<Book> bookList2 = new ArrayList<>();
        bookList.stream().filter(book -> book.getPage() > 100).forEach(((List<Book>) bookList2)::add);
        for (Book book : bookList2) {
            System.out.println(book.getBookName());
        }
    }
}

