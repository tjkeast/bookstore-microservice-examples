package example.springboot.bookstore.core.service;


import example.springboot.bookstore.api.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getBooks();

    Book getBook(Long bookId);

    Book createBook(Book book);
}
