package com.service.impl;

import com.dao.BookDAoImpl;
import com.dao.BookDao;
import com.domain.Book;
import com.service.BookService;

public class BookServiceImpl implements BookService {
    private BookDao bookDao = new BookDAoImpl();
    @Override
    public int addBook(Book book) {
        return bookDao.addBook(book);
    }

    @Override
    public int deleteBook(String isbn) {
        return bookDao.deleteBook(isbn);
    }
}
