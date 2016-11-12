package com.xcz.book_management.service;

import com.xcz.search.domain.Book;

/**
 * Created by yhq on 2016/10/24.
 */
public interface BookManageService  {
    Boolean addBook(Book a);
    Boolean delBookByISBN(String ISBN);
    Boolean delBookById(String id);
    int getBookCount(String ISBN);
}
