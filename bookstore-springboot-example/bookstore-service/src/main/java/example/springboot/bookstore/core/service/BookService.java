package example.springboot.bookstore.core.service;


import example.springboot.bookstore.api.model.Book;

public interface BookService {

    Book getBook(Long bookId);

}
