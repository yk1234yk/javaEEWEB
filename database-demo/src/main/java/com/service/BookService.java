package com.service;

import com.domain.Book;

public interface BookService {
    int addBook(Book book);
    int deleteBook(String isbn);
}
