package com.xcz.borrow_history.service;

import com.xcz.borrow_history.domain.BorrowHistory;
import com.xcz.borrow_history.domain.Reservation;
import com.xcz.search.domain.Book;

import java.util.ArrayList;

/**
 * Created by yhq on 2016/10/9.
 */
public interface BorrowInfoService {
    BorrowHistory[] check(String user_id);
    Boolean add(String user_id,String ISBN);
    Book queryBook(String ISBN);
    ArrayList<Book> queryBooks(ArrayList<String> ISBNs);
    Reservation[] queryReserve(String user_id);
}
