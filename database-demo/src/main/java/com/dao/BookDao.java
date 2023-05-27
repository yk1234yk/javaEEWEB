package com.dao;

import com.domain.Book;

public interface BookDao extends Dao{
    int addBook(Book book);
    int deleteBook(String isbn);
}
